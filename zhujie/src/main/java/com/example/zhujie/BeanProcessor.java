package com.example.zhujie;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.util.ElementFilter;
import javax.lang.model.util.Elements;

/**
 * Created by 林其望
 * data：2016/7/9
 * email: 1105896230@qq.com
 */
public class BeanProcessor extends AbstractProcessor {
    // 元素操作的辅助类
    Elements elementUtils;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        // 元素操作的辅助类
        elementUtils = processingEnv.getElementUtils();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
//        获得被改注解声明的类
        Set<? extends Element> elements = roundEnv.getElementsAnnotatedWith(Seriable.class);
//        声明改类的元素
        TypeElement typeElement = null;
//        声明一个存放成员变量的列表
        List<VariableElement> fileds = null;
        Map<String, List<VariableElement>> map = new HashMap<>();
        for (Element element : elements) {
            // 判断该元素是否为类。
            if (element.getKind() == ElementKind.CLASS) {
                typeElement = (TypeElement) element;
                // 返回此类型元素的完全限定名称。 getQualifiedName
                map.put(typeElement.getQualifiedName().toString(), fileds = new ArrayList<>());
                // 判断该元素是否成员变量
            } else if (element.getKind() == ElementKind.FIELD) {
                VariableElement varEle = (VariableElement) element;
                // 获取该元素封装类型
                TypeElement enclosingElement = (TypeElement) varEle.getEnclosingElement();
                // 拿到key
                String key = enclosingElement.getQualifiedName().toString();
                fileds = map.get(key);
                if (fileds == null) {
                    map.put(key, fileds = new ArrayList<VariableElement>());
                }
                fileds.add(varEle);
            }
        }
        // 获取 声明那些 只是声明key的类，其中的属性
        for (String key : map.keySet()) {

            if (map.get(key).size() == 0) {
                TypeElement ele = elementUtils.getTypeElement(key);
                // 返回类型元素的所有成员，不管是继承的还是直接声明的。
                List<? extends Element> allMembers = elementUtils.getAllMembers(ele);
                if (allMembers.size() > 0) {
                    map.get(key).addAll(ElementFilter.fieldsIn(allMembers));
                }
            }
        }
        generateCodes(map);
        return true;
    }

    private void generateCodes(Map<String, List<VariableElement>> maps) {
        File dir = new File(BeanProcessor.class.getResource("/").getPath());
        if (!dir.exists()) dir.mkdirs();
        // 遍历map
        for (String key : maps.keySet()) {

            // 创建文件
            File file = new File(dir, key.replaceAll("\\.", "_") + ".txt");
            try {
                /**
                 * 编写json文件内容
                 */
                FileWriter fw = new FileWriter(file);
                fw.append("{").append("class:").append("\"" + key + "\"").append(",\n ");
                fw.append("fields:\n {\n");
                List<VariableElement> fields = maps.get(key);

                for (int i = 0; i < fields.size(); i++) {
                    VariableElement field = fields.get(i);
                    fw.append("  ")
                            .append(field.getSimpleName())
                            .append(":")
                            .append("\"" + field.asType().toString() + "\"");
                    if (i < fields.size() - 1) {
                        fw.append(",");
                        fw.append("\n");
                    }
                }
                fw.append("\n }\n");
                fw.append("}");
                fw.flush();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

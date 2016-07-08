package custom.fmt.com.mycustomview.zhujie;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by 林其望
 * data：2016/7/8
 * email: 1105896230@qq.com
 */
//Target 表上该注解用在什么地方，ElementType是可能的类型 有类和成员变量等
@Target(ElementType.TYPE)
//表示需要在什么级别保存该注解信息,设置为运行时
@Retention(RetentionPolicy.RUNTIME)
public @interface ContentView {
    int value();
}

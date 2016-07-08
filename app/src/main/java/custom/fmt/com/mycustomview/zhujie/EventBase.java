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
//给注解类型进行注解
@Target(ElementType.ANNOTATION_TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface EventBase {
    Class<?> linsterType();

    String listernSetter();

    String methodname();
}

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
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.FIELD,ElementType.TYPE})
public @interface InjectView {
    int value();
}

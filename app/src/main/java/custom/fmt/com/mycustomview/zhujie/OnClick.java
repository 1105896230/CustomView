package custom.fmt.com.mycustomview.zhujie;

import android.view.View;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by 林其望
 * data：2016/7/8
 * email: 1105896230@qq.com
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@EventBase(linsterType = View.OnClickListener.class, listernSetter = "setOnClickListener", methodname = "onClick")
public @interface OnClick {
    //    注解进来的东西
    int[] value();
}

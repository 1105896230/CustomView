package custom.fmt.com.mycustomview.zhujie;

import android.app.Activity;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by 林其望
 * data：2016/7/8
 * email: 1105896230@qq.com
 */
public class ViewInjectUtils {
    private static final String METHOD_SET_CONTENTVIEW = "setContentView";
    private static final String METHOD_FIND_VIEW_BY_ID = "findViewById";

    public static void injectContentView(Activity activity) {
        Class<? extends Activity> clazz = activity.getClass();
//        查找该类上是否有ConteView.class的注解
        ContentView contentView = clazz.getAnnotation(ContentView.class);
        if (contentView != null) {
            int layoutId = contentView.value();
            try {
//                类查找方法
                Method method = clazz.getMethod(METHOD_SET_CONTENTVIEW, int.class);
//               将成员变量设置为public
                method.setAccessible(true);
                method.invoke(activity, layoutId);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void injectViews(Activity activity) {
        Class<? extends Activity> clazz = activity.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields) {
            ViewInject viewInject = f.getAnnotation(ViewInject.class);
            if (viewInject != null) {
                int value = viewInject.value();
                if (value != -1) {
                    // 初始化View
                    try {
                        Method method = clazz.getMethod(METHOD_FIND_VIEW_BY_ID, int.class);
                        Object resView = method.invoke(activity, value);
                        f.setAccessible(true);
                        f.set(activity, resView);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void inject(Activity activity) {

        injectContentView(activity);
        injectViews(activity);
    }
}

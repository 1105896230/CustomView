package custom.fmt.com.mycustomview.zhujie;

import android.app.Activity;
import android.view.View;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

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
        injectClick(activity);
    }

    private static void injectClick(Activity activity) {
//        Class<?> clazz = activity.getClass();
//        Method[] methods = clazz.getMethods();
//        for (Method method : methods) {
////           方法的注解可能有很多
//            Annotation[] annotations = method.getAnnotations();
//            //拿到方法上的所有的注解
//            for (Annotation annotation : annotations) {
//                Class<? extends Annotation> annotationType = annotation.annotationType();
////                拿到注解上的注解
//                EventBase eventBase = annotationType.getAnnotation(EventBase.class);
//                if (eventBase != null) {
////                    将监听器的名字监听的类型和方法名字拿出
//                    Class<?> listenerType = eventBase.linsterType();
//                    String listenerSetter = eventBase.listernSetter();
//                    String methodname = eventBase.methodname();
//                    try {
////                        拿到OnClick注解中的value方法
//                        Method aMethod = annotationType.getDeclaredMethod("value");
//                        //取出所有的viewId
//                        int[] viewIds = (int[]) aMethod.invoke(annotation, null);
////                        设置代理
//                        DynamicHandler handler = new DynamicHandler(activity);
//                        handler.addMethod(methodname, method);
//                        Object listener = Proxy.newProxyInstance(listenerType.getClassLoader(),
//                                new Class<?>[]{listenerType}, handler);
//                        //遍历所有的View，设置事件
//                        for (int viewId : viewIds) {
//                            View view = activity.findViewById(viewId);
//                            Method setEventListenerMethod = view.getClass()
//                                    .getMethod(listenerSetter, listenerType);
//                            setEventListenerMethod.invoke(view, listener);
//                        }
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }
    }
}

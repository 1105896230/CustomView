package custom.fmt.com.mycustomview.zhujie;

import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * Created by 林其望
 * data：2016/7/8
 * email: 1105896230@qq.com
 */
public class DynamicHandler implements InvocationHandler {
    private WeakReference<Object> handlerRef;
    private final HashMap<String, Method> methodMap = new HashMap<String, Method>(
            1);

    public DynamicHandler(Object handler)
    {
        this.handlerRef = new WeakReference<Object>(handler);
    }

    public void addMethod(String name, Method method)
    {
        methodMap.put(name, method);
    }

    public Object getHandler()
    {
        return handlerRef.get();
    }

    public void setHandler(Object handler)
    {
        this.handlerRef = new WeakReference<Object>(handler);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable
    {
        Object handler = handlerRef.get();
        if (handler != null)
        {
            String methodName = method.getName();
            method = methodMap.get(methodName);
            if (method != null)
            {
                return method.invoke(handler, args);
            }
        }
        return null;
    }
}

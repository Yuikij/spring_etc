package aki.dynamicProxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibUtils {
    public static Object getProxyObj(Class<?> iClass, Runnable before, Runnable after) {
         class MyApiInterceptor implements MethodInterceptor {
            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                before.run(); // 此处可以做一些操作
                Object result = proxy.invokeSuper(obj, args);
                after.run();  // 方法调用之后也可以进行一些操作
                return result;
            }
        }
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(iClass);
        enhancer.setCallback(new MyApiInterceptor());
        return enhancer.create();
    }
}

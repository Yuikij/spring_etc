package aki.dynamicProxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxyUtils {

    public static Object getProxyObj(Class<?> iClass, Runnable before, Runnable after) {
         class DynamicProxy implements InvocationHandler {
            Object originalObj;
            Object bind(Object originalObj){
                this.originalObj = originalObj;
                //this, invoke 调用
                // 运行过程中生成字节码 byte数组
                return Proxy.newProxyInstance(originalObj.getClass().getClassLoader(),originalObj.getClass().getInterfaces(),this );
            }
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
                before.run();
                //具体的类
                Object invokeRes = method.invoke(originalObj, args);
                after.run();
                return invokeRes;
            }
        }
//        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        try {
            return new DynamicProxy().bind(iClass.newInstance());
        } catch (InstantiationException | IllegalAccessException e) {
            return null;
        }
    }


}

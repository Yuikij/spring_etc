package aki.dynamicProxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxyTest {
    public interface IHello {
        void sayHello();
        default void sayBye(){
            System.out.println("bye");
        };
    }

    static class IHelloImpl implements IHello {

        @Override
        public void sayHello() {
            System.out.println("hello");
        }

//        public void sayBye(){
//            System.out.println("bye");
//        }
    }

    public static class IHelloImpl2 implements IHello {

        @Override
        public void sayHello() {
            System.out.println("hello2");
        }

//        public void sayBye(){
//            System.out.println("bye");
//        }
    }

    static class DynamicProxy implements InvocationHandler{

        Object originalObj;

        Object bind(Object originalObj){
            this.originalObj = originalObj;
            //this, invoke 调用
            // 运行过程中生成字节码 byte数组
            return Proxy.newProxyInstance(originalObj.getClass().getClassLoader(),originalObj.getClass().getInterfaces(),this );
        }
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
            System.out.println("welcome");
            //具体的类
            return method.invoke(originalObj,args);
        }

        public static void main(String[] args) {
            System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
            IHello hello = (IHello) new DynamicProxy().bind(new IHelloImpl2());
            hello.sayHello();
        }
    }

    public static void main(String[] args) {
        IHello hello = (IHello)JdkProxyUtils.getProxyObj(IHelloImpl2.class, () -> System.out.println("before"), () -> System.out.println("after"));
        hello.sayHello();
    }
}

package aki.dynamicProxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibTest {

    static class IHelloImpl  {


        public void sayHello() {
            System.out.println("hello");
        }

//        public void sayBye(){
//            System.out.println("bye");
//        }
    }


    static class MyApiInterceptor implements MethodInterceptor {

        @Override
        public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
            System.out.println("welcome"); // 此处可以做一些操作
            Object result = proxy.invokeSuper(obj, args);
            System.out.println("end");  // 方法调用之后也可以进行一些操作
            return result;
        }

    }

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(IHelloImpl.class);
        enhancer.setCallback(new MyApiInterceptor());
        IHelloImpl hello = (IHelloImpl) enhancer.create();
        hello.sayHello();

    }
}

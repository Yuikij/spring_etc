package aki;

//import lombok.Data;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.openjdk.jol.vm.VM;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class BaseTest {

    private volatile BaseTest test;

    public synchronized BaseTest getBaseTest(){
        if (test==null){
            test = new BaseTest();
        }
        return test;
    }



//    public static void main(String[] args) {
//
//        caseTest();
////        returnTest();
//    }



    public static void caseTest() {
        int a = 2;
        switch (a) {
            case 1:
                System.out.println(1);
            case 2:
                System.out.println(2);
        }
    }

    public static void returnTest() {
        String b[] = new String[1];
        List<Integer> a = Arrays.asList(1, 2);
        a.forEach(e -> {
            if (e == 1) {
                return;
            }
            System.out.println(2);

        });
    }

    private static final String MESSAGE = "taobao";

    public static Unsafe getUnsafe() throws IllegalAccessException {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        return (Unsafe) unsafeField.get(null);
    }


    static class Test{
        String v;
        Test(String v){
            this.v=v;
        }

        public String getV() {
            return v;
        }

        public void setV(String v) {
            this.v = v;
        }
    }

    private static void getTest(Test t){
        System.out.println(t.getV());
    }

    private static void setTest(Test t,String v){
        t.setV(v);
    }

    public static void main(String[] args) throws IllegalAccessException {
//        System.out.println( new Test("a").hashCode());
//        System.out.println( new Test("a").hashCode());

//        Test test = new Test("a");
//        setTest(test,"b");
//        getTest(test);

//
//        for (Test a : new Test[]{new Test("a"),new Test("a"), new Test("a")}) {
//            new Thread(() -> {
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(a.hashCode());
//            }).start();
//        }


//        for (String a : new String[]{"a", "b", "c"}) {
//
//                System.out.println( VM.current().addressOf(a));
//
//        }


//        Unsafe unsafe =   getUnsafe();
//        Thread main = Thread.currentThread();
//        new Thread(() -> {
//            try {
//                Thread.sleep(2000);
//                LockSupport.unpark(main);//
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//        }).start();
//
//        LockSupport.park();//
//        System.out.println(123);


//        System.out.println(Math.pow(2,255));
//        System.out.println(123);
//        Object o = 1;
//        String a ="tao"+"bao";
//        String b="tao";
//        String c="bao";
//        System.out.println(a==MESSAGE);
//        String b = "b";
//        String c = "c";
//        System.out.println((b+c)=="bc");


//        String a = "taobao".intern();
//                String d="tao";
//        String c="bao";
//        String b =c+d;
//        System.out.println( VM.current().addressOf(a));
//        System.out.println( VM.current().addressOf(b));
        toStringTest();
    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    @lombok.ToString(callSuper = true)
    static class ToString extends ToStringF{
        private String test2;
    }

    @Data
    static class ToStringF{
        private String test1;
    }

    public static void toStringTest(){
//        ToString toString = ToString.builder().test1("123").build();
        ToString toString = new ToString();
        toString.setTest1("123");
        toString.setTest2("123");
        System.out.println(toString);
    }








    public static String foreachTest(){
        Arrays.asList("1","2","3").forEach(e->{
            if (e.equals("2")){
                return;
            }
            System.out.println(e);
        });
        return "2";
    }
}


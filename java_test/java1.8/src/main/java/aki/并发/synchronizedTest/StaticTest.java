package aki.并发.synchronizedTest;

import aki.common.utiles.ConcurrentUtils;

public class StaticTest {

    public synchronized static void test1(){
        ConcurrentUtils.print("test1");
    }

    public synchronized static void test2(){
        ConcurrentUtils.print("test2");
    }

    public static void main(String[] args) {
        ConcurrentUtils.multiRun(1, ()->{
            test1();
            test2();
        });


    }
}

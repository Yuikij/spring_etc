package aki.并发.synchronizedTest;

import aki.并发.commonClass.utils.Utils;

public class StaticTest {

    public synchronized static void test1(){
        Utils.print("test1");
    }

    public synchronized static void test2(){
        Utils.print("test2");
    }

    public static void main(String[] args) {
        Utils.multiRun(1, ()->{
            test1();
            test2();
        });


    }
}

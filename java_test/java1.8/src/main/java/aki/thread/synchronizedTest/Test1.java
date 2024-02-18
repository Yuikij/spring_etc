package aki.thread.synchronizedTest;

public class Test1 {

    public static void main(String[] args) {
        SynchronizedTest synchronizedTest = new SynchronizedTest();
//        new Thread(() -> {
//            synchronizedTest.test1();
//        }).start();
//
//        new Thread(() -> {
//            synchronizedTest.test2();
//        }).start();

        new Thread(() -> {
            synchronizedTest.test3();
        }).start();

    }

}

class SynchronizedTest {
    synchronized void test1() {
        System.out.println("test1");
        try {
            Thread.sleep(10000);
        } catch (Exception e) {

        }
        System.out.println("test1-end");

    }

    synchronized void test2() {
        System.out.println("test2");
        try {
            Thread.sleep(10000);
        } catch (Exception e) {

        }
        System.out.println("test2-end");
    }


    /**
     * 可重入
     */
    synchronized void test3() {
        System.out.println("test3");
        test2();
        try {
            Thread.sleep(10000);
        } catch (Exception e) {

        }
        System.out.println("test3-end");
    }

}
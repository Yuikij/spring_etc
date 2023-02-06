package aki.thread.synchronizedTest;


/**
 * 测试synchronized原理
 */
public class Test2 {


    /**
     * 作用在方法上，访问标志：0x002a [private static synchronized]
     * Test2.class对象
     */
    private synchronized static void t1() {
        System.out.println("t1");
    }

    /**
     * 作用在代码块，monitorenter,monitorexit
     */
    private static void t2() {
        synchronized (Test2.class) {
            System.out.println("t2");
        }
    }


    /**
     * Test2（）对象
     */
    private synchronized  void t3() {
        System.out.println("t1");
    }

    public static void main(String[] args) {
        Test2 test2 = new Test2();
        test2.t3();
    }
}

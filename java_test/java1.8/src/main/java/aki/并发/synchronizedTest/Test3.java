package aki.并发.synchronizedTest;

/**
 * 同一个类的不同方法加synchronized会互斥
 */
public class Test3 {

    private synchronized void t1(){
        System.out.println("t1");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private synchronized void t2(){
        System.out.println("t2");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Test3 test3 = new Test3();
        new Thread(test3::t1).start();
        new Thread(test3::t2).start();
    }
}

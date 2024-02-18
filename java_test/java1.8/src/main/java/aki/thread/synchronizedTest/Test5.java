package aki.thread.synchronizedTest;

public class Test5 {
    private static final Integer a = 0;
    private static final Integer b = 0;
    private static final Integer a2 = new Integer(0);
    private static final Integer b2 = new Integer(0);
    private static final Object a1 = new Object();
    private static final Object b1 = new Object();


    private static class Thread2 extends Thread {
        @Override
        public void run() {
            synchronized (a2){
                try {
                    for (int i = 0; i < 5; i++) {
                        System.out.println(Thread.currentThread().getName() + " loop " + i);
                        Thread.sleep(100);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    private static class Thread1 extends Thread {
        @Override
        public void run() {
            synchronized (b2){
                try {
                    for (int i = 0; i < 5; i++) {
                        System.out.println(Thread.currentThread().getName() + " loop " + i);
                        Thread.sleep(100);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void main(String[] args){
        new Thread1().start();
        new Thread2().start();
    }
}

package aki.并发.synchronizedTest;

public class Test4 {
    private static Integer a = 0;
    private static Integer b = 0;

    private static class Thread2 extends Thread {
        @Override
        public void run() {
            synchronized (a){
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
            synchronized (b){
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
        System.out.println(a==b);
        new Thread1().start();
        new Thread2().start();
    }
}

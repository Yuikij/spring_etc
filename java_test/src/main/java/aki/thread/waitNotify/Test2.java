package aki.thread.waitNotify;

public class Test2 {
    private static SOut c = new SOut();

    private static class SOut{
        synchronized void  SysOut(){
            try {
                for (int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread().getName() + " loop " + i);
                    Thread.sleep(100);
                }
            }catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    private static class Thread1 extends Thread {
        @Override
        public void run() {
            synchronized (c){
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
        c.SysOut();
    }
}

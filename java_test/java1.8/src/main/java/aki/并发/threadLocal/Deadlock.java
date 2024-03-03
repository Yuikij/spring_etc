package aki.并发.threadLocal;

import aki.common.utiles.ConcurrentUtils;

import static aki.common.utiles.ConcurrentUtils.*;

public class Deadlock {
    static final Object lock1= new Object();
    static final Object lock2= new Object();

    public static void main(String[] args) {
        ConcurrentUtils.multiRun(1,()->{
            synchronized (lock1){
                print("t1","start lock1");
                sleep(1000);
                print("t1","start lock2");
                synchronized (lock2){
                    sleep(1000);
                }
            }
        });
        sleep(100);
        ConcurrentUtils.multiRun(1,()->{
            synchronized (lock2){
                print("t2","start lock2");
                sleep(1000);
                print("t2","start lock1");
                synchronized (lock1){
                    sleep(1000);
                }
            }
        });
    }
}

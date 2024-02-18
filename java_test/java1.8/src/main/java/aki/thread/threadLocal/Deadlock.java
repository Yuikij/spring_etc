package aki.thread.threadLocal;

import aki.thread.commonClass.utils.Utils;

import static aki.thread.commonClass.utils.Utils.*;

public class Deadlock {
    static final Object lock1= new Object();
    static final Object lock2= new Object();

    public static void main(String[] args) {
        Utils.multiRun(1,()->{
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
        Utils.multiRun(1,()->{
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

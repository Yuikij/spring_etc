package aki.thread.ConcurrentModificationException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Test1 {

    public static CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();

    public static void main(String[] args) {
        new Thread(()->{
            for (int i = 0; i < 10000; i++) {
                sleep(100);
                list.add(i);
            }
        }).start();
        sleep(2000);
        new Thread(()->{
            for (Integer integer : list) {
                sleep(100);
                System.out.println(integer);
            }
        }).start();
    }


    private static void sleep(long time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

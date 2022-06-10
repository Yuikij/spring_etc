package aki.面试题;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Scheduler {

    static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 10, TimeUnit.DAYS, new PriorityBlockingQueue<>());


    private static final Resource resource = new Resource();


    static class Resource {
        private int toNum = 0;
        private int num = 0;

        public synchronized void get(int count) {
            while (num < count) {
                toNum = count;
                try {
                    System.out.println("等待资源");
                    wait(); // waits for notify() call from Producer
                } catch (InterruptedException e) {
                }
            }
            num = num - count;
        }

        public synchronized void put() {
            if (num >= toNum) {
                notify();
            }
            num++;
        }
    }

    static class Task implements Runnable, Comparable<Task> {
        public Task(String name, Integer priority, Integer resurceNum) {
            this.name = name;
            this.priority = priority;
            this.resurceNum = resurceNum;
        }

        String name;
        Integer priority;
        Integer resurceNum;

        @Override
        public void run() {
            LocalDateTime localDateTime = LocalDateTime.now();
            resource.get(resurceNum);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            LocalDateTime localDateTime2 = LocalDateTime.now();
            System.out.println("------------------------------------------");
            System.out.println("任务完成");
            java.time.Duration duration = java.time.Duration.between(localDateTime, localDateTime2);
            System.out.println("任务时间:" + duration.getSeconds()+"s");
            System.out.println(this.toString());
            System.out.println(localDateTime2.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            System.out.println("------------------------------------------");
        }

        @Override
        public int compareTo(Task o) {
            return this.priority - o.priority;
        }

        @Override
        public String toString() {
            return "Task{" +
                    "name='" + name + '\'' +
                    ", priority=" + priority +
                    ", resurceNum=" + resurceNum +
                    '}';
        }
    }

    static class AddTask implements Runnable {


        @Override
        public void run() {
            int i = 0;
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Task task = new Task("1" + i++, (int) (Math.random() * 10), (int) (Math.random() * 20));
                threadPoolExecutor.execute(task);
            }
        }

    }

    static class AddResource implements Runnable {


        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                resource.put();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        new Thread(new AddTask()).start();
        new Thread(new AddResource()).start();
        int count = 0;
        int count1 = 0;

        while (true){
            Thread.sleep(2000);
            count1++;
            if (threadPoolExecutor.getPoolSize()==0){
                count++;
            }
            System.out.println("-------------------------------");
            System.out.println("任务长度:"+threadPoolExecutor.getQueue().size());
            System.out.println("资源池数量:"+threadPoolExecutor.getPoolSize());
            System.out.println("当前执行任务数:"+threadPoolExecutor.getActiveCount());
            System.out.println("调度器空闲率:"+count/count1);
            System.out.println("-------------------------------");
        }


    }
}

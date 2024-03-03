package aki.并发.threadPool;

import aki.common.utiles.ConcurrentUtils;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinPoolTest extends RecursiveTask<String> {
    String str;

    ForkJoinPoolTest(String str) {
        this.str = str;
    }

    @Override
    protected String compute() {
        ConcurrentUtils.sleep(1000);
        ConcurrentUtils.print("thread:" + Thread.currentThread().getName());
        if (str.length() > 9) {
            System.out.println(str);
            return str;
        }

        ForkJoinPoolTest left = new ForkJoinPoolTest(str + "-l");
//        ForkJoinPoolTest m = new ForkJoinPoolTest(str + "-m");
        ForkJoinPoolTest right = new ForkJoinPoolTest(str + "-r");
        left.fork();
//        String ls = left.compute();
//        m.compute();

        right.fork();
        String ls = left.join();
        String rs = right.join();

//        String rs = right.compute();
        return rs + "~" + ls;
    }

    public static void main(String[] args) {
        ConcurrentUtils.print("thread:" + Thread.currentThread().getName());
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ConcurrentUtils.print("end", forkJoinPool.invoke(new ForkJoinPoolTest("base")));
        System.out.println("---");
    }
}

package aki.thread.threadPool;

import aki.thread.commonClass.utils.Utils;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinPoolTest extends RecursiveTask<String> {
    String str;

    ForkJoinPoolTest(String str) {
        this.str = str;
    }

    @Override
    protected String compute() {
        Utils.sleep(1000);
        Utils.print("thread:" + Thread.currentThread().getName());
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
        Utils.print("thread:" + Thread.currentThread().getName());
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Utils.print("end", forkJoinPool.invoke(new ForkJoinPoolTest("base")));
        System.out.println("---");
    }
}

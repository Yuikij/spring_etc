package aki.并发.threadPool;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinPoolTest2 extends RecursiveTask<Integer> {
    private final int n;

    public ForkJoinPoolTest2(int n) {
        this.n = n;
    }

    @Override
    protected Integer compute() {
        // 终止条件
        if (n <= 1) {
            return n;
        } else {
            ForkJoinPoolTest2 fib1 = new ForkJoinPoolTest2(n - 1);
            fib1.fork(); // 在新的线程中异步执行 fib(n-1)

            ForkJoinPoolTest2 fib2 = new ForkJoinPoolTest2(n - 2);
            return fib2.compute() + fib1.join(); // 在当前线程中计算 fib(n-2)，然后等待 fib(n-1) 完成并获取其结果
        }
    }

    public static void main(String[] args) {
        int n = 10;
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        ForkJoinPoolTest2 calculator = new ForkJoinPoolTest2(n);
        int result = forkJoinPool.invoke(calculator);
        System.out.println("The " + n + "th Fibonacci number is: " + result);
    }
}

package aki.并发.threadPool;

import aki.common.utiles.ConcurrentUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class CharCounter extends RecursiveTask<Map<Character, Integer>> {
    private final String str;
    private final int threshold;

    /** 拆分的阈值，最小粒度 */
    public CharCounter(String str, int threshold) {
        this.str = str;
        this.threshold = threshold;
    }

    @Override
    protected Map<Character, Integer> compute() {
        if (str.length() <= threshold) {
            return countChars(str);
        } else {
            int mid = str.length() / 2;
            CharCounter left = new CharCounter(str.substring(0, mid), threshold);
            CharCounter right = new CharCounter(str.substring(mid), threshold);
            ConcurrentUtils.print("left.fork();",mid);
            left.fork();
            right.fork();
            ConcurrentUtils.print("right.join();",mid);
            Map<Character, Integer> rightResult = right.join();

//            Map<Character, Integer> rightResult = right.compute();
            Map<Character, Integer> leftResult = left.join();
            mergeResults(leftResult, rightResult);
            return leftResult;
        }
    }

    private static Map<Character, Integer> countChars(String str) {
        Map<Character, Integer> result = new ConcurrentHashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            result.compute(c, (k, v) -> v == null ? 1 : v + 1);
        }
        return result;
    }

    private static void mergeResults(Map<Character, Integer> left, Map<Character, Integer> right) {
        right.forEach((k, v) -> left.merge(k, v, Integer::sum));
    }

    public static void main(String[] args) {
        String str = "This is a test string to count the number of occurrences of each character.";
        ForkJoinPool pool = new ForkJoinPool();
        CharCounter counter = new CharCounter(str, 10);
        Map<Character, Integer> result = pool.invoke(counter);
        System.out.println(result);
    }
}

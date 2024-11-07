package aki.concurrent.ConcurrentHashMap;

import aki.common.utiles.ConcurrentUtils;
import org.junit.jupiter.api.Test;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestRunner {

    @Test
    public void runTest() {
        // 使用不安全的HashMap
        Map<Integer, String> unsafeMap = new HashMap<>();
        System.out.println("测试 HashMap（非线程安全）：");
        runTest(unsafeMap);

        // 使用线程安全的ConcurrentHashMap
        Map<Integer, String> safeMap = new ConcurrentHashMap<>();
        System.out.println("测试 ConcurrentHashMap（线程安全）：");
        runTest(safeMap);
    }

    private static void runTest(Map<Integer, String> map) {
        // 使用线程池模拟高并发环境
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        // 向Map中并发写入数据
        for (int i = 0; i < 1000; i++) {
            final int key = i;
            executorService.submit(() -> {
                map.put(key, "Value" + key);
            });
        }

        // 并发读取数据
        for (int i = 0; i < 1000; i++) {
            final int key = i;
            executorService.submit(() -> {
                map.get(key);
            });
        }

        // 关闭线程池
        executorService.shutdown();

        // 等待所有任务执行完毕
        while (!executorService.isTerminated()) {
            // 等待线程池任务完成
        }

        System.out.println("最终映射大小: " + map.size());
    }
}

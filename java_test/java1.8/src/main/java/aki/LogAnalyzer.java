package aki;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class LogAnalyzer {
    public static void main(String[] args) {
        String logFile = "D:\\chrome_download\\info.log (1)\\info.log"; // 日志文件路径
        Map<String, Map<String, Integer>> logCountMap = new TreeMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(logFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                processLogLine(line, logCountMap);
            }

            printLogCount(logCountMap);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void processLogLine(String line, Map<String, Map<String, Integer>> logCountMap) {
        // 提取时间和类别
        String timestamp = line.substring(0, 23); // 假设时间格式固定，如 "2024-10-11 19:30:55.051"
        String logTime = timestamp.substring(0, 19); // 截取到秒
        String logType = getLogType(line); // 获取日志类型

        // 更新统计
        logCountMap.putIfAbsent(logTime, new HashMap<>());
        Map<String, Integer> countMap = logCountMap.get(logTime);
        countMap.put(logType, countMap.getOrDefault(logType, 0) + 1);
    }

    private static String getLogType(String line) {
        // 提取日志类型：例如 "接收监测点检测状态"
        String[] parts =  line.split(" ");
        if (parts.length > 10) {
            return parts[10].split(":")[0]; // 取出第一部分日志内容
        }
        return "Unknown";
    }

    private static void printLogCount(Map<String, Map<String, Integer>> logCountMap) {
        for (Map.Entry<String, Map<String, Integer>> entry : logCountMap.entrySet()) {
            String logTime = entry.getKey();
            Map<String, Integer> countMap = entry.getValue();
            List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(countMap.entrySet());

            sortedList.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue())); // 按照数量降序排序

//            for (Map.Entry<String, Integer> countEntry : countMap.entrySet()) {
//                System.out.println(countEntry.getValue() + " " + logTime + " " + countEntry.getKey());
//            }

            Map<Integer,String> map = new HashMap<>();
            for (Map.Entry<String, Integer> countEntry : countMap.entrySet()) {
                map.put(countEntry.getValue(),logTime + " " + countEntry.getKey());
            }


        }



    }
}

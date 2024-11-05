package aki.并发测试;

import aki.demo.util.HttpClientUtils;
import cn.hutool.core.lang.Console;
import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import okhttp3.*;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MainTest {

    //  线程个数
    private static final int threadNum = 50;
    //  间隔时间
    private static final int intervalTime = 1000;
    //  循环次数
    private static final int loopNum = 10000;
    private static int errCount = 0;

    private static final HashMap<Integer, String> resMap = new HashMap<>();

    public static void main(String[] args) {

        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(100);
        scheduledThreadPoolExecutor.scheduleAtFixedRate(() -> {
            for (int i = 0; i < threadNum; i++) {
                new Thread(MainTest::doPost).start();
            }

        }, 0, intervalTime, java.util.concurrent.TimeUnit.MILLISECONDS);

    }

    public static void doPost() {


        String url = "http://192.168.9.148/prod-api/device/ptz/1561636627632099330/status/detect";
        String token = "Bearer 3f8b7f0e-a752-4a83-ba9c-6b1eee1bdf29";
        File file = new File("C:\\Users\\SouKon\\Desktop\\5061909547d7426682fd836ba63accae.jpg");
        Map<String, Object> map = new HashMap<>();
        map.put("file", file);
        map.put("desc", "{\n" +
                "\"files\": [\n" +
                "{\n" +
                "\"fileName\": \"5061909547d7426682fd836ba63accae.jpg\",\n" +
                "\"hashCode\": \"e3c686f4c89ae8e85e7f052ba5042e31\"\n" +
                "}\n" +
                "],\n" +
                "\"hashType\": \"md5\"\n" +
                "}");
        map.put("status", "{\"pan\":1.1,\"tilt\":1.1,\"zoom\":2,\"presetId\":1,\"gyroData\":[12,1,1],\"detectMode\":1,\"detectEnable\":1,\"updateTime\":\"2022-06-29 11:33:20\",\"detectConfigHash\":\"2314141\",\"detectVersion\":\"1.2.0\"}");

        String result2 = HttpRequest.post(url)
                .header(Header.AUTHORIZATION, token)//头信息，多个头信息多次调用此方法即可
                .form(map)//表单内容
                // .timeout(20000)//超时，毫秒
                .execute().body();
//        Console.log(result2);

//        if (!result2.contains("200")) {
//            resMap.put(errCount++, result2);
//        }
        //  记录结果


    }

}

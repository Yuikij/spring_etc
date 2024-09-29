package aki.demo.excel;


import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.util.ListUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class ReadAndPost {
    private static final Logger log = LoggerFactory.getLogger(ReadAndPost.class);
    public static final String gbId = "";
    public static final String deptId = "";
    public static final String url = "http://192.168.9.148/prod-api/resource/device";
    public static final String json = "{\n" +
            "    \"ptzId\": \"34020000001320000023\",\n" +
            "    \"districtCode\": \"01\",\n" +
            "    \"name\": \"石门坎M3D机场-01\",\n" +
            "    \"lon\": 118.78462704024977,\n" +
            "    \"lat\": 32.040355273996084,\n" +
            "    \"ptzCameraList\": [\n" +
            "        {\n" +
            "            \"isAuth\": 0,\n" +
            "            \"cameraStreamList\": [],\n" +
            "            \"cameraId\": \"34020000001320000023\",\n" +
            "            \"cameraType\": 1\n" +
            "        }\n" +
            "    ],\n" +
            "\n" +
            "    \"deptId\": \"100\",\n" +
            "    \"domainId\": \"888899\",\n" +
            "    \n" +
            "    \"ptzType\": 1,\n" +
            "    \"serviceList\": [\n" +
            "        {\n" +
            "            \"serviceCode\": \"stream\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"serviceCode\": \"ptz\"\n" +
            "        },\n" +
            "        {\"serviceCode\": \"videoRecord\"}\n" +
            "    ],\n" +
            "    \"deviceModel\": \"1\",\n" +
            "\n" +
            "\n" +
            "\n" +
            "    \"altitude\": 1,\n" +
            "    \"towerHeight\": 18,\n" +
            "    \"northAngle\": 1,\n" +
            "\n" +
            "\n" +
            "    \"connectionModel\": 3,\n" +
            "\n" +
            "\n" +
            "    \"isCtrlFunction\": 1,\n" +
            "    \"ctrlType\": 1,\n" +
            "    \"isAuth\": 1,\n" +
            "    \"isCtrl\": 0,\n" +
            "    \"ctrlUsername\": \"enbo\",\n" +
            "    \"ctrlPassword\": \"123456\",\n" +
            "    \"isDetect\": 1,\n" +
            "    \"fileList\": [],\n" +
            "    \"deviceTypeCode\": 22\n" +
            "}";

    public static class NoModelDataListener extends AnalysisEventListener<Map<Integer, String>> {
        /**
         * 每隔5条存储数据库，实际使用中可以100条，然后清理list ，方便内存回收
         */
        private static final int BATCH_COUNT = 5;
        private List<Map<Integer, String>> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);

        @Override
        public void invoke(Map<Integer, String> data, AnalysisContext context) {

            log.info("解析到一条数据:{}", JSON.toJSONString(data));
            cachedDataList.add(data);
            if (cachedDataList.size() >= BATCH_COUNT) {
                saveData();
                cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
            }
        }

        @Override
        public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
            log.info("解析到一条数据:{}", JSON.toJSONString(headMap));
        }

        @Override
        public void doAfterAllAnalysed(AnalysisContext context) {
            saveData();
            log.info("所有数据解析完成！");
        }

        /**
         * 加上存储数据库
         */
        private void saveData() {
            log.info("{}条数据，开始存储数据库！", cachedDataList.size());
            cachedDataList.forEach(e->{
                String thirdId = e.get(0);
                String name = e.get(1);
                String lon = e.get(2);
                String lat = e.get(3);
                String area = e.get(4);
                JSONObject jsonObject = JSON.parseObject(json);
                jsonObject.put("name",name);
                jsonObject.put("lon", lon);
                jsonObject.put("lat", lat);
                jsonObject.put("districtCode", area);
                jsonObject.put("ptzId", thirdId);
                jsonObject.getJSONArray("ptzCameraList").getJSONObject(0).put("cameraId",thirdId);

                jsonObject.put("deptId", deptId);
                jsonObject.put("domainId", gbId);

                log.info("生成设备：{}", jsonObject);

            });
            log.info("存储数据库成功！");
        }
    }

    public static void main(String[] args) {
        String fileName = "D:\\Users\\设备.xlsx";
        EasyExcel.read(fileName, new NoModelDataListener()).sheet().doRead();

    }
}

package aki;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Stopwatch;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StopWatch;

import java.util.ArrayList;

//@SpringBootTest
class TestApplicationTests {

    class A {
        public void test() {
            System.out.println("A");
        }
    }

    class B extends A {
        public void test() {
            System.out.println("B");
        }
        public void test2() {
            System.out.println("B2");
        }
    }

    @Test
    void testStopwatch() throws InterruptedException {
        Stopwatch stopwatch = Stopwatch.createStarted();
        Thread.sleep(1000);
        System.out.println(stopwatch.elapsed().toMillis());
        Thread.sleep(1000);
        System.out.println(stopwatch.elapsed().toMillis());
    }
    @Test
    void contextLoads() {
//        ArrayList
        B b = new B();
        A a = b;
        a.test();
    }

    String json = "{\n" +
            "\t\"code\" : 0,\n" +
            "\t\"data\" : \n" +
            "\t[\n" +
            "\t\t{\n" +
            "\t\t\t\"aliveSecond\" : 3,\n" +
            "\t\t\t\"app\" : \"live\",\n" +
            "\t\t\t\"bytesSpeed\" : 544154,\n" +
            "\t\t\t\"createStamp\" : 1728701666,\n" +
            "\t\t\t\"isRecordingHLS\" : true,\n" +
            "\t\t\t\"isRecordingMP4\" : false,\n" +
            "\t\t\t\"originSock\" : \n" +
            "\t\t\t{\n" +
            "\t\t\t\t\"identifier\" : \"319337-41\",\n" +
            "\t\t\t\t\"local_ip\" : \"172.19.59.39\",\n" +
            "\t\t\t\t\"local_port\" : 17108,\n" +
            "\t\t\t\t\"peer_ip\" : \"36.153.126.194\",\n" +
            "\t\t\t\t\"peer_port\" : 58120\n" +
            "\t\t\t},\n" +
            "\t\t\t\"originType\" : 2,\n" +
            "\t\t\t\"originTypeStr\" : \"rtsp_push\",\n" +
            "\t\t\t\"originUrl\" : \"rtsp://139.196.164.210:17108/live/1791367474531700751/1_1?token=9675950b-7988-4184-9edb-9d53b8e71329\",\n" +
            "\t\t\t\"readerCount\" : 0,\n" +
            "\t\t\t\"schema\" : \"hls\",\n" +
            "\t\t\t\"stream\" : \"1791367474531700751/1_1\",\n" +
            "\t\t\t\"totalReaderCount\" : 0,\n" +
            "\t\t\t\"tracks\" : \n" +
            "\t\t\t[\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"channels\" : 1,\n" +
            "\t\t\t\t\t\"codec_id\" : 2,\n" +
            "\t\t\t\t\t\"codec_id_name\" : \"mpeg4-generic\",\n" +
            "\t\t\t\t\t\"codec_type\" : 1,\n" +
            "\t\t\t\t\t\"duration\" : 4357,\n" +
            "\t\t\t\t\t\"frames\" : 41,\n" +
            "\t\t\t\t\t\"loss\" : -1.0,\n" +
            "\t\t\t\t\t\"ready\" : true,\n" +
            "\t\t\t\t\t\"sample_bit\" : 16,\n" +
            "\t\t\t\t\t\"sample_rate\" : 8000\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"codec_id\" : 0,\n" +
            "\t\t\t\t\t\"codec_id_name\" : \"H264\",\n" +
            "\t\t\t\t\t\"codec_type\" : 0,\n" +
            "\t\t\t\t\t\"duration\" : 4613,\n" +
            "\t\t\t\t\t\"fps\" : 15.0,\n" +
            "\t\t\t\t\t\"frames\" : 76,\n" +
            "\t\t\t\t\t\"gop_interval_ms\" : 1941,\n" +
            "\t\t\t\t\t\"gop_size\" : 30,\n" +
            "\t\t\t\t\t\"height\" : 1080,\n" +
            "\t\t\t\t\t\"key_frames\" : 3,\n" +
            "\t\t\t\t\t\"loss\" : -1.0,\n" +
            "\t\t\t\t\t\"ready\" : true,\n" +
            "\t\t\t\t\t\"width\" : 1920\n" +
            "\t\t\t\t}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"vhost\" : \"__defaultVhost__\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"aliveSecond\" : 5,\n" +
            "\t\t\t\"app\" : \"live\",\n" +
            "\t\t\t\"bytesSpeed\" : 244873,\n" +
            "\t\t\t\"createStamp\" : 1728701663,\n" +
            "\t\t\t\"isRecordingHLS\" : true,\n" +
            "\t\t\t\"isRecordingMP4\" : false,\n" +
            "\t\t\t\"originSock\" : \n" +
            "\t\t\t{\n" +
            "\t\t\t\t\"identifier\" : \"319332-39\",\n" +
            "\t\t\t\t\"local_ip\" : \"172.19.59.39\",\n" +
            "\t\t\t\t\"local_port\" : 17108,\n" +
            "\t\t\t\t\"peer_ip\" : \"36.153.126.194\",\n" +
            "\t\t\t\t\"peer_port\" : 58112\n" +
            "\t\t\t},\n" +
            "\t\t\t\"originType\" : 2,\n" +
            "\t\t\t\"originTypeStr\" : \"rtsp_push\",\n" +
            "\t\t\t\"originUrl\" : \"rtsp://139.196.164.210:17108/live/1791367474531700747/1_1?token=9675950b-7988-4184-9edb-9d53b8e71329\",\n" +
            "\t\t\t\"readerCount\" : 0,\n" +
            "\t\t\t\"schema\" : \"hls\",\n" +
            "\t\t\t\"stream\" : \"1791367474531700747/1_1\",\n" +
            "\t\t\t\"totalReaderCount\" : 0,\n" +
            "\t\t\t\"tracks\" : \n" +
            "\t\t\t[\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"channels\" : 1,\n" +
            "\t\t\t\t\t\"codec_id\" : 2,\n" +
            "\t\t\t\t\t\"codec_id_name\" : \"mpeg4-generic\",\n" +
            "\t\t\t\t\t\"codec_type\" : 1,\n" +
            "\t\t\t\t\t\"duration\" : 6791,\n" +
            "\t\t\t\t\t\"frames\" : 62,\n" +
            "\t\t\t\t\t\"loss\" : -1.0,\n" +
            "\t\t\t\t\t\"ready\" : true,\n" +
            "\t\t\t\t\t\"sample_bit\" : 16,\n" +
            "\t\t\t\t\t\"sample_rate\" : 8000\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"codec_id\" : 0,\n" +
            "\t\t\t\t\t\"codec_id_name\" : \"H264\",\n" +
            "\t\t\t\t\t\"codec_type\" : 0,\n" +
            "\t\t\t\t\t\"duration\" : 7268,\n" +
            "\t\t\t\t\t\"fps\" : 15.0,\n" +
            "\t\t\t\t\t\"frames\" : 115,\n" +
            "\t\t\t\t\t\"gop_interval_ms\" : 2005,\n" +
            "\t\t\t\t\t\"gop_size\" : 30,\n" +
            "\t\t\t\t\t\"height\" : 1080,\n" +
            "\t\t\t\t\t\"key_frames\" : 4,\n" +
            "\t\t\t\t\t\"loss\" : -1.0,\n" +
            "\t\t\t\t\t\"ready\" : true,\n" +
            "\t\t\t\t\t\"width\" : 1920\n" +
            "\t\t\t\t}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"vhost\" : \"__defaultVhost__\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"aliveSecond\" : 13,\n" +
            "\t\t\t\"app\" : \"live\",\n" +
            "\t\t\t\"bytesSpeed\" : 21928,\n" +
            "\t\t\t\"createStamp\" : 1728701656,\n" +
            "\t\t\t\"isRecordingHLS\" : true,\n" +
            "\t\t\t\"isRecordingMP4\" : false,\n" +
            "\t\t\t\"originSock\" : null,\n" +
            "\t\t\t\"originType\" : 0,\n" +
            "\t\t\t\"originTypeStr\" : \"unknown\",\n" +
            "\t\t\t\"originUrl\" : \"hls://__defaultVhost__/live/1791367474531700746/1_1\",\n" +
            "\t\t\t\"readerCount\" : 0,\n" +
            "\t\t\t\"schema\" : \"hls\",\n" +
            "\t\t\t\"stream\" : \"1791367474531700746/1_1\",\n" +
            "\t\t\t\"totalReaderCount\" : 0,\n" +
            "\t\t\t\"tracks\" : \n" +
            "\t\t\t[\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"channels\" : 1,\n" +
            "\t\t\t\t\t\"codec_id\" : 2,\n" +
            "\t\t\t\t\t\"codec_id_name\" : \"mpeg4-generic\",\n" +
            "\t\t\t\t\t\"codec_type\" : 1,\n" +
            "\t\t\t\t\t\"duration\" : 5895,\n" +
            "\t\t\t\t\t\"frames\" : 55,\n" +
            "\t\t\t\t\t\"loss\" : -1.0,\n" +
            "\t\t\t\t\t\"ready\" : true,\n" +
            "\t\t\t\t\t\"sample_bit\" : 16,\n" +
            "\t\t\t\t\t\"sample_rate\" : 8000\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"codec_id\" : 0,\n" +
            "\t\t\t\t\t\"codec_id_name\" : \"H264\",\n" +
            "\t\t\t\t\t\"codec_type\" : 0,\n" +
            "\t\t\t\t\t\"duration\" : 6261,\n" +
            "\t\t\t\t\t\"fps\" : 15.0,\n" +
            "\t\t\t\t\t\"frames\" : 95,\n" +
            "\t\t\t\t\t\"gop_interval_ms\" : 2001,\n" +
            "\t\t\t\t\t\"gop_size\" : 30,\n" +
            "\t\t\t\t\t\"height\" : 1080,\n" +
            "\t\t\t\t\t\"key_frames\" : 4,\n" +
            "\t\t\t\t\t\"loss\" : -1.0,\n" +
            "\t\t\t\t\t\"ready\" : true,\n" +
            "\t\t\t\t\t\"width\" : 1920\n" +
            "\t\t\t\t}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"vhost\" : \"__defaultVhost__\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"aliveSecond\" : 15,\n" +
            "\t\t\t\"app\" : \"live\",\n" +
            "\t\t\t\"bytesSpeed\" : 32652,\n" +
            "\t\t\t\"createStamp\" : 1728701653,\n" +
            "\t\t\t\"isRecordingHLS\" : true,\n" +
            "\t\t\t\"isRecordingMP4\" : false,\n" +
            "\t\t\t\"originSock\" : null,\n" +
            "\t\t\t\"originType\" : 0,\n" +
            "\t\t\t\"originTypeStr\" : \"unknown\",\n" +
            "\t\t\t\"originUrl\" : \"hls://__defaultVhost__/live/1791367474531700754/1_1\",\n" +
            "\t\t\t\"readerCount\" : 0,\n" +
            "\t\t\t\"schema\" : \"hls\",\n" +
            "\t\t\t\"stream\" : \"1791367474531700754/1_1\",\n" +
            "\t\t\t\"totalReaderCount\" : 0,\n" +
            "\t\t\t\"tracks\" : \n" +
            "\t\t\t[\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"channels\" : 1,\n" +
            "\t\t\t\t\t\"codec_id\" : 2,\n" +
            "\t\t\t\t\t\"codec_id_name\" : \"mpeg4-generic\",\n" +
            "\t\t\t\t\t\"codec_type\" : 1,\n" +
            "\t\t\t\t\t\"duration\" : 7945,\n" +
            "\t\t\t\t\t\"frames\" : 73,\n" +
            "\t\t\t\t\t\"loss\" : -1.0,\n" +
            "\t\t\t\t\t\"ready\" : true,\n" +
            "\t\t\t\t\t\"sample_bit\" : 16,\n" +
            "\t\t\t\t\t\"sample_rate\" : 8000\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"codec_id\" : 0,\n" +
            "\t\t\t\t\t\"codec_id_name\" : \"H264\",\n" +
            "\t\t\t\t\t\"codec_type\" : 0,\n" +
            "\t\t\t\t\t\"duration\" : 8333,\n" +
            "\t\t\t\t\t\"fps\" : 15.0,\n" +
            "\t\t\t\t\t\"frames\" : 132,\n" +
            "\t\t\t\t\t\"gop_interval_ms\" : 1998,\n" +
            "\t\t\t\t\t\"gop_size\" : 30,\n" +
            "\t\t\t\t\t\"height\" : 1080,\n" +
            "\t\t\t\t\t\"key_frames\" : 5,\n" +
            "\t\t\t\t\t\"loss\" : -1.0,\n" +
            "\t\t\t\t\t\"ready\" : true,\n" +
            "\t\t\t\t\t\"width\" : 1920\n" +
            "\t\t\t\t}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"vhost\" : \"__defaultVhost__\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"aliveSecond\" : 8690,\n" +
            "\t\t\t\"app\" : \"live\",\n" +
            "\t\t\t\"bytesSpeed\" : 573098,\n" +
            "\t\t\t\"createStamp\" : 1728692978,\n" +
            "\t\t\t\"isRecordingHLS\" : true,\n" +
            "\t\t\t\"isRecordingMP4\" : false,\n" +
            "\t\t\t\"originSock\" : \n" +
            "\t\t\t{\n" +
            "\t\t\t\t\"identifier\" : \"314256-33\",\n" +
            "\t\t\t\t\"local_ip\" : \"172.19.59.39\",\n" +
            "\t\t\t\t\"local_port\" : 17108,\n" +
            "\t\t\t\t\"peer_ip\" : \"117.179.65.135\",\n" +
            "\t\t\t\t\"peer_port\" : 7986\n" +
            "\t\t\t},\n" +
            "\t\t\t\"originType\" : 2,\n" +
            "\t\t\t\"originTypeStr\" : \"rtsp_push\",\n" +
            "\t\t\t\"originUrl\" : \"rtsp://139.196.164.210:17108/live/1810865672773238785/1_1?token=73a620a1-4bf1-4d86-b95e-56df641cf695\",\n" +
            "\t\t\t\"readerCount\" : 0,\n" +
            "\t\t\t\"schema\" : \"hls\",\n" +
            "\t\t\t\"stream\" : \"1810865672773238785/1_1\",\n" +
            "\t\t\t\"totalReaderCount\" : 1,\n" +
            "\t\t\t\"tracks\" : \n" +
            "\t\t\t[\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"channels\" : 1,\n" +
            "\t\t\t\t\t\"codec_id\" : 2,\n" +
            "\t\t\t\t\t\"codec_id_name\" : \"mpeg4-generic\",\n" +
            "\t\t\t\t\t\"codec_type\" : 1,\n" +
            "\t\t\t\t\t\"duration\" : 8343541,\n" +
            "\t\t\t\t\t\"frames\" : 73811,\n" +
            "\t\t\t\t\t\"ready\" : true,\n" +
            "\t\t\t\t\t\"sample_bit\" : 16,\n" +
            "\t\t\t\t\t\"sample_rate\" : 8000\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"codec_id\" : 0,\n" +
            "\t\t\t\t\t\"codec_id_name\" : \"H264\",\n" +
            "\t\t\t\t\t\"codec_type\" : 0,\n" +
            "\t\t\t\t\t\"duration\" : 8682040,\n" +
            "\t\t\t\t\t\"fps\" : 15.0,\n" +
            "\t\t\t\t\t\"frames\" : 130243,\n" +
            "\t\t\t\t\t\"gop_interval_ms\" : 2063,\n" +
            "\t\t\t\t\t\"gop_size\" : 30,\n" +
            "\t\t\t\t\t\"height\" : 1080,\n" +
            "\t\t\t\t\t\"key_frames\" : 4347,\n" +
            "\t\t\t\t\t\"ready\" : true,\n" +
            "\t\t\t\t\t\"width\" : 1920\n" +
            "\t\t\t\t}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"vhost\" : \"__defaultVhost__\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"aliveSecond\" : 71452,\n" +
            "\t\t\t\"app\" : \"live\",\n" +
            "\t\t\t\"bytesSpeed\" : 713120,\n" +
            "\t\t\t\"createStamp\" : 1728630216,\n" +
            "\t\t\t\"isRecordingHLS\" : true,\n" +
            "\t\t\t\"isRecordingMP4\" : false,\n" +
            "\t\t\t\"originSock\" : \n" +
            "\t\t\t{\n" +
            "\t\t\t\t\"identifier\" : \"299071-48\",\n" +
            "\t\t\t\t\"local_ip\" : \"172.19.59.39\",\n" +
            "\t\t\t\t\"local_port\" : 17108,\n" +
            "\t\t\t\t\"peer_ip\" : \"223.112.98.10\",\n" +
            "\t\t\t\t\"peer_port\" : 19643\n" +
            "\t\t\t},\n" +
            "\t\t\t\"originType\" : 2,\n" +
            "\t\t\t\"originTypeStr\" : \"rtsp_push\",\n" +
            "\t\t\t\"originUrl\" : \"rtsp://139.196.164.210:17108/live/1822912047996399620/1_1?token=2a7a9227-db3a-4078-8f30-86a71a957579\",\n" +
            "\t\t\t\"readerCount\" : 0,\n" +
            "\t\t\t\"schema\" : \"hls\",\n" +
            "\t\t\t\"stream\" : \"1822912047996399620/1_1\",\n" +
            "\t\t\t\"totalReaderCount\" : 1,\n" +
            "\t\t\t\"tracks\" : \n" +
            "\t\t\t[\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"channels\" : 1,\n" +
            "\t\t\t\t\t\"codec_id\" : 2,\n" +
            "\t\t\t\t\t\"codec_id_name\" : \"mpeg4-generic\",\n" +
            "\t\t\t\t\t\"codec_type\" : 1,\n" +
            "\t\t\t\t\t\"duration\" : 69742245,\n" +
            "\t\t\t\t\t\"frames\" : 587445,\n" +
            "\t\t\t\t\t\"ready\" : true,\n" +
            "\t\t\t\t\t\"sample_bit\" : 16,\n" +
            "\t\t\t\t\t\"sample_rate\" : 8000\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"codec_id\" : 0,\n" +
            "\t\t\t\t\t\"codec_id_name\" : \"H264\",\n" +
            "\t\t\t\t\t\"codec_type\" : 0,\n" +
            "\t\t\t\t\t\"duration\" : 71453455,\n" +
            "\t\t\t\t\t\"fps\" : 25.0,\n" +
            "\t\t\t\t\t\"frames\" : 1072932,\n" +
            "\t\t\t\t\t\"gop_interval_ms\" : 3357,\n" +
            "\t\t\t\t\t\"gop_size\" : 50,\n" +
            "\t\t\t\t\t\"height\" : 1080,\n" +
            "\t\t\t\t\t\"key_frames\" : 21459,\n" +
            "\t\t\t\t\t\"ready\" : true,\n" +
            "\t\t\t\t\t\"width\" : 1920\n" +
            "\t\t\t\t}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"vhost\" : \"__defaultVhost__\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"aliveSecond\" : 0,\n" +
            "\t\t\t\"app\" : \"live\",\n" +
            "\t\t\t\"bytesSpeed\" : 0,\n" +
            "\t\t\t\"createStamp\" : 1728701668,\n" +
            "\t\t\t\"isRecordingHLS\" : true,\n" +
            "\t\t\t\"isRecordingMP4\" : false,\n" +
            "\t\t\t\"originSock\" : \n" +
            "\t\t\t{\n" +
            "\t\t\t\t\"identifier\" : \"319343-38\",\n" +
            "\t\t\t\t\"local_ip\" : \"172.19.59.39\",\n" +
            "\t\t\t\t\"local_port\" : 17108,\n" +
            "\t\t\t\t\"peer_ip\" : \"36.153.126.194\",\n" +
            "\t\t\t\t\"peer_port\" : 58140\n" +
            "\t\t\t},\n" +
            "\t\t\t\"originType\" : 2,\n" +
            "\t\t\t\"originTypeStr\" : \"rtsp_push\",\n" +
            "\t\t\t\"originUrl\" : \"rtsp://139.196.164.210:17108/live/1791367474531700743/1_1?token=9675950b-7988-4184-9edb-9d53b8e71329\",\n" +
            "\t\t\t\"readerCount\" : 1,\n" +
            "\t\t\t\"schema\" : \"rtsp\",\n" +
            "\t\t\t\"stream\" : \"1791367474531700743/1_1\",\n" +
            "\t\t\t\"totalReaderCount\" : 1,\n" +
            "\t\t\t\"tracks\" : \n" +
            "\t\t\t[\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"channels\" : 1,\n" +
            "\t\t\t\t\t\"codec_id\" : 2,\n" +
            "\t\t\t\t\t\"codec_id_name\" : \"mpeg4-generic\",\n" +
            "\t\t\t\t\t\"codec_type\" : 1,\n" +
            "\t\t\t\t\t\"duration\" : 1,\n" +
            "\t\t\t\t\t\"frames\" : 2,\n" +
            "\t\t\t\t\t\"ready\" : true,\n" +
            "\t\t\t\t\t\"sample_bit\" : 16,\n" +
            "\t\t\t\t\t\"sample_rate\" : 8000\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"codec_id\" : 0,\n" +
            "\t\t\t\t\t\"codec_id_name\" : \"H264\",\n" +
            "\t\t\t\t\t\"codec_type\" : 0,\n" +
            "\t\t\t\t\t\"duration\" : 0,\n" +
            "\t\t\t\t\t\"fps\" : 15.0,\n" +
            "\t\t\t\t\t\"frames\" : 2,\n" +
            "\t\t\t\t\t\"gop_interval_ms\" : 404,\n" +
            "\t\t\t\t\t\"gop_size\" : 1,\n" +
            "\t\t\t\t\t\"height\" : 1080,\n" +
            "\t\t\t\t\t\"key_frames\" : 1,\n" +
            "\t\t\t\t\t\"ready\" : true,\n" +
            "\t\t\t\t\t\"width\" : 1920\n" +
            "\t\t\t\t}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"vhost\" : \"__defaultVhost__\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"aliveSecond\" : 3,\n" +
            "\t\t\t\"app\" : \"live\",\n" +
            "\t\t\t\"bytesSpeed\" : 546549,\n" +
            "\t\t\t\"createStamp\" : 1728701666,\n" +
            "\t\t\t\"isRecordingHLS\" : true,\n" +
            "\t\t\t\"isRecordingMP4\" : false,\n" +
            "\t\t\t\"originSock\" : \n" +
            "\t\t\t{\n" +
            "\t\t\t\t\"identifier\" : \"319337-41\",\n" +
            "\t\t\t\t\"local_ip\" : \"172.19.59.39\",\n" +
            "\t\t\t\t\"local_port\" : 17108,\n" +
            "\t\t\t\t\"peer_ip\" : \"36.153.126.194\",\n" +
            "\t\t\t\t\"peer_port\" : 58120\n" +
            "\t\t\t},\n" +
            "\t\t\t\"originType\" : 2,\n" +
            "\t\t\t\"originTypeStr\" : \"rtsp_push\",\n" +
            "\t\t\t\"originUrl\" : \"rtsp://139.196.164.210:17108/live/1791367474531700751/1_1?token=9675950b-7988-4184-9edb-9d53b8e71329\",\n" +
            "\t\t\t\"readerCount\" : 0,\n" +
            "\t\t\t\"schema\" : \"rtsp\",\n" +
            "\t\t\t\"stream\" : \"1791367474531700751/1_1\",\n" +
            "\t\t\t\"totalReaderCount\" : 0,\n" +
            "\t\t\t\"tracks\" : \n" +
            "\t\t\t[\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"channels\" : 1,\n" +
            "\t\t\t\t\t\"codec_id\" : 2,\n" +
            "\t\t\t\t\t\"codec_id_name\" : \"mpeg4-generic\",\n" +
            "\t\t\t\t\t\"codec_type\" : 1,\n" +
            "\t\t\t\t\t\"duration\" : 4357,\n" +
            "\t\t\t\t\t\"frames\" : 41,\n" +
            "\t\t\t\t\t\"loss\" : -1.0,\n" +
            "\t\t\t\t\t\"ready\" : true,\n" +
            "\t\t\t\t\t\"sample_bit\" : 16,\n" +
            "\t\t\t\t\t\"sample_rate\" : 8000\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"codec_id\" : 0,\n" +
            "\t\t\t\t\t\"codec_id_name\" : \"H264\",\n" +
            "\t\t\t\t\t\"codec_type\" : 0,\n" +
            "\t\t\t\t\t\"duration\" : 4613,\n" +
            "\t\t\t\t\t\"fps\" : 15.0,\n" +
            "\t\t\t\t\t\"frames\" : 76,\n" +
            "\t\t\t\t\t\"gop_interval_ms\" : 1941,\n" +
            "\t\t\t\t\t\"gop_size\" : 30,\n" +
            "\t\t\t\t\t\"height\" : 1080,\n" +
            "\t\t\t\t\t\"key_frames\" : 3,\n" +
            "\t\t\t\t\t\"loss\" : -1.0,\n" +
            "\t\t\t\t\t\"ready\" : true,\n" +
            "\t\t\t\t\t\"width\" : 1920\n" +
            "\t\t\t\t}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"vhost\" : \"__defaultVhost__\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"aliveSecond\" : 5,\n" +
            "\t\t\t\"app\" : \"live\",\n" +
            "\t\t\t\"bytesSpeed\" : 254534,\n" +
            "\t\t\t\"createStamp\" : 1728701663,\n" +
            "\t\t\t\"isRecordingHLS\" : true,\n" +
            "\t\t\t\"isRecordingMP4\" : false,\n" +
            "\t\t\t\"originSock\" : \n" +
            "\t\t\t{\n" +
            "\t\t\t\t\"identifier\" : \"319332-39\",\n" +
            "\t\t\t\t\"local_ip\" : \"172.19.59.39\",\n" +
            "\t\t\t\t\"local_port\" : 17108,\n" +
            "\t\t\t\t\"peer_ip\" : \"36.153.126.194\",\n" +
            "\t\t\t\t\"peer_port\" : 58112\n" +
            "\t\t\t},\n" +
            "\t\t\t\"originType\" : 2,\n" +
            "\t\t\t\"originTypeStr\" : \"rtsp_push\",\n" +
            "\t\t\t\"originUrl\" : \"rtsp://139.196.164.210:17108/live/1791367474531700747/1_1?token=9675950b-7988-4184-9edb-9d53b8e71329\",\n" +
            "\t\t\t\"readerCount\" : 0,\n" +
            "\t\t\t\"schema\" : \"rtsp\",\n" +
            "\t\t\t\"stream\" : \"1791367474531700747/1_1\",\n" +
            "\t\t\t\"totalReaderCount\" : 0,\n" +
            "\t\t\t\"tracks\" : \n" +
            "\t\t\t[\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"channels\" : 1,\n" +
            "\t\t\t\t\t\"codec_id\" : 2,\n" +
            "\t\t\t\t\t\"codec_id_name\" : \"mpeg4-generic\",\n" +
            "\t\t\t\t\t\"codec_type\" : 1,\n" +
            "\t\t\t\t\t\"duration\" : 6791,\n" +
            "\t\t\t\t\t\"frames\" : 62,\n" +
            "\t\t\t\t\t\"loss\" : -1.0,\n" +
            "\t\t\t\t\t\"ready\" : true,\n" +
            "\t\t\t\t\t\"sample_bit\" : 16,\n" +
            "\t\t\t\t\t\"sample_rate\" : 8000\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"codec_id\" : 0,\n" +
            "\t\t\t\t\t\"codec_id_name\" : \"H264\",\n" +
            "\t\t\t\t\t\"codec_type\" : 0,\n" +
            "\t\t\t\t\t\"duration\" : 7268,\n" +
            "\t\t\t\t\t\"fps\" : 15.0,\n" +
            "\t\t\t\t\t\"frames\" : 115,\n" +
            "\t\t\t\t\t\"gop_interval_ms\" : 2005,\n" +
            "\t\t\t\t\t\"gop_size\" : 30,\n" +
            "\t\t\t\t\t\"height\" : 1080,\n" +
            "\t\t\t\t\t\"key_frames\" : 4,\n" +
            "\t\t\t\t\t\"loss\" : -1.0,\n" +
            "\t\t\t\t\t\"ready\" : true,\n" +
            "\t\t\t\t\t\"width\" : 1920\n" +
            "\t\t\t\t}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"vhost\" : \"__defaultVhost__\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"aliveSecond\" : 10,\n" +
            "\t\t\t\"app\" : \"live\",\n" +
            "\t\t\t\"bytesSpeed\" : 1536,\n" +
            "\t\t\t\"createStamp\" : 1728701658,\n" +
            "\t\t\t\"isRecordingHLS\" : true,\n" +
            "\t\t\t\"isRecordingMP4\" : false,\n" +
            "\t\t\t\"originSock\" : null,\n" +
            "\t\t\t\"originType\" : 0,\n" +
            "\t\t\t\"originTypeStr\" : \"unknown\",\n" +
            "\t\t\t\"originUrl\" : \"rtsp://__defaultVhost__/live/1791367474531700757/1_1\",\n" +
            "\t\t\t\"readerCount\" : 0,\n" +
            "\t\t\t\"schema\" : \"rtsp\",\n" +
            "\t\t\t\"stream\" : \"1791367474531700757/1_1\",\n" +
            "\t\t\t\"totalReaderCount\" : 0,\n" +
            "\t\t\t\"tracks\" : \n" +
            "\t\t\t[\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"channels\" : 1,\n" +
            "\t\t\t\t\t\"codec_id\" : 2,\n" +
            "\t\t\t\t\t\"codec_id_name\" : \"mpeg4-generic\",\n" +
            "\t\t\t\t\t\"codec_type\" : 1,\n" +
            "\t\t\t\t\t\"duration\" : 3331,\n" +
            "\t\t\t\t\t\"frames\" : 31,\n" +
            "\t\t\t\t\t\"ready\" : true,\n" +
            "\t\t\t\t\t\"sample_bit\" : 16,\n" +
            "\t\t\t\t\t\"sample_rate\" : 8000\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"codec_id\" : 0,\n" +
            "\t\t\t\t\t\"codec_id_name\" : \"H264\",\n" +
            "\t\t\t\t\t\"codec_type\" : 0,\n" +
            "\t\t\t\t\t\"duration\" : 3439,\n" +
            "\t\t\t\t\t\"fps\" : 138.0,\n" +
            "\t\t\t\t\t\"frames\" : 54,\n" +
            "\t\t\t\t\t\"gop_interval_ms\" : 217,\n" +
            "\t\t\t\t\t\"gop_size\" : 30,\n" +
            "\t\t\t\t\t\"height\" : 1080,\n" +
            "\t\t\t\t\t\"key_frames\" : 2,\n" +
            "\t\t\t\t\t\"ready\" : true,\n" +
            "\t\t\t\t\t\"width\" : 1920\n" +
            "\t\t\t\t}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"vhost\" : \"__defaultVhost__\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"aliveSecond\" : 0,\n" +
            "\t\t\t\"app\" : \"live\",\n" +
            "\t\t\t\"bytesSpeed\" : 0,\n" +
            "\t\t\t\"createStamp\" : 1728701668,\n" +
            "\t\t\t\"isRecordingHLS\" : true,\n" +
            "\t\t\t\"isRecordingMP4\" : false,\n" +
            "\t\t\t\"originSock\" : \n" +
            "\t\t\t{\n" +
            "\t\t\t\t\"identifier\" : \"319342-36\",\n" +
            "\t\t\t\t\"local_ip\" : \"172.19.59.39\",\n" +
            "\t\t\t\t\"local_port\" : 17108,\n" +
            "\t\t\t\t\"peer_ip\" : \"36.153.126.194\",\n" +
            "\t\t\t\t\"peer_port\" : 58128\n" +
            "\t\t\t},\n" +
            "\t\t\t\"originType\" : 2,\n" +
            "\t\t\t\"originTypeStr\" : \"rtsp_push\",\n" +
            "\t\t\t\"originUrl\" : \"rtsp://139.196.164.210:17108/live/1791367474531700749/1_1?token=9675950b-7988-4184-9edb-9d53b8e71329\",\n" +
            "\t\t\t\"readerCount\" : 0,\n" +
            "\t\t\t\"schema\" : \"rtsp\",\n" +
            "\t\t\t\"stream\" : \"1791367474531700749/1_1\",\n" +
            "\t\t\t\"totalReaderCount\" : 0,\n" +
            "\t\t\t\"tracks\" : \n" +
            "\t\t\t[\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"channels\" : 1,\n" +
            "\t\t\t\t\t\"codec_id\" : 2,\n" +
            "\t\t\t\t\t\"codec_id_name\" : \"mpeg4-generic\",\n" +
            "\t\t\t\t\t\"codec_type\" : 1,\n" +
            "\t\t\t\t\t\"duration\" : 1,\n" +
            "\t\t\t\t\t\"frames\" : 2,\n" +
            "\t\t\t\t\t\"loss\" : -1.0,\n" +
            "\t\t\t\t\t\"ready\" : true,\n" +
            "\t\t\t\t\t\"sample_bit\" : 16,\n" +
            "\t\t\t\t\t\"sample_rate\" : 8000\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"codec_id\" : 0,\n" +
            "\t\t\t\t\t\"codec_id_name\" : \"H264\",\n" +
            "\t\t\t\t\t\"codec_type\" : 0,\n" +
            "\t\t\t\t\t\"duration\" : 0,\n" +
            "\t\t\t\t\t\"fps\" : 15.0,\n" +
            "\t\t\t\t\t\"frames\" : 2,\n" +
            "\t\t\t\t\t\"gop_interval_ms\" : 863,\n" +
            "\t\t\t\t\t\"gop_size\" : 1,\n" +
            "\t\t\t\t\t\"height\" : 1080,\n" +
            "\t\t\t\t\t\"key_frames\" : 1,\n" +
            "\t\t\t\t\t\"loss\" : -1.0,\n" +
            "\t\t\t\t\t\"ready\" : true,\n" +
            "\t\t\t\t\t\"width\" : 1920\n" +
            "\t\t\t\t}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"vhost\" : \"__defaultVhost__\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"aliveSecond\" : 13,\n" +
            "\t\t\t\"app\" : \"live\",\n" +
            "\t\t\t\"bytesSpeed\" : 19749,\n" +
            "\t\t\t\"createStamp\" : 1728701656,\n" +
            "\t\t\t\"isRecordingHLS\" : true,\n" +
            "\t\t\t\"isRecordingMP4\" : false,\n" +
            "\t\t\t\"originSock\" : null,\n" +
            "\t\t\t\"originType\" : 0,\n" +
            "\t\t\t\"originTypeStr\" : \"unknown\",\n" +
            "\t\t\t\"originUrl\" : \"rtsp://__defaultVhost__/live/1791367474531700746/1_1\",\n" +
            "\t\t\t\"readerCount\" : 0,\n" +
            "\t\t\t\"schema\" : \"rtsp\",\n" +
            "\t\t\t\"stream\" : \"1791367474531700746/1_1\",\n" +
            "\t\t\t\"totalReaderCount\" : 0,\n" +
            "\t\t\t\"tracks\" : \n" +
            "\t\t\t[\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"channels\" : 1,\n" +
            "\t\t\t\t\t\"codec_id\" : 2,\n" +
            "\t\t\t\t\t\"codec_id_name\" : \"mpeg4-generic\",\n" +
            "\t\t\t\t\t\"codec_type\" : 1,\n" +
            "\t\t\t\t\t\"duration\" : 5895,\n" +
            "\t\t\t\t\t\"frames\" : 55,\n" +
            "\t\t\t\t\t\"loss\" : -1.0,\n" +
            "\t\t\t\t\t\"ready\" : true,\n" +
            "\t\t\t\t\t\"sample_bit\" : 16,\n" +
            "\t\t\t\t\t\"sample_rate\" : 8000\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"codec_id\" : 0,\n" +
            "\t\t\t\t\t\"codec_id_name\" : \"H264\",\n" +
            "\t\t\t\t\t\"codec_type\" : 0,\n" +
            "\t\t\t\t\t\"duration\" : 6261,\n" +
            "\t\t\t\t\t\"fps\" : 15.0,\n" +
            "\t\t\t\t\t\"frames\" : 95,\n" +
            "\t\t\t\t\t\"gop_interval_ms\" : 2001,\n" +
            "\t\t\t\t\t\"gop_size\" : 30,\n" +
            "\t\t\t\t\t\"height\" : 1080,\n" +
            "\t\t\t\t\t\"key_frames\" : 4,\n" +
            "\t\t\t\t\t\"loss\" : -1.0,\n" +
            "\t\t\t\t\t\"ready\" : true,\n" +
            "\t\t\t\t\t\"width\" : 1920\n" +
            "\t\t\t\t}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"vhost\" : \"__defaultVhost__\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"aliveSecond\" : 15,\n" +
            "\t\t\t\"app\" : \"live\",\n" +
            "\t\t\t\"bytesSpeed\" : 27970,\n" +
            "\t\t\t\"createStamp\" : 1728701653,\n" +
            "\t\t\t\"isRecordingHLS\" : true,\n" +
            "\t\t\t\"isRecordingMP4\" : false,\n" +
            "\t\t\t\"originSock\" : null,\n" +
            "\t\t\t\"originType\" : 0,\n" +
            "\t\t\t\"originTypeStr\" : \"unknown\",\n" +
            "\t\t\t\"originUrl\" : \"rtsp://__defaultVhost__/live/1791367474531700754/1_1\",\n" +
            "\t\t\t\"readerCount\" : 0,\n" +
            "\t\t\t\"schema\" : \"rtsp\",\n" +
            "\t\t\t\"stream\" : \"1791367474531700754/1_1\",\n" +
            "\t\t\t\"totalReaderCount\" : 0,\n" +
            "\t\t\t\"tracks\" : \n" +
            "\t\t\t[\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"channels\" : 1,\n" +
            "\t\t\t\t\t\"codec_id\" : 2,\n" +
            "\t\t\t\t\t\"codec_id_name\" : \"mpeg4-generic\",\n" +
            "\t\t\t\t\t\"codec_type\" : 1,\n" +
            "\t\t\t\t\t\"duration\" : 7945,\n" +
            "\t\t\t\t\t\"frames\" : 73,\n" +
            "\t\t\t\t\t\"loss\" : -1.0,\n" +
            "\t\t\t\t\t\"ready\" : true,\n" +
            "\t\t\t\t\t\"sample_bit\" : 16,\n" +
            "\t\t\t\t\t\"sample_rate\" : 8000\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"codec_id\" : 0,\n" +
            "\t\t\t\t\t\"codec_id_name\" : \"H264\",\n" +
            "\t\t\t\t\t\"codec_type\" : 0,\n" +
            "\t\t\t\t\t\"duration\" : 8333,\n" +
            "\t\t\t\t\t\"fps\" : 15.0,\n" +
            "\t\t\t\t\t\"frames\" : 132,\n" +
            "\t\t\t\t\t\"gop_interval_ms\" : 1998,\n" +
            "\t\t\t\t\t\"gop_size\" : 30,\n" +
            "\t\t\t\t\t\"height\" : 1080,\n" +
            "\t\t\t\t\t\"key_frames\" : 5,\n" +
            "\t\t\t\t\t\"loss\" : -1.0,\n" +
            "\t\t\t\t\t\"ready\" : true,\n" +
            "\t\t\t\t\t\"width\" : 1920\n" +
            "\t\t\t\t}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"vhost\" : \"__defaultVhost__\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"aliveSecond\" : 8690,\n" +
            "\t\t\t\"app\" : \"live\",\n" +
            "\t\t\t\"bytesSpeed\" : 563651,\n" +
            "\t\t\t\"createStamp\" : 1728692978,\n" +
            "\t\t\t\"isRecordingHLS\" : true,\n" +
            "\t\t\t\"isRecordingMP4\" : false,\n" +
            "\t\t\t\"originSock\" : \n" +
            "\t\t\t{\n" +
            "\t\t\t\t\"identifier\" : \"314256-33\",\n" +
            "\t\t\t\t\"local_ip\" : \"172.19.59.39\",\n" +
            "\t\t\t\t\"local_port\" : 17108,\n" +
            "\t\t\t\t\"peer_ip\" : \"117.179.65.135\",\n" +
            "\t\t\t\t\"peer_port\" : 7986\n" +
            "\t\t\t},\n" +
            "\t\t\t\"originType\" : 2,\n" +
            "\t\t\t\"originTypeStr\" : \"rtsp_push\",\n" +
            "\t\t\t\"originUrl\" : \"rtsp://139.196.164.210:17108/live/1810865672773238785/1_1?token=73a620a1-4bf1-4d86-b95e-56df641cf695\",\n" +
            "\t\t\t\"readerCount\" : 0,\n" +
            "\t\t\t\"schema\" : \"rtsp\",\n" +
            "\t\t\t\"stream\" : \"1810865672773238785/1_1\",\n" +
            "\t\t\t\"totalReaderCount\" : 1,\n" +
            "\t\t\t\"tracks\" : \n" +
            "\t\t\t[\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"channels\" : 1,\n" +
            "\t\t\t\t\t\"codec_id\" : 2,\n" +
            "\t\t\t\t\t\"codec_id_name\" : \"mpeg4-generic\",\n" +
            "\t\t\t\t\t\"codec_type\" : 1,\n" +
            "\t\t\t\t\t\"duration\" : 8343541,\n" +
            "\t\t\t\t\t\"frames\" : 73811,\n" +
            "\t\t\t\t\t\"ready\" : true,\n" +
            "\t\t\t\t\t\"sample_bit\" : 16,\n" +
            "\t\t\t\t\t\"sample_rate\" : 8000\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"codec_id\" : 0,\n" +
            "\t\t\t\t\t\"codec_id_name\" : \"H264\",\n" +
            "\t\t\t\t\t\"codec_type\" : 0,\n" +
            "\t\t\t\t\t\"duration\" : 8682040,\n" +
            "\t\t\t\t\t\"fps\" : 15.0,\n" +
            "\t\t\t\t\t\"frames\" : 130243,\n" +
            "\t\t\t\t\t\"gop_interval_ms\" : 2063,\n" +
            "\t\t\t\t\t\"gop_size\" : 30,\n" +
            "\t\t\t\t\t\"height\" : 1080,\n" +
            "\t\t\t\t\t\"key_frames\" : 4347,\n" +
            "\t\t\t\t\t\"ready\" : true,\n" +
            "\t\t\t\t\t\"width\" : 1920\n" +
            "\t\t\t\t}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"vhost\" : \"__defaultVhost__\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"aliveSecond\" : 71452,\n" +
            "\t\t\t\"app\" : \"live\",\n" +
            "\t\t\t\"bytesSpeed\" : 614967,\n" +
            "\t\t\t\"createStamp\" : 1728630216,\n" +
            "\t\t\t\"isRecordingHLS\" : true,\n" +
            "\t\t\t\"isRecordingMP4\" : false,\n" +
            "\t\t\t\"originSock\" : \n" +
            "\t\t\t{\n" +
            "\t\t\t\t\"identifier\" : \"299071-48\",\n" +
            "\t\t\t\t\"local_ip\" : \"172.19.59.39\",\n" +
            "\t\t\t\t\"local_port\" : 17108,\n" +
            "\t\t\t\t\"peer_ip\" : \"223.112.98.10\",\n" +
            "\t\t\t\t\"peer_port\" : 19643\n" +
            "\t\t\t},\n" +
            "\t\t\t\"originType\" : 2,\n" +
            "\t\t\t\"originTypeStr\" : \"rtsp_push\",\n" +
            "\t\t\t\"originUrl\" : \"rtsp://139.196.164.210:17108/live/1822912047996399620/1_1?token=2a7a9227-db3a-4078-8f30-86a71a957579\",\n" +
            "\t\t\t\"readerCount\" : 0,\n" +
            "\t\t\t\"schema\" : \"rtsp\",\n" +
            "\t\t\t\"stream\" : \"1822912047996399620/1_1\",\n" +
            "\t\t\t\"totalReaderCount\" : 1,\n" +
            "\t\t\t\"tracks\" : \n" +
            "\t\t\t[\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"channels\" : 1,\n" +
            "\t\t\t\t\t\"codec_id\" : 2,\n" +
            "\t\t\t\t\t\"codec_id_name\" : \"mpeg4-generic\",\n" +
            "\t\t\t\t\t\"codec_type\" : 1,\n" +
            "\t\t\t\t\t\"duration\" : 69742245,\n" +
            "\t\t\t\t\t\"frames\" : 587445,\n" +
            "\t\t\t\t\t\"ready\" : true,\n" +
            "\t\t\t\t\t\"sample_bit\" : 16,\n" +
            "\t\t\t\t\t\"sample_rate\" : 8000\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"codec_id\" : 0,\n" +
            "\t\t\t\t\t\"codec_id_name\" : \"H264\",\n" +
            "\t\t\t\t\t\"codec_type\" : 0,\n" +
            "\t\t\t\t\t\"duration\" : 71453455,\n" +
            "\t\t\t\t\t\"fps\" : 25.0,\n" +
            "\t\t\t\t\t\"frames\" : 1072932,\n" +
            "\t\t\t\t\t\"gop_interval_ms\" : 3357,\n" +
            "\t\t\t\t\t\"gop_size\" : 50,\n" +
            "\t\t\t\t\t\"height\" : 1080,\n" +
            "\t\t\t\t\t\"key_frames\" : 21459,\n" +
            "\t\t\t\t\t\"ready\" : true,\n" +
            "\t\t\t\t\t\"width\" : 1920\n" +
            "\t\t\t\t}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"vhost\" : \"__defaultVhost__\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"aliveSecond\" : 0,\n" +
            "\t\t\t\"app\" : \"live\",\n" +
            "\t\t\t\"bytesSpeed\" : 0,\n" +
            "\t\t\t\"createStamp\" : 1728701668,\n" +
            "\t\t\t\"isRecordingHLS\" : true,\n" +
            "\t\t\t\"isRecordingMP4\" : false,\n" +
            "\t\t\t\"originSock\" : \n" +
            "\t\t\t{\n" +
            "\t\t\t\t\"identifier\" : \"319343-38\",\n" +
            "\t\t\t\t\"local_ip\" : \"172.19.59.39\",\n" +
            "\t\t\t\t\"local_port\" : 17108,\n" +
            "\t\t\t\t\"peer_ip\" : \"36.153.126.194\",\n" +
            "\t\t\t\t\"peer_port\" : 58140\n" +
            "\t\t\t},\n" +
            "\t\t\t\"originType\" : 2,\n" +
            "\t\t\t\"originTypeStr\" : \"rtsp_push\",\n" +
            "\t\t\t\"originUrl\" : \"rtsp://139.196.164.210:17108/live/1791367474531700743/1_1?token=9675950b-7988-4184-9edb-9d53b8e71329\",\n" +
            "\t\t\t\"readerCount\" : 0,\n" +
            "\t\t\t\"schema\" : \"ts\",\n" +
            "\t\t\t\"stream\" : \"1791367474531700743/1_1\",\n" +
            "\t\t\t\"totalReaderCount\" : 1,\n" +
            "\t\t\t\"tracks\" : \n" +
            "\t\t\t[\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"channels\" : 1,\n" +
            "\t\t\t\t\t\"codec_id\" : 2,\n" +
            "\t\t\t\t\t\"codec_id_name\" : \"mpeg4-generic\",\n" +
            "\t\t\t\t\t\"codec_type\" : 1,\n" +
            "\t\t\t\t\t\"duration\" : 1,\n" +
            "\t\t\t\t\t\"frames\" : 2,\n" +
            "\t\t\t\t\t\"ready\" : true,\n" +
            "\t\t\t\t\t\"sample_bit\" : 16,\n" +
            "\t\t\t\t\t\"sample_rate\" : 8000\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"codec_id\" : 0,\n" +
            "\t\t\t\t\t\"codec_id_name\" : \"H264\",\n" +
            "\t\t\t\t\t\"codec_type\" : 0,\n" +
            "\t\t\t\t\t\"duration\" : 0,\n" +
            "\t\t\t\t\t\"fps\" : 15.0,\n" +
            "\t\t\t\t\t\"frames\" : 2,\n" +
            "\t\t\t\t\t\"gop_interval_ms\" : 404,\n" +
            "\t\t\t\t\t\"gop_size\" : 1,\n" +
            "\t\t\t\t\t\"height\" : 1080,\n" +
            "\t\t\t\t\t\"key_frames\" : 1,\n" +
            "\t\t\t\t\t\"ready\" : true,\n" +
            "\t\t\t\t\t\"width\" : 1920\n" +
            "\t\t\t\t}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"vhost\" : \"__defaultVhost__\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"aliveSecond\" : 3,\n" +
            "\t\t\t\"app\" : \"live\",\n" +
            "\t\t\t\"bytesSpeed\" : 543874,\n" +
            "\t\t\t\"createStamp\" : 1728701666,\n" +
            "\t\t\t\"isRecordingHLS\" : true,\n" +
            "\t\t\t\"isRecordingMP4\" : false,\n" +
            "\t\t\t\"originSock\" : \n" +
            "\t\t\t{\n" +
            "\t\t\t\t\"identifier\" : \"319337-41\",\n" +
            "\t\t\t\t\"local_ip\" : \"172.19.59.39\",\n" +
            "\t\t\t\t\"local_port\" : 17108,\n" +
            "\t\t\t\t\"peer_ip\" : \"36.153.126.194\",\n" +
            "\t\t\t\t\"peer_port\" : 58120\n" +
            "\t\t\t},\n" +
            "\t\t\t\"originType\" : 2,\n" +
            "\t\t\t\"originTypeStr\" : \"rtsp_push\",\n" +
            "\t\t\t\"originUrl\" : \"rtsp://139.196.164.210:17108/live/1791367474531700751/1_1?token=9675950b-7988-4184-9edb-9d53b8e71329\",\n" +
            "\t\t\t\"readerCount\" : 0,\n" +
            "\t\t\t\"schema\" : \"ts\",\n" +
            "\t\t\t\"stream\" : \"1791367474531700751/1_1\",\n" +
            "\t\t\t\"totalReaderCount\" : 0,\n" +
            "\t\t\t\"tracks\" : \n" +
            "\t\t\t[\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"channels\" : 1,\n" +
            "\t\t\t\t\t\"codec_id\" : 2,\n" +
            "\t\t\t\t\t\"codec_id_name\" : \"mpeg4-generic\",\n" +
            "\t\t\t\t\t\"codec_type\" : 1,\n" +
            "\t\t\t\t\t\"duration\" : 4357,\n" +
            "\t\t\t\t\t\"frames\" : 41,\n" +
            "\t\t\t\t\t\"loss\" : -1.0,\n" +
            "\t\t\t\t\t\"ready\" : true,\n" +
            "\t\t\t\t\t\"sample_bit\" : 16,\n" +
            "\t\t\t\t\t\"sample_rate\" : 8000\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"codec_id\" : 0,\n" +
            "\t\t\t\t\t\"codec_id_name\" : \"H264\",\n" +
            "\t\t\t\t\t\"codec_type\" : 0,\n" +
            "\t\t\t\t\t\"duration\" : 4613,\n" +
            "\t\t\t\t\t\"fps\" : 15.0,\n" +
            "\t\t\t\t\t\"frames\" : 76,\n" +
            "\t\t\t\t\t\"gop_interval_ms\" : 1941,\n" +
            "\t\t\t\t\t\"gop_size\" : 30,\n" +
            "\t\t\t\t\t\"height\" : 1080,\n" +
            "\t\t\t\t\t\"key_frames\" : 3,\n" +
            "\t\t\t\t\t\"loss\" : -1.0,\n" +
            "\t\t\t\t\t\"ready\" : true,\n" +
            "\t\t\t\t\t\"width\" : 1920\n" +
            "\t\t\t\t}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"vhost\" : \"__defaultVhost__\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"aliveSecond\" : 5,\n" +
            "\t\t\t\"app\" : \"live\",\n" +
            "\t\t\t\"bytesSpeed\" : 244738,\n" +
            "\t\t\t\"createStamp\" : 1728701663,\n" +
            "\t\t\t\"isRecordingHLS\" : true,\n" +
            "\t\t\t\"isRecordingMP4\" : false,\n" +
            "\t\t\t\"originSock\" : \n" +
            "\t\t\t{\n" +
            "\t\t\t\t\"identifier\" : \"319332-39\",\n" +
            "\t\t\t\t\"local_ip\" : \"172.19.59.39\",\n" +
            "\t\t\t\t\"local_port\" : 17108,\n" +
            "\t\t\t\t\"peer_ip\" : \"36.153.126.194\",\n" +
            "\t\t\t\t\"peer_port\" : 58112\n" +
            "\t\t\t},\n" +
            "\t\t\t\"originType\" : 2,\n" +
            "\t\t\t\"originTypeStr\" : \"rtsp_push\",\n" +
            "\t\t\t\"originUrl\" : \"rtsp://139.196.164.210:17108/live/1791367474531700747/1_1?token=9675950b-7988-4184-9edb-9d53b8e71329\",\n" +
            "\t\t\t\"readerCount\" : 0,\n" +
            "\t\t\t\"schema\" : \"ts\",\n" +
            "\t\t\t\"stream\" : \"1791367474531700747/1_1\",\n" +
            "\t\t\t\"totalReaderCount\" : 0,\n" +
            "\t\t\t\"tracks\" : \n" +
            "\t\t\t[\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"channels\" : 1,\n" +
            "\t\t\t\t\t\"codec_id\" : 2,\n" +
            "\t\t\t\t\t\"codec_id_name\" : \"mpeg4-generic\",\n" +
            "\t\t\t\t\t\"codec_type\" : 1,\n" +
            "\t\t\t\t\t\"duration\" : 6791,\n" +
            "\t\t\t\t\t\"frames\" : 62,\n" +
            "\t\t\t\t\t\"loss\" : -1.0,\n" +
            "\t\t\t\t\t\"ready\" : true,\n" +
            "\t\t\t\t\t\"sample_bit\" : 16,\n" +
            "\t\t\t\t\t\"sample_rate\" : 8000\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"codec_id\" : 0,\n" +
            "\t\t\t\t\t\"codec_id_name\" : \"H264\",\n" +
            "\t\t\t\t\t\"codec_type\" : 0,\n" +
            "\t\t\t\t\t\"duration\" : 7268,\n" +
            "\t\t\t\t\t\"fps\" : 15.0,\n" +
            "\t\t\t\t\t\"frames\" : 115,\n" +
            "\t\t\t\t\t\"gop_interval_ms\" : 2005,\n" +
            "\t\t\t\t\t\"gop_size\" : 30,\n" +
            "\t\t\t\t\t\"height\" : 1080,\n" +
            "\t\t\t\t\t\"key_frames\" : 4,\n" +
            "\t\t\t\t\t\"loss\" : -1.0,\n" +
            "\t\t\t\t\t\"ready\" : true,\n" +
            "\t\t\t\t\t\"width\" : 1920\n" +
            "\t\t\t\t}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"vhost\" : \"__defaultVhost__\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"aliveSecond\" : 10,\n" +
            "\t\t\t\"app\" : \"live\",\n" +
            "\t\t\t\"bytesSpeed\" : 1498,\n" +
            "\t\t\t\"createStamp\" : 1728701658,\n" +
            "\t\t\t\"isRecordingHLS\" : true,\n" +
            "\t\t\t\"isRecordingMP4\" : false,\n" +
            "\t\t\t\"originSock\" : null,\n" +
            "\t\t\t\"originType\" : 0,\n" +
            "\t\t\t\"originTypeStr\" : \"unknown\",\n" +
            "\t\t\t\"originUrl\" : \"ts://__defaultVhost__/live/1791367474531700757/1_1\",\n" +
            "\t\t\t\"readerCount\" : 0,\n" +
            "\t\t\t\"schema\" : \"ts\",\n" +
            "\t\t\t\"stream\" : \"1791367474531700757/1_1\",\n" +
            "\t\t\t\"totalReaderCount\" : 0,\n" +
            "\t\t\t\"tracks\" : \n" +
            "\t\t\t[\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"channels\" : 1,\n" +
            "\t\t\t\t\t\"codec_id\" : 2,\n" +
            "\t\t\t\t\t\"codec_id_name\" : \"mpeg4-generic\",\n" +
            "\t\t\t\t\t\"codec_type\" : 1,\n" +
            "\t\t\t\t\t\"duration\" : 3331,\n" +
            "\t\t\t\t\t\"frames\" : 31,\n" +
            "\t\t\t\t\t\"ready\" : true,\n" +
            "\t\t\t\t\t\"sample_bit\" : 16,\n" +
            "\t\t\t\t\t\"sample_rate\" : 8000\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"codec_id\" : 0,\n" +
            "\t\t\t\t\t\"codec_id_name\" : \"H264\",\n" +
            "\t\t\t\t\t\"codec_type\" : 0,\n" +
            "\t\t\t\t\t\"duration\" : 3439,\n" +
            "\t\t\t\t\t\"fps\" : 138.0,\n" +
            "\t\t\t\t\t\"frames\" : 54,\n" +
            "\t\t\t\t\t\"gop_interval_ms\" : 217,\n" +
            "\t\t\t\t\t\"gop_size\" : 30,\n" +
            "\t\t\t\t\t\"height\" : 1080,\n" +
            "\t\t\t\t\t\"key_frames\" : 2,\n" +
            "\t\t\t\t\t\"ready\" : true,\n" +
            "\t\t\t\t\t\"width\" : 1920\n" +
            "\t\t\t\t}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"vhost\" : \"__defaultVhost__\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"aliveSecond\" : 0,\n" +
            "\t\t\t\"app\" : \"live\",\n" +
            "\t\t\t\"bytesSpeed\" : 0,\n" +
            "\t\t\t\"createStamp\" : 1728701668,\n" +
            "\t\t\t\"isRecordingHLS\" : true,\n" +
            "\t\t\t\"isRecordingMP4\" : false,\n" +
            "\t\t\t\"originSock\" : \n" +
            "\t\t\t{\n" +
            "\t\t\t\t\"identifier\" : \"319342-36\",\n" +
            "\t\t\t\t\"local_ip\" : \"172.19.59.39\",\n" +
            "\t\t\t\t\"local_port\" : 17108,\n" +
            "\t\t\t\t\"peer_ip\" : \"36.153.126.194\",\n" +
            "\t\t\t\t\"peer_port\" : 58128\n" +
            "\t\t\t},\n" +
            "\t\t\t\"originType\" : 2,\n" +
            "\t\t\t\"originTypeStr\" : \"rtsp_push\",\n" +
            "\t\t\t\"originUrl\" : \"rtsp://139.196.164.210:17108/live/1791367474531700749/1_1?token=9675950b-7988-4184-9edb-9d53b8e71329\",\n" +
            "\t\t\t\"readerCount\" : 0,\n" +
            "\t\t\t\"schema\" : \"ts\",\n" +
            "\t\t\t\"stream\" : \"1791367474531700749/1_1\",\n" +
            "\t\t\t\"totalReaderCount\" : 0,\n" +
            "\t\t\t\"tracks\" : \n" +
            "\t\t\t[\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"channels\" : 1,\n" +
            "\t\t\t\t\t\"codec_id\" : 2,\n" +
            "\t\t\t\t\t\"codec_id_name\" : \"mpeg4-generic\",\n" +
            "\t\t\t\t\t\"codec_type\" : 1,\n" +
            "\t\t\t\t\t\"duration\" : 1,\n" +
            "\t\t\t\t\t\"frames\" : 2,\n" +
            "\t\t\t\t\t\"loss\" : -1.0,\n" +
            "\t\t\t\t\t\"ready\" : true,\n" +
            "\t\t\t\t\t\"sample_bit\" : 16,\n" +
            "\t\t\t\t\t\"sample_rate\" : 8000\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"codec_id\" : 0,\n" +
            "\t\t\t\t\t\"codec_id_name\" : \"H264\",\n" +
            "\t\t\t\t\t\"codec_type\" : 0,\n" +
            "\t\t\t\t\t\"duration\" : 0,\n" +
            "\t\t\t\t\t\"fps\" : 15.0,\n" +
            "\t\t\t\t\t\"frames\" : 2,\n" +
            "\t\t\t\t\t\"gop_interval_ms\" : 863,\n" +
            "\t\t\t\t\t\"gop_size\" : 1,\n" +
            "\t\t\t\t\t\"height\" : 1080,\n" +
            "\t\t\t\t\t\"key_frames\" : 1,\n" +
            "\t\t\t\t\t\"loss\" : -1.0,\n" +
            "\t\t\t\t\t\"ready\" : true,\n" +
            "\t\t\t\t\t\"width\" : 1920\n" +
            "\t\t\t\t}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"vhost\" : \"__defaultVhost__\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"aliveSecond\" : 13,\n" +
            "\t\t\t\"app\" : \"live\",\n" +
            "\t\t\t\"bytesSpeed\" : 21925,\n" +
            "\t\t\t\"createStamp\" : 1728701656,\n" +
            "\t\t\t\"isRecordingHLS\" : true,\n" +
            "\t\t\t\"isRecordingMP4\" : false,\n" +
            "\t\t\t\"originSock\" : null,\n" +
            "\t\t\t\"originType\" : 0,\n" +
            "\t\t\t\"originTypeStr\" : \"unknown\",\n" +
            "\t\t\t\"originUrl\" : \"ts://__defaultVhost__/live/1791367474531700746/1_1\",\n" +
            "\t\t\t\"readerCount\" : 0,\n" +
            "\t\t\t\"schema\" : \"ts\",\n" +
            "\t\t\t\"stream\" : \"1791367474531700746/1_1\",\n" +
            "\t\t\t\"totalReaderCount\" : 0,\n" +
            "\t\t\t\"tracks\" : \n" +
            "\t\t\t[\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"channels\" : 1,\n" +
            "\t\t\t\t\t\"codec_id\" : 2,\n" +
            "\t\t\t\t\t\"codec_id_name\" : \"mpeg4-generic\",\n" +
            "\t\t\t\t\t\"codec_type\" : 1,\n" +
            "\t\t\t\t\t\"duration\" : 5895,\n" +
            "\t\t\t\t\t\"frames\" : 55,\n" +
            "\t\t\t\t\t\"loss\" : -1.0,\n" +
            "\t\t\t\t\t\"ready\" : true,\n" +
            "\t\t\t\t\t\"sample_bit\" : 16,\n" +
            "\t\t\t\t\t\"sample_rate\" : 8000\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"codec_id\" : 0,\n" +
            "\t\t\t\t\t\"codec_id_name\" : \"H264\",\n" +
            "\t\t\t\t\t\"codec_type\" : 0,\n" +
            "\t\t\t\t\t\"duration\" : 6261,\n" +
            "\t\t\t\t\t\"fps\" : 15.0,\n" +
            "\t\t\t\t\t\"frames\" : 95,\n" +
            "\t\t\t\t\t\"gop_interval_ms\" : 2001,\n" +
            "\t\t\t\t\t\"gop_size\" : 30,\n" +
            "\t\t\t\t\t\"height\" : 1080,\n" +
            "\t\t\t\t\t\"key_frames\" : 4,\n" +
            "\t\t\t\t\t\"loss\" : -1.0,\n" +
            "\t\t\t\t\t\"ready\" : true,\n" +
            "\t\t\t\t\t\"width\" : 1920\n" +
            "\t\t\t\t}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"vhost\" : \"__defaultVhost__\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"aliveSecond\" : 15,\n" +
            "\t\t\t\"app\" : \"live\",\n" +
            "\t\t\t\"bytesSpeed\" : 32646,\n" +
            "\t\t\t\"createStamp\" : 1728701653,\n" +
            "\t\t\t\"isRecordingHLS\" : true,\n" +
            "\t\t\t\"isRecordingMP4\" : false,\n" +
            "\t\t\t\"originSock\" : null,\n" +
            "\t\t\t\"originType\" : 0,\n" +
            "\t\t\t\"originTypeStr\" : \"unknown\",\n" +
            "\t\t\t\"originUrl\" : \"ts://__defaultVhost__/live/1791367474531700754/1_1\",\n" +
            "\t\t\t\"readerCount\" : 0,\n" +
            "\t\t\t\"schema\" : \"ts\",\n" +
            "\t\t\t\"stream\" : \"1791367474531700754/1_1\",\n" +
            "\t\t\t\"totalReaderCount\" : 0,\n" +
            "\t\t\t\"tracks\" : \n" +
            "\t\t\t[\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"channels\" : 1,\n" +
            "\t\t\t\t\t\"codec_id\" : 2,\n" +
            "\t\t\t\t\t\"codec_id_name\" : \"mpeg4-generic\",\n" +
            "\t\t\t\t\t\"codec_type\" : 1,\n" +
            "\t\t\t\t\t\"duration\" : 7945,\n" +
            "\t\t\t\t\t\"frames\" : 73,\n" +
            "\t\t\t\t\t\"loss\" : -1.0,\n" +
            "\t\t\t\t\t\"ready\" : true,\n" +
            "\t\t\t\t\t\"sample_bit\" : 16,\n" +
            "\t\t\t\t\t\"sample_rate\" : 8000\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"codec_id\" : 0,\n" +
            "\t\t\t\t\t\"codec_id_name\" : \"H264\",\n" +
            "\t\t\t\t\t\"codec_type\" : 0,\n" +
            "\t\t\t\t\t\"duration\" : 8333,\n" +
            "\t\t\t\t\t\"fps\" : 15.0,\n" +
            "\t\t\t\t\t\"frames\" : 132,\n" +
            "\t\t\t\t\t\"gop_interval_ms\" : 1998,\n" +
            "\t\t\t\t\t\"gop_size\" : 30,\n" +
            "\t\t\t\t\t\"height\" : 1080,\n" +
            "\t\t\t\t\t\"key_frames\" : 5,\n" +
            "\t\t\t\t\t\"loss\" : -1.0,\n" +
            "\t\t\t\t\t\"ready\" : true,\n" +
            "\t\t\t\t\t\"width\" : 1920\n" +
            "\t\t\t\t}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"vhost\" : \"__defaultVhost__\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"aliveSecond\" : 8690,\n" +
            "\t\t\t\"app\" : \"live\",\n" +
            "\t\t\t\"bytesSpeed\" : 572724,\n" +
            "\t\t\t\"createStamp\" : 1728692978,\n" +
            "\t\t\t\"isRecordingHLS\" : true,\n" +
            "\t\t\t\"isRecordingMP4\" : false,\n" +
            "\t\t\t\"originSock\" : \n" +
            "\t\t\t{\n" +
            "\t\t\t\t\"identifier\" : \"314256-33\",\n" +
            "\t\t\t\t\"local_ip\" : \"172.19.59.39\",\n" +
            "\t\t\t\t\"local_port\" : 17108,\n" +
            "\t\t\t\t\"peer_ip\" : \"117.179.65.135\",\n" +
            "\t\t\t\t\"peer_port\" : 7986\n" +
            "\t\t\t},\n" +
            "\t\t\t\"originType\" : 2,\n" +
            "\t\t\t\"originTypeStr\" : \"rtsp_push\",\n" +
            "\t\t\t\"originUrl\" : \"rtsp://139.196.164.210:17108/live/1810865672773238785/1_1?token=73a620a1-4bf1-4d86-b95e-56df641cf695\",\n" +
            "\t\t\t\"readerCount\" : 0,\n" +
            "\t\t\t\"schema\" : \"ts\",\n" +
            "\t\t\t\"stream\" : \"1810865672773238785/1_1\",\n" +
            "\t\t\t\"totalReaderCount\" : 1,\n" +
            "\t\t\t\"tracks\" : \n" +
            "\t\t\t[\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"channels\" : 1,\n" +
            "\t\t\t\t\t\"codec_id\" : 2,\n" +
            "\t\t\t\t\t\"codec_id_name\" : \"mpeg4-generic\",\n" +
            "\t\t\t\t\t\"codec_type\" : 1,\n" +
            "\t\t\t\t\t\"duration\" : 8343541,\n" +
            "\t\t\t\t\t\"frames\" : 73811,\n" +
            "\t\t\t\t\t\"ready\" : true,\n" +
            "\t\t\t\t\t\"sample_bit\" : 16,\n" +
            "\t\t\t\t\t\"sample_rate\" : 8000\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"codec_id\" : 0,\n" +
            "\t\t\t\t\t\"codec_id_name\" : \"H264\",\n" +
            "\t\t\t\t\t\"codec_type\" : 0,\n" +
            "\t\t\t\t\t\"duration\" : 8682040,\n" +
            "\t\t\t\t\t\"fps\" : 15.0,\n" +
            "\t\t\t\t\t\"frames\" : 130243,\n" +
            "\t\t\t\t\t\"gop_interval_ms\" : 2063,\n" +
            "\t\t\t\t\t\"gop_size\" : 30,\n" +
            "\t\t\t\t\t\"height\" : 1080,\n" +
            "\t\t\t\t\t\"key_frames\" : 4347,\n" +
            "\t\t\t\t\t\"ready\" : true,\n" +
            "\t\t\t\t\t\"width\" : 1920\n" +
            "\t\t\t\t}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"vhost\" : \"__defaultVhost__\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"aliveSecond\" : 71452,\n" +
            "\t\t\t\"app\" : \"live\",\n" +
            "\t\t\t\"bytesSpeed\" : 712645,\n" +
            "\t\t\t\"createStamp\" : 1728630216,\n" +
            "\t\t\t\"isRecordingHLS\" : true,\n" +
            "\t\t\t\"isRecordingMP4\" : false,\n" +
            "\t\t\t\"originSock\" : \n" +
            "\t\t\t{\n" +
            "\t\t\t\t\"identifier\" : \"299071-48\",\n" +
            "\t\t\t\t\"local_ip\" : \"172.19.59.39\",\n" +
            "\t\t\t\t\"local_port\" : 17108,\n" +
            "\t\t\t\t\"peer_ip\" : \"223.112.98.10\",\n" +
            "\t\t\t\t\"peer_port\" : 19643\n" +
            "\t\t\t},\n" +
            "\t\t\t\"originType\" : 2,\n" +
            "\t\t\t\"originTypeStr\" : \"rtsp_push\",\n" +
            "\t\t\t\"originUrl\" : \"rtsp://139.196.164.210:17108/live/1822912047996399620/1_1?token=2a7a9227-db3a-4078-8f30-86a71a957579\",\n" +
            "\t\t\t\"readerCount\" : 0,\n" +
            "\t\t\t\"schema\" : \"ts\",\n" +
            "\t\t\t\"stream\" : \"1822912047996399620/1_1\",\n" +
            "\t\t\t\"totalReaderCount\" : 1,\n" +
            "\t\t\t\"tracks\" : \n" +
            "\t\t\t[\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"channels\" : 1,\n" +
            "\t\t\t\t\t\"codec_id\" : 2,\n" +
            "\t\t\t\t\t\"codec_id_name\" : \"mpeg4-generic\",\n" +
            "\t\t\t\t\t\"codec_type\" : 1,\n" +
            "\t\t\t\t\t\"duration\" : 69742245,\n" +
            "\t\t\t\t\t\"frames\" : 587445,\n" +
            "\t\t\t\t\t\"ready\" : true,\n" +
            "\t\t\t\t\t\"sample_bit\" : 16,\n" +
            "\t\t\t\t\t\"sample_rate\" : 8000\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"codec_id\" : 0,\n" +
            "\t\t\t\t\t\"codec_id_name\" : \"H264\",\n" +
            "\t\t\t\t\t\"codec_type\" : 0,\n" +
            "\t\t\t\t\t\"duration\" : 71453455,\n" +
            "\t\t\t\t\t\"fps\" : 25.0,\n" +
            "\t\t\t\t\t\"frames\" : 1072932,\n" +
            "\t\t\t\t\t\"gop_interval_ms\" : 3357,\n" +
            "\t\t\t\t\t\"gop_size\" : 50,\n" +
            "\t\t\t\t\t\"height\" : 1080,\n" +
            "\t\t\t\t\t\"key_frames\" : 21459,\n" +
            "\t\t\t\t\t\"ready\" : true,\n" +
            "\t\t\t\t\t\"width\" : 1920\n" +
            "\t\t\t\t}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"vhost\" : \"__defaultVhost__\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"aliveSecond\" : 0,\n" +
            "\t\t\t\"app\" : \"live\",\n" +
            "\t\t\t\"bytesSpeed\" : 0,\n" +
            "\t\t\t\"createStamp\" : 1728701668,\n" +
            "\t\t\t\"isRecordingHLS\" : true,\n" +
            "\t\t\t\"isRecordingMP4\" : false,\n" +
            "\t\t\t\"originSock\" : \n" +
            "\t\t\t{\n" +
            "\t\t\t\t\"identifier\" : \"319343-38\",\n" +
            "\t\t\t\t\"local_ip\" : \"172.19.59.39\",\n" +
            "\t\t\t\t\"local_port\" : 17108,\n" +
            "\t\t\t\t\"peer_ip\" : \"36.153.126.194\",\n" +
            "\t\t\t\t\"peer_port\" : 58140\n" +
            "\t\t\t},\n" +
            "\t\t\t\"originType\" : 2,\n" +
            "\t\t\t\"originTypeStr\" : \"rtsp_push\",\n" +
            "\t\t\t\"originUrl\" : \"rtsp://139.196.164.210:17108/live/1791367474531700743/1_1?token=9675950b-7988-4184-9edb-9d53b8e71329\",\n" +
            "\t\t\t\"readerCount\" : 0,\n" +
            "\t\t\t\"schema\" : \"rtmp\",\n" +
            "\t\t\t\"stream\" : \"1791367474531700743/1_1\",\n" +
            "\t\t\t\"totalReaderCount\" : 1,\n" +
            "\t\t\t\"tracks\" : \n" +
            "\t\t\t[\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"channels\" : 1,\n" +
            "\t\t\t\t\t\"codec_id\" : 2,\n" +
            "\t\t\t\t\t\"codec_id_name\" : \"mpeg4-generic\",\n" +
            "\t\t\t\t\t\"codec_type\" : 1,\n" +
            "\t\t\t\t\t\"duration\" : 1,\n" +
            "\t\t\t\t\t\"frames\" : 2,\n" +
            "\t\t\t\t\t\"ready\" : true,\n" +
            "\t\t\t\t\t\"sample_bit\" : 16,\n" +
            "\t\t\t\t\t\"sample_rate\" : 8000\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"codec_id\" : 0,\n" +
            "\t\t\t\t\t\"codec_id_name\" : \"H264\",\n" +
            "\t\t\t\t\t\"codec_type\" : 0,\n" +
            "\t\t\t\t\t\"duration\" : 0,\n" +
            "\t\t\t\t\t\"fps\" : 15.0,\n" +
            "\t\t\t\t\t\"frames\" : 2,\n" +
            "\t\t\t\t\t\"gop_interval_ms\" : 404,\n" +
            "\t\t\t\t\t\"gop_size\" : 1,\n" +
            "\t\t\t\t\t\"height\" : 1080,\n" +
            "\t\t\t\t\t\"key_frames\" : 1,\n" +
            "\t\t\t\t\t\"ready\" : true,\n" +
            "\t\t\t\t\t\"width\" : 1920\n" +
            "\t\t\t\t}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"vhost\" : \"__defaultVhost__\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"aliveSecond\" : 3,\n" +
            "\t\t\t\"app\" : \"live\",\n" +
            "\t\t\t\"bytesSpeed\" : 541115,\n" +
            "\t\t\t\"createStamp\" : 1728701666,\n" +
            "\t\t\t\"isRecordingHLS\" : true,\n" +
            "\t\t\t\"isRecordingMP4\" : false,\n" +
            "\t\t\t\"originSock\" : \n" +
            "\t\t\t{\n" +
            "\t\t\t\t\"identifier\" : \"319337-41\",\n" +
            "\t\t\t\t\"local_ip\" : \"172.19.59.39\",\n" +
            "\t\t\t\t\"local_port\" : 17108,\n" +
            "\t\t\t\t\"peer_ip\" : \"36.153.126.194\",\n" +
            "\t\t\t\t\"peer_port\" : 58120\n" +
            "\t\t\t},\n" +
            "\t\t\t\"originType\" : 2,\n" +
            "\t\t\t\"originTypeStr\" : \"rtsp_push\",\n" +
            "\t\t\t\"originUrl\" : \"rtsp://139.196.164.210:17108/live/1791367474531700751/1_1?token=9675950b-7988-4184-9edb-9d53b8e71329\",\n" +
            "\t\t\t\"readerCount\" : 0,\n" +
            "\t\t\t\"schema\" : \"rtmp\",\n" +
            "\t\t\t\"stream\" : \"1791367474531700751/1_1\",\n" +
            "\t\t\t\"totalReaderCount\" : 0,\n" +
            "\t\t\t\"tracks\" : \n" +
            "\t\t\t[\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"channels\" : 1,\n" +
            "\t\t\t\t\t\"codec_id\" : 2,\n" +
            "\t\t\t\t\t\"codec_id_name\" : \"mpeg4-generic\",\n" +
            "\t\t\t\t\t\"codec_type\" : 1,\n" +
            "\t\t\t\t\t\"duration\" : 4357,\n" +
            "\t\t\t\t\t\"frames\" : 41,\n" +
            "\t\t\t\t\t\"loss\" : -1.0,\n" +
            "\t\t\t\t\t\"ready\" : true,\n" +
            "\t\t\t\t\t\"sample_bit\" : 16,\n" +
            "\t\t\t\t\t\"sample_rate\" : 8000\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"codec_id\" : 0,\n" +
            "\t\t\t\t\t\"codec_id_name\" : \"H264\",\n" +
            "\t\t\t\t\t\"codec_type\" : 0,\n" +
            "\t\t\t\t\t\"duration\" : 4613,\n" +
            "\t\t\t\t\t\"fps\" : 15.0,\n" +
            "\t\t\t\t\t\"frames\" : 76,\n" +
            "\t\t\t\t\t\"gop_interval_ms\" : 1941,\n" +
            "\t\t\t\t\t\"gop_size\" : 30,\n" +
            "\t\t\t\t\t\"height\" : 1080,\n" +
            "\t\t\t\t\t\"key_frames\" : 3,\n" +
            "\t\t\t\t\t\"loss\" : -1.0,\n" +
            "\t\t\t\t\t\"ready\" : true,\n" +
            "\t\t\t\t\t\"width\" : 1920\n" +
            "\t\t\t\t}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"vhost\" : \"__defaultVhost__\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"aliveSecond\" : 5,\n" +
            "\t\t\t\"app\" : \"live\",\n" +
            "\t\t\t\"bytesSpeed\" : 236497,\n" +
            "\t\t\t\"createStamp\" : 1728701663,\n" +
            "\t\t\t\"isRecordingHLS\" : true,\n" +
            "\t\t\t\"isRecordingMP4\" : false,\n" +
            "\t\t\t\"originSock\" : \n" +
            "\t\t\t{\n" +
            "\t\t\t\t\"identifier\" : \"319332-39\",\n" +
            "\t\t\t\t\"local_ip\" : \"172.19.59.39\",\n" +
            "\t\t\t\t\"local_port\" : 17108,\n" +
            "\t\t\t\t\"peer_ip\" : \"36.153.126.194\",\n" +
            "\t\t\t\t\"peer_port\" : 58112\n" +
            "\t\t\t},\n" +
            "\t\t\t\"originType\" : 2,\n" +
            "\t\t\t\"originTypeStr\" : \"rtsp_push\",\n" +
            "\t\t\t\"originUrl\" : \"rtsp://139.196.164.210:17108/live/1791367474531700747/1_1?token=9675950b-7988-4184-9edb-9d53b8e71329\",\n" +
            "\t\t\t\"readerCount\" : 0,\n" +
            "\t\t\t\"schema\" : \"rtmp\",\n" +
            "\t\t\t\"stream\" : \"1791367474531700747/1_1\",\n" +
            "\t\t\t\"totalReaderCount\" : 0,\n" +
            "\t\t\t\"tracks\" : \n" +
            "\t\t\t[\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"channels\" : 1,\n" +
            "\t\t\t\t\t\"codec_id\" : 2,\n" +
            "\t\t\t\t\t\"codec_id_name\" : \"mpeg4-generic\",\n" +
            "\t\t\t\t\t\"codec_type\" : 1,\n" +
            "\t\t\t\t\t\"duration\" : 6791,\n" +
            "\t\t\t\t\t\"frames\" : 62,\n" +
            "\t\t\t\t\t\"loss\" : -1.0,\n" +
            "\t\t\t\t\t\"ready\" : true,\n" +
            "\t\t\t\t\t\"sample_bit\" : 16,\n" +
            "\t\t\t\t\t\"sample_rate\" : 8000\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"codec_id\" : 0,\n" +
            "\t\t\t\t\t\"codec_id_name\" : \"H264\",\n" +
            "\t\t\t\t\t\"codec_type\" : 0,\n" +
            "\t\t\t\t\t\"duration\" : 7268,\n" +
            "\t\t\t\t\t\"fps\" : 15.0,\n" +
            "\t\t\t\t\t\"frames\" : 115,\n" +
            "\t\t\t\t\t\"gop_interval_ms\" : 2005,\n" +
            "\t\t\t\t\t\"gop_size\" : 30,\n" +
            "\t\t\t\t\t\"height\" : 1080,\n" +
            "\t\t\t\t\t\"key_frames\" : 4,\n" +
            "\t\t\t\t\t\"loss\" : -1.0,\n" +
            "\t\t\t\t\t\"ready\" : true,\n" +
            "\t\t\t\t\t\"width\" : 1920\n" +
            "\t\t\t\t}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"vhost\" : \"__defaultVhost__\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"aliveSecond\" : 10,\n" +
            "\t\t\t\"app\" : \"live\",\n" +
            "\t\t\t\"bytesSpeed\" : 1458,\n" +
            "\t\t\t\"createStamp\" : 1728701658,\n" +
            "\t\t\t\"isRecordingHLS\" : true,\n" +
            "\t\t\t\"isRecordingMP4\" : false,\n" +
            "\t\t\t\"originSock\" : null,\n" +
            "\t\t\t\"originType\" : 0,\n" +
            "\t\t\t\"originTypeStr\" : \"unknown\",\n" +
            "\t\t\t\"originUrl\" : \"rtmp://__defaultVhost__/live/1791367474531700757/1_1\",\n" +
            "\t\t\t\"readerCount\" : 0,\n" +
            "\t\t\t\"schema\" : \"rtmp\",\n" +
            "\t\t\t\"stream\" : \"1791367474531700757/1_1\",\n" +
            "\t\t\t\"totalReaderCount\" : 0,\n" +
            "\t\t\t\"tracks\" : \n" +
            "\t\t\t[\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"channels\" : 1,\n" +
            "\t\t\t\t\t\"codec_id\" : 2,\n" +
            "\t\t\t\t\t\"codec_id_name\" : \"mpeg4-generic\",\n" +
            "\t\t\t\t\t\"codec_type\" : 1,\n" +
            "\t\t\t\t\t\"duration\" : 3331,\n" +
            "\t\t\t\t\t\"frames\" : 31,\n" +
            "\t\t\t\t\t\"ready\" : true,\n" +
            "\t\t\t\t\t\"sample_bit\" : 16,\n" +
            "\t\t\t\t\t\"sample_rate\" : 8000\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"codec_id\" : 0,\n" +
            "\t\t\t\t\t\"codec_id_name\" : \"H264\",\n" +
            "\t\t\t\t\t\"codec_type\" : 0,\n" +
            "\t\t\t\t\t\"duration\" : 3439,\n" +
            "\t\t\t\t\t\"fps\" : 138.0,\n" +
            "\t\t\t\t\t\"frames\" : 54,\n" +
            "\t\t\t\t\t\"gop_interval_ms\" : 217,\n" +
            "\t\t\t\t\t\"gop_size\" : 30,\n" +
            "\t\t\t\t\t\"height\" : 1080,\n" +
            "\t\t\t\t\t\"key_frames\" : 2,\n" +
            "\t\t\t\t\t\"ready\" : true,\n" +
            "\t\t\t\t\t\"width\" : 1920\n" +
            "\t\t\t\t}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"vhost\" : \"__defaultVhost__\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"aliveSecond\" : 0,\n" +
            "\t\t\t\"app\" : \"live\",\n" +
            "\t\t\t\"bytesSpeed\" : 0,\n" +
            "\t\t\t\"createStamp\" : 1728701668,\n" +
            "\t\t\t\"isRecordingHLS\" : true,\n" +
            "\t\t\t\"isRecordingMP4\" : false,\n" +
            "\t\t\t\"originSock\" : \n" +
            "\t\t\t{\n" +
            "\t\t\t\t\"identifier\" : \"319342-36\",\n" +
            "\t\t\t\t\"local_ip\" : \"172.19.59.39\",\n" +
            "\t\t\t\t\"local_port\" : 17108,\n" +
            "\t\t\t\t\"peer_ip\" : \"36.153.126.194\",\n" +
            "\t\t\t\t\"peer_port\" : 58128\n" +
            "\t\t\t},\n" +
            "\t\t\t\"originType\" : 2,\n" +
            "\t\t\t\"originTypeStr\" : \"rtsp_push\",\n" +
            "\t\t\t\"originUrl\" : \"rtsp://139.196.164.210:17108/live/1791367474531700749/1_1?token=9675950b-7988-4184-9edb-9d53b8e71329\",\n" +
            "\t\t\t\"readerCount\" : 0,\n" +
            "\t\t\t\"schema\" : \"rtmp\",\n" +
            "\t\t\t\"stream\" : \"1791367474531700749/1_1\",\n" +
            "\t\t\t\"totalReaderCount\" : 0,\n" +
            "\t\t\t\"tracks\" : \n" +
            "\t\t\t[\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"channels\" : 1,\n" +
            "\t\t\t\t\t\"codec_id\" : 2,\n" +
            "\t\t\t\t\t\"codec_id_name\" : \"mpeg4-generic\",\n" +
            "\t\t\t\t\t\"codec_type\" : 1,\n" +
            "\t\t\t\t\t\"duration\" : 1,\n" +
            "\t\t\t\t\t\"frames\" : 2,\n" +
            "\t\t\t\t\t\"loss\" : -1.0,\n" +
            "\t\t\t\t\t\"ready\" : true,\n" +
            "\t\t\t\t\t\"sample_bit\" : 16,\n" +
            "\t\t\t\t\t\"sample_rate\" : 8000\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"codec_id\" : 0,\n" +
            "\t\t\t\t\t\"codec_id_name\" : \"H264\",\n" +
            "\t\t\t\t\t\"codec_type\" : 0,\n" +
            "\t\t\t\t\t\"duration\" : 0,\n" +
            "\t\t\t\t\t\"fps\" : 15.0,\n" +
            "\t\t\t\t\t\"frames\" : 2,\n" +
            "\t\t\t\t\t\"gop_interval_ms\" : 863,\n" +
            "\t\t\t\t\t\"gop_size\" : 1,\n" +
            "\t\t\t\t\t\"height\" : 1080,\n" +
            "\t\t\t\t\t\"key_frames\" : 1,\n" +
            "\t\t\t\t\t\"loss\" : -1.0,\n" +
            "\t\t\t\t\t\"ready\" : true,\n" +
            "\t\t\t\t\t\"width\" : 1920\n" +
            "\t\t\t\t}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"vhost\" : \"__defaultVhost__\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"aliveSecond\" : 13,\n" +
            "\t\t\t\"app\" : \"live\",\n" +
            "\t\t\t\"bytesSpeed\" : 21197,\n" +
            "\t\t\t\"createStamp\" : 1728701656,\n" +
            "\t\t\t\"isRecordingHLS\" : true,\n" +
            "\t\t\t\"isRecordingMP4\" : false,\n" +
            "\t\t\t\"originSock\" : null,\n" +
            "\t\t\t\"originType\" : 0,\n" +
            "\t\t\t\"originTypeStr\" : \"unknown\",\n" +
            "\t\t\t\"originUrl\" : \"rtmp://__defaultVhost__/live/1791367474531700746/1_1\",\n" +
            "\t\t\t\"readerCount\" : 0,\n" +
            "\t\t\t\"schema\" : \"rtmp\",\n" +
            "\t\t\t\"stream\" : \"1791367474531700746/1_1\",\n" +
            "\t\t\t\"totalReaderCount\" : 0,\n" +
            "\t\t\t\"tracks\" : \n" +
            "\t\t\t[\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"channels\" : 1,\n" +
            "\t\t\t\t\t\"codec_id\" : 2,\n" +
            "\t\t\t\t\t\"codec_id_name\" : \"mpeg4-generic\",\n" +
            "\t\t\t\t\t\"codec_type\" : 1,\n" +
            "\t\t\t\t\t\"duration\" : 5895,\n" +
            "\t\t\t\t\t\"frames\" : 55,\n" +
            "\t\t\t\t\t\"loss\" : -1.0,\n" +
            "\t\t\t\t\t\"ready\" : true,\n" +
            "\t\t\t\t\t\"sample_bit\" : 16,\n" +
            "\t\t\t\t\t\"sample_rate\" : 8000\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"codec_id\" : 0,\n" +
            "\t\t\t\t\t\"codec_id_name\" : \"H264\",\n" +
            "\t\t\t\t\t\"codec_type\" : 0,\n" +
            "\t\t\t\t\t\"duration\" : 6261,\n" +
            "\t\t\t\t\t\"fps\" : 15.0,\n" +
            "\t\t\t\t\t\"frames\" : 95,\n" +
            "\t\t\t\t\t\"gop_interval_ms\" : 2001,\n" +
            "\t\t\t\t\t\"gop_size\" : 30,\n" +
            "\t\t\t\t\t\"height\" : 1080,\n" +
            "\t\t\t\t\t\"key_frames\" : 4,\n" +
            "\t\t\t\t\t\"loss\" : -1.0,\n" +
            "\t\t\t\t\t\"ready\" : true,\n" +
            "\t\t\t\t\t\"width\" : 1920\n" +
            "\t\t\t\t}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"vhost\" : \"__defaultVhost__\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"aliveSecond\" : 15,\n" +
            "\t\t\t\"app\" : \"live\",\n" +
            "\t\t\t\"bytesSpeed\" : 12478,\n" +
            "\t\t\t\"createStamp\" : 1728701653,\n" +
            "\t\t\t\"isRecordingHLS\" : true,\n" +
            "\t\t\t\"isRecordingMP4\" : false,\n" +
            "\t\t\t\"originSock\" : null,\n" +
            "\t\t\t\"originType\" : 0,\n" +
            "\t\t\t\"originTypeStr\" : \"unknown\",\n" +
            "\t\t\t\"originUrl\" : \"rtmp://__defaultVhost__/live/1791367474531700754/1_1\",\n" +
            "\t\t\t\"readerCount\" : 0,\n" +
            "\t\t\t\"schema\" : \"rtmp\",\n" +
            "\t\t\t\"stream\" : \"1791367474531700754/1_1\",\n" +
            "\t\t\t\"totalReaderCount\" : 0,\n" +
            "\t\t\t\"tracks\" : \n" +
            "\t\t\t[\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"channels\" : 1,\n" +
            "\t\t\t\t\t\"codec_id\" : 2,\n" +
            "\t\t\t\t\t\"codec_id_name\" : \"mpeg4-generic\",\n" +
            "\t\t\t\t\t\"codec_type\" : 1,\n" +
            "\t\t\t\t\t\"duration\" : 7945,\n" +
            "\t\t\t\t\t\"frames\" : 73,\n" +
            "\t\t\t\t\t\"loss\" : -1.0,\n" +
            "\t\t\t\t\t\"ready\" : true,\n" +
            "\t\t\t\t\t\"sample_bit\" : 16,\n" +
            "\t\t\t\t\t\"sample_rate\" : 8000\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"codec_id\" : 0,\n" +
            "\t\t\t\t\t\"codec_id_name\" : \"H264\",\n" +
            "\t\t\t\t\t\"codec_type\" : 0,\n" +
            "\t\t\t\t\t\"duration\" : 8333,\n" +
            "\t\t\t\t\t\"fps\" : 15.0,\n" +
            "\t\t\t\t\t\"frames\" : 132,\n" +
            "\t\t\t\t\t\"gop_interval_ms\" : 1998,\n" +
            "\t\t\t\t\t\"gop_size\" : 30,\n" +
            "\t\t\t\t\t\"height\" : 1080,\n" +
            "\t\t\t\t\t\"key_frames\" : 5,\n" +
            "\t\t\t\t\t\"loss\" : -1.0,\n" +
            "\t\t\t\t\t\"ready\" : true,\n" +
            "\t\t\t\t\t\"width\" : 1920\n" +
            "\t\t\t\t}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"vhost\" : \"__defaultVhost__\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"aliveSecond\" : 8690,\n" +
            "\t\t\t\"app\" : \"live\",\n" +
            "\t\t\t\"bytesSpeed\" : 588645,\n" +
            "\t\t\t\"createStamp\" : 1728692978,\n" +
            "\t\t\t\"isRecordingHLS\" : true,\n" +
            "\t\t\t\"isRecordingMP4\" : false,\n" +
            "\t\t\t\"originSock\" : \n" +
            "\t\t\t{\n" +
            "\t\t\t\t\"identifier\" : \"314256-33\",\n" +
            "\t\t\t\t\"local_ip\" : \"172.19.59.39\",\n" +
            "\t\t\t\t\"local_port\" : 17108,\n" +
            "\t\t\t\t\"peer_ip\" : \"117.179.65.135\",\n" +
            "\t\t\t\t\"peer_port\" : 7986\n" +
            "\t\t\t},\n" +
            "\t\t\t\"originType\" : 2,\n" +
            "\t\t\t\"originTypeStr\" : \"rtsp_push\",\n" +
            "\t\t\t\"originUrl\" : \"rtsp://139.196.164.210:17108/live/1810865672773238785/1_1?token=73a620a1-4bf1-4d86-b95e-56df641cf695\",\n" +
            "\t\t\t\"readerCount\" : 0,\n" +
            "\t\t\t\"schema\" : \"rtmp\",\n" +
            "\t\t\t\"stream\" : \"1810865672773238785/1_1\",\n" +
            "\t\t\t\"totalReaderCount\" : 1,\n" +
            "\t\t\t\"tracks\" : \n" +
            "\t\t\t[\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"channels\" : 1,\n" +
            "\t\t\t\t\t\"codec_id\" : 2,\n" +
            "\t\t\t\t\t\"codec_id_name\" : \"mpeg4-generic\",\n" +
            "\t\t\t\t\t\"codec_type\" : 1,\n" +
            "\t\t\t\t\t\"duration\" : 8343541,\n" +
            "\t\t\t\t\t\"frames\" : 73811,\n" +
            "\t\t\t\t\t\"ready\" : true,\n" +
            "\t\t\t\t\t\"sample_bit\" : 16,\n" +
            "\t\t\t\t\t\"sample_rate\" : 8000\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"codec_id\" : 0,\n" +
            "\t\t\t\t\t\"codec_id_name\" : \"H264\",\n" +
            "\t\t\t\t\t\"codec_type\" : 0,\n" +
            "\t\t\t\t\t\"duration\" : 8682040,\n" +
            "\t\t\t\t\t\"fps\" : 15.0,\n" +
            "\t\t\t\t\t\"frames\" : 130243,\n" +
            "\t\t\t\t\t\"gop_interval_ms\" : 2063,\n" +
            "\t\t\t\t\t\"gop_size\" : 30,\n" +
            "\t\t\t\t\t\"height\" : 1080,\n" +
            "\t\t\t\t\t\"key_frames\" : 4347,\n" +
            "\t\t\t\t\t\"ready\" : true,\n" +
            "\t\t\t\t\t\"width\" : 1920\n" +
            "\t\t\t\t}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"vhost\" : \"__defaultVhost__\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"aliveSecond\" : 71452,\n" +
            "\t\t\t\"app\" : \"live\",\n" +
            "\t\t\t\"bytesSpeed\" : 680170,\n" +
            "\t\t\t\"createStamp\" : 1728630216,\n" +
            "\t\t\t\"isRecordingHLS\" : true,\n" +
            "\t\t\t\"isRecordingMP4\" : false,\n" +
            "\t\t\t\"originSock\" : \n" +
            "\t\t\t{\n" +
            "\t\t\t\t\"identifier\" : \"299071-48\",\n" +
            "\t\t\t\t\"local_ip\" : \"172.19.59.39\",\n" +
            "\t\t\t\t\"local_port\" : 17108,\n" +
            "\t\t\t\t\"peer_ip\" : \"223.112.98.10\",\n" +
            "\t\t\t\t\"peer_port\" : 19643\n" +
            "\t\t\t},\n" +
            "\t\t\t\"originType\" : 2,\n" +
            "\t\t\t\"originTypeStr\" : \"rtsp_push\",\n" +
            "\t\t\t\"originUrl\" : \"rtsp://139.196.164.210:17108/live/1822912047996399620/1_1?token=2a7a9227-db3a-4078-8f30-86a71a957579\",\n" +
            "\t\t\t\"readerCount\" : 0,\n" +
            "\t\t\t\"schema\" : \"rtmp\",\n" +
            "\t\t\t\"stream\" : \"1822912047996399620/1_1\",\n" +
            "\t\t\t\"totalReaderCount\" : 1,\n" +
            "\t\t\t\"tracks\" : \n" +
            "\t\t\t[\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"channels\" : 1,\n" +
            "\t\t\t\t\t\"codec_id\" : 2,\n" +
            "\t\t\t\t\t\"codec_id_name\" : \"mpeg4-generic\",\n" +
            "\t\t\t\t\t\"codec_type\" : 1,\n" +
            "\t\t\t\t\t\"duration\" : 69742245,\n" +
            "\t\t\t\t\t\"frames\" : 587445,\n" +
            "\t\t\t\t\t\"ready\" : true,\n" +
            "\t\t\t\t\t\"sample_bit\" : 16,\n" +
            "\t\t\t\t\t\"sample_rate\" : 8000\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"codec_id\" : 0,\n" +
            "\t\t\t\t\t\"codec_id_name\" : \"H264\",\n" +
            "\t\t\t\t\t\"codec_type\" : 0,\n" +
            "\t\t\t\t\t\"duration\" : 71453455,\n" +
            "\t\t\t\t\t\"fps\" : 25.0,\n" +
            "\t\t\t\t\t\"frames\" : 1072932,\n" +
            "\t\t\t\t\t\"gop_interval_ms\" : 3357,\n" +
            "\t\t\t\t\t\"gop_size\" : 50,\n" +
            "\t\t\t\t\t\"height\" : 1080,\n" +
            "\t\t\t\t\t\"key_frames\" : 21459,\n" +
            "\t\t\t\t\t\"ready\" : true,\n" +
            "\t\t\t\t\t\"width\" : 1920\n" +
            "\t\t\t\t}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"vhost\" : \"__defaultVhost__\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"aliveSecond\" : 0,\n" +
            "\t\t\t\"app\" : \"live\",\n" +
            "\t\t\t\"bytesSpeed\" : 0,\n" +
            "\t\t\t\"createStamp\" : 1728701668,\n" +
            "\t\t\t\"isRecordingHLS\" : true,\n" +
            "\t\t\t\"isRecordingMP4\" : false,\n" +
            "\t\t\t\"originSock\" : \n" +
            "\t\t\t{\n" +
            "\t\t\t\t\"identifier\" : \"319343-38\",\n" +
            "\t\t\t\t\"local_ip\" : \"172.19.59.39\",\n" +
            "\t\t\t\t\"local_port\" : 17108,\n" +
            "\t\t\t\t\"peer_ip\" : \"36.153.126.194\",\n" +
            "\t\t\t\t\"peer_port\" : 58140\n" +
            "\t\t\t},\n" +
            "\t\t\t\"originType\" : 2,\n" +
            "\t\t\t\"originTypeStr\" : \"rtsp_push\",\n" +
            "\t\t\t\"originUrl\" : \"rtsp://139.196.164.210:17108/live/1791367474531700743/1_1?token=9675950b-7988-4184-9edb-9d53b8e71329\",\n" +
            "\t\t\t\"readerCount\" : 0,\n" +
            "\t\t\t\"schema\" : \"fmp4\",\n" +
            "\t\t\t\"stream\" : \"1791367474531700743/1_1\",\n" +
            "\t\t\t\"totalReaderCount\" : 1,\n" +
            "\t\t\t\"tracks\" : \n" +
            "\t\t\t[\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"channels\" : 1,\n" +
            "\t\t\t\t\t\"codec_id\" : 2,\n" +
            "\t\t\t\t\t\"codec_id_name\" : \"mpeg4-generic\",\n" +
            "\t\t\t\t\t\"codec_type\" : 1,\n" +
            "\t\t\t\t\t\"duration\" : 1,\n" +
            "\t\t\t\t\t\"frames\" : 2,\n" +
            "\t\t\t\t\t\"ready\" : true,\n" +
            "\t\t\t\t\t\"sample_bit\" : 16,\n" +
            "\t\t\t\t\t\"sample_rate\" : 8000\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"codec_id\" : 0,\n" +
            "\t\t\t\t\t\"codec_id_name\" : \"H264\",\n" +
            "\t\t\t\t\t\"codec_type\" : 0,\n" +
            "\t\t\t\t\t\"duration\" : 0,\n" +
            "\t\t\t\t\t\"fps\" : 15.0,\n" +
            "\t\t\t\t\t\"frames\" : 2,\n" +
            "\t\t\t\t\t\"gop_interval_ms\" : 404,\n" +
            "\t\t\t\t\t\"gop_size\" : 1,\n" +
            "\t\t\t\t\t\"height\" : 1080,\n" +
            "\t\t\t\t\t\"key_frames\" : 1,\n" +
            "\t\t\t\t\t\"ready\" : true,\n" +
            "\t\t\t\t\t\"width\" : 1920\n" +
            "\t\t\t\t}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"vhost\" : \"__defaultVhost__\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"aliveSecond\" : 3,\n" +
            "\t\t\t\"app\" : \"live\",\n" +
            "\t\t\t\"bytesSpeed\" : 538831,\n" +
            "\t\t\t\"createStamp\" : 1728701666,\n" +
            "\t\t\t\"isRecordingHLS\" : true,\n" +
            "\t\t\t\"isRecordingMP4\" : false,\n" +
            "\t\t\t\"originSock\" : \n" +
            "\t\t\t{\n" +
            "\t\t\t\t\"identifier\" : \"319337-41\",\n" +
            "\t\t\t\t\"local_ip\" : \"172.19.59.39\",\n" +
            "\t\t\t\t\"local_port\" : 17108,\n" +
            "\t\t\t\t\"peer_ip\" : \"36.153.126.194\",\n" +
            "\t\t\t\t\"peer_port\" : 58120\n" +
            "\t\t\t},\n" +
            "\t\t\t\"originType\" : 2,\n" +
            "\t\t\t\"originTypeStr\" : \"rtsp_push\",\n" +
            "\t\t\t\"originUrl\" : \"rtsp://139.196.164.210:17108/live/1791367474531700751/1_1?token=9675950b-7988-4184-9edb-9d53b8e71329\",\n" +
            "\t\t\t\"readerCount\" : 0,\n" +
            "\t\t\t\"schema\" : \"fmp4\",\n" +
            "\t\t\t\"stream\" : \"1791367474531700751/1_1\",\n" +
            "\t\t\t\"totalReaderCount\" : 0,\n" +
            "\t\t\t\"tracks\" : \n" +
            "\t\t\t[\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"channels\" : 1,\n" +
            "\t\t\t\t\t\"codec_id\" : 2,\n" +
            "\t\t\t\t\t\"codec_id_name\" : \"mpeg4-generic\",\n" +
            "\t\t\t\t\t\"codec_type\" : 1,\n" +
            "\t\t\t\t\t\"duration\" : 4357,\n" +
            "\t\t\t\t\t\"frames\" : 41,\n" +
            "\t\t\t\t\t\"loss\" : -1.0,\n" +
            "\t\t\t\t\t\"ready\" : true,\n" +
            "\t\t\t\t\t\"sample_bit\" : 16,\n" +
            "\t\t\t\t\t\"sample_rate\" : 8000\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"codec_id\" : 0,\n" +
            "\t\t\t\t\t\"codec_id_name\" : \"H264\",\n" +
            "\t\t\t\t\t\"codec_type\" : 0,\n" +
            "\t\t\t\t\t\"duration\" : 4613,\n" +
            "\t\t\t\t\t\"fps\" : 15.0,\n" +
            "\t\t\t\t\t\"frames\" : 76,\n" +
            "\t\t\t\t\t\"gop_interval_ms\" : 1941,\n" +
            "\t\t\t\t\t\"gop_size\" : 30,\n" +
            "\t\t\t\t\t\"height\" : 1080,\n" +
            "\t\t\t\t\t\"key_frames\" : 3,\n" +
            "\t\t\t\t\t\"loss\" : -1.0,\n" +
            "\t\t\t\t\t\"ready\" : true,\n" +
            "\t\t\t\t\t\"width\" : 1920\n" +
            "\t\t\t\t}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"vhost\" : \"__defaultVhost__\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"aliveSecond\" : 5,\n" +
            "\t\t\t\"app\" : \"live\",\n" +
            "\t\t\t\"bytesSpeed\" : 243042,\n" +
            "\t\t\t\"createStamp\" : 1728701663,\n" +
            "\t\t\t\"isRecordingHLS\" : true,\n" +
            "\t\t\t\"isRecordingMP4\" : false,\n" +
            "\t\t\t\"originSock\" : \n" +
            "\t\t\t{\n" +
            "\t\t\t\t\"identifier\" : \"319332-39\",\n" +
            "\t\t\t\t\"local_ip\" : \"172.19.59.39\",\n" +
            "\t\t\t\t\"local_port\" : 17108,\n" +
            "\t\t\t\t\"peer_ip\" : \"36.153.126.194\",\n" +
            "\t\t\t\t\"peer_port\" : 58112\n" +
            "\t\t\t},\n" +
            "\t\t\t\"originType\" : 2,\n" +
            "\t\t\t\"originTypeStr\" : \"rtsp_push\",\n" +
            "\t\t\t\"originUrl\" : \"rtsp://139.196.164.210:17108/live/1791367474531700747/1_1?token=9675950b-7988-4184-9edb-9d53b8e71329\",\n" +
            "\t\t\t\"readerCount\" : 0,\n" +
            "\t\t\t\"schema\" : \"fmp4\",\n" +
            "\t\t\t\"stream\" : \"1791367474531700747/1_1\",\n" +
            "\t\t\t\"totalReaderCount\" : 0,\n" +
            "\t\t\t\"tracks\" : \n" +
            "\t\t\t[\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"channels\" : 1,\n" +
            "\t\t\t\t\t\"codec_id\" : 2,\n" +
            "\t\t\t\t\t\"codec_id_name\" : \"mpeg4-generic\",\n" +
            "\t\t\t\t\t\"codec_type\" : 1,\n" +
            "\t\t\t\t\t\"duration\" : 6791,\n" +
            "\t\t\t\t\t\"frames\" : 62,\n" +
            "\t\t\t\t\t\"loss\" : -1.0,\n" +
            "\t\t\t\t\t\"ready\" : true,\n" +
            "\t\t\t\t\t\"sample_bit\" : 16,\n" +
            "\t\t\t\t\t\"sample_rate\" : 8000\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"codec_id\" : 0,\n" +
            "\t\t\t\t\t\"codec_id_name\" : \"H264\",\n" +
            "\t\t\t\t\t\"codec_type\" : 0,\n" +
            "\t\t\t\t\t\"duration\" : 7268,\n" +
            "\t\t\t\t\t\"fps\" : 15.0,\n" +
            "\t\t\t\t\t\"frames\" : 115,\n" +
            "\t\t\t\t\t\"gop_interval_ms\" : 2005,\n" +
            "\t\t\t\t\t\"gop_size\" : 30,\n" +
            "\t\t\t\t\t\"height\" : 1080,\n" +
            "\t\t\t\t\t\"key_frames\" : 4,\n" +
            "\t\t\t\t\t\"loss\" : -1.0,\n" +
            "\t\t\t\t\t\"ready\" : true,\n" +
            "\t\t\t\t\t\"width\" : 1920\n" +
            "\t\t\t\t}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"vhost\" : \"__defaultVhost__\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"aliveSecond\" : 10,\n" +
            "\t\t\t\"app\" : \"live\",\n" +
            "\t\t\t\"bytesSpeed\" : 65,\n" +
            "\t\t\t\"createStamp\" : 1728701658,\n" +
            "\t\t\t\"isRecordingHLS\" : true,\n" +
            "\t\t\t\"isRecordingMP4\" : false,\n" +
            "\t\t\t\"originSock\" : null,\n" +
            "\t\t\t\"originType\" : 0,\n" +
            "\t\t\t\"originTypeStr\" : \"unknown\",\n" +
            "\t\t\t\"originUrl\" : \"fmp4://__defaultVhost__/live/1791367474531700757/1_1\",\n" +
            "\t\t\t\"readerCount\" : 0,\n" +
            "\t\t\t\"schema\" : \"fmp4\",\n" +
            "\t\t\t\"stream\" : \"1791367474531700757/1_1\",\n" +
            "\t\t\t\"totalReaderCount\" : 0,\n" +
            "\t\t\t\"tracks\" : \n" +
            "\t\t\t[\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"channels\" : 1,\n" +
            "\t\t\t\t\t\"codec_id\" : 2,\n" +
            "\t\t\t\t\t\"codec_id_name\" : \"mpeg4-generic\",\n" +
            "\t\t\t\t\t\"codec_type\" : 1,\n" +
            "\t\t\t\t\t\"duration\" : 3331,\n" +
            "\t\t\t\t\t\"frames\" : 31,\n" +
            "\t\t\t\t\t\"ready\" : true,\n" +
            "\t\t\t\t\t\"sample_bit\" : 16,\n" +
            "\t\t\t\t\t\"sample_rate\" : 8000\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"codec_id\" : 0,\n" +
            "\t\t\t\t\t\"codec_id_name\" : \"H264\",\n" +
            "\t\t\t\t\t\"codec_type\" : 0,\n" +
            "\t\t\t\t\t\"duration\" : 3439,\n" +
            "\t\t\t\t\t\"fps\" : 138.0,\n" +
            "\t\t\t\t\t\"frames\" : 54,\n" +
            "\t\t\t\t\t\"gop_interval_ms\" : 217,\n" +
            "\t\t\t\t\t\"gop_size\" : 30,\n" +
            "\t\t\t\t\t\"height\" : 1080,\n" +
            "\t\t\t\t\t\"key_frames\" : 2,\n" +
            "\t\t\t\t\t\"ready\" : true,\n" +
            "\t\t\t\t\t\"width\" : 1920\n" +
            "\t\t\t\t}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"vhost\" : \"__defaultVhost__\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"aliveSecond\" : 0,\n" +
            "\t\t\t\"app\" : \"live\",\n" +
            "\t\t\t\"bytesSpeed\" : 0,\n" +
            "\t\t\t\"createStamp\" : 1728701668,\n" +
            "\t\t\t\"isRecordingHLS\" : true,\n" +
            "\t\t\t\"isRecordingMP4\" : false,\n" +
            "\t\t\t\"originSock\" : \n" +
            "\t\t\t{\n" +
            "\t\t\t\t\"identifier\" : \"319342-36\",\n" +
            "\t\t\t\t\"local_ip\" : \"172.19.59.39\",\n" +
            "\t\t\t\t\"local_port\" : 17108,\n" +
            "\t\t\t\t\"peer_ip\" : \"36.153.126.194\",\n" +
            "\t\t\t\t\"peer_port\" : 58128\n" +
            "\t\t\t},\n" +
            "\t\t\t\"originType\" : 2,\n" +
            "\t\t\t\"originTypeStr\" : \"rtsp_push\",\n" +
            "\t\t\t\"originUrl\" : \"rtsp://139.196.164.210:17108/live/1791367474531700749/1_1?token=9675950b-7988-4184-9edb-9d53b8e71329\",\n" +
            "\t\t\t\"readerCount\" : 0,\n" +
            "\t\t\t\"schema\" : \"fmp4\",\n" +
            "\t\t\t\"stream\" : \"1791367474531700749/1_1\",\n" +
            "\t\t\t\"totalReaderCount\" : 0,\n" +
            "\t\t\t\"tracks\" : \n" +
            "\t\t\t[\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"channels\" : 1,\n" +
            "\t\t\t\t\t\"codec_id\" : 2,\n" +
            "\t\t\t\t\t\"codec_id_name\" : \"mpeg4-generic\",\n" +
            "\t\t\t\t\t\"codec_type\" : 1,\n" +
            "\t\t\t\t\t\"duration\" : 1,\n" +
            "\t\t\t\t\t\"frames\" : 2,\n" +
            "\t\t\t\t\t\"loss\" : -1.0,\n" +
            "\t\t\t\t\t\"ready\" : true,\n" +
            "\t\t\t\t\t\"sample_bit\" : 16,\n" +
            "\t\t\t\t\t\"sample_rate\" : 8000\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"codec_id\" : 0,\n" +
            "\t\t\t\t\t\"codec_id_name\" : \"H264\",\n" +
            "\t\t\t\t\t\"codec_type\" : 0,\n" +
            "\t\t\t\t\t\"duration\" : 0,\n" +
            "\t\t\t\t\t\"fps\" : 15.0,\n" +
            "\t\t\t\t\t\"frames\" : 2,\n" +
            "\t\t\t\t\t\"gop_interval_ms\" : 863,\n" +
            "\t\t\t\t\t\"gop_size\" : 1,\n" +
            "\t\t\t\t\t\"height\" : 1080,\n" +
            "\t\t\t\t\t\"key_frames\" : 1,\n" +
            "\t\t\t\t\t\"loss\" : -1.0,\n" +
            "\t\t\t\t\t\"ready\" : true,\n" +
            "\t\t\t\t\t\"width\" : 1920\n" +
            "\t\t\t\t}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"vhost\" : \"__defaultVhost__\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"aliveSecond\" : 13,\n" +
            "\t\t\t\"app\" : \"live\",\n" +
            "\t\t\t\"bytesSpeed\" : 21637,\n" +
            "\t\t\t\"createStamp\" : 1728701656,\n" +
            "\t\t\t\"isRecordingHLS\" : true,\n" +
            "\t\t\t\"isRecordingMP4\" : false,\n" +
            "\t\t\t\"originSock\" : null,\n" +
            "\t\t\t\"originType\" : 0,\n" +
            "\t\t\t\"originTypeStr\" : \"unknown\",\n" +
            "\t\t\t\"originUrl\" : \"fmp4://__defaultVhost__/live/1791367474531700746/1_1\",\n" +
            "\t\t\t\"readerCount\" : 0,\n" +
            "\t\t\t\"schema\" : \"fmp4\",\n" +
            "\t\t\t\"stream\" : \"1791367474531700746/1_1\",\n" +
            "\t\t\t\"totalReaderCount\" : 0,\n" +
            "\t\t\t\"tracks\" : \n" +
            "\t\t\t[\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"channels\" : 1,\n" +
            "\t\t\t\t\t\"codec_id\" : 2,\n" +
            "\t\t\t\t\t\"codec_id_name\" : \"mpeg4-generic\",\n" +
            "\t\t\t\t\t\"codec_type\" : 1,\n" +
            "\t\t\t\t\t\"duration\" : 5895,\n" +
            "\t\t\t\t\t\"frames\" : 55,\n" +
            "\t\t\t\t\t\"loss\" : -1.0,\n" +
            "\t\t\t\t\t\"ready\" : true,\n" +
            "\t\t\t\t\t\"sample_bit\" : 16,\n" +
            "\t\t\t\t\t\"sample_rate\" : 8000\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"codec_id\" : 0,\n" +
            "\t\t\t\t\t\"codec_id_name\" : \"H264\",\n" +
            "\t\t\t\t\t\"codec_type\" : 0,\n" +
            "\t\t\t\t\t\"duration\" : 6261,\n" +
            "\t\t\t\t\t\"fps\" : 15.0,\n" +
            "\t\t\t\t\t\"frames\" : 95,\n" +
            "\t\t\t\t\t\"gop_interval_ms\" : 2001,\n" +
            "\t\t\t\t\t\"gop_size\" : 30,\n" +
            "\t\t\t\t\t\"height\" : 1080,\n" +
            "\t\t\t\t\t\"key_frames\" : 4,\n" +
            "\t\t\t\t\t\"loss\" : -1.0,\n" +
            "\t\t\t\t\t\"ready\" : true,\n" +
            "\t\t\t\t\t\"width\" : 1920\n" +
            "\t\t\t\t}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"vhost\" : \"__defaultVhost__\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"aliveSecond\" : 15,\n" +
            "\t\t\t\"app\" : \"live\",\n" +
            "\t\t\t\"bytesSpeed\" : 11713,\n" +
            "\t\t\t\"createStamp\" : 1728701653,\n" +
            "\t\t\t\"isRecordingHLS\" : true,\n" +
            "\t\t\t\"isRecordingMP4\" : false,\n" +
            "\t\t\t\"originSock\" : null,\n" +
            "\t\t\t\"originType\" : 0,\n" +
            "\t\t\t\"originTypeStr\" : \"unknown\",\n" +
            "\t\t\t\"originUrl\" : \"fmp4://__defaultVhost__/live/1791367474531700754/1_1\",\n" +
            "\t\t\t\"readerCount\" : 0,\n" +
            "\t\t\t\"schema\" : \"fmp4\",\n" +
            "\t\t\t\"stream\" : \"1791367474531700754/1_1\",\n" +
            "\t\t\t\"totalReaderCount\" : 0,\n" +
            "\t\t\t\"tracks\" : \n" +
            "\t\t\t[\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"channels\" : 1,\n" +
            "\t\t\t\t\t\"codec_id\" : 2,\n" +
            "\t\t\t\t\t\"codec_id_name\" : \"mpeg4-generic\",\n" +
            "\t\t\t\t\t\"codec_type\" : 1,\n" +
            "\t\t\t\t\t\"duration\" : 7945,\n" +
            "\t\t\t\t\t\"frames\" : 73,\n" +
            "\t\t\t\t\t\"loss\" : -1.0,\n" +
            "\t\t\t\t\t\"ready\" : true,\n" +
            "\t\t\t\t\t\"sample_bit\" : 16,\n" +
            "\t\t\t\t\t\"sample_rate\" : 8000\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"codec_id\" : 0,\n" +
            "\t\t\t\t\t\"codec_id_name\" : \"H264\",\n" +
            "\t\t\t\t\t\"codec_type\" : 0,\n" +
            "\t\t\t\t\t\"duration\" : 8333,\n" +
            "\t\t\t\t\t\"fps\" : 15.0,\n" +
            "\t\t\t\t\t\"frames\" : 132,\n" +
            "\t\t\t\t\t\"gop_interval_ms\" : 1998,\n" +
            "\t\t\t\t\t\"gop_size\" : 30,\n" +
            "\t\t\t\t\t\"height\" : 1080,\n" +
            "\t\t\t\t\t\"key_frames\" : 5,\n" +
            "\t\t\t\t\t\"loss\" : -1.0,\n" +
            "\t\t\t\t\t\"ready\" : true,\n" +
            "\t\t\t\t\t\"width\" : 1920\n" +
            "\t\t\t\t}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"vhost\" : \"__defaultVhost__\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"aliveSecond\" : 8690,\n" +
            "\t\t\t\"app\" : \"live\",\n" +
            "\t\t\t\"bytesSpeed\" : 546579,\n" +
            "\t\t\t\"createStamp\" : 1728692978,\n" +
            "\t\t\t\"isRecordingHLS\" : true,\n" +
            "\t\t\t\"isRecordingMP4\" : false,\n" +
            "\t\t\t\"originSock\" : \n" +
            "\t\t\t{\n" +
            "\t\t\t\t\"identifier\" : \"314256-33\",\n" +
            "\t\t\t\t\"local_ip\" : \"172.19.59.39\",\n" +
            "\t\t\t\t\"local_port\" : 17108,\n" +
            "\t\t\t\t\"peer_ip\" : \"117.179.65.135\",\n" +
            "\t\t\t\t\"peer_port\" : 7986\n" +
            "\t\t\t},\n" +
            "\t\t\t\"originType\" : 2,\n" +
            "\t\t\t\"originTypeStr\" : \"rtsp_push\",\n" +
            "\t\t\t\"originUrl\" : \"rtsp://139.196.164.210:17108/live/1810865672773238785/1_1?token=73a620a1-4bf1-4d86-b95e-56df641cf695\",\n" +
            "\t\t\t\"readerCount\" : 1,\n" +
            "\t\t\t\"schema\" : \"fmp4\",\n" +
            "\t\t\t\"stream\" : \"1810865672773238785/1_1\",\n" +
            "\t\t\t\"totalReaderCount\" : 1,\n" +
            "\t\t\t\"tracks\" : \n" +
            "\t\t\t[\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"channels\" : 1,\n" +
            "\t\t\t\t\t\"codec_id\" : 2,\n" +
            "\t\t\t\t\t\"codec_id_name\" : \"mpeg4-generic\",\n" +
            "\t\t\t\t\t\"codec_type\" : 1,\n" +
            "\t\t\t\t\t\"duration\" : 8343541,\n" +
            "\t\t\t\t\t\"frames\" : 73811,\n" +
            "\t\t\t\t\t\"ready\" : true,\n" +
            "\t\t\t\t\t\"sample_bit\" : 16,\n" +
            "\t\t\t\t\t\"sample_rate\" : 8000\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"codec_id\" : 0,\n" +
            "\t\t\t\t\t\"codec_id_name\" : \"H264\",\n" +
            "\t\t\t\t\t\"codec_type\" : 0,\n" +
            "\t\t\t\t\t\"duration\" : 8682040,\n" +
            "\t\t\t\t\t\"fps\" : 15.0,\n" +
            "\t\t\t\t\t\"frames\" : 130243,\n" +
            "\t\t\t\t\t\"gop_interval_ms\" : 2063,\n" +
            "\t\t\t\t\t\"gop_size\" : 30,\n" +
            "\t\t\t\t\t\"height\" : 1080,\n" +
            "\t\t\t\t\t\"key_frames\" : 4347,\n" +
            "\t\t\t\t\t\"ready\" : true,\n" +
            "\t\t\t\t\t\"width\" : 1920\n" +
            "\t\t\t\t}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"vhost\" : \"__defaultVhost__\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"aliveSecond\" : 71452,\n" +
            "\t\t\t\"app\" : \"live\",\n" +
            "\t\t\t\"bytesSpeed\" : 628594,\n" +
            "\t\t\t\"createStamp\" : 1728630216,\n" +
            "\t\t\t\"isRecordingHLS\" : true,\n" +
            "\t\t\t\"isRecordingMP4\" : false,\n" +
            "\t\t\t\"originSock\" : \n" +
            "\t\t\t{\n" +
            "\t\t\t\t\"identifier\" : \"299071-48\",\n" +
            "\t\t\t\t\"local_ip\" : \"172.19.59.39\",\n" +
            "\t\t\t\t\"local_port\" : 17108,\n" +
            "\t\t\t\t\"peer_ip\" : \"223.112.98.10\",\n" +
            "\t\t\t\t\"peer_port\" : 19643\n" +
            "\t\t\t},\n" +
            "\t\t\t\"originType\" : 2,\n" +
            "\t\t\t\"originTypeStr\" : \"rtsp_push\",\n" +
            "\t\t\t\"originUrl\" : \"rtsp://139.196.164.210:17108/live/1822912047996399620/1_1?token=2a7a9227-db3a-4078-8f30-86a71a957579\",\n" +
            "\t\t\t\"readerCount\" : 1,\n" +
            "\t\t\t\"schema\" : \"fmp4\",\n" +
            "\t\t\t\"stream\" : \"1822912047996399620/1_1\",\n" +
            "\t\t\t\"totalReaderCount\" : 1,\n" +
            "\t\t\t\"tracks\" : \n" +
            "\t\t\t[\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"channels\" : 1,\n" +
            "\t\t\t\t\t\"codec_id\" : 2,\n" +
            "\t\t\t\t\t\"codec_id_name\" : \"mpeg4-generic\",\n" +
            "\t\t\t\t\t\"codec_type\" : 1,\n" +
            "\t\t\t\t\t\"duration\" : 69742245,\n" +
            "\t\t\t\t\t\"frames\" : 587445,\n" +
            "\t\t\t\t\t\"ready\" : true,\n" +
            "\t\t\t\t\t\"sample_bit\" : 16,\n" +
            "\t\t\t\t\t\"sample_rate\" : 8000\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"codec_id\" : 0,\n" +
            "\t\t\t\t\t\"codec_id_name\" : \"H264\",\n" +
            "\t\t\t\t\t\"codec_type\" : 0,\n" +
            "\t\t\t\t\t\"duration\" : 71453455,\n" +
            "\t\t\t\t\t\"fps\" : 25.0,\n" +
            "\t\t\t\t\t\"frames\" : 1072932,\n" +
            "\t\t\t\t\t\"gop_interval_ms\" : 3357,\n" +
            "\t\t\t\t\t\"gop_size\" : 50,\n" +
            "\t\t\t\t\t\"height\" : 1080,\n" +
            "\t\t\t\t\t\"key_frames\" : 21459,\n" +
            "\t\t\t\t\t\"ready\" : true,\n" +
            "\t\t\t\t\t\"width\" : 1920\n" +
            "\t\t\t\t}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"vhost\" : \"__defaultVhost__\"\n" +
            "\t\t}\n" +
            "\t]\n" +
            "}";


    @Test
    void jsonTest(){
        JSONObject parse = JSON.parseObject(json);
        System.out.println(parse);

    }

}

package aki.demo;

import aki.demo.util.HttpClientUtils;
import aki.demo.util.ToolUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Arrays;

public class ReadRaw {
    private static final Logger log = LoggerFactory.getLogger(ReadRaw.class);
    private static int imageWidth;
    private static int imageHeight;
    private static int imageDataLength;

    public static void main(String[] args) throws Exception {
        test();
//        File file = new File("C:\\Users\\SouKon\\Desktop\\raw\\data.raw");
//        byte[] rawData;
//        InputStream inputStream = HttpClientUtils.getStreamForShiHui("http://" + "192.168.5.92" + "/raw",
//                "/raw", "admin", "admin");
//        while (true) {
//            int length = ParseFARawDataHeader(inputStream);
//            if (length!=655404){
//                log.info("length-err:"+length);
//            }
//            if (length > 0) {
//                rawData = ParseVSAVFrame(inputStream, length);
//            } else {
//                rawData = null;
//            }
////            log.info(Arrays.toString(rawData));
//        }

    }

    public static void test(){
        int headerV = 86;
        byte[] vsavHeader = new byte[]{83, 65, 86, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        if (vsavHeader[0] != 'S' || vsavHeader[1] != 'A' || vsavHeader[2] != 'V') {
            log.info("Invalid VSAV header.");
        }
        byte extFrameLen = vsavHeader[21];
        int checkSum = headerV;
        for (int i = 0; i < 22; ++i) {
            checkSum += vsavHeader[i];
        }
        checkSum %= 256;
//        int checkedSum = ((vsavHeader[22] >= 0 && checkSum >= 0) || (vsavHeader[22] < 0 && checkSum < 0)) ? vsavHeader[22] : vsavHeader[22] + 256;
        int checkedSum = vsavHeader[22] & 0xff;
        if ((checkSum & 0xff) != (checkedSum)) {
            log.info("--checkSum--: " + (checkSum & 0xff));
            log.info("--校验和--: " + checkedSum);
            log.info("Invalid check sum.");
        }
    }


    public static int ParseFARawDataHeader(InputStream inputStream) {
        int length;
        try {
            int sync = inputStream.read();
            if (sync == -1) return sync;
            while (sync != '$') {
                log.info("头部不为$,为" + sync + ",读下一位");
                sync = inputStream.read();
            }
            ReadBytes(inputStream, 1);
            byte[] lengthBytes = ReadBytes(inputStream, 4);
            length = ToolUtils.toIntBE(lengthBytes);
//            log.info("头部ok,读到分组长度---:" + length);
        } catch (Exception ex) {
            log.info("Read error: " + ex);
            length = -1;
        }
        return length;
    }


    public static byte[] ParseVSAVFrame(InputStream inputStream, int imgLen) throws IOException {
        int headerV = inputStream.read();
        if (headerV != 'V') {
            log.info("Invalid VSAV header.V");
            return null;
        }
        byte[] vsavHeader = ReadBytes(inputStream, 23);
        if (vsavHeader[0] != 'S' || vsavHeader[1] != 'A' || vsavHeader[2] != 'V') {
            log.info("Invalid VSAV header.");
            return null;
        }
        byte extFrameLen = vsavHeader[21];
        int checkSum = headerV;
        for (int i = 0; i < 22; ++i) {
            checkSum += vsavHeader[i];
        }
        checkSum %= 256;
//        int checkedSum = ((vsavHeader[22] >= 0 && checkSum >= 0) || (vsavHeader[22] < 0 && checkSum < 0)) ? vsavHeader[22] : vsavHeader[22] + 256;
        int checkedSum = vsavHeader[22] & 0xff;
        if ((checkSum & 0xff) != (checkedSum)) {
            log.info("--checkSum--: " + (checkSum & 0xff));
            log.info("--校验和--: " + checkedSum);
            log.info("Invalid check sum.");
            return null;
        }
        if (extFrameLen > 0) {
            // Read extern frame
            byte[] extFrame = ReadBytes(inputStream, extFrameLen);
            switch (extFrame[0]) {
                case (byte) 0x82: {
//                    log.info("扩展类型为:" + "0x82");
                    if (imageWidth == 0 || imageHeight == 0) {
                        byte[] strideWidthBytes = {extFrame[2], extFrame[3]};
                        int strideWidth = ToolUtils.toIntLE(strideWidthBytes);
                        byte[] widthBytes = {extFrame[4], extFrame[5]};
                        imageWidth = ToolUtils.toIntLE(widthBytes);
                        byte[] heightBytes = {extFrame[6], extFrame[7]};
                        int height = ToolUtils.toIntLE(heightBytes);
                        //奇偶数判断
                        if (height % 2 == 0) {
                            imageHeight = ToolUtils.toIntLE(heightBytes);
                        } else {
                            imageHeight = ToolUtils.toIntLE(heightBytes) - 1;
                        }
                        log.info("图片宽:" + imageWidth);
                        log.info("图片高：" + imageHeight);
                        log.info("图片stride:" + strideWidth);
                        imageDataLength = imageHeight * strideWidth;
                        log.info("获取raw数据的宽高:" + imageWidth + "," + imageHeight);

                    }
                }
                break;
//                case (byte) 0x81:
//                    log.info("扩展类型为:" + "0x81");
//                    break;
                default:
                    if (imageWidth == 0 || imageHeight == 0) {
                        imageWidth = 960;
                        imageHeight = 540;
                        imageDataLength = imageHeight * imageWidth * 2;
                    }
                    break;
            }
        }
        //分段长度-帧尾-扩展帧头-帧尾
        int rawLen = imgLen - 24 - extFrameLen - 8;
        byte[] raw = ReadFARawData(inputStream, rawLen);
        ReadBytes(inputStream, 8);
//        log.info("--------读到raw:----------");
        return raw;
    }


    private static byte[] ReadFARawData(InputStream inputStream, int bufSize) {
        int ret = 0;
        byte[] rawData = null;
        int readsize = 0;           //已经读取的字节数
        int remain = bufSize;       //还需读取的字节数
        try {
            rawData = new byte[bufSize];
            while ((ret = inputStream.read(rawData, readsize, remain)) > 0) {
                readsize += ret;
                remain -= ret;
            }
        } catch (Exception e) {
            rawData = null;
        }
        return rawData;
    }


    private static byte[] ReadBytes(InputStream inputStream, int bytesLength) {
        byte[] bytes;
        try {
            bytes = new byte[bytesLength];
            inputStream.read(bytes);
        } catch (Exception e) {
            bytes = null;
        }
        return bytes;
    }

}

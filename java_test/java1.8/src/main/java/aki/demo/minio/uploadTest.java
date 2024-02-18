package aki.demo.minio;

import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.UploadObjectArgs;
import io.minio.errors.MinioException;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class uploadTest {

    public static void main(String[] args) {
        uploadFileFromHttpUrl();
    }

    // 将指定URL的MP4文件上传到MinIO服务器的方法
    public static void uploadFileFromHttpUrl() {
        try {
            //MinIO所需的认证信息
            String accessKey = "iHRQWlZAgERaGk7V";
            String secretKey = "BN9ttW5JINWL3zJK5suuv4r22glCwdcq";
            String endpoint = "YOUR_ENDPOINT";

            //创建MinIO客户端对象
            MinioClient minioClient = new MinioClient.Builder()
                    .endpoint("http://192.168.9.5:9000")
                    .credentials(accessKey, secretKey)
                    .build();

            // 创建连接并获取输入流
//            URL fileUrl = new URL(url);
//            URLConnection connection = fileUrl.openConnection();
//            InputStream file = connection.getInputStream();
            URL url = new URL("http://192.168.9.148:8800//drone/12345/record/live/1571835122427105282/165-0-7/normal-0/2023-01-11/13-16-12.mp4");
            InputStream inputStream = url.openStream();
            // 上传文件
            URLConnection connection = url.openConnection();
            long objectSize = connection.getContentLengthLong();
            String contentType = connection.getContentType();
            minioClient.putObject(
                    PutObjectArgs.builder()
                            .bucket("accesstest")
                            .object("example.mp4")
//                            .stream(inputStream, -1, 10 * 1024 * 1024L)
                            .stream(inputStream, objectSize, -1)
                            .build());
        } catch (IOException | MinioException e) {
            System.out.println("Error occurred: " + e.getMessage());
            e.printStackTrace();
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            throw new RuntimeException(e);
        }
    }
}

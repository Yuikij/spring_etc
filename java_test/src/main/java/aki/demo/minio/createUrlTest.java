package aki.demo.minio;

import io.minio.GetPresignedObjectUrlArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.errors.MinioException;
import io.minio.http.Method;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class createUrlTest {

    public static void main(String[] args) {
        uploadFileFromHttpUrl();
    }

    // 将指定URL的MP4文件上传到MinIO服务器的方法
    public static void uploadFileFromHttpUrl() {
        try {
            //MinIO所需的认证信息
            String accessKey = "iHRQWlZAgERaGk7V";
            String secretKey = "BN9ttW5JINWL3zJK5suuv4r22glCwdcq";
            String endpoint = "http://192.168.9.5:9000";
            String fileUrl = "http://192.168.9.148:8800//drone/12345/record/live/1571835122427105282/165-0-7/normal-0/2023-01-11/13-16-12.mp4";
            String ketName = "example.mp4";
            String bucket = "accesstest";
            //创建MinIO客户端对象
            MinioClient minioClient = new MinioClient.Builder()
                    .endpoint(endpoint)
                    .credentials(accessKey, secretKey)
                    .build();

            HashMap<String, String> headers = new HashMap<>();
//            headers.put("Content-Type","video/mp4");
            headers.put("Content-Disposition","inline; filename=example.mp4");
            GetPresignedObjectUrlArgs args = GetPresignedObjectUrlArgs.builder()
                    .bucket(bucket).object(ketName).method(Method.GET)
//                    .extraHeaders(headers)
                    .expiry(7, TimeUnit.DAYS).build();
            System.out.println(minioClient.getPresignedObjectUrl(args));
        } catch (IOException | MinioException e) {
            System.out.println("Error occurred: " + e.getMessage());
            e.printStackTrace();
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            throw new RuntimeException(e);
        }
    }
}

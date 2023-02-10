package aki.demo.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;


import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class HttpClientUtils {


    public static HttpResponse doGet(HttpClient httpClient, String url) {
        HttpGet httpGet = new HttpGet(url);
        try {
//            RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(30000)
//                    .setSocketTimeout(30000).setConnectTimeout(30000).build();
//            httpGet.setConfig(requestConfig);
            httpGet.setHeader("Content-type", "Raw/VSAV;fps=" + 5);
            httpGet.setHeader("User-Agent", "Raw Client");
            httpGet.setHeader("Connection", "Keep-Alive");
//            httpGet.setHeader("Accept", "*/*");
//            httpGet.setHeader("keep-alive", "on");
            httpGet.setHeader("Cache-Control", "no-cache");
            return httpClient.execute(httpGet);
        } catch (Exception e) {
      
            return null;
        }
    }


    public static InputStream getStreamForShiHui(String url, String dir, String username, String password) {
        InputStream inputStream = null;
        try {
            HttpClient httpClient = HttpClientBuilder.create().build();
            HttpResponse httpResponse = doGet(httpClient, url);
            HttpResponse authResponse = getAuthResponse(httpClient, httpResponse, url, dir, username, password);
            System.out.println(authResponse.getStatusLine().getStatusCode());
            inputStream = authResponse.getEntity().getContent();
        } catch (Exception e) {
       
        }

        return inputStream;
    }

    public static HttpResponse getAuthResponse(HttpClient httpClient, HttpResponse response, String url, String dir, String username, String password) {
        try {
            if (HttpStatus.SC_UNAUTHORIZED == response.getStatusLine().getStatusCode()) {
                Header[] headers = response.getHeaders("WWW-Authenticate");
                HeaderElement[] elements = headers[0].getElements();
                String realm = null;
                String qop = null;
                String nonce = null;
                String opaque = null;
                String method = "GET";
                String uri = dir;
                for (HeaderElement element : elements) {
                    if (element.getName().equals("Digest realm")) {
                        realm = element.getValue();
                    } else if (element.getName().equals("qop")) {
                        qop = element.getValue();
                    } else if (element.getName().equals("nonce")) {
                        nonce = element.getValue();
//                        nonce = "element.getValue()";
                    } else if (element.getName().equals("opaque")) {
                        opaque = element.getValue();
                    }
                }
                String responseHeader = getAuthorization(realm, dir, username, password, nonce);
//                org.apache.http.client.HttpClient httpClient = HttpClientBuilder.create().build();
                HttpGet httpGet = new HttpGet(url);
//                RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(30000)
//                        .setSocketTimeout(30000).setConnectTimeout(30000).build();
//                httpGet.setConfig(requestConfig);
                httpGet.setHeader("Authorization", responseHeader);
                httpGet.setHeader("Connection", "keep-alive");
//                httpGet.setHeader("Content-type", "Raw/VSAV");
                httpGet.setHeader("Content-type", "Raw/VSAV;fps=" + 56);
                httpGet.setHeader("User-Agent", "Raw Client");
                httpGet.setHeader("Connection", "Keep-Alive");
                httpGet.setHeader("Cache-Control", "no-cache");
                HttpResponse response2 = httpClient.execute(httpGet);
                if (HttpStatus.SC_UNAUTHORIZED == response2.getStatusLine().getStatusCode()) {
                    System.out.println("--------请求401，再次请求-------");
                    System.out.println();
//                    return getAuthResponse(response2, url, dir, username, password);
                } else {
                    System.out.println("--------请求" + response2.getStatusLine().getStatusCode() + "，结束请求-------");
                }
                return response2;
            } else {
                System.out.println("--------请求" + response.getStatusLine().getStatusCode() + "，结束请求-------");
                return response;
            }

        } catch (Exception e) {

            return null;
        }
    }

    //获取Authorization信息
    public static String getAuthorization(String realm, String dir, String username, String password, String nonce) {
        String method = "GET";
        String a1 = username + ":" + realm + ":" + password;
        String a2 = method + ":" + dir;
        String response1 = null;
        String algorithm = "MD5";
        try {
            String ha1 = DigestUtils.md5Hex(a1.getBytes(StandardCharsets.UTF_8));
            String ha2 = DigestUtils.md5Hex(a2.getBytes(StandardCharsets.UTF_8));
            response1 = DigestUtils.md5Hex((ha1 + ":" + nonce + ":" + ha2).getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {

        }
        return "Digest username=\"" + username + "\""
                + ", realm=\"" + realm + "\""
                + ", nonce=\"" + nonce + "\""
                + ", uri=\"" + dir + "\""
                + ", algorithm=\"" + algorithm + "\""
                + ", response=\"" + response1 + "\"";
    }
}

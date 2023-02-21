package aki.netty;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTest {
    private static final String IP = "127.0.0.1";
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("[*] Listening on " + IP + ":" + PORT);
            while (true) {
                Socket client = server.accept();
                System.out.println("[*] Accepted connection from " + client.getInetAddress().getHostAddress() + ":" + client.getPort());
                Thread clientHandler = new Thread(new ClientHandler(client));
                clientHandler.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler implements Runnable {
        private final Socket clientSocket;

        public ClientHandler(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try (InputStream inputStream = clientSocket.getInputStream();
                 OutputStream outputStream = clientSocket.getOutputStream()) {
                //接受串口设备发过来心跳包
                byte[] buffer = new byte[10];
                int bytesRead = inputStream.read(buffer);
                System.out.println("Receive...\n");
                //原始数据是字节流数据
                System.out.println(bytesToHex(buffer));
                System.out.println("--------------");

                //read wind speed，问询帧
                String hexStr = "010300000001840A";
                //将 16 进制字符串转换成字节流序列
                byte[] data = hexStringToByteArray(hexStr);
                outputStream.write(data);

                //SIM 卡 ICCID 用来表示该数据从那个地方发过来，一个 ICCID 对应一个点位，20 个数字,十进制表示
                byte[] iccid = new byte[20];
                bytesRead = inputStream.read(iccid);
                System.out.println("Receive ICCID..\n");
                System.out.println(new String(iccid, "UTF-8"));
                System.out.println("--------------");

                //在读取 7 个字节数据，其中第四和第五个字节组成风速
                byte[] windValue = new byte[7];
                bytesRead = inputStream.read(windValue);
                System.out.println("Receive Wind Speed..\n");
                System.out.println(bytesToHex(windValue));
                System.out.println("--------------");

                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private static String bytesToHex(byte[] bytes) {
            StringBuilder hex = new StringBuilder();
            for (byte b : bytes) {
                hex.append(String.format("%02X", b));
            }
            return hex.toString();
        }

        private static byte[] hexStringToByteArray(String s) {
            int len = s.length();
            byte[] data = new byte[len / 2];
            for (int i = 0; i < len; i += 2) {
                data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                        + Character.digit(s.charAt(i + 1), 16));
            }
            return data;
        }
    }
}

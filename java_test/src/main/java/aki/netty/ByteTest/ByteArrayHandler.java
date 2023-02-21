package aki.netty.ByteTest;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import org.apache.commons.codec.binary.Hex;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutionException;

public class ByteArrayHandler extends SimpleChannelInboundHandler<ByteBuf> {

    private byte[] readBytes(ByteBuf buf, int length) {
        int readableBytes = buf.readableBytes();
        byte[] res;
        if (readableBytes >= length) {
            res = new byte[length];
        } else {
            res = new byte[readableBytes];
        }
        buf.readBytes(res);
        return res;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) {
        try {
            byte[] array = readBytes(msg, 20);
            System.out.println("array1: " + Hex.encodeHexString(array));
            if (array.length == 1 && Byte.toUnsignedLong(array[0]) == 0Xaa) {
                String hexString = "010300000001840A";
                long value = Long.parseLong(hexString, 16);
                ByteBuf data = Unpooled.copyLong(value);
                ChannelFuture channelFuture = ctx.writeAndFlush(data);
                channelFuture.sync();
                channelFuture.addListener((ChannelFutureListener) future -> {
                    if (future.isSuccess()) {
                            byte[] array1 = readBytes(msg, 20);
                            String ICCID = new String(array1, StandardCharsets.UTF_8);
                        System.out.println("Received ICCID: " + ICCID);
                        // 操作成功完成
                    } else {
                        // 操作失败，可以通过future.cause()方法获取失败的原因
                    }
                });
            }

//                array = readBytes(msg, 20);
//                String ICCID = new String(array, StandardCharsets.UTF_8);
//                System.out.println("Received ICCID: " + ICCID);
//                byte[] array1 = readBytes(msg, 7);
//                System.out.println("array2: " + Hex.encodeHexString(array1));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



//    @Override
//    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf buf) {
//        try {
//            // 接收数据并处理
//            System.out.println("Receive...");
//            byte[] bytes = new byte[buf.readableBytes()];
//            buf.readBytes(bytes);
//            System.out.println(bytes);
//            System.out.println(bytesToHex(bytes));
//            System.out.println("--------------");
//
//            String hexStr = "010300000001840A";
//            byte[] request = hexStringToByteArray(hexStr);
//            ctx.writeAndFlush(ctx.alloc().buffer().writeBytes(request));
//
//            byte[] iccid = new byte[20];
//            buf.readBytes(iccid);
//            System.out.println("Receive ICCID...");
//            System.out.println(iccid);
//            System.out.println(new String(iccid, "UTF-8"));
//            System.out.println("--------------");
//
//            byte[] windValue = new byte[7];
//            buf.readBytes(windValue);
//            System.out.println("Receive Wind Speed...");
//            System.out.println(windValue);
//            System.out.println(bytesToHex(windValue));
//            System.out.println("--------------");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    private static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i + 1), 16));
        }
        return data;
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02X", b));
        }
        return sb.toString();

    }
}
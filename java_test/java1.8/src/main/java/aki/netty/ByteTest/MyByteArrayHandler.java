package aki.netty.ByteTest;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import org.apache.commons.codec.binary.Hex;

import java.nio.charset.StandardCharsets;

public class MyByteArrayHandler extends ChannelInboundHandlerAdapter {

    private ByteBuf msg; // 保存未处理的数据

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
    public void channelRead(ChannelHandlerContext ctx, Object obj) throws Exception {
        try {
            msg = (ByteBuf) obj;
            byte[] array = readBytes(msg, 20);
            System.out.println("array1: " + Hex.encodeHexString(array));
            if (array.length == 1 && Byte.toUnsignedLong(array[0]) == 0Xaa) {
                String hexString = "010300000001840A";
                long value = Long.parseLong(hexString, 16);
                ByteBuf data = Unpooled.copyLong(value);
                ChannelFuture channelFuture = ctx.writeAndFlush(data);
            }
//            array = readBytes(msg, 20);
//            String ICCID = new String(array, StandardCharsets.UTF_8);
//            System.out.println("Received ICCID: " + ICCID);
//            byte[] array1 = readBytes(msg, 7);
//            System.out.println("array2: " + Hex.encodeHexString(array1));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        byte[] array = readBytes(msg, 20);
        array = readBytes(msg, 20);
        String ICCID = new String(array, StandardCharsets.UTF_8);
        System.out.println("Received ICCID: " + ICCID);
        byte[] array1 = readBytes(msg, 7);
        System.out.println("array2: " + Hex.encodeHexString(array1));
        // 处理所有剩余的数据
        // 这里可以将保存的未处理数据和新接收到的数据合并成一个完整的消息
        // 然后调用 fireChannelRead() 方法将完整的消息传递到下一个处理器
    }

}
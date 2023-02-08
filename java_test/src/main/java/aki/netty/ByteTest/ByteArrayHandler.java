package aki.netty.ByteTest;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.apache.commons.codec.binary.Hex;

import java.nio.charset.StandardCharsets;

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
                ctx.writeAndFlush(data);
            } else {
                String ICCID = new String(array, StandardCharsets.UTF_8);
                System.out.println("Received ICCID: " + ICCID);
                byte[] array1 = readBytes(msg, 7);
                System.out.println("array2: " + Hex.encodeHexString(array1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
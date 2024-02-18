package aki.netty;

import javax.xml.bind.DatatypeConverter;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
//        int a =  (int)(byte)(0Xaa&0Xff);
//        System.out.println(Integer.toBinaryString(a) );
//        System.out.println(Integer.toBinaryString(0Xaa&0Xff) );
//        System.out.println(Byte.toUnsignedInt((byte)(0Xaa&0Xff)) );
//        System.out.println(Integer.toBinaryString(0Xaa) );
//        System.out.println(a);
        String hexString = "010300000001840A";
//        byte[] bytes = DatatypeConverter.parseHexBinary(hexString);
//        System.out.println(Arrays.toString(bytes));
        System.out.println(Long.parseLong("010300000001840A", 16));


        byte[] byteArray = new byte[]{(byte) 0Xaa};
        long value = ByteBuffer.wrap(byteArray).getLong();
        System.out.println(value);
    }
}

package aki.onjava.enums;

import java.util.Arrays;

public enum EnumsTest {
    A, B;



    public static void main(String[] args) {
        System.out.println(A.ordinal());
        System.out.println(A.name());
        System.out.println(Arrays.toString(B.getClass().getEnumConstants()));
//        EnumsTest[] values = EnumsTest.values();
//        System.out.println(Arrays.toString(values));
//        System.out.println(EnumsTest.valueOf("A"));
    }
}

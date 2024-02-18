package aki.string;

public class StringTest {
    public static void main(String[] args) {
        test2();
    }

    public static void test4() {
        String s = new String("12");
        String s2 = new String("1") + new String("2");
        String s3 = "12";
        System.out.println(s2 == s);
    }

    public static void test2() {
        String s = new String("1");
        s.intern();
        String s2 = "1";
        System.out.println(s == s2);

        String s3 = new String("1") + new String("1");
        s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4);
    }

    public static void test1() {
        String s2 = new String("11");
        String s3 = new String("1") + new String("1");

        String s4 = "11";
        System.out.println(s2 == s4);
        System.out.println(s3 == s4);
        System.out.println(s2.intern() == s4);
    }
}

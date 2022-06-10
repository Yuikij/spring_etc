package aki.string;

public class StringTest {
    public static void main(String[] args) {
        String s2 = new String("11");
        String s3 = new String("1") + new String("1");
        s2.intern();
        String s4 = "11";
        System.out.println(s2 == s4);
        System.out.println(s3 == s4);
    }
}

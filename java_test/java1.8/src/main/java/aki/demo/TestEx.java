package aki.demo;

public class TestEx {
    public static void main(String[] args) {
        test1();
    }

    private static void test1(){
        System.out.println(1);
        try {
            throw new NullPointerException();
        }catch (IllegalAccessError e){
            System.out.println(3);
            e.printStackTrace();
        }
        System.out.println(2);
    }
}

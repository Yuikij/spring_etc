package aki.并发.Final;

public class finalTest {
    static Foo foo;

    static class Foo {
        final int a;
        int b;

        Foo() {
            this.a = 1;
            b = 2;
        }
    }

    public static void write() {
        foo = new Foo();
    }

    public static void read() {
        if (foo != null) {
            System.out.println(foo.a);
            System.out.println(foo.b);
        }
    }

    public static void main(String[] args) {

    }
}

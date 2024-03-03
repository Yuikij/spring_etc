package aki.并发.Final;

import aki.common.utiles.ConcurrentUtils;

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
        System.out.println("-----write-----");
    }

    public static void read() {
        System.out.println("-----read-----");
        if (foo != null) {
            System.out.println(foo.a);
            System.out.println(foo.b);
        }
    }

    public static void main(String[] args) {
        ConcurrentUtils.oneMultiRun(10000,finalTest::read,null);
        ConcurrentUtils.sleep(20);
        write();
    }
}

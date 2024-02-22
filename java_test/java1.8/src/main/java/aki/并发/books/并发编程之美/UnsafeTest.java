package aki.并发.books.并发编程之美;

import sun.misc.Unsafe;

import java.util.Random;

public class UnsafeTest {
    static final Unsafe unsafe = Unsafe.getUnsafe();

    public static void main(String[] args) {
        System.out.println(unsafe);
        Random random = new Random();
    }
}

package aki.并发.books.并发编程之美;

public class ThreadLocalTest {
    static void print(){
        System.out.println(threadLocal);
    }

    static ThreadLocal<String> threadLocal = new ThreadLocal<>();

}

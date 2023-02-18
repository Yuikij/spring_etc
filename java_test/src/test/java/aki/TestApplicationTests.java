package aki;

import com.google.common.base.Stopwatch;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StopWatch;

import java.util.ArrayList;

//@SpringBootTest
class TestApplicationTests {

    class A {
        public void test() {
            System.out.println("A");
        }
    }

    class B extends A {
        public void test() {
            System.out.println("B");
        }
        public void test2() {
            System.out.println("B2");
        }
    }

    @Test
    void testStopwatch() throws InterruptedException {
        Stopwatch stopwatch = Stopwatch.createStarted();
        Thread.sleep(1000);
        System.out.println(stopwatch.elapsed().toMillis());
        Thread.sleep(1000);
        System.out.println(stopwatch.elapsed().toMillis());
    }
    @Test
    void contextLoads() {
//        ArrayList
        B b = new B();
        A a = b;
        a.test();
    }

}

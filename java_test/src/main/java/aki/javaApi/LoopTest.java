package aki.javaApi;

import java.util.Arrays;

public class LoopTest {

    public static void main(String[] args) {


        test5();


    }

    private static void test1() {
        Arrays.asList(1, 2, 3).forEach(e -> {
            if (e == 2) {
                return;
            }
            System.out.println(e);
        });
    }

    private static void test2() {
        for (Integer e : Arrays.asList(1, 2, 3)) {
            if (e == 2) {
                continue;
            }
            System.out.println(e);
        }
    }

    private static void test3() {
        for (Integer e : Arrays.asList(1, 2, 3)) {
            if (e == 2) {
                return;
            }
            System.out.println(e);
        }
    }

    private static void test4() {
        Arrays.asList(1, 2, 3).forEach(e -> {
            Arrays.asList(1, 2, 3).forEach(e1 -> {
                if (e1 == 2) {
                    return;
                }
                System.out.println("e1:" + e1);
            });
            System.out.println("e:" + e);
        });
    }

    private static void test5() {
        for (Integer e : Arrays.asList(1, 2, 3)) {
            for (Integer e1 : Arrays.asList(1, 2, 3)) {
                if (e1 == 2) {
                    continue;
                }
                System.out.println("e1:" + e1);
            }
            System.out.println("e:" + e);
        }
    }
}

package aki;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

public class Test2 {
    public static void main(String[] args) {
//        System.out.println((8 > 1) ? (3200 >>> 3) / 8 : 3200);
        ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(new Integer[1000]));

        for (int i = 0; i < 1000; i++) {
            integers.add(i);
        }
//        integers.forEach(e->{
//            System.out.println(e);
//        });

        integers.parallelStream().forEach(System.out::println);

    }

}

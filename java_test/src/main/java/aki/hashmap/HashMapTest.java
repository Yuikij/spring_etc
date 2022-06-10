package aki.hashmap;

import java.util.HashMap;
import java.util.HashSet;

public class HashMapTest {

    public static void main(String[] args) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        class A {
            int a = 0;

            public A(int a) {
                this.a = a;
            }

            @Override
            public int hashCode() {
                return 100;
            }
        }

        HashSet<Object> a = new HashSet<>();

        for (int i = 0; i <10 ; i++) {
            a.add(new A(i));
        }

        a.add(2);

        System.out.println(a);
    }
}

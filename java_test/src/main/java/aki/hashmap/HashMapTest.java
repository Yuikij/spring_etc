package aki.hashmap;

import java.util.HashMap;
import java.util.HashSet;

public class HashMapTest {

    public static void main(String[] args) {

        class A {
            int a = 0;

            public A(int a) {
                this.a = a;
            }

            @Override
            public int hashCode() {
                return 1;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                A a1 = (A) o;
                return a == a1.a;
            }
        }
        HashMap<A, Integer> hashMap = new HashMap<>();

        HashSet<Object> a = new HashSet<>();

        for (int i = 0; i <11 ; i++) {
            hashMap.put(new A(i),1);
        }


        System.out.println(hashMap);
    }
}

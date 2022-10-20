package aki.guava;


import com.google.common.collect.HashMultimap;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;

public class MultisetT {
    public static void main(String[] args) {
        Multiset<Object> objects = HashMultiset.create();
        objects.add(1);
        objects.add(1);
        objects.add(1,10);
        objects.add(2,10);
        System.out.println(objects.count(1));
        // Map<Object,Collection<Object>>
        Multimap<Object,Object> objects2 = HashMultimap.create();
        objects2.put(1,1);
        objects2.put(1,2);
        System.out.println(objects2.get(1));

    }
}

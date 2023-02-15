package aki;


import aki.JVM.onstackalloc.OnStackTest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Test2 {
    public static void main(String[] args) {
        ArrayList<OnStackTest.User> arrayList = new ArrayList<OnStackTest.User>();
        arrayList.stream().sorted(Comparator.comparingInt(e -> e.id)).collect(Collectors.toList());
    }

}

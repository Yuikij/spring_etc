package aki.onjava.collectiontopics.tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList(
                "A B C D E F G H I J K L".split(" "));

        List<String> c = list;
        List<String> subList = list.subList(1,8);
        // Copy of the sublist:
        List<String> c2 = new ArrayList<>(subList);

        c.removeAll(c2);


    }
}

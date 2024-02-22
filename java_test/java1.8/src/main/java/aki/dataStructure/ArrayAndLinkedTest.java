package aki.dataStructure;

import aki.并发.commonClass.utils.Utils;

import java.util.ArrayList;
import java.util.LinkedList;

public class ArrayAndLinkedTest {
    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<>();
        arr.add("1");
        arr.remove(0);
        Utils.print("array",arr);

        LinkedList<String> linked = new LinkedList<>();
        linked.add("1");
        linked.add(1,"2");
        Utils.print("linked",linked);
    }
}

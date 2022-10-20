package aki.javaApi;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortTest {
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    static class Test {
        private int int1;
        private int int2;
    }


    /**
     * sort(从小到大) -> a-b
     */
    public static void main(String[] args) {
        Test test1 = Test.builder().int1(1).int2(2).build();
        Test test2 = Test.builder().int1(2).int2(2).build();
        Test test3 = Test.builder().int1(3).int2(2).build();
        List<Test> testList = new ArrayList<>();
        testList.add(test1);
        testList.add(test2);
        testList.add(test3);
        System.out.printf(testList.stream().sorted(Comparator.comparingInt(t -> t.int1)).collect(Collectors.toList()).toString());
    }
}

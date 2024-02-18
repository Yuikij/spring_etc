package aki;

import lombok.Data;

public class Test {
    @Data
    static class Result<T> {
        T res;

        Result(T t) {
            res = t;
        }

        public static <T> Result<T> getTest(T t) {
            return new Result<>(t);
        }
    }
    @Data
    static class Test1 {
        private String str1;

    }
    @Data
    static class Test2 extends TestHelper {

    }
    @Data
    static class Test3 extends TestHelper {

    }

    @Data
    static class TestHelper extends Test1 {
        private String str2;
    }

    private static Result<? extends Test1> get() {
        Test2 t = new Test2();
        t.setStr2("str2");
        return Result.getTest(t);
    }

    public static void main(String[] args) {
        Result<? extends Test1> result = get();
        Test1 res =  result.getRes();
        System.out.println(res);

    }
}

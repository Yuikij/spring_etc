package aki.guava;

import com.google.common.base.Strings;

import static com.google.common.base.Preconditions.checkArgument;

public class CheckArgumentT {
    public static void main(String[] args) {
        test(1);
    }

    private static void test(int a) {
        checkArgument(a > 5, "Argument was %s but expected >5", a);
        System.out.println(Strings.lenientFormat("%s >5", a));
    }
}

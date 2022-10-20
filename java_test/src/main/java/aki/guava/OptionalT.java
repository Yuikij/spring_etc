package aki.guava;


import com.google.common.base.Strings;

public class OptionalT {
    public static void main(String[] args) {
        Integer a = 1;
        com.google.common.base.Optional<Integer> possible = com.google.common.base.Optional.fromNullable(a);
        System.out.println(possible.or(2));
        System.out.println(possible.orNull());
        System.out.println(com.google.common.base.Optional.absent());
        System.out.println(possible.asSet());
        System.out.println(Strings.nullToEmpty(null));
        System.out.println(Strings.emptyToNull(""));
    }
}

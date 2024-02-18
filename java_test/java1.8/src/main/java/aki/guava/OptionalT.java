package aki.guava;


import com.google.common.base.Strings;

import java.util.Collections;
import java.util.Optional;

public class OptionalT {
    public static void main(String[] args) {
        Integer a = 1;
        Optional<Integer> possible = Optional.ofNullable(a);
        System.out.println(possible.orElse(2));
        System.out.println(possible.orElse(null));
        System.out.println(com.google.common.base.Optional.absent());
        System.out.println(possible.map(Collections::singleton).orElse(Collections.emptySet()));
        System.out.println(Strings.nullToEmpty(null));
        System.out.println(Strings.emptyToNull(""));
    }
}

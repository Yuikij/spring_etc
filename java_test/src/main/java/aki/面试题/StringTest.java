package aki.面试题;

import java.lang.reflect.Field;

public class StringTest {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        String a = "123";
        System.out.println(a.hashCode());
        Field field = String.class.getDeclaredField("value");
        field.setAccessible(true);
        field.set(a, new char[]{'4', '5', '6'});
        System.out.println(a);
        System.out.println(a.hashCode());

    }
}

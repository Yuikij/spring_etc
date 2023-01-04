package aki.javaApi;

import java.time.LocalDateTime;

public class TimeT {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        LocalDateTime now2 = LocalDateTime.now();
        System.out.println(now.compareTo(now2));

    }
}

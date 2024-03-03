package aki.并发.producerAndConsumer;

import aki.common.utiles.ConcurrentUtils;

import java.util.ArrayList;
import java.util.List;

public class ProducerAndConsumerTest {
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        ProducerAndConsumer<Integer> producerAndConsumer = new ProducerAndConsumer<>();
        ConcurrentUtils utils = new ConcurrentUtils(true);
        Runnable get = () -> {
            while (true) {
                producerAndConsumer.consumer(() -> {
                    Integer remove = list.remove(0);
                    utils.log("remove",remove);
                }, () -> list.isEmpty());
            }
        };

        Runnable set = () -> {
            for (int i = 0; i < 10000; i++) {
                producerAndConsumer.produce((integer) -> {
                    list.add(integer);
                    utils.log("add");
                }, () -> !list.isEmpty(),i);
            }
        };

        ConcurrentUtils.multiRun(1, set);
        ConcurrentUtils.multiRun(100, get);
    }
}

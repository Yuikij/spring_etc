package aki.并发.atomicClass;

import aki.并发.commonClass.MultiAdd;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

public class Test1 {
    private static AtomicInteger atomicInteger = new AtomicInteger(0);
    static int commonInt = 0;
    private AtomicBoolean atomicBoolean = new AtomicBoolean();
    private AtomicReference atomicReference = new AtomicReference();
    private AtomicStampedReference atomicStampedReference = new AtomicStampedReference(new Object(), 1);

    public static void main(String[] args) {
//---test int
//        MultiAdd.doAdd(()-> commonInt++);
//        System.out.println(commonInt);
//--correct use
        MultiAdd.doAdd(()-> atomicInteger.getAndIncrement());
//---err use
//        MultiAdd.doAdd((i)-> atomicInteger.set(atomicInteger.get()+1));
//---和getAndIncrement逻辑一样，自旋
        MultiAdd.doAdd((i) -> {
            for (;;) {
                if (atomicInteger.compareAndSet(atomicInteger.get(), atomicInteger.get() + 1)) {
                    return;
                }
            }
        });
        System.out.println(atomicInteger);


    }

}

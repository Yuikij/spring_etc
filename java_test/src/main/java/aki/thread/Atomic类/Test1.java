package aki.thread.Atomic类;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

public class Test1 {
    private AtomicInteger atomicInteger = new AtomicInteger(1);
    private AtomicBoolean atomicBoolean = new AtomicBoolean();
    private AtomicReference atomicReference = new AtomicReference();
    private AtomicStampedReference atomicStampedReference = new AtomicStampedReference(new Object(),1);
}

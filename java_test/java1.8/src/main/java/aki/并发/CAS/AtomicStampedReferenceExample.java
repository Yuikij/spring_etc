package aki.并发.CAS;

import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicStampedReferenceExample {
    public static void main(String[] args) {
        // 初始值为100，初始版本号为0
        AtomicStampedReference<Integer> atomicStampedRef = new AtomicStampedReference<>(100, 0);

        // 模拟线程A，先获取当前的值和版本号
        int[] stampHolder = new int[1];
        int initialValue = atomicStampedRef.get(stampHolder);
        int initialStamp = stampHolder[0];

        // 模拟线程B，修改值并更新版本号
        boolean success = atomicStampedRef.compareAndSet(initialValue, 200, initialStamp, initialStamp + 1);
        System.out.println("Thread B updated value: " + success);

        // 模拟线程C，尝试使用旧的版本号进行CAS操作，此时会失败
        success = atomicStampedRef.compareAndSet(initialValue, 300, initialStamp, initialStamp + 1);
        System.out.println("Thread C updated value: " + success);

        // 模拟线程D，使用新的版本号进行CAS操作，此时会成功
        int[] newStampHolder = new int[1];
        int newValue = atomicStampedRef.get(newStampHolder);
        int newStamp = newStampHolder[0];
        success = atomicStampedRef.compareAndSet(newValue, 300, newStamp, newStamp + 1);
        System.out.println("Thread D updated value: " + success);
    }
}

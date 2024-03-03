package aki.JVM;

import aki.common.utiles.ConcurrentUtils;
import org.openjdk.jol.info.ClassLayout;

public class ObjLock {
    public static void main(String[] args) {
        ConcurrentUtils.sleep(5000);
        Object obj = new Object();
//        System.out.println(ClassLayout.parseInstance(obj).toPrintable());
        ConcurrentUtils.print("初始化", ClassLayout.parseInstance(obj).toPrintable());
        ConcurrentUtils.multiRun(1, () -> {
            synchronized (obj) {
                ConcurrentUtils.print("t1", ClassLayout.parseInstance(obj).toPrintable());
                ConcurrentUtils.sleep(1000);
            }
        });
        ConcurrentUtils.sleep(100);
        ConcurrentUtils.multiRun(1, () -> {
            synchronized (obj) {
                ConcurrentUtils.print("t2", ClassLayout.parseInstance(obj).toPrintable());
                ConcurrentUtils.sleep(1000);
            }
        });
        ConcurrentUtils.sleep(100);
        ConcurrentUtils.multiRun(1, () -> {
            synchronized (obj) {
                ConcurrentUtils.print("t3", ClassLayout.parseInstance(obj).toPrintable());
                ConcurrentUtils.sleep(1000);
            }
        });

//        Utils.sleep(500);
//        Utils.print("main", ClassLayout.parseInstance(obj).toPrintable());

//        System.out.println(obj.hashCode());
//        System.out.println(ClassLayout.parseInstance(obj).toPrintable());


    }
}
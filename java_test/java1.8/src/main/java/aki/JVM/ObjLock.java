package aki.JVM;

import aki.并发.commonClass.utils.Utils;
import org.openjdk.jol.info.ClassLayout;

public class ObjLock {
    public static void main(String[] args) {
        Utils.sleep(5000);
        Object obj = new Object();
//        System.out.println(ClassLayout.parseInstance(obj).toPrintable());
        Utils.print("初始化", ClassLayout.parseInstance(obj).toPrintable());
        Utils.multiRun(1, () -> {
            synchronized (obj) {
                Utils.print("t1", ClassLayout.parseInstance(obj).toPrintable());
                Utils.sleep(1000);
            }
        });
        Utils.sleep(100);
        Utils.multiRun(1, () -> {
            synchronized (obj) {
                Utils.print("t2", ClassLayout.parseInstance(obj).toPrintable());
                Utils.sleep(1000);
            }
        });
        Utils.sleep(100);
        Utils.multiRun(1, () -> {
            synchronized (obj) {
                Utils.print("t3", ClassLayout.parseInstance(obj).toPrintable());
                Utils.sleep(1000);
            }
        });

//        Utils.sleep(500);
//        Utils.print("main", ClassLayout.parseInstance(obj).toPrintable());

//        System.out.println(obj.hashCode());
//        System.out.println(ClassLayout.parseInstance(obj).toPrintable());


    }
}
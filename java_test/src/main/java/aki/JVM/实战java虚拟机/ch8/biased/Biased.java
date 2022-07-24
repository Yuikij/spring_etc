package aki.JVM.实战java虚拟机.ch8.biased;

import org.openjdk.jol.info.ClassLayout;

import java.util.List;
import java.util.Vector;

/**
 * 启用偏向：-XX:+UseBiasedLocking
 * 立即启用偏向(默认4000)：-XX:BiasedLockingStartupDelay=0
 * 禁用偏向：-XX:-UseBiasedLocking
 */
public class Biased {
    public static List<Integer> numberList = new Vector<Integer>();

    public static void main(String[] args) throws InterruptedException {
		//2022/7/24 hash之后不可偏向，todo 时间还快了？
		// hashCode 被重写，没有撤销
		System.out.println(ClassLayout.parseInstance(numberList).toPrintable());
		System.identityHashCode(numberList);
//		numberList.hashCode();
		System.out.println(ClassLayout.parseInstance(numberList).toPrintable());
		long begin = System.currentTimeMillis();
        int count = 0;
        int startnum = 0;
        while (count < 10000000) {
            numberList.add(startnum);
            startnum += 2;
            count++;
        }
        long end = System.currentTimeMillis();
        System.out.println(end - begin);
    }
}

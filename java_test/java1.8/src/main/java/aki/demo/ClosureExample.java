package aki.demo;

import java.util.function.IntSupplier;

public class ClosureExample {
    public static void main(String[] args) {
        //定义一个整型变量x
        int x = 10;

        //创建Lambda表达式
        //该Lambda表达式访问了外围作用域中的变量x
        //这个变量不用标记为final也可以，因为它被隐式地视为final类型
        Runnable myRunnable = () -> {
//            System.out.println("X is: " + x);
        };

        //运行myRunnable
        myRunnable.run();

        //在Lambda表达式外部修改x的值
        x = 20;

        //运行myRunnable
        myRunnable.run();
    }
}

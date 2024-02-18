package aki.leetcode;

//给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
//
//        如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
//
//        假设环境不允许存储 64 位整数（有符号或无符号）。
//        示例 1：
//
//        输入：x = 123
//        输出：321
//        示例 2：
//
//        输入：x = -123
//        输出：-321
//        示例 3：
//
//        输入：x = 120
//        输出：21
//        示例 4：
//
//        输入：x = 0
//        输出：0
public class Class_7 {

    public static void main(String[] args) {
//        System.out.println(Integer.MAX_VALUE);
        System.out.println(reverse(1534236469));
    }

    public static int reverse(int x) {
        int m = x;
        int n = 0;
        while (m != 0) {
            if (n < Integer.MIN_VALUE / 10 || n > Integer.MAX_VALUE / 10) {
                return 0;
            }
            n = n * 10 + m % 10;
            m = m / 10;
        }
        return n;
    }

}

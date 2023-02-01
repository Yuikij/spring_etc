package aki.leetcode;

import java.util.ArrayList;
import java.util.List;
//给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
//
//        回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
//
//        例如，121 是回文，而 123 不是。

public class Class_9 {
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int res = 0;
        int palindrome = 0;
        int pow = 1;
        while (res != x) {
            double v = Math.pow(10, pow++);
            res = (int) (x % v);
            palindrome = palindrome * 10 + (res / (int) (v/10));
        }
        return palindrome == x;
    }


    public static void main(String[] args) {
        System.out.println(isPalindrome(121121));

    }
}

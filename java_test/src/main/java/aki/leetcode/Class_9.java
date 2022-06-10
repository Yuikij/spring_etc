package aki.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Class_9 {
    public static boolean isPalindrome(int x) {
        int res = 0;
        List<Integer> list = new ArrayList<>();
        while (res != x) {
            res = (int)(x % (Math.pow(10,list.size()+1)));
            list.add(res);
        }

        int palindrome = 0;
        for (int i = 0; i < list.size(); i++) {
            palindrome = palindrome+list.get(i)*10*(list.size()-i);
        }

        return palindrome==x;
    }


    public static void main(String[] args) {


        System.out.println(isPalindrome(121));


    }
}

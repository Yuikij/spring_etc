package aki.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//给你一个字符串 s，找到 s 中最长的回文子串。
//
//         
//
//        示例 1：
//
//        输入：s = "babad"
//        输出："bab"
//        解释："aba" 同样是符合题意的答案。
//        示例 2：
//
//        输入：s = "cbbd"
//        输出："bb"
//         
//
//        提示：
//
//        1 <= s.length <= 1000
//        s 仅由数字和英文字母组成
public class Class_5 {
    public static void main(String[] args) {
        //3 2    4 2.5  5 3 6 3.5
        System.out.println(longestPalindrome("babad"));
//        System.out.println(getLen(1, 1, "babad"));
    }

    private static int getLen(double center, int len, String s) {
        int left, right;
        double step = (len + 1) / 2.0;
        left = (int) (center - step);
        right = (int) (center + step);
        if (left < 0 || right >= s.length() || s.charAt(left) != s.charAt(right)) {
            return len;
        } else {
            return getLen(center, len + 2, s);
        }
    }

    private static String longestPalindrome(String s) {
        Map<Character, List<Integer>> indexToLenMap = new HashMap<>();
        int maxLen = 1;
        double index = 0;
        for (double i = 0; i < s.length(); i += 0.5) {
            int len = getLen(i, i % 1 == 0 ? 1 : 0, s);
            if (len > maxLen) {
                maxLen = len;
                index = i;
            }
        }
        return s.substring((int) (index - (maxLen + 1) / 2.0 + 1), (int) (index - (maxLen + 1) / 2.0 + maxLen + 1));
    }

//    public static String longestPalindrome(String s) {
//
//        int maxLen = 1;
//        int len = 0;
//        int index = 0;
//        for (int i = 1; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if (i - len - 1 < 0) {
//                len = 0;
//            } else if (c == s.charAt(i - len - 1)) {
//                len += 2;
//                if (len > maxLen) {
//                    maxLen = len;
//                    index = i;
//                }
//            }
//            if (len == 0) {
//                if (i - 2 >= 0 && c == s.charAt(i - 2)) {
//                    len = 3;
//                    if (len > maxLen) {
//                        maxLen = len;
//                        index = i;
//                    }
//                }
//            }
//        }
//        return s.substring(index - maxLen + 1, index + 1);
//    }
}

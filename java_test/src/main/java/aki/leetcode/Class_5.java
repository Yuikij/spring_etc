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
//        System.out.println(longestPalindrome("aaaa"));
        System.out.println(getLen(2,0,"babad"));
    }

    private static int getLen(double center, int len, String s) {
        int left, right;
        double step = len / 2.0;
        left = (int) (center - step);
        right = (int) (center + step);
        System.out.println(left);
        System.out.println(right);
        if (left < 0 || right > s.length() || s.charAt(left) != s.charAt(right)) {
            return len;
        } else {
            return getLen(center, len, s);
        }
    }

    private static String shortestPalindrome(String s) {
        Map<Character, List<Integer>> indexToLenMap = new HashMap<>();
        int maxLen = 1;
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            List<Integer> list = indexToLenMap.get(c);
            if (list == null) {
                indexToLenMap.put(c, Arrays.asList(1, i));
            } else {
                Integer oldIndex = list.get(1);
                int len = i - oldIndex + 1;
                Integer oldMax = list.get(0);
                int max = len > oldMax ? len : oldMax;
                list.set(1, i);
                list.set(0, max);
                if (len > maxLen) {
                    maxLen = len;
                    index = oldIndex;
                }
            }
        }
        return s.substring(index, maxLen + index);
    }

    public static String longestPalindrome(String s) {

        int maxLen = 1;
        int len = 0;
        int index = 0;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i - len - 1 < 0) {
                len = 0;
            } else if (c == s.charAt(i - len - 1)) {
                len += 2;
                if (len > maxLen) {
                    maxLen = len;
                    index = i;
                }
            }
            if (len == 0) {
                if (i - 2 >= 0 && c == s.charAt(i - 2)) {
                    len = 3;
                    if (len > maxLen) {
                        maxLen = len;
                        index = i;
                    }
                }
            }
        }
        return s.substring(index - maxLen + 1, index + 1);
    }
}

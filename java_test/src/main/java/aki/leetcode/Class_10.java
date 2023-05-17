package aki.leetcode;
//给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
//
//        '.' 匹配任意单个字符
//        '*' 匹配零个或多个前面的那一个元素
//        所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
//        示例 1：
//
//        输入：s = "aa", p = "a"
//        输出：false
//        解释："a" 无法匹配 "aa" 整个字符串。
//        示例 2:
//
//        输入：s = "aa", p = "a*"
//        输出：true
//        解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
//        示例 3：
//
//        输入：s = "ab", p = ".*"
//        输出：true
//        解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
//        提示：
//
//        1 <= s.length <= 20
//        1 <= p.length <= 20
//        s 只包含从 a-z 的小写字母。
//        p 只包含从 a-z 的小写字母，以及字符 . 和 *。
//        保证每次出现字符 * 时，前面都匹配到有效的字符

public class Class_10 {

    public static void main(String[] args) {
        boolean[][] b = new boolean[2][2];
        System.out.println(b[0][0]);
    }

    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] b = new boolean[m + 1][n + 1];
        b[0][0] = true;
        // 遍历s
        for (int i = 1; i < m; i++) {
            //比较s和p
            for (int j = 0; j < n; j++) {
                if (p.charAt(j + 1) == '*') {

                    j++;

                } else {
                    //匹配下一位
                    if (s.charAt(i) == p.charAt(j)) {
                        b[i][j] = true;
                    }
                }
            }
        }

        return b[m][n];
    }
}

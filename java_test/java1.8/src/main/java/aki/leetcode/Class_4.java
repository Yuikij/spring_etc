package aki.leetcode;

//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
//
//        算法的时间复杂度应该为 O(log (m+n)) 。
//
//         
//
//        示例 1：
//
//        输入：nums1 = [1,3], nums2 = [2]
//        输出：2.00000
//        解释：合并数组 = [1,2,3] ，中位数 2
//        示例 2：
//
//        输入：nums1 = [1,2], nums2 = [3,4]
//        输出：2.50000
//        解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
//         
//
//         
//
//        提示：
//
//        nums1.length == m
//        nums2.length == n
//        0 <= m <= 1000
//        0 <= n <= 1000
//        1 <= m + n <= 2000
//        -10^6 <= nums1[i], nums2[i] <= 10^6
//
//[100000]
//        [100001]
public class Class_4 {

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{100000}, new int[]{100001}));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int l1 = nums1.length;
        int l2 = nums2.length;
        int len = l1 + l2;
        int index1 = 0;
        int index2 = 0;
        int[] tmpArr = new int[len];
        for (int i = 0; i < len; i++) {
            int n1 = index1 > l1 - 1 ? Integer.MAX_VALUE : nums1[index1];
            int n2 = index2 > l2 - 1 ? Integer.MAX_VALUE: nums2[index2];
            if (n1 < n2) {
                tmpArr[i] = n1;
                index1++;
            } else {
                tmpArr[i] = n2;
                index2++;
            }
        }
        int i = len / 2;
        if (i * 2 != len) {
            return tmpArr[i];
        } else {
            return (tmpArr[i] + tmpArr[i - 1]) / 2.0;
        }
    }

}

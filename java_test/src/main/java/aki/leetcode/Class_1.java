package aki.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Class_1 {

    public static int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int i1 = i+1; i1 < nums.length; i1++) {
                if (nums[i]+nums[i1] == target){
                    return new int[]{i,i1};
                }
            }
        }

        return null;
    }

    public static int[] twoSumHash(int[] nums, int target) {
        HashMap<Integer,Integer> hash = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (hash.containsKey(nums[i])){
                return new int[]{hash.get(i),i};
            }
            hash.put(target-nums[i],i);

        }

        return null;
    }

    public static int[] process2(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }
        Map<Integer, Integer> hasLooked = new HashMap<>();
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            if (hasLooked.containsKey(target - nums[l])) {
                return new int[]{hasLooked.get(target - nums[l]), l};
            } else {
                hasLooked.put(nums[l], l++);
            }
            if (hasLooked.containsKey(target - nums[r])) {
                return new int[]{hasLooked.get(target - nums[r]), r};
            } else {
                hasLooked.put(nums[r], r--);
            }
        }
        return null;
    }




    public static void main(String[] args) {

      ;
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));

    }
}

package leetcode.arrays._3sum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * AlgoExpert.io source task;
 * @author: Khassangali Gapparov
 * @Date: 2022
 * @version: 0.0.1
 * @target: F(M)ANG & Tesla!
 */

public class ThreeNumberSum {
    public static List<Integer[]> getAllThreeSum(List<Integer> nums, int targetSum){
        /**
         * to solve this taks we can first sort input,
         * starting from left getCurrent[index] and search pairs from right side with binary approach;
         */
        List<Integer[]> result = new ArrayList<>();

        //sorting
        Collections.sort(nums);
        for (int i = 0; i < nums.size() - 2; i++) {
            int currentNumber = nums.get(i);
            int left = i+1, right = nums.size()-1;

            //applying binary search
            int difference = targetSum - currentNumber;
            while (left < right) {
                int pairSum = nums.get(left) + nums.get(right);
                if (pairSum == difference) {
                    result.add(new Integer[]{currentNumber, nums.get(left), nums.get(right)});
                    left++;
                    right--;
                } else if (pairSum < difference) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    };
}

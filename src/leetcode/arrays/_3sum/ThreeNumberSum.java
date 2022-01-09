package leetcode.arrays._3sum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: Khassangali Gapparov
 * @Date: 01/08/2022
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
            if ((i > 0 ) && currentNumber == nums.get(i-1)) continue;

            int left = i+1, right = nums.size()-1;

            //applying binary search
            int difference = targetSum - currentNumber;
            while (left < right) {
                int pairSum = nums.get(left) + nums.get(right);
                if (pairSum == difference) {
                    result.add(new Integer[]{currentNumber, nums.get(left), nums.get(right)});
                    left++;
                    right--;
                    //remove duplicates on left
                    while (nums.get(left -1) == nums.get(left) && left < right) left++;
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

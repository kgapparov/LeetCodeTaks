package leetcode.arrays.easy.monoliticarray;
/**
 * @author Khassangali Gapparov
 * @Date 01/09/2022
 * @version 0.0.1
 * @target F(M)ANG & Tesla!
 */
public class MonoliticArray {
    public boolean isMonotonic(int[] nums) {
        boolean isNotIncreasing = true;
        boolean isNotDecreasing = true;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i-1]) {
                isNotDecreasing = false;
            } else if (nums[i] > nums[i-1]) {
                isNotIncreasing = false;
            }
        }
        return isNotDecreasing || isNotIncreasing;
    }
}

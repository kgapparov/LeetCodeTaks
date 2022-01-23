package grockingPatterns.slidingwindow;

public class _02_SubArrayMaxumumSum {
    /*
    Given an array of positive numbers and a positive number ‘k,’ find the maximum sum of any contiguous subarray of size ‘k’.

Example 1:

    Input: [2, 1, 5, 1, 3, 2], k=3
    Output: 9
    Explanation: Subarray with maximum sum is [5, 1, 3].

Example 2:

    Input: [2, 3, 4, 1, 5], k=2
    Output: 7
    Explanation: Subarray with maximum sum is [3, 4].

     */

    public double findMaxAverage(int[] nums, int k) {
        double max = Integer.MIN_VALUE;
        int windowStart = 0;
        double windowSum = 0;
        for (int windowEnd = 0; windowEnd < nums.length; ++windowEnd) {
            windowSum += nums[windowEnd];
            if (windowEnd >= k -1) {
                max = Math.max(windowSum/k, max);
                windowSum -= nums[windowStart++];
            }
        }
        return max;
    }
}

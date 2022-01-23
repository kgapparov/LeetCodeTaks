package grockingPatterns.slidingwindow;

/*

Problem Statement#
Given an array of positive numbers and a positive number ‘S,’ find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’. Return 0 if no such subarray exists.

Example 1:

Input: [2, 1, 5, 2, 3, 2], S=7
Output: 2
Explanation: The smallest subarray with a sum greater than or equal to '7' is [5, 2].
Example 2:

Input: [2, 1, 5, 2, 8], S=7
Output: 1
Explanation: The smallest subarray with a sum greater than or equal to '7' is [8].
Example 3:

Input: [3, 4, 1, 1, 6], S=8
Output: 3
Explanation: Smallest subarrays with a sum greater than or equal to '8' are [3, 4, 1]
or [1, 1, 6].
 */
public class _03_MinSizeSubArraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int windowStart = 0;
        long windowSum  = 0;
        int minLen = Integer.MAX_VALUE;

        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            //increment size window
            windowSum += nums[windowEnd];
            //decrease size window until condition is met.
            while (windowSum >= target) {
                minLen = Math.min(minLen, windowEnd - windowStart + 1);
                windowSum -= nums[windowStart++];
            }
        }
        //clean minLen in case of never reached result;
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}

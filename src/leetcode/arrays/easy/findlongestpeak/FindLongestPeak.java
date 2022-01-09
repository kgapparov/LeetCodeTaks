package leetcode.arrays.easy.findlongestpeak;

/**
 * @author Khassangali Gapparov
 * @Date  01/08/2022
 * @version  0.0.1
 * @target  F(M)ANG & Tesla!
 */

public class FindLongestPeak {
    /**
     * @param array input array
     * @return return longest value of length peak
     */
    public static int findLongestPeak(int[] array){
        /*
            To solve this problem we have to start from searching peak elements
                1) where peak element is  i if index then   nums[i-1] < nums[i] > nums[i+1]
                2) starting this i position move with two pointers to left and to right until condition is met
                3) compare and update result with right - left distance.
         */
        int result = 0;
        int i = 1;
        while (i < array.length-1) {
            int left = i, right = i;

            //find peak
            if (array[i-1] < array[i] && array[i+1] < array[i]) {
                //move left from i to left
                while (left > 0 && array[left] > array[left-1]) {
                    left--;
                }
                while (right < array.length && (array[right] > array[right+1])) {
                    right++;
                }
            }
            result = Math.max(result, right - left+1);
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findLongestPeak(new int[]{1,2,3,3,4,0,10,3,2,-1,-3,4,5}));
    }
}

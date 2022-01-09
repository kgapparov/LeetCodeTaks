package leetcode.arrays.easy.smallest_difference;

import java.util.Arrays;

/**
 * @author: Khassangali Gapparov
 * @Date: 01/09/2022
 * @version: 0.0.1
 * @target: F(M)ANG & Tesla!
 */
public class SmallestDifference {
    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {

        /**
         *  1st sort both arrays,
         *
         *  starting from 1st element of each array, we do compare
         *      if left is smaller then we move left forward (decrease distance) track current distance and pair
         *
         *      if right is smaller then we move right backward (decrease disstance) and track current distance and pair
         *
         *      update current distance if smaller minimum
         *
         *   return result
         */
        //sort both arrays
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);
        //result params
        int absoluteDistance = Integer.MAX_VALUE;
        int[] result = new int[2];
        //starting from leftIndex from 1st array and 1st index from secondArray
        int leftIndex = 0, rightIndex = 0;
        while (leftIndex < arrayOne.length && rightIndex < arrayTwo.length) {
            int first = arrayOne[leftIndex];
            int second = arrayTwo[rightIndex];
            if (first < second) {
                leftIndex++;
            } else if (second < first) {
                rightIndex++;
            } else {
                result = new int[] {first, second};
                break;
            }
            int currDistance = Math.abs(first - second);
            if (currDistance < absoluteDistance) {
                result = new int[] {first, second};
                absoluteDistance = currDistance;
            }
        }
        return result;
    }
}

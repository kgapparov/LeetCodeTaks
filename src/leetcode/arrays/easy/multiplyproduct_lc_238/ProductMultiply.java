package leetcode.arrays.easy.multiplyproduct_lc_238;

import java.util.Arrays;

/**
 * @author Khassangali Gapparov
 * @Date  01/09/2022
 * @version  0.0.1
 * @target  F(M)ANG & Tesla!
 */
public class ProductMultiply {
        public static int[] productExceptSelf(int[] nums) {
            int len = nums.length;
            /*
                PseudoCode
                Main point is: Naive solution is two loops and multiply elements where (i != j from each loop indexes).
                but at this approach O(N^2) makes a lot of calculate repetitions. To remove this repetitions we can
                save results of multiply into two arrays, array left and array right.
                on left array will save all elements multiplied from 0 to end,
                on right array will save all elements multiplied from end to start.
             */
            int[] left = new int[len], right = new int[len];
            // fill both arrays with value 1
            Arrays.fill(left, 1);
            Arrays.fill(right, 1);

            //multiply all elements from start to end
            int leftRunningProduct = 1;
            for (int i = 0; i < len; i++) {
                left[i] = leftRunningProduct;
                leftRunningProduct *= nums[i];
            }

            //multiplay all elements from end to start
            int rightRunningProduct = 1;
            for (int i = len-1; i >=0 ; i--) {
                right[i] = rightRunningProduct;
                rightRunningProduct *= nums[i];
            }

            int[] result = new int[len];
            for (int i = 0; i < len; i++) {
                result[i] = left[i] * right[i];
            }
            return result;
        }

    public static void main(String[] args) {
        Arrays.stream(productExceptSelf(new int[]{2, 3, 4, 5})).forEach(System.out::println);
    }
}

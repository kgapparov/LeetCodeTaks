package leetcode.arrays.medium.firstd_duplicate_value_LC287;

/**
 * @author Khassangali Gapparov
 * @Date  01/08/2022
 * @version  0.0.1
 * @target  F(M)ANG & Tesla!
 */

public class FirstDuplicateValue {
    /*
            we can approach in two ways:
            a) first if in constraints says that we are not allowed modify array
            and O(1) space, then we can go with turtle and hire method, slow and fast index traversing. Array values not
            more than indexes, thats why we can traverse from value as index of next value.

            b) if we can modify then we can jast modify visited elements with negotive value, if we face with negative
            value while traversing then we found answer.
         */

    /**
     * First without modifying input array.
     * @param array input array
     * @return return repeated value;
     */
    public static int firstDuplicateValue(int[] array) {
        //fast and slow as hire and turtle approach.
        int slow = array[0];
        int fast = array[0];

        slow = array[slow];
        fast = array[array[fast]];

        // traverse until slow and fast equals.
        while (slow != fast) {
            slow = array[slow];
            fast = array[array[fast]];
        }
        // reset slow one, and where they meet again that value will be cyclic value. this time same speed.
        slow = array[0];
        while (slow != fast) {
            slow = array[slow];
            fast = array[fast];
        }
        return slow;
    }

    /**
     * First with modifying input array.
     * @param array input array
     * @return return repeated value;
     */
    public static int firstDuplicateValueModified(int[] array) {
        for (int value : array) {
            int absValue = Math.abs(value);
            if (array[absValue-1] < 0) return absValue;
            array[absValue -1] *= -1;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstDuplicateValue(new int[] {1,2,3,4,4,5,6}));
        System.out.println(firstDuplicateValueModified(new int[] {1,2,3,4,4,5,6}));
    }
}

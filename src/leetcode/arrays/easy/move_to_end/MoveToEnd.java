package leetcode.arrays.easy.move_to_end;


import java.util.ArrayList;
import java.util.List;

/**
 * @author Khassangali Gapparov
 * @Date  01/09/2022
 * @version  0.0.1
 * @target  F(M)ANG & Tesla!
 */
public class MoveToEnd {

    /**
     * @param array input list of integers,
     * @param toMove number which we should move to the end
     * @return moved all elements of toMove to the end of array
     */
    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        /**
         * to solve this task we can use two point pattern.
         * left will increase until gets toMove
         * right will decrease until not equal to toMove and ready to swap with left.
         * repeat until left < right;
         * return result;
         */
        int left = 0, right = array.size()-1;
        while (left < right) {
            //move right to left until right not equal to toMove, prepair to swap
            while (array.get(right) == toMove && left < right) right--;
            //swap left which equal to toMove with right which not equal toMove
            if (array.get(left) == toMove)
                swap(array, left, right);
            left++;
        }
        return array;
    }
    private static void swap(List<Integer> array, int left, int right) {
        int temp = array.get(left);
        array.set(left, array.get(right));
        array.set(right, temp);
    }

    public static void main(String[] args) {
        moveElementToEnd(new ArrayList<>(List.of(1,2,3,3,4,3,2,1,2,3)), 3).stream().forEach(System.out::println);
    }
}

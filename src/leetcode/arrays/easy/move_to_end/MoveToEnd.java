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
    public static List<Integer> moveElementToEndWithoutOrder(List<Integer> array, int toMove) {
        /*
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

    /**
     * LeetCode task 283
     * @param array input List(array)
     * @param toMove digit to move
     * @return moved result with maintaining order;
     */
    public static List<Integer> moveElementToEndWithOrder(List<Integer> array, int toMove) {
        int lastIndex = 0;
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) != toMove) {
                array.set(lastIndex++, array.get(i));
            }
        }
        for (int i = lastIndex; i < array.size(); i++) {
            array.set(i, toMove);
        }
        return array;
    }
    private static void swap(List<Integer> array, int left, int right) {
        int temp = array.get(left);
        array.set(left, array.get(right));
        array.set(right, temp);
    }

    public static void main(String[] args) {
        moveElementToEndWithoutOrder(new ArrayList<>(List.of(1,2,3,3,4,3,2,1,2,3)), 3).forEach(System.out::println);
        System.out.println("With Order ");
        moveElementToEndWithOrder(new ArrayList<>(List.of(1,2,3,3,4,3,2,1,2,3)), 3).forEach(System.out::println);
    }
}

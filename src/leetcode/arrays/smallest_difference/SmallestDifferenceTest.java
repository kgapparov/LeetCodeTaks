package leetcode.arrays.smallest_difference;



import org.junit.Test;


import static org.junit.Assert.assertArrayEquals;


public class SmallestDifferenceTest {

    @Test
    public void smallestDifference() {
        int[] arrayOne = new int[] {-5, 5, 10, 20, 28, 3};
        int[] arrayTwo = new int[] {26, 134, 135, 15, 17};
        int[] expected = new int[] {28, 26};
        int[] output;
        output = SmallestDifference.smallestDifference(arrayOne, arrayTwo);
        assertArrayEquals(output, expected);
    }
}
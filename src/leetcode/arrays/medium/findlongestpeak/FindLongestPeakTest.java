package leetcode.arrays.medium.findlongestpeak;

import org.junit.Test;

import static leetcode.arrays.medium.findlongestpeak.FindLongestPeak.findLongestPeak;
import static org.junit.Assert.*;

public class FindLongestPeakTest {

    @Test
    public void findLongestPeakTest() {
        int[] input = new int[]{1,2,3,3,4,0,10,3,2,-1,-3,4,5};
        int exp = 6;
        assertEquals(exp, findLongestPeak(input));
    }
}
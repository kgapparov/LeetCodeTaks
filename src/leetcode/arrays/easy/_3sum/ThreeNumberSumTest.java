package leetcode.arrays.easy._3sum;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ThreeNumberSumTest {
    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void getAllThreeSum() {
        //Case 1
        List<Integer> input = new ArrayList<>(List.of(-1,0,1,2,-1,-4,-2,-3,3,0,4));
        List<Integer[]> expected = new ArrayList<>();
        //[[-4,0,4],[-4,1,3],[-3,-1,4],[-3,0,3],[-3,1,2],[-2,-1,3],[-2,0,2],[-1,-1,2],[-1,0,1]]
        expected.add(new Integer[]{-4,0,4});
        expected.add(new Integer[]{-4,1,3});
        expected.add(new Integer[]{-3,-1,4});
        expected.add(new Integer[]{-3,0,3});
        expected.add(new Integer[]{-3,1,2});
        expected.add(new Integer[]{-2,-1,3});
        expected.add(new Integer[]{-2,0,2});
        expected.add(new Integer[]{-1,-1,2});
        expected.add(new Integer[]{-1,0,1});
        List<Integer[]> output = ThreeNumberSum.getAllThreeSum(input, 0);
        assertTrue(compare(expected, output));
    //case 2
        input = new ArrayList<>(List.of(-1,0,1,2,-1,-4));
        expected = new ArrayList<>();
        //[[-4,0,4],[-4,1,3],[-3,-1,4],[-3,0,3],[-3,1,2],[-2,-1,3],[-2,0,2],[-1,-1,2],[-1,0,1]]
        expected.add(new Integer[]{-1,0,1});
        expected.add(new Integer[]{-1,-1,2});
        output = ThreeNumberSum.getAllThreeSum(input, 0);
        assertTrue(compare(expected, output));

    }

    private boolean compare(List<Integer[]> triplets1, List<Integer[]> triplets2) {
        if (triplets1.size() != triplets2.size()) return false;
        for (int i = 0; i < triplets1.size(); i++) {
            if (!Arrays.equals(triplets1.get(i), triplets2.get(i))) {
                return false;
            }
        }
        return true;
    }
}
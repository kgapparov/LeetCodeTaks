package leetcode.arrays._3sum;

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
        List<Integer> input = new ArrayList<>(List.of(1,2,3,4,5,6,7));
        List<Integer[]> expected = new ArrayList<>();
        expected.add(new Integer[]{1,2,5});
        expected.add(new Integer[]{1,3,4});
        List<Integer[]> output = ThreeNumberSum.getAllThreeSum(input, 8);
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
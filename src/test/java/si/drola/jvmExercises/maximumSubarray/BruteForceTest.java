package si.drola.jvmExercises.maximumSubarray;

import org.junit.Test;

import static org.junit.Assert.*;

public class BruteForceTest {
    @Test
    public void findMaximumSubarrayPositiveIntegers() throws Exception {
        int[] input = new int[]{1,2,3,4,5};
        MaximumSubarrayResult expectedResult = new MaximumSubarrayResult(0, input.length, 15);
        MaximumSubarrayResult actualResult = (new BruteForce()).findMaximumSubarray(input);

        assertEquals(expectedResult.startIndex, actualResult.startIndex);
        assertEquals(expectedResult.endIndex, actualResult.endIndex);
        assertEquals(expectedResult.sum, actualResult.sum);
    }
}

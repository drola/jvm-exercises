package si.drola.jvmExercises.maximumSubarray;

import org.junit.Test;

import static org.junit.Assert.*;

public class DivideAndConquerTest {
    @Test
    public void findMaximumSubarrayPositiveIntegers() throws Exception {
        int[] input = new int[]{1,2,3,4,5};
        MaximumSubarrayResult expectedResult = new MaximumSubarrayResult(0, input.length, 15);
        MaximumSubarrayResult actualResult = (new DivideAndConquer()).findMaximumSubarray(input);

        assertMaxximumSubarrayResultEqual(expectedResult, actualResult);
    }

    @Test
    public void findMaximumSubarrayNegativeIntegers() throws Exception {
        int[] input = new int[]{-1,-2,-3,-4,-5};
        MaximumSubarrayResult expectedResult = new MaximumSubarrayResult(0, 0, 0);
        MaximumSubarrayResult actualResult = (new DivideAndConquer()).findMaximumSubarray(input);

        assertMaxximumSubarrayResultEqual(expectedResult, actualResult);
    }

    @Test
    public void findMaximumSubarrayNegativeAndPositiveIntegers() throws Exception {
        int[] input = new int[]{-1,-2,-3,-4,-5, 1, 2, 3};
        MaximumSubarrayResult expectedResult = new MaximumSubarrayResult(5, 8, 6);
        MaximumSubarrayResult actualResult = (new DivideAndConquer()).findMaximumSubarray(input);

        assertMaxximumSubarrayResultEqual(expectedResult, actualResult);
    }



    protected void assertMaxximumSubarrayResultEqual(MaximumSubarrayResult expectedResult, MaximumSubarrayResult actualResult) {
        assertEquals(expectedResult.startIndex, actualResult.startIndex);
        assertEquals(expectedResult.endIndex, actualResult.endIndex);
        assertEquals(expectedResult.sum, actualResult.sum);
    }
}

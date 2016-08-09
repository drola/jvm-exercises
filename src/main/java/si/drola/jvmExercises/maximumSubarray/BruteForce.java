package si.drola.jvmExercises.maximumSubarray;

public class BruteForce implements IMaximumSubarray {
    public MaximumSubarrayResult findMaximumSubarray(int[] inputArray) {
        int sum = 0;
        for (int i:inputArray) {
            sum+=i;
        }

        return new MaximumSubarrayResult(0, inputArray.length, sum);
    }
}

package si.drola.jvmExercises.maximumSubarray;

public class BruteForce implements IMaximumSubarray {
    public MaximumSubarrayResult findMaximumSubarray(int[] inputArray) {
        int maximumSum = 0;
        int maximumI = 0;
        int maximumJ = 0;
        int sum;
        for(int i = 0; i < inputArray.length; i++) {
            sum = 0;
            for(int j = i + 1; j < inputArray.length + 1; j++) {
                sum += inputArray[j - 1];

                if(sum > maximumSum) {
                    maximumI = i;
                    maximumJ = j;
                    maximumSum = sum;
                }
            }
        }

        return new MaximumSubarrayResult(maximumI, maximumJ, maximumSum);
    }
}

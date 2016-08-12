package si.drola.jvmExercises.maximumSubarray;

public class BruteForce implements IMaximumSubarray {
    public MaximumSubarrayResult findMaximumSubarray(int[] inputArray) {
        int maximumSum = 0;
        int maximumI = 0;
        int maximumJ = 0;

        for(int i = 0; i < inputArray.length; i++) {
            for(int j = i; j < inputArray.length + 1; j++) {
                int sum = 0;

                //@TODO: This summation can be optimized
                for(int a = i; a < j; a++) {
                    sum += inputArray[a];
                }
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

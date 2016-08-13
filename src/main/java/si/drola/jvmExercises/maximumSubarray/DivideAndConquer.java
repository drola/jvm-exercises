package si.drola.jvmExercises.maximumSubarray;

public class DivideAndConquer implements IMaximumSubarray {
    public MaximumSubarrayResult findMaximumSubarray(int[] inputArray) {
        return findMaxSubarrayDivideAndConquer(inputArray, 0, inputArray.length);
    }

    protected static MaximumSubarrayResult findMaxSubarrayDivideAndConquer(int[] A, int low, int high) {
        if (low + 1 == high) {
            return new MaximumSubarrayResult(low, high, A[low]);
        }
        if(low == high) {
            return new MaximumSubarrayResult(low, high, 0);
        }

        int mid = (int) Math.floor(low / 2.0 + (high-1) / 2.0);
        MaximumSubarrayResult left = findMaxSubarrayDivideAndConquer(A, low, mid + 1);
        MaximumSubarrayResult right = findMaxSubarrayDivideAndConquer(A, mid + 1, high);
        MaximumSubarrayResult acrossMidpoint = findMaxCrossingSubarray(A, low, mid, high);

        if (left.sum >= acrossMidpoint.sum && left.sum >= right.sum) {
            return left;
        } else if (acrossMidpoint.sum >= left.sum && acrossMidpoint.sum >= right.sum) {
            return acrossMidpoint;
        } else {
            return right;
        }
    }



    protected  static  MaximumSubarrayResult findMaxCrossingSubarray(int[] A, int low, int mid, int high) {
        int leftSum = 0;
        int maxLeftSum = 0;
        int maxI = mid;
        for(int i = mid; i >= low; i--) {
            leftSum += A[i];
            if(leftSum > maxLeftSum) {
                maxI = i;
                maxLeftSum = leftSum;
            }
        }

        int rightSum = 0;
        int maxRightSum = 0;
        int maxJ = mid;
        for(int j = mid + 1; j < high; j++) {
            rightSum += A[j];
            if(rightSum > maxRightSum) {
                maxRightSum = rightSum;
                maxJ = j + 1;
            }
        }

        return new MaximumSubarrayResult(maxI, maxJ, maxLeftSum + maxRightSum);
    }
}

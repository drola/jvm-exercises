package si.drola.jvmExercises.sorting;

public class QuickSort implements ISorter {
    public int[] sort(int[] numbers) {
        quicksort(numbers, 0, numbers.length);
        return numbers;
    }

    protected void quicksort(int[] A, int p, int r) {
        if (p < r-1) { //At least two elements
            int q = partition(A, p, r);
            quicksort(A, p, q);
            quicksort(A, q, r);
        }
    }

    protected int partition(int[] A, int p, int r) {
        int i = p - 1; //All elements <= p are already smaller or equal than pivot
        int pivot = A[r-1];
        int j, t;
        for(j = p; j < r - 1; j++) {
            if(A[j] < pivot) {
                i++;
                //Swap
                t = A[j];
                A[j] = A[i];
                A[i] = t;
            }
        }
        i++;
        t = pivot;
        A[r-1] = A[i];
        A[i] = t;
        return i;
    }
}

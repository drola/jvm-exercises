package si.drola.jvmExercises.sorting;

import org.apache.commons.lang3.ArrayUtils;
import si.drola.jvmExercises.dataStructures.MaxIntegerHeap;

public class HeapSort implements ISorter {

    public int[] sort(int[] numbers) {
        MaxIntegerHeap heap = new MaxIntegerHeap(ArrayUtils.toObject(numbers));
        for(int i = heap.A.length - 1; i >= 1; i--) {
            Integer t = heap.A[i];
            heap.A[i] = heap.A[0];
            heap.A[0] = t;
            heap.heapSize = heap.heapSize - 1;
            heap.maxHeapifyIterative(0);
        }

        return ArrayUtils.toPrimitive(heap.A);
    }
}

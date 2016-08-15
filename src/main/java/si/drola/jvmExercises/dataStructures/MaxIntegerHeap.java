package si.drola.jvmExercises.dataStructures;

public class MaxIntegerHeap extends Heap<Integer> {
    public void maxHeapifyRecursive(int i) {
        int l = left(i);
        int r = right(i);
        int largest = i;
        if(l < heapSize && A[l].compareTo(A[largest]) > 0) {
            largest = l;
        }
        if(r < heapSize && A[r].compareTo(A[largest]) > 0) {
            largest = r;
        }
        if (largest != i) {
            //swap(A[i], A[largest])
            Integer t = A[i];
            A[i] = A[largest];
            A[largest] = t;
        }
        maxHeapifyRecursive(largest);
    }

    public void maxHeapifyIterative(int i) {
        while(true) {
            int largest = i;
            int l = left(i);
            int r = right(i);
            if(l < heapSize && A[l].compareTo(A[largest]) > 0) {
                largest = l;
            }
            if(r < heapSize && A[r].compareTo(A[largest]) > 0) {
                largest = r;
            }

            if (largest != i) {
                //swap(A[i], A[largest])
                Integer t = A[i];
                A[i] = A[largest];
                A[largest] = t;
                i = largest;
                continue;
            }
            break;
        }
    }
}

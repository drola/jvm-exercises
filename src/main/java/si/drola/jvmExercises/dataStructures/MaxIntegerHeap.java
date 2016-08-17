package si.drola.jvmExercises.dataStructures;

public class MaxIntegerHeap extends Heap {
    public int[] A;

    public MaxIntegerHeap(int[] A) {
        heapSize = A.length;
        this.A = A;
        for(int i = (int)(Math.floor(heapSize/2)) - 1; i >= 0; i--) {
            maxHeapifyIterative(i);
        }
    }

    public void maxHeapifyRecursive(int i) {
        int l = left(i);
        int r = right(i);
        int largest = i;
        if(l < heapSize && A[l] > A[largest]) {
            largest = l;
        }
        if(r < heapSize && A[r] > A[largest]) {
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
            if(l < heapSize && A[l] > A[largest]) {
                largest = l;
            }
            if(r < heapSize && A[r] > A[largest]) {
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

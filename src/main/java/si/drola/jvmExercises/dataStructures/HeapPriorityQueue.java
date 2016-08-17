package si.drola.jvmExercises.dataStructures;


import java.util.Arrays;

public class HeapPriorityQueue extends MaxIntegerHeap implements IMaxPriorityQueue {
    public HeapPriorityQueue(int[] A) {
        super(A);
    }


    public void insert(int a) {
        if(A.length < heapSize + 1) {
            //Need to resize the array
            A = Arrays.copyOf(A, A.length * 2);
        }

        A[heapSize] = a - 1;
        heapSize = heapSize + 1;
        try {
            increaseKey(heapSize - 1, a);
        } catch(Exception e) {
            //Cannot occur here
        }
    }

    public int maximum() {
        return A[0];
    }

    public int extractMax() throws Exception {
        if(heapSize < 1) {
            throw new Exception("Buffer underflow");
        }

        int max = A[0];
        A[0] = A[heapSize - 1];
        heapSize = heapSize - 1;
        maxHeapifyIterative(0);
        return max;
    }

    public void increaseKey(int i, int k) throws Exception {
        if(A[i] > k) {
            throw new Exception("New key is smaller than the current key");
        }

        while(i > 0 && A[parent(i)] < k) {
            A[i] = A[parent(i)];
            i = parent(i);
        }
        A[i] = k;
    }
}

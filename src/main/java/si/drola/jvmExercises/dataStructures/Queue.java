package si.drola.jvmExercises.dataStructures;

public class Queue {
    /**
     * Index of next item to dequeue
     */
    int head = -1;

    /**
     * Index of last inserted item
     */
    int tail = -1;

    int[] data;

    public Queue(int n) {
        data = new int[n];
    }
}

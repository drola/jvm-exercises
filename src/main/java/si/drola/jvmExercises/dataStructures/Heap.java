package si.drola.jvmExercises.dataStructures;

public class Heap<T> {
    protected T[] A;
    protected int heapSize;

    public int left(int i) {
        return 2*i + 1;
    }

    public int right(int i) {
        return 2*i + 2;
    }

    public int parent(int i) {
        return (int)Math.floor((i+1) / 2) - 1;
    }
}

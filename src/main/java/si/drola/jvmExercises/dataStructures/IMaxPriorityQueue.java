package si.drola.jvmExercises.dataStructures;

public interface IMaxPriorityQueue {
    void insert(int a);
    int maximum();
    int extractMax() throws Exception;
    void increaseKey(int i, int k) throws Exception;
}

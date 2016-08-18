package si.drola.jvmExercises.dataStructures;

import org.junit.Test;

import static org.junit.Assert.*;
public class HeapPriorityQueueTest {
    @Test
    public void insert() throws Exception {
        IMaxPriorityQueue queue = new HeapPriorityQueue(new int[]{1,2, 3, 5, 6});
        assertEquals(6, queue.maximum());
        queue.insert(15);
        assertEquals(15, queue.extractMax());
        assertEquals(6, queue.extractMax());
        assertEquals(5, queue.extractMax());
        assertEquals(3, queue.extractMax());
        assertEquals(2, queue.extractMax());
        assertEquals(1, queue.extractMax());
    }
}

package si.drola.jvmExercises.sorting;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class HeapSortTest {
    @Test
    public void simpleSortTest() throws Exception {
        ISorter s = new HeapSort();
        int[] input = new int[] {1,2,3};
        int[] expected = new int[] {1,2,3};
        assertArrayEquals(expected, s.sort(input));
    }

    @Test
    public void sortTest() throws Exception {
        ISorter s = new HeapSort();
        int[] input = new int[] {3,2,1};
        int[] expected = new int[] {1,2,3};
        assertArrayEquals(expected, s.sort(input));
    }

    @Test
    public void randomNumbers() throws Exception {
        ISorter s = new HeapSort();
        int[] input    = new int[] {5, 13, 2, 25, 7, 17, 20, 8, 4};
        int[] expected = new int[] {2, 4, 5, 7, 8, 13, 17, 20, 25};
        assertArrayEquals(expected, s.sort(input));
    }

}
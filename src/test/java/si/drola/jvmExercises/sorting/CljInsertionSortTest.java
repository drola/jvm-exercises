package si.drola.jvmExercises.sorting;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class CljInsertionSortTest {
    @Test
    public void simpleSortTest() throws Exception {
        ISorter s = new CljInsertionSort();
        int[] input = new int[] {1,2,3};
        int[] expected = new int[] {1,2,3};
        assertArrayEquals(expected, s.sort(input));
    }

    @Test
    public void sortTest() throws Exception {
        ISorter s = new CljInsertionSort();
        int[] input = new int[] {3,2,1};
        int[] expected = new int[] {1,2,3};
        assertArrayEquals(expected, s.sort(input));
    }

}
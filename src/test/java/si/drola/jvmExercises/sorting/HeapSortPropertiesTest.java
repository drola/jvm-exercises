package si.drola.jvmExercises.sorting;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(JUnitQuickcheck.class)
public class HeapSortPropertiesTest {
    @Property
    public void sortedAndEqualLengthAsInput(int[] input) {
        int expectedCount = input.length;
        ISorter qs = new HeapSort();
        int[] output = qs.sort(input);
        for(int i = 1; i < output.length; i++) {
            assertTrue(output[i-1] <= output[i]);
        }
        assertEquals(expectedCount, output.length);
    }
}

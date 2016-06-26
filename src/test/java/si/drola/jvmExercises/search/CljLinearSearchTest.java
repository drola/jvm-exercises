package si.drola.jvmExercises.search;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CljLinearSearchTest {
    @Test
    public void trivialTest() throws Exception {
        int expected = -1;
        int actual = (new CljLinearSearch()).find(10, new int[]{});
        assertEquals(expected, actual);
    }

    @Test
    public void simpleTest() throws Exception {
        int expected = 0;
        int actual = (new CljLinearSearch()).find(10, new int[]{10});
        assertEquals(expected, actual);
    }

    @Test
    public void multielementListTest() throws Exception {
        int expected = 1;
        int actual = (new CljLinearSearch()).find(10, new int[]{5, 10, 15, 20});
        assertEquals(expected, actual);
    }
}
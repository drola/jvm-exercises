package si.drola.jvmExercises.dataStructures;

import org.junit.Test;

import static org.junit.Assert.*;

public class StackTest {
    @Test
    public void empty() throws Exception {
        Stack s = new Stack(10);
        assertTrue(s.empty());
        s.push(1);
        assertFalse(s.empty());
        s.pop();
        assertTrue(s.empty());
    }

    @Test
    public void pushPop() throws Exception {
        Stack s = new Stack(10);
        s.push(1);
        s.push(2);
        s.push(3);
        assertEquals(3, s.pop());
        assertEquals(2, s.pop());
        assertEquals(1, s.pop());
    }
}
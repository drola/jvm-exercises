package si.drola.jvmExercises.dataStructures;

/**
 * A simple stack that can store integers
 */
public class Stack {
    int[] data;
    int top = -1;

    /**
     * Create a new stack
     *
     * @param max Maximum number of elements to allocate space for
     */
    public Stack(int max) {
        data = new int[max];
    }

    /**
     * Check whether the stack is empty
     *
     * @return
     */
    public boolean empty() {
        return top == -1;
    }

    /**
     * Push an element onto the stack
     *
     * @param elem
     * @throws Exception
     */
    public void push(int elem) throws Exception {
        if (top + 1 == data.length) {
            throw new Exception("Stack overflow.");
        }
        top = top + 1;
        data[top] = elem;
    }

    /**
     * Pop element from the stack
     *
     * @return
     * @throws Exception
     */
    public int pop() throws Exception {
        if(empty()) {
            throw new Exception("Stack underflow.");
        }

        return data[top--];
    }
}


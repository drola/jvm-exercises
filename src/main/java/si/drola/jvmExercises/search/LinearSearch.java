package si.drola.jvmExercises.search;

public class LinearSearch implements ISearch{
    public int find(int needle, int[] haystack) {
        for(int i = 0; i < haystack.length; i++) {
            if (haystack[i] == needle) {
                return i;
            }
        }

        return -1;
    }
}

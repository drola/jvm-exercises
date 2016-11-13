package si.drola.jvmExercises.dataStructures;

public class RedBlackNode {
    public enum Color {
        RED, BLACK
    }

    public Color color;

    public RedBlackNode parent;
    public RedBlackNode left;
    public RedBlackNode right;

    public int value;
}

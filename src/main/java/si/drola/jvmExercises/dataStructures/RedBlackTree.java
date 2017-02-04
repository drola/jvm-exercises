package si.drola.jvmExercises.dataStructures;

import java.util.function.Consumer;

public class RedBlackTree extends BinarySearchTree {
    public enum Color {
        RED,
        BLACK
    }

    public static class Node extends BinarySearchTree.Node {
        Color color = Color.BLACK;

        public Node(int val, Node left, Node right) {
            super(val, left, right);
        }

        public Node(int val) {
            super(val);
        }

        public Node() {
            super();
        }

        @Override
        public String toString() {
            return String.format("(%s, %d)", color == Color.RED ? "red" : "black", val);
        }
    }
}

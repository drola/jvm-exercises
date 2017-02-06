package si.drola.jvmExercises.dataStructures;

import com.sun.org.apache.regexp.internal.RE;

public class RedBlackTree extends BinarySearchTree {
    public enum Color {
        RED,
        BLACK
    }

    public static class Node extends BinarySearchTree.Node {
        Color color = Color.BLACK;
        public Node parent, left, right;

        public Node(int val, Node left, Node right) {
            super(val, left, right);
            this.right = (Node) super.right;
            this.left = (Node) super.left;
            this.right.parent = this;
            this.left.parent = this;
        }

        public Node(int val) {
            this(val, new Node(), new Node());
        }

        public Node() {
            super();
        }

        @Override
        public String toString() {
            return String.format("(%s, %d)", color == Color.RED ? "red" : "black", val);
        }
    }

    public Node root;




    public void delete(Node x) {
        super.delete(x);

        //TODO: It appers subclassing the tree this way is not optimal.
        if(super.root == null) {
            this.root = null;
        } else {
            this.root = (Node) super.root;
        }

        //Fix colors
    }

    public void insert(Node x) {
        super.insert(x);
        //TODO: It appers subclassing the tree this way is not optimal.
        this.root = (Node) super.root;
        x.color = Color.RED;


        //Fixup of red-black tree properties
        while(x.parent != null && x.parent.color == Color.RED && x.parent.parent != null) {
            if (x.parent == x.parent.parent.left) {
                Node y = x.parent.parent.left;
                if(y.color == Color.RED) {
                    x.parent.color = Color.BLACK;
                    y.color = Color.BLACK;
                    x.parent.parent.color = Color.RED;
                    x = x.parent.parent;
                } else {
                    if(x == x.parent.right) {
                        x = x.parent;
                        leftRotate(x);
                    }
                    x.parent.color = Color.BLACK;
                    x.parent.parent.color = Color.RED;
                    rightRotate(x.parent.parent);
                }
            } else {
                Node y = x.parent.parent.right;
                if(y.color == Color.RED) {
                    x.parent.color = Color.BLACK;
                    y.color = Color.BLACK;
                    x.parent.parent.color = Color.RED;
                    x = x.parent.parent;
                } else {
                    if(x == x.parent.left) {
                        x = x.parent;
                        rightRotate(x);
                    }
                    x.parent.color = Color.BLACK;
                    x.parent.parent.color = Color.RED;
                    leftRotate(x.parent.parent);
                }
            }
        }
        root.color = Color.BLACK;
    }
}

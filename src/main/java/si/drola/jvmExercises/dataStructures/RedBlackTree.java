package si.drola.jvmExercises.dataStructures;

import com.sun.org.apache.regexp.internal.RE;

public class RedBlackTree extends BinarySearchTree<RedBlackTree.Node> {
    public enum Color {
        RED,
        BLACK
    }

    @Override
    protected RedBlackTree.Node newNode() {
        return new RedBlackTree.Node();
    }

    public class Node extends BinarySearchTree.Node<RedBlackTree.Node> {
        Color color = Color.BLACK;

        public Node(int val, RedBlackTree.Node left, RedBlackTree.Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.isNil = false;

            this.left.parent = this;
            this.right.parent = this;
        }

        public Node(int val) {
            this(val, new RedBlackTree.Node(), new RedBlackTree.Node());
        }

        public Node() {
            this.isNil = true;
        }


        @Override
        public String toString() {
            return isNil ? "NIL" : String.format("(%s, %d)", color == Color.RED ? "red" : "black", val);
        }
    }


    public RedBlackTree(RedBlackTree.Node root) {
        this.root = root;
    }

    public RedBlackTree() {
        this.root = this.newNode();
    }

    public void delete(Node x) {
        super.delete(x);


        //Fix colors
    }

    public void insert(Node x) {
        super.insert(x);

        x.color = Color.RED;

        //Fixup of red-black tree properties
        while(x.parent != null && x.parent.color == Color.RED && x.parent.parent != null) {
            if (x.parent == x.parent.parent.left) {
                Node y = x.parent.parent.right;
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
                Node y = x.parent.parent.left;
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

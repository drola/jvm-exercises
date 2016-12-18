package si.drola.jvmExercises.dataStructures;

import javax.swing.tree.TreeNode;
import java.util.function.Consumer;

public class BinarySearchTree {
    public static class Node {
        public Node left;
        public Node right;
        public Node parent;
        public int val;

        public Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;

            if (left != null) {
                this.left.parent = this;
            }

            if (right != null) {
                this.right.parent = this;
            }
        }
    }

    Node root;

    public BinarySearchTree(Node root) {
        this.root = root;
    }

    public void walkInOrder(Consumer<Node> c) {
        Node node = this.root;
        while (node != null) {
            if (node.left != null) {
                node = node.left;
                continue;
            }
            c.accept(node);

            while (node != null) {
                if (node.parent == null) {
                    node = null;
                } else if (node.parent.left == node && node.parent.right != null) {
                    c.accept(node.parent);
                    node = node.parent.right;
                    break;
                } else if (node.parent.right == node) {
                    node = node.parent;
                } else if (node.parent.left == node && node.parent.right == null) {
                    c.accept(node.parent);
                    node = node.parent;
                }
            }
        }
    }

    public Node search(int key) {
        Node node = this.root;
        while (node != null && node.val != key) {
            if(key > node.val) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        return node;
    }
}

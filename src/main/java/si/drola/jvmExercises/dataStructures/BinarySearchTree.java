package si.drola.jvmExercises.dataStructures;

import java.util.function.Consumer;

public class BinarySearchTree {
    public static class Node {
        public Node left;
        public Node right;
        public Node parent;
        public int val;
        public boolean isNil;

        public Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.isNil = false;

            this.left.parent = this;
            this.right.parent = this;
        }

        public Node(int val) {
            this(val, new Node(), new Node());
        }

        public Node() {
            this.isNil = true;
        }

        public String toString() {
            return Integer.toString(val);
        }
    }

    Node root;

    public BinarySearchTree(Node root) {
        this.root = root;
    }

    public BinarySearchTree() {
        this.root = new Node();
    }

    public void walkInOrder(Consumer<Node> c) {
        Node node = this.root;

        //Find minimum
        while (!node.isNil && !node.left.isNil) {
            node = node.left;
        }
        if (!node.isNil) {
            c.accept(node);
        }

        //Now iterate over all successors
        while (node != null && !node.isNil) {
            if (!node.right.isNil) {
                //Minimum of node.right
                node = node.right;
                while (!node.left.isNil) {
                    node = node.left;
                }
                c.accept(node);
                continue;
            }

            //Go up until we find a node where we didn't turn right
            while (node.parent != null && node.parent.right == node) {
                node = node.parent;
            }
            if (node.parent != null) {
                c.accept(node.parent);
            }
            node = node.parent;
        }
    }

    public Node search(int key) {
        Node node = this.root;
        while (!node.isNil && node.val != key) {
            if (key > node.val) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        return node.isNil ? null : node;
    }

    public static Node min(Node node) {
        while (!node.isNil && !node.left.isNil) {
            node = node.left;
        }
        return node;
    }

    public static Node max(Node node) {
        while (!node.isNil && !node.right.isNil) {
            node = node.right;
        }
        return node;
    }

    public Node min() {
        return BinarySearchTree.min(this.root);
    }

    public Node max() {
        return BinarySearchTree.max(this.root);
    }

    public static Node successor(Node node) {
        if (!node.right.isNil) {
            return BinarySearchTree.min(node.right);
        }
        while (node.parent != null && node.parent.right == node) {
            node = node.parent;
        }

        return node.parent;
    }

    public static Node predecessor(Node node) {
        if (!node.left.isNil) {
            return BinarySearchTree.max(node.left);
        }

        while (node.parent != null && node.parent.left == node) {
            node = node.parent;
        }
        return node.parent;
    }

    public void insert(Node x) {
        if (this.root.isNil) {
            this.root = x;
            x.parent = null;
            return;
        }

        Node y = this.root;
        while (true) {
            if (x.val >= y.val) {
                if (y.right.isNil) {
                    y.right = x;
                    x.parent = y;
                    return;
                } else {
                    y = y.right;
                }
            } else {
                if (y.left.isNil) {
                    y.left = x;
                    x.parent = y;
                    return;
                } else {
                    y = y.left;
                }
            }
        }
    }

    protected void transplant(Node target, Node newNode) {
        newNode.parent = target.parent;

        if (target.parent == null) {
            this.root = newNode;
        } else if (target.parent.left == target) {
            target.parent.left = newNode;
        } else if (target.parent.right == target) {
            target.parent.right = newNode;
        }
    }

    public void delete(Node x) {
        if (x.left.isNil && x.right.isNil) {
            transplant(x, new Node());
        } else if (!x.left.isNil && !x.right.isNil) {
            Node succ = BinarySearchTree.successor(x);
            if (x.right == succ) {
                x.left.parent = x.right;
                x.right.left = x.left;
                transplant(x, x.right);
            } else {
                succ.left = x.left;
                succ.left.parent = succ;
                transplant(succ, succ.right);
                succ.right = x.right;
                succ.right.parent = succ;
                transplant(x, succ);
            }
        } else if (!x.left.isNil) {
            transplant(x, x.left);
        } else if (!x.right.isNil) {
            transplant(x, x.right);
        }
    }

    public void leftRotate(Node x) {
        Node t = x.right;

        x.right = t.left;
        x.right.parent = x;

        transplant(x, t);

        t.left = x;
        t.left.parent = t;
    }

    public void rightRotate(Node x) {
        Node t = x.left;

        x.left = t.right;
        x.left.parent = x;

        transplant(x, t);

        t.right = x;
        t.right.parent = t;
    }
}

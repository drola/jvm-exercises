package si.drola.jvmExercises.dataStructures;

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

        public String toString() {
            return Integer.toString(val);
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

    public static Node min(Node node) {
        while (node != null && node.left != null) {
            node = node.left;
        }
        return node;
    }

    public static Node max(Node node) {
        while (node != null && node.right != null) {
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
        if(node.right != null) {
            return BinarySearchTree.min(node.right);
        }
        while (node.parent != null && node.parent.right == node ) {
            node = node.parent;
        }

        return node.parent;
    }

    public static Node predecessor(Node node) {
        if(node.left != null) {
            return BinarySearchTree.max(node.left);
        }

        while(node.parent != null && node.parent.left == node) {
            node = node.parent;
        }
        return node.parent;
    }

    public void insert(Node x) {
        if (this.root == null) {
            this.root = x;
            x.parent = null;
            return;
        }

        Node y = this.root;
        while (true) {
            if (x.val >= y.val) {
                if (y.right == null) {
                    y.right = x;
                    x.parent = y;
                    return;
                } else {
                    y = y.right;
                }
            } else {
                if (y.left == null) {
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
        if(newNode != null) {
            newNode.parent = target.parent;
        }
        if(target.parent == null) {
            this.root = newNode;
        } else if(target.parent.left == target) {
            target.parent.left = newNode;
        } else if(target.parent.right == target) {
            target.parent.right = newNode;
        }
    }

    public void delete(Node x) {
        if (x.left == null && x.right == null) {
            transplant(x, null);
        } else if(x.left != null && x.right != null) {
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
        } else if(x.left != null) {
            transplant(x, x.left);
        } else if(x.right != null) {
            transplant(x, x.right);
        }
    }
}

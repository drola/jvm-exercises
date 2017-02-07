package si.drola.jvmExercises.dataStructures;

import java.util.function.Consumer;

public abstract  class BinarySearchTree<TTreeNode extends BinarySearchTree.Node<TTreeNode>> {
    public static class Node<TNode extends Node> {
        public TNode left;
        public TNode right;
        public TNode parent;
        public int val;
        public boolean isNil;

        public String toString() {
            return isNil ? "NIL" : Integer.toString(val);
        }
    }

    TTreeNode root;

    protected abstract TTreeNode newNode();

    public void walkInOrder(Consumer<TTreeNode> c) {
        TTreeNode node = this.root;

        //Find minimum
        while (!node.isNil && !node.left.isNil) {
            node = node.left;
        }
        if (!node.isNil) {
            c.accept(node);
        }

        //Now iterate over all successors
        while (node != null) {
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

    public TTreeNode search(int key) {
        TTreeNode node = this.root;
        while (!node.isNil && node.val != key) {
            if (key > node.val) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        return node.isNil ? null : node;
    }

    public static <TTreeNode extends Node<TTreeNode>> TTreeNode min(TTreeNode node) {
        while (!node.isNil && !node.left.isNil) {
            node = node.left;
        }
        return node;
    }

    public static <TTreeNode extends Node<TTreeNode>> TTreeNode max(TTreeNode node) {
        while (!node.isNil && !node.right.isNil) {
            node = node.right;
        }
        return node;
    }

    public TTreeNode min() {
        return BinarySearchTree.min(this.root);
    }

    public TTreeNode max() {
        return BinarySearchTree.max(this.root);
    }

    public static <TTreeNode extends Node<TTreeNode>> TTreeNode successor(TTreeNode node) {
        if (!node.right.isNil) {
            return BinarySearchTree.min(node.right);
        }
        while (node.parent != null && node.parent.right == node) {
            node = node.parent;
        }

        return node.parent;
    }

    public static <TTreeNode extends Node<TTreeNode>> TTreeNode predecessor(TTreeNode node) {
        if (!node.left.isNil) {
            return BinarySearchTree.max(node.left);
        }

        while (node.parent != null && node.parent.left == node) {
            node = node.parent;
        }
        return node.parent;
    }

    public void insert(TTreeNode x) {
        if (this.root.isNil) {
            this.root = x;
            x.parent = null;
            return;
        }

        TTreeNode y = this.root;
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

    protected void transplant(TTreeNode target, TTreeNode newNode) {
        newNode.parent = target.parent;

        if (target.parent == null) {
            this.root = newNode;
        } else if (target.parent.left == target) {
            target.parent.left = newNode;
        } else if (target.parent.right == target) {
            target.parent.right = newNode;
        }
    }

    public void delete(TTreeNode x) {
        if (x.left.isNil && x.right.isNil) {
            transplant(x, this.newNode());
        } else if (!x.left.isNil && !x.right.isNil) {
            TTreeNode succ = BinarySearchTree.successor(x);
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

    public void leftRotate(TTreeNode x) {
        TTreeNode t = x.right;

        x.right = t.left;
        x.right.parent = x;

        transplant(x, t);

        t.left = x;
        t.left.parent = t;
    }

    public void rightRotate(TTreeNode x) {
        TTreeNode t = x.left;

        x.left = t.right;
        x.left.parent = x;

        transplant(x, t);

        t.right = x;
        t.right.parent = t;
    }
}

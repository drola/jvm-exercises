package si.drola.jvmExercises.dataStructures;


public class RedBlackTree {
    public RedBlackNode root;

    public void leftRotate(RedBlackNode x) {
        RedBlackNode y = x.right;
        x.right = y.left;
        if(y.left != null) {
            y.left.parent = x;
        }
        y.parent = x.parent;
        if(x.parent == null) {
            this.root = y;
        } else if(x == x.parent.left) {
            x.parent.left = y;
        }
        y.left = x;
        x.parent = y;
    }

    public void rightRotate(RedBlackNode x) {
        RedBlackNode y = x.left;
        x.left = y.right;
        if(y.right != null) {
            y.right.parent = x;
        }
        y.parent = x.parent;
        if(x.parent == null) {
            this.root = y;
        } else if(x == x.parent.right) {
            x.parent.right = y;
        }
        y.right = x;
        x.parent = y;
    }

    public void insert(RedBlackNode z) {
        RedBlackNode y = null;
        RedBlackNode x = this.root;
        while(x != null) {
            y = x;
            if(z.value < x.value) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        z.parent = y;
        if(y == null) {
            this.root = z;
        } else if(z.value < y.value) {
            y.left = z;
        } else {
            y.right = z;
        }
        z.left = null;
        z.right = null;
        z.color = RedBlackNode.Color.RED;

        insertFixup(z);
    }

    private void insertFixup(RedBlackNode z) {
        RedBlackNode y;

        while (z.parent.color == RedBlackNode.Color.RED) {
            if (z.parent == z.parent.parent.left) {
                y = z.parent.parent.right;
                if(y.color == RedBlackNode.Color.RED) {
                    z.parent.color = RedBlackNode.Color.BLACK;
                    y.color = RedBlackNode.Color.BLACK;
                    z.parent.parent.color = RedBlackNode.Color.RED;
                    z = z.parent.parent;
                } else {
                    if (z == z.parent.right) {
                        z = z.parent;
                        leftRotate(z);
                    }

                    z.parent.color = RedBlackNode.Color.BLACK;
                    z.parent.parent.color = RedBlackNode.Color.RED;
                    rightRotate(z.parent.parent);
                }
            } else {
                y = z.parent.parent.left;
                if(y.color == RedBlackNode.Color.RED) {
                    z.parent.color = RedBlackNode.Color.BLACK;
                    y.color = RedBlackNode.Color.BLACK;
                    z.parent.parent.color = RedBlackNode.Color.RED;
                    z = z.parent.parent;
                } else {
                    if( z == z.parent.left) {
                        z = z.parent;
                        rightRotate(z);
                    }

                    z.parent.color = RedBlackNode.Color.BLACK;
                    z.parent.parent.color = RedBlackNode.Color.RED;
                    leftRotate(z.parent.parent);
                }
            }

            this.root.color = RedBlackNode.Color.BLACK;
        }
    }


}

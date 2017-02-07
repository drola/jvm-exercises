package si.drola.jvmExercises.dataStructures;

public class SimpleBinarySearchTree extends BinarySearchTree<SimpleBinarySearchTree.Node> {
    @Override
    protected Node newNode() {
        return new Node();
    }

    public class Node extends BinarySearchTree.Node<Node> {
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
    }


    public SimpleBinarySearchTree(Node root) {
        this.root = root;
    }

    public SimpleBinarySearchTree() {
        this.root = this.newNode();
    }
}

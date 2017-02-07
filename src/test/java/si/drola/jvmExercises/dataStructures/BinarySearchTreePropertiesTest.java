package si.drola.jvmExercises.dataStructures;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.Assert.*;

@RunWith(JUnitQuickcheck.class)
public class BinarySearchTreePropertiesTest {
    @Property
    public void validateCreation(int[] nodeValues) {
        SimpleBinarySearchTree bst = new SimpleBinarySearchTree();
        for (int i = 0; i < nodeValues.length; i++) {
            bst.insert(bst.new Node(nodeValues[i]));
        }

        Arrays.sort(nodeValues);

        assertValidBst(bst);
        assertBstWithValues(nodeValues, bst);
    }

    @Property
    public void validateRotationLeft(int[] nodeValues) {
        if(nodeValues.length == 0) {
            assertTrue(true);
            return;
        }

        SimpleBinarySearchTree bst = new SimpleBinarySearchTree();
        for (int i = 0; i < nodeValues.length; i++) {
            bst.insert(bst.new Node(nodeValues[i]));
        }

        Arrays.sort(nodeValues);

        if(bst.root != null && !bst.root.isNil && !bst.root.left.isNil && !bst.root.left.right.isNil) {
            bst.leftRotate(bst.root.left);
            assertValidBst(bst);
            assertBstWithValues(nodeValues, bst);
        }
        if(bst.root != null && !bst.root.isNil && !bst.root.right.isNil) {
            bst.leftRotate(bst.root);
            assertValidBst(bst);
            assertBstWithValues(nodeValues, bst);
        }
    }

    @Property
    public void validateRotationRight(int[] nodeValues) {
        if(nodeValues.length == 0) {
            assertTrue(true);
            return;
        }

        SimpleBinarySearchTree bst = new SimpleBinarySearchTree();
        for (int i = 0; i < nodeValues.length; i++) {
            bst.insert(bst.new Node(nodeValues[i]));
        }

        Arrays.sort(nodeValues);

        if(bst.root != null && !bst.root.isNil && !bst.root.right.isNil && !bst.root.right.left.isNil) {
            bst.rightRotate(bst.root.right);
            assertValidBst(bst);
            assertBstWithValues(nodeValues, bst);
        }
        if(bst.root != null && !bst.root.isNil && !bst.root.left.isNil) {
            bst.rightRotate(bst.root);
            assertValidBst(bst);
            assertBstWithValues(nodeValues, bst);
        }
    }

    @Property
    public void validateDeletion(int[] nodeValues) {
        if(nodeValues.length == 0) {
            assertTrue(true);
            return;
        }


        SimpleBinarySearchTree bst = new SimpleBinarySearchTree();
        SimpleBinarySearchTree.Node last = null;
        for (int i = 0; i < nodeValues.length; i++) {
            last = bst.new Node(nodeValues[i]);
            bst.insert(last);
        }

        bst.delete(last);

        nodeValues = Arrays.copyOfRange(nodeValues, 0, nodeValues.length - 1);
        Arrays.sort(nodeValues);

        assertValidBst(bst);
        assertBstWithValues(nodeValues, bst);
    }

    public static <TTreeNode extends BinarySearchTree.Node<TTreeNode>> void assertBstWithValues(int[] expectedValues, BinarySearchTree<TTreeNode> t) {
        if (t.root.isNil && expectedValues.length == 0) {
            assertTrue(true);
            return;
        }

        LinkedList<Integer> result = new LinkedList<Integer>();
        t.walkInOrder((TTreeNode node) -> {
            result.add(new Integer(node.val));
        });

        int[] result_ = ArrayUtils.toPrimitive(result.toArray(new Integer[result.size()]));

        assertArrayEquals(expectedValues, result_);
    }

    public static <TTreeNode extends BinarySearchTree.Node<TTreeNode>> void assertValidBst(BinarySearchTree<TTreeNode> t) {
        if (t.root.isNil) {
            assertTrue(true);
            return;
        }

        t.walkInOrder((TTreeNode node) -> {
            if(!node.left.isNil) {
                assertEquals(node.left.parent, node);
                assertTrue(node.left.val <= node.val);
            }
            if(!node.right.isNil) {
                assertEquals(node.right.parent, node);
                assertTrue(node.right.val >= node.val);
            }
            if(node.parent != null && node != t.root) {
                assertTrue(node.parent.left == node || node.parent.right == node);
            }
        });
    }

    public static <TTreeNode extends BinarySearchTree.Node<TTreeNode>> int calculateHeight(TTreeNode node) {
        if (node == null || node.isNil) {
            return 0;
        } else {
            return 1 + Math.max(calculateHeight(node.left), calculateHeight(node.right));
        }
    }
}


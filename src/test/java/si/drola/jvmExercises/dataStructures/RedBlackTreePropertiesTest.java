package si.drola.jvmExercises.dataStructures;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import java.util.Arrays;

import static org.junit.Assert.*;

@RunWith(JUnitQuickcheck.class)
public class RedBlackTreePropertiesTest {
    @Property
    public void validateCreation(int[] nodeValues) {
        RedBlackTree bst = new RedBlackTree();
        for (int i = 0; i < nodeValues.length; i++) {
            bst.insert(bst.new Node(nodeValues[i]));
        }

        Arrays.sort(nodeValues);

        BinarySearchTreePropertiesTest.assertValidBst(bst);
        BinarySearchTreePropertiesTest.assertBstWithValues(nodeValues, bst);
        RedBlackTreePropertiesTest.assertBalancedBst(bst);
    }

    @Property
    public void validateDeletion(int[] nodeValues) {
        if(nodeValues.length == 0) {
            assertTrue(true);
            return;
        }


        RedBlackTree bst = new RedBlackTree();
        RedBlackTree.Node last = null;
        for (int i = 0; i < nodeValues.length; i++) {
            last = bst.new Node(nodeValues[i]);
            bst.insert(last);
        }

        bst.delete(last);

        nodeValues = Arrays.copyOfRange(nodeValues, 0, nodeValues.length - 1);
        Arrays.sort(nodeValues);

        BinarySearchTreePropertiesTest.assertValidBst(bst);
        BinarySearchTreePropertiesTest.assertBstWithValues(nodeValues, bst);
        //BinarySearchTreePropertiesTest.assertBalancedBst(bst);
    }

    public static void assertBalancedBst(RedBlackTree t) {
        if (t.root.isNil) {
            assertTrue(true);
            return;
        }

        t.walkInOrder((RedBlackTree.Node node) -> {
            int left = BinarySearchTreePropertiesTest.calculateHeight(node.left);
            int right = BinarySearchTreePropertiesTest.calculateHeight(node.right);
            int tolerance = Math.max(2, Math.min(left, right) * 2);

            assertTrue(String.format("Node %s is balanced (%d, %d)", node.toString(), left, right), (left - right) <= tolerance);
            assertTrue(String.format("Node %s is balanced (%d, %d)", node.toString(), left, right), (left - right) >= (-1*tolerance));
        });
    }
}


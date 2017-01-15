package si.drola.jvmExercises.dataStructures;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(JUnitQuickcheck.class)
public class BinarySearchTreePropertiesTest {
    @Property
    public void validateCreation(int[] nodeValues) {
        BinarySearchTree bst = new BinarySearchTree(null);
        for (int i = 0; i < nodeValues.length; i++) {
            bst.insert(new BinarySearchTree.Node(nodeValues[i], null, null));
            System.out.println("Insert: ");
            System.out.println(nodeValues[i]);
        }

        Arrays.sort(nodeValues);

        assertValidBst(bst);
        assertBstWithValues(nodeValues, bst);
    }

    public static void assertBstWithValues(int[] expectedValues, BinarySearchTree t) {
        LinkedList<Integer> result = new LinkedList<Integer>();
        t.walkInOrder((BinarySearchTree.Node node) -> {
            //System.out.println(node.val);
            result.add(new Integer(node.val));
            System.out.println("Walk: ");
            System.out.println(node.val);
        });

        int[] result_ = ArrayUtils.toPrimitive(result.toArray(new Integer[result.size()]));

        assertArrayEquals(expectedValues, result_);
    }

    public static void assertValidBst(BinarySearchTree t) {
        t.walkInOrder((BinarySearchTree.Node node) -> {
            if(node.left != null) {
                assertEquals(node.left.parent, node);
                assertTrue(node.left.val <= node.val);
            }
            if(node.right != null) {
                assertEquals(node.right.parent, node);
                assertTrue(node.right.val >= node.val);
            }
            if(node.parent != null) {
                assertTrue(node.parent.left == node || node.parent.right == node);
            }
        });
    }
}


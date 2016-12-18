package si.drola.jvmExercises.dataStructures;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;


public class BinarySearchTreeTest {
    @Test
    public void walkInOrder() throws Exception {
        int[] expected = new int[]{1,4,5,10,16,17,21};
        LinkedList<Integer> result = new LinkedList<Integer>();

        BinarySearchTree.Node n1 = new BinarySearchTree.Node(1, null, null);
        BinarySearchTree.Node n5 = new BinarySearchTree.Node(5, null, null);
        BinarySearchTree.Node n16 = new BinarySearchTree.Node(16, null, null);
        BinarySearchTree.Node n21 = new BinarySearchTree.Node(21, null, null);
        BinarySearchTree.Node n4 = new BinarySearchTree.Node(4, n1, n5);
        BinarySearchTree.Node n17 = new BinarySearchTree.Node(17, n16, n21);
        BinarySearchTree.Node n10 = new BinarySearchTree.Node(10, n4, n17);
        BinarySearchTree t = new BinarySearchTree(n10);

        t.walkInOrder((BinarySearchTree.Node node) -> {
            //System.out.println(node.val);
            result.add(new Integer(node.val));
        });

        int[] result_ = ArrayUtils.toPrimitive(result.toArray(new Integer[result.size()]));

        assertArrayEquals(expected, result_);
    }

}
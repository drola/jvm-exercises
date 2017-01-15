package si.drola.jvmExercises.dataStructures;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;


public class BinarySearchTreeTest {
    @Test
    public void insert() throws Exception {
        BinarySearchTree.Node n1 = new BinarySearchTree.Node(1, null, null);
        BinarySearchTree.Node n5 = new BinarySearchTree.Node(5, null, null);
        BinarySearchTree.Node n16 = new BinarySearchTree.Node(16, null, null);
        BinarySearchTree.Node n21 = new BinarySearchTree.Node(21, null, null);
        BinarySearchTree.Node n4 = new BinarySearchTree.Node(4, n1, n5);
        BinarySearchTree.Node n17 = new BinarySearchTree.Node(17, n16, n21);
        BinarySearchTree.Node n10 = new BinarySearchTree.Node(10, n4, n17);
        BinarySearchTree t = new BinarySearchTree(n10);

        BinarySearchTree.Node n22 = new BinarySearchTree.Node(22, null, null);
        t.insert(n22);
        assertEquals(n21, n22.parent);
        assertTrue(n21.right == n22);

        BinarySearchTree.Node n6 = new BinarySearchTree.Node(6, null, null);
        t.insert(n6);
        assertEquals(n5, n6.parent);
        assertTrue(n5.right == n6);
    }

    @Test
    public void predecessor() throws Exception {
        BinarySearchTree.Node n1 = new BinarySearchTree.Node(1, null, null);
        BinarySearchTree.Node n5 = new BinarySearchTree.Node(5, null, null);
        BinarySearchTree.Node n16 = new BinarySearchTree.Node(16, null, null);
        BinarySearchTree.Node n21 = new BinarySearchTree.Node(21, null, null);
        BinarySearchTree.Node n4 = new BinarySearchTree.Node(4, n1, n5);
        BinarySearchTree.Node n17 = new BinarySearchTree.Node(17, n16, n21);
        BinarySearchTree.Node n10 = new BinarySearchTree.Node(10, n4, n17);

        assertEquals(null, BinarySearchTree.predecessor(n1));
        assertEquals(n1, BinarySearchTree.predecessor(n4));
        assertEquals(n4, BinarySearchTree.predecessor(n5));
        assertEquals(n5, BinarySearchTree.predecessor(n10));
        assertEquals(n10, BinarySearchTree.predecessor(n16));
        assertEquals(n16, BinarySearchTree.predecessor(n17));
        assertEquals(n17, BinarySearchTree.predecessor(n21));
    }

    @Test
    public void successor() throws Exception {
        BinarySearchTree.Node n1 = new BinarySearchTree.Node(1, null, null);
        BinarySearchTree.Node n5 = new BinarySearchTree.Node(5, null, null);
        BinarySearchTree.Node n16 = new BinarySearchTree.Node(16, null, null);
        BinarySearchTree.Node n21 = new BinarySearchTree.Node(21, null, null);
        BinarySearchTree.Node n4 = new BinarySearchTree.Node(4, n1, n5);
        BinarySearchTree.Node n17 = new BinarySearchTree.Node(17, n16, n21);
        BinarySearchTree.Node n10 = new BinarySearchTree.Node(10, n4, n17);

        assertEquals(n4, BinarySearchTree.successor(n1));
        assertEquals(n5, BinarySearchTree.successor(n4));
        assertEquals(n10, BinarySearchTree.successor(n5));
        assertEquals(n16, BinarySearchTree.successor(n10));
        assertEquals(n17, BinarySearchTree.successor(n16));
        assertEquals(n21, BinarySearchTree.successor(n17));
        assertEquals(null, BinarySearchTree.successor(n21));
    }

    @Test
    public void min() throws Exception {
        BinarySearchTree.Node n1 = new BinarySearchTree.Node(1, null, null);
        BinarySearchTree.Node n5 = new BinarySearchTree.Node(5, null, null);
        BinarySearchTree.Node n16 = new BinarySearchTree.Node(16, null, null);
        BinarySearchTree.Node n21 = new BinarySearchTree.Node(21, null, null);
        BinarySearchTree.Node n4 = new BinarySearchTree.Node(4, n1, n5);
        BinarySearchTree.Node n17 = new BinarySearchTree.Node(17, n16, n21);
        BinarySearchTree.Node n10 = new BinarySearchTree.Node(10, n4, n17);
        BinarySearchTree t = new BinarySearchTree(n10);

        assertEquals(n1, t.min());
    }

    @Test
    public void max() throws Exception {
        BinarySearchTree.Node n1 = new BinarySearchTree.Node(1, null, null);
        BinarySearchTree.Node n5 = new BinarySearchTree.Node(5, null, null);
        BinarySearchTree.Node n16 = new BinarySearchTree.Node(16, null, null);
        BinarySearchTree.Node n21 = new BinarySearchTree.Node(21, null, null);
        BinarySearchTree.Node n4 = new BinarySearchTree.Node(4, n1, n5);
        BinarySearchTree.Node n17 = new BinarySearchTree.Node(17, n16, n21);
        BinarySearchTree.Node n10 = new BinarySearchTree.Node(10, n4, n17);
        BinarySearchTree t = new BinarySearchTree(n10);

        assertEquals(n21, t.max());
    }

    @Test
    public void search() throws Exception {
        BinarySearchTree.Node n1 = new BinarySearchTree.Node(1, null, null);
        BinarySearchTree.Node n5 = new BinarySearchTree.Node(5, null, null);
        BinarySearchTree.Node n16 = new BinarySearchTree.Node(16, null, null);
        BinarySearchTree.Node n21 = new BinarySearchTree.Node(21, null, null);
        BinarySearchTree.Node n4 = new BinarySearchTree.Node(4, n1, n5);
        BinarySearchTree.Node n17 = new BinarySearchTree.Node(17, n16, n21);
        BinarySearchTree.Node n10 = new BinarySearchTree.Node(10, n4, n17);
        BinarySearchTree t = new BinarySearchTree(n10);

        assertEquals(n1, t.search(1));
        assertEquals(n21, t.search(21));
        assertEquals(null, t.search(30));
        assertEquals(null, t.search(0));
    }

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
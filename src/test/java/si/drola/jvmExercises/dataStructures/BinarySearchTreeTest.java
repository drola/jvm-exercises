package si.drola.jvmExercises.dataStructures;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;


public class BinarySearchTreeTest {
    @Test
    public void insert() throws Exception {
        SimpleBinarySearchTree t = new SimpleBinarySearchTree();

        SimpleBinarySearchTree.Node n1 = t.new Node(1);
        SimpleBinarySearchTree.Node n5 = t.new Node(5);
        SimpleBinarySearchTree.Node n16 = t.new Node(16);
        SimpleBinarySearchTree.Node n21 = t.new Node(21);
        SimpleBinarySearchTree.Node n4 = t.new Node(4, n1, n5);
        SimpleBinarySearchTree.Node n17 = t.new Node(17, n16, n21);
        SimpleBinarySearchTree.Node n10 = t.new Node(10, n4, n17);
        t.insert(n10);

        SimpleBinarySearchTree.Node n22 = t.new Node(22);
        t.insert(n22);
        assertEquals(n21, n22.parent);
        assertTrue(n21.right == n22);

        SimpleBinarySearchTree.Node n6 = t.new Node(6);
        t.insert(n6);
        assertEquals(n5, n6.parent);
        assertTrue(n5.right == n6);
    }

    @Test
    public void predecessor() throws Exception {
        SimpleBinarySearchTree t = new SimpleBinarySearchTree();

        SimpleBinarySearchTree.Node n1 = t.new Node(1);
        SimpleBinarySearchTree.Node n5 = t.new Node(5);
        SimpleBinarySearchTree.Node n16 = t.new Node(16);
        SimpleBinarySearchTree.Node n21 = t.new Node(21);
        SimpleBinarySearchTree.Node n4 = t.new Node(4, n1, n5);
        SimpleBinarySearchTree.Node n17 = t.new Node(17, n16, n21);
        SimpleBinarySearchTree.Node n10 = t.new Node(10, n4, n17);

        assertEquals(null, SimpleBinarySearchTree.predecessor(n1));
        assertEquals(n1, SimpleBinarySearchTree.predecessor(n4));
        assertEquals(n4, SimpleBinarySearchTree.predecessor(n5));
        assertEquals(n5, SimpleBinarySearchTree.predecessor(n10));
        assertEquals(n10, SimpleBinarySearchTree.predecessor(n16));
        assertEquals(n16, SimpleBinarySearchTree.predecessor(n17));
        assertEquals(n17, SimpleBinarySearchTree.predecessor(n21));
    }

    @Test
    public void successor() throws Exception {
        SimpleBinarySearchTree t = new SimpleBinarySearchTree();


        SimpleBinarySearchTree.Node n1 = t.new Node(1);
        SimpleBinarySearchTree.Node n5 = t.new Node(5);
        SimpleBinarySearchTree.Node n16 = t.new Node(16);
        SimpleBinarySearchTree.Node n21 = t.new Node(21);
        SimpleBinarySearchTree.Node n4 = t.new Node(4, n1, n5);
        SimpleBinarySearchTree.Node n17 = t.new Node(17, n16, n21);
        SimpleBinarySearchTree.Node n10 = t.new Node(10, n4, n17);

        assertEquals(n4, SimpleBinarySearchTree.successor(n1));
        assertEquals(n5, SimpleBinarySearchTree.successor(n4));
        assertEquals(n10, SimpleBinarySearchTree.successor(n5));
        assertEquals(n16, SimpleBinarySearchTree.successor(n10));
        assertEquals(n17, SimpleBinarySearchTree.successor(n16));
        assertEquals(n21, SimpleBinarySearchTree.successor(n17));
        assertEquals(null, SimpleBinarySearchTree.successor(n21));
    }

    @Test
    public void min() throws Exception {
        SimpleBinarySearchTree t = new SimpleBinarySearchTree();

        SimpleBinarySearchTree.Node n1 = t.new Node(1);
        SimpleBinarySearchTree.Node n5 = t.new Node(5);
        SimpleBinarySearchTree.Node n16 = t.new Node(16);
        SimpleBinarySearchTree.Node n21 = t.new Node(21);
        SimpleBinarySearchTree.Node n4 = t.new Node(4, n1, n5);
        SimpleBinarySearchTree.Node n17 = t.new Node(17, n16, n21);
        SimpleBinarySearchTree.Node n10 = t.new Node(10, n4, n17);
        t.insert(n10);

        assertEquals(n1, t.min());
    }

    @Test
    public void max() throws Exception {
        SimpleBinarySearchTree t = new SimpleBinarySearchTree();

        SimpleBinarySearchTree.Node n1 = t.new Node(1);
        SimpleBinarySearchTree.Node n5 = t.new Node(5);
        SimpleBinarySearchTree.Node n16 = t.new Node(16);
        SimpleBinarySearchTree.Node n21 = t.new Node(21);
        SimpleBinarySearchTree.Node n4 = t.new Node(4, n1, n5);
        SimpleBinarySearchTree.Node n17 = t.new Node(17, n16, n21);
        SimpleBinarySearchTree.Node n10 = t.new Node(10, n4, n17);
        t.insert(n10);

        assertEquals(n21, t.max());
    }

    @Test
    public void search() throws Exception {
        SimpleBinarySearchTree t = new SimpleBinarySearchTree();

        SimpleBinarySearchTree.Node n1 = t.new Node(1);
        SimpleBinarySearchTree.Node n5 = t.new Node(5);
        SimpleBinarySearchTree.Node n16 = t.new Node(16);
        SimpleBinarySearchTree.Node n21 = t.new Node(21);
        SimpleBinarySearchTree.Node n4 = t.new Node(4, n1, n5);
        SimpleBinarySearchTree.Node n17 = t.new Node(17, n16, n21);
        SimpleBinarySearchTree.Node n10 = t.new Node(10, n4, n17);
        t.insert(n10);

        assertEquals(n1, t.search(1));
        assertEquals(n21, t.search(21));
        assertEquals(null, t.search(30));
        assertEquals(null, t.search(0));
    }

    @Test
    public void walkInOrder() throws Exception {
        SimpleBinarySearchTree t = new SimpleBinarySearchTree();

        int[] expected = new int[]{1,4,5,10,16,17,21};
        LinkedList<Integer> result = new LinkedList<Integer>();

        SimpleBinarySearchTree.Node n1 = t.new Node(1);
        SimpleBinarySearchTree.Node n5 = t.new Node(5);
        SimpleBinarySearchTree.Node n16 = t.new Node(16);
        SimpleBinarySearchTree.Node n21 = t.new Node(21);
        SimpleBinarySearchTree.Node n4 = t.new Node(4, n1, n5);
        SimpleBinarySearchTree.Node n17 = t.new Node(17, n16, n21);
        SimpleBinarySearchTree.Node n10 = t.new Node(10, n4, n17);
        t.insert(n10);

        t.walkInOrder((SimpleBinarySearchTree.Node node) -> {
            //System.out.println(node.val);
            result.add(new Integer(node.val));
        });

        int[] result_ = ArrayUtils.toPrimitive(result.toArray(new Integer[result.size()]));

        assertArrayEquals(expected, result_);
    }



}
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class BalancedBSTTest {
    @Test public void testEmpty(){
        BalancedBST bst = new BalancedBST();
        int[] array = { };
        bst.GenerateTree(array);

        Integer[] result = { };
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(result));
        assertEquals(bst.WideAllNodes(), expected);
        assertTrue(bst.IsProperBST(bst.Root));
    }

    @Test public void testOne(){
        BalancedBST bst = new BalancedBST();
        int[] array = { 1 };
        bst.GenerateTree(array);

        Integer[] result = { 1 };
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(result));
        assertEquals(bst.WideAllNodes(), expected);
        assertTrue(bst.IsProperBST(bst.Root));
    }

    @Test public void testRegres(){
        BalancedBST bst = new BalancedBST();
        int[] array = { 1, 3, 5, 7, 6, 4, 2 };
        bst.GenerateTree(array);

        Integer[] result = { 4, 2, 6, 1, 3, 5, 7 };
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(result));
        assertEquals(bst.WideAllNodes(), expected);
        assertTrue(bst.IsProperBST(bst.Root));
    }

    @Test public void testNegativeProper(){
        BalancedBST bst = new BalancedBST();
        int[] array = { 1 };
        bst.GenerateTree(array);
        BSTNode left = new BSTNode(5, bst.Root);
        bst.Root.LeftChild = left;

        assertFalse(bst.IsProperBST(bst.Root));
    }

    @Test public void testNegativeProperEq(){
        BalancedBST bst = new BalancedBST();
        int[] array = { 1 };
        bst.GenerateTree(array);
        BSTNode left = new BSTNode(1, bst.Root);
        bst.Root.LeftChild = left;

        assertFalse(bst.IsProperBST(bst.Root));
    }

    @Test public void testPositiveProperEq(){
        BalancedBST bst = new BalancedBST();
        int[] array = { 1 };
        bst.GenerateTree(array);
        BSTNode right = new BSTNode(1, bst.Root);
        bst.Root.RightChild = right;

        assertTrue(bst.IsProperBST(bst.Root));
    }

    @Test public void testRegresBalanced(){
        BalancedBST bst = new BalancedBST();
        int[] array = { 1, 3, 5, 7, 6, 4, 2 };
        bst.GenerateTree(array);

        assertTrue(bst.IsBalanced(bst.Root));
    }
}
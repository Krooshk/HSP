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

    @Test public void testBalancedEmpty(){
        BalancedBST bst = new BalancedBST();

        assertTrue(bst.IsBalanced(bst.Root));
    }

    @Test public void testBalancedOne(){
        BalancedBST bst = new BalancedBST();
        int[] array = { 1 };
        bst.GenerateTree(array);

        assertTrue(bst.IsBalanced(bst.Root));
    }

    @Test public void testRegresBalanced(){
        BalancedBST bst = new BalancedBST();
        int[] array = { 1, 3, 5, 7, 6, 4, 2 };
        bst.GenerateTree(array);

        assertTrue(bst.IsBalanced(bst.Root));
    }

    @Test public void testBalancedNegative(){
        BSTNode root = new BSTNode(1, null);
        BSTNode two2 = new BSTNode(2, root);
        BSTNode three4 = new BSTNode(3, two2);
        root.Level = 0;
        two2.Level = 1;
        three4.Level = 2;
        root.RightChild = two2;
        two2.RightChild = three4;
        BalancedBST bst = new BalancedBST();
        bst.Root = root;

        assertFalse(bst.IsBalanced(bst.Root));
    }

    @Test public void testBalancedNegativeSubTree(){
        BSTNode root = new BSTNode(8, null);
        BSTNode two1 = new BSTNode(5, root);
        BSTNode two2 = new BSTNode(10, root);
        BSTNode three2 = new BSTNode(6, two1);
        BSTNode three4 = new BSTNode(12, two2);
        BSTNode four4 = new BSTNode(7, three2);
        root.Level = 0;
        two1.Level = 1;
        two2.Level = 1;
        three2.Level = 2;
        three4.Level = 2;
        four4.Level = 3;
        root.RightChild = two2;
        root.LeftChild = two1;
        two1.RightChild = three2;
        two2.RightChild = three4;
        three2.RightChild = four4;
        BalancedBST bst = new BalancedBST();
        bst.Root = root;

        assertFalse(bst.IsBalanced(bst.Root));
    }
}


import org.junit.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class BSTAdditionalTest {
    @Test public void testInvertFull(){
        BSTNode<Integer> root = new BSTNode<Integer>(1, 1, null);
        BSTNode<Integer> two1 = new BSTNode<Integer>(2, 3, root);
        BSTNode<Integer> two2 = new BSTNode<Integer>(3, 3, root);
        BSTNode<Integer> three1 = new BSTNode<Integer>(4, 4, two1);
        BSTNode<Integer> three2 = new BSTNode<Integer>(5, 5, two1);
        BSTNode<Integer> three3 = new BSTNode<Integer>(6, 6, two2);
        BSTNode<Integer> three4 = new BSTNode<Integer>(7, 7, two2);
        root.LeftChild = two1;
        root.RightChild = two2;
        two1.LeftChild = three1;
        two1.RightChild = three2;
        two2.LeftChild = three3;
        two2.RightChild = three4;
        BSTAdditional<Integer> bst = new BSTAdditional<>(root);

        ArrayList<BSTNode> actual = new ArrayList<>();
        actual.add(root);
        actual.add(two2);
        actual.add(two1);
        actual.add(three4);
        actual.add(three3);
        actual.add(three2);
        actual.add(three1);

        bst.invert();
        ArrayList<BSTNode> result = bst.WideAllNodes();
        assertEquals(result.size(), 7);
        assertEquals(result, actual);
    }

    @Test public void testInvertEmpty(){
        BSTAdditional<Integer> bst = new BSTAdditional<>(null);

        bst.invert();
        ArrayList<BSTNode> result = bst.WideAllNodes();
        assertEquals(result.size(), 0);
    }

    @Test public void testInvertOne(){
        BSTNode<Integer> root = new BSTNode<Integer>(1, 1, null);
        BSTAdditional<Integer> bst = new BSTAdditional<>(root);

        bst.invert();
        ArrayList<BSTNode> result = bst.WideAllNodes();
        assertEquals(result.size(), 1);
    }

    @Test public void testInvertNotFull(){
        BSTNode<Integer> root = new BSTNode<Integer>(8, 8, null);
        BSTNode<Integer> two1 = new BSTNode<Integer>(4, 4, root);
        BSTNode<Integer> two2 = new BSTNode<Integer>(10, 10, root);
        BSTNode<Integer> three1 = new BSTNode<Integer>(3, 3, two1);
        BSTNode<Integer> three2 = new BSTNode<Integer>(5, 5, two1);
        BSTNode<Integer> three3 = new BSTNode<Integer>(9, 9, two2);
        BSTNode<Integer> three4 = new BSTNode<Integer>(12, 12, two2);
        BSTNode<Integer> four1 = new BSTNode<Integer>(1, 1, three1);
        BSTNode<Integer> four4 = new BSTNode<Integer>(6, 6, three2);
        root.LeftChild = two1;
        root.RightChild = two2;
        two1.LeftChild = three1;
        two1.RightChild = three2;
        two2.LeftChild = three3;
        two2.RightChild = three4;
        three1.LeftChild = four1;
        three2.RightChild = four4;
        BSTAdditional<Integer> bst = new BSTAdditional<>(root);

        ArrayList<BSTNode> actual = new ArrayList<>();
        actual.add(root);
        actual.add(two2);
        actual.add(two1);
        actual.add(three4);
        actual.add(three3);
        actual.add(three2);
        actual.add(three1);
        actual.add(four4);
        actual.add(four1);

        bst.invert();
        ArrayList<BSTNode> result = bst.WideAllNodes();
        assertEquals(result.size(), 9);
        assertEquals(result, actual);
    }
}
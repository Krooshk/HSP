import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BSTAdditionalTest {
    @Test public void identicalPositive(){
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

        BSTNode<Integer> second_root = new BSTNode<Integer>(8, 8, null);
        BSTNode<Integer> second_two1 = new BSTNode<Integer>(4, 4, root);
        BSTNode<Integer> second_two2 = new BSTNode<Integer>(10, 10, root);
        BSTNode<Integer> second_three1 = new BSTNode<Integer>(3, 3, two1);
        BSTNode<Integer> second_three2 = new BSTNode<Integer>(5, 5, two1);
        BSTNode<Integer> second_three3 = new BSTNode<Integer>(9, 9, two2);
        BSTNode<Integer> second_three4 = new BSTNode<Integer>(12, 12, two2);
        BSTNode<Integer> second_four1 = new BSTNode<Integer>(1, 1, three1);
        BSTNode<Integer> second_four4 = new BSTNode<Integer>(6, 6, three2);
        second_root.LeftChild = second_two1;
        second_root.RightChild = second_two2;
        second_two1.LeftChild = second_three1;
        second_two1.RightChild = second_three2;
        second_two2.LeftChild = second_three3;
        second_two2.RightChild = second_three4;
        second_three1.LeftChild = second_four1;
        second_three2.RightChild = second_four4;

        assertTrue(bst.isIdentical(second_root));
    }

    @Test public void identicalNegative(){
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

        BSTNode<Integer> second_root = new BSTNode<Integer>(8, 8, null);
        BSTNode<Integer> second_two1 = new BSTNode<Integer>(4, 4, root);
        BSTNode<Integer> second_two2 = new BSTNode<Integer>(10, 10, root);
        BSTNode<Integer> second_three1 = new BSTNode<Integer>(3, 3, two1);
        BSTNode<Integer> second_three2 = new BSTNode<Integer>(5, 5, two1);
        BSTNode<Integer> second_three3 = new BSTNode<Integer>(9, 9, two2);
        second_root.LeftChild = second_two1;
        second_root.RightChild = second_two2;
        second_two1.LeftChild = second_three1;
        second_two1.RightChild = second_three2;
        second_two2.LeftChild = second_three3;

        assertFalse(bst.isIdentical(second_root));
    }

    @Test public void isSymmetricNegative(){
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

        assertFalse(bst.isSymmetric());
    }

    @Test public void isSymmetricPositive(){
        BSTNode<Integer> root = new BSTNode<Integer>(8, 8, null);
        BSTNode<Integer> two1 = new BSTNode<Integer>(4, 4, root);
        BSTNode<Integer> two2 = new BSTNode<Integer>(10, 10, root);
        BSTNode<Integer> three1 = new BSTNode<Integer>(3, 3, two1);
        BSTNode<Integer> three2 = new BSTNode<Integer>(5, 5, two1);
        BSTNode<Integer> three3 = new BSTNode<Integer>(9, 9, two2);
        BSTNode<Integer> three4 = new BSTNode<Integer>(12, 12, two2);
        BSTNode<Integer> four1 = new BSTNode<Integer>(1, 1, three1);
        BSTNode<Integer> four8 = new BSTNode<Integer>(13, 13, three4);
        root.LeftChild = two1;
        root.RightChild = two2;
        two1.LeftChild = three1;
        two1.RightChild = three2;
        two2.LeftChild = three3;
        two2.RightChild = three4;
        three1.LeftChild = four1;
        three4.RightChild = four8;
        BSTAdditional<Integer> bst = new BSTAdditional<>(root);

        assertFalse(bst.isSymmetric());
    }

    @Test public void testGetAllPath(){
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

        assertEquals(bst.getAllPath(3).size(), 2);
        assertEquals(bst.getAllPath(4).size(), 2);
    }

    @Test public void testMaxPath(){
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

        ArrayList<ArrayList<Integer>> result = bst.getMaxPath();

        String path1 =  result.get(0).toString();
        String path2 =  result.get(1).toString();
        assertEquals(result.size(), 2);
        assertEquals(path1, "[8, 4, 3, 1]");
        assertEquals(path2, "[8, 4, 5, 6]");
    }
}
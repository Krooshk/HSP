import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class BSTTest {
    @Test public void testExistKey(){
        BSTNode<Integer> root = new BSTNode<Integer>(8, 99, null);
        BSTNode<Integer> left = new BSTNode<Integer>(4, 99, root);
        BSTNode<Integer> right = new BSTNode<Integer>(10, 99, root);
        root.LeftChild = left;
        root.RightChild = right;
        BST<Integer> bst = new BST<>(root);

        BSTFind<Integer> interimResultFindKey = bst.FindNodeByKey(10);

        assertEquals(interimResultFindKey.Node, right);
        assertEquals(interimResultFindKey.NodeHasKey, true);
    }

    @Test public void testNotExistKeyRight(){
        BSTNode<Integer> root = new BSTNode<Integer>(8, 99, null);
        BSTNode<Integer> left = new BSTNode<Integer>(4, 99, root);
        BSTNode<Integer> right = new BSTNode<Integer>(10, 99, root);
        root.LeftChild = left;
        root.RightChild = right;
        BST<Integer> bst = new BST<>(root);

        BSTFind<Integer> interimResultFindKey = bst.FindNodeByKey(9);

        assertEquals(interimResultFindKey.Node, right);
        assertEquals(interimResultFindKey.NodeHasKey, false);
        assertEquals(interimResultFindKey.ToLeft, true);
    }

    @Test public void testNotExistKeyLeft(){
        BSTNode<Integer> root = new BSTNode<Integer>(8, 99, null);
        BSTNode<Integer> left = new BSTNode<Integer>(4, 99, root);
        BSTNode<Integer> right = new BSTNode<Integer>(10, 99, root);
        root.LeftChild = left;
        root.RightChild = right;
        BST<Integer> bst = new BST<>(root);

        BSTFind<Integer> interimResultFindKey = bst.FindNodeByKey(12);

        assertEquals(interimResultFindKey.Node, right);
        assertEquals(interimResultFindKey.NodeHasKey, false);
        assertEquals(interimResultFindKey.ToLeft, false);
    }

    @Test public void testAddingExistKey(){
        BSTNode<Integer> root = new BSTNode<Integer>(8, 99, null);
        BSTNode<Integer> left = new BSTNode<Integer>(4, 99, root);
        BSTNode<Integer> right = new BSTNode<Integer>(10, 99, root);
        root.LeftChild = left;
        root.RightChild = right;
        BST<Integer> bst = new BST<>(root);

        boolean isAdd = bst.AddKeyValue(8, 109);

        assertEquals(isAdd, false);
        assertEquals(root.NodeValue, 99);
    }

    @Test public void testAddingKeyRight(){
        BSTNode<Integer> root = new BSTNode<Integer>(8, 99, null);
        BSTNode<Integer> left = new BSTNode<Integer>(4, 99, root);
        BSTNode<Integer> right = new BSTNode<Integer>(10, 99, root);
        root.LeftChild = left;
        root.RightChild = right;
        BST<Integer> bst = new BST<>(root);

        BSTFind<Integer> interimResultFindKeyBeforeAdd = bst.FindNodeByKey(12);
        boolean isAdd = bst.AddKeyValue(12, 1000);
        BSTFind<Integer> interimResultFindKeyAfterAdd = bst.FindNodeByKey(12);

        assertEquals(interimResultFindKeyBeforeAdd.NodeHasKey, false);
        assertEquals(isAdd, true);
        assertEquals(interimResultFindKeyAfterAdd.NodeHasKey, true);
        assertEquals(right.RightChild.NodeValue, 1000);
    }

    @Test public void testAddingKeyLeft(){
        BSTNode<Integer> root = new BSTNode<Integer>(8, 99, null);
        BSTNode<Integer> left = new BSTNode<Integer>(4, 99, root);
        BSTNode<Integer> right = new BSTNode<Integer>(10, 99, root);
        root.LeftChild = left;
        root.RightChild = right;
        BST<Integer> bst = new BST<>(root);

        BSTFind<Integer> interimResultFindKeyBeforeAdd = bst.FindNodeByKey(9);
        boolean isAdd = bst.AddKeyValue(9, 1000);
        BSTFind<Integer> interimResultFindKeyAfterAdd = bst.FindNodeByKey(9);

        assertEquals(interimResultFindKeyBeforeAdd.NodeHasKey, false);
        assertEquals(isAdd, true);
        assertEquals(interimResultFindKeyAfterAdd.NodeHasKey, true);
        assertEquals(right.LeftChild.NodeValue, 1000);
    }

    @Test public void testFindMaxRoot(){
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
        BST<Integer> bst = new BST<>(root);

        BSTNode<Integer> max = bst.FinMinMax(root, true);

        assertEquals(max, three4);
        assertEquals(max.NodeValue, 12);
    }

    @Test public void testFindMinRoot(){
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
        BST<Integer> bst = new BST<>(root);

        BSTNode<Integer> min = bst.FinMinMax(root, false);

        assertEquals(min, four1);
        assertEquals(min.NodeValue, 1);
    }

    @Test public void testFindMaxSubtree(){
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
        BST<Integer> bst = new BST<>(root);

        BSTNode<Integer> max = bst.FinMinMax(two1, true);

        assertEquals(max, four4);
        assertEquals(max.NodeValue, 6);
    }


    @Test public void testFindMinSubtree(){
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
        BST<Integer> bst = new BST<>(root);

        BSTNode<Integer> min = bst.FinMinMax(two1, false);

        assertEquals(min, four1);
        assertEquals(min.NodeValue, 1);
    }

    @Test public void testCount(){
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
        BST<Integer> bst = new BST<>(root);

        assertEquals(bst.Count(), 9);
    }

    @Test public void testCountEmpty(){
        BST<Integer> bst = new BST<>(null);

        assertEquals(bst.Count(), 0);
    }

    @Test public void testCountRegress(){
        BSTNode<Integer> root = new BSTNode<Integer>(8, 99, null);
        BSTNode<Integer> left = new BSTNode<Integer>(4, 99, root);
        BSTNode<Integer> right = new BSTNode<Integer>(10, 99, root);
        root.LeftChild = left;
        root.RightChild = right;
        BST<Integer> bst = new BST<>(root);

        assertEquals(bst.Count(), 3);
    }

    @Test public void testDeleteRoot(){
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
        BST<Integer> bst = new BST<>(root);

        BSTFind<Integer> interimResultFindKeyBeforeDelete = bst.FindNodeByKey(8);
        boolean isDelete = bst.DeleteNodeByKey(8);
        BSTFind<Integer> interimResultFindKeyAfterDelete = bst.FindNodeByKey(8);

        assertEquals(interimResultFindKeyBeforeDelete.NodeHasKey, true);
        assertEquals(isDelete, true);
        assertEquals(interimResultFindKeyAfterDelete.NodeHasKey, false);
        assertEquals(bst.Count(), 8);
    }

    @Test public void testDeleteRootWithOneChild(){
        BSTNode<Integer> root = new BSTNode<Integer>(8, 8, null);
        BSTNode<Integer> two1 = new BSTNode<Integer>(4, 4, root);
        BSTNode<Integer> three1 = new BSTNode<Integer>(3, 3, two1);
        BSTNode<Integer> three2 = new BSTNode<Integer>(5, 5, two1);
        BSTNode<Integer> four1 = new BSTNode<Integer>(1, 1, three1);
        BSTNode<Integer> four4 = new BSTNode<Integer>(6, 6, three2);
        root.LeftChild = two1;
        two1.LeftChild = three1;
        two1.RightChild = three2;
        three1.LeftChild = four1;
        three2.RightChild = four4;
        BST<Integer> bst = new BST<>(root);

        BSTFind<Integer> interimResultFindKeyBeforeDelete = bst.FindNodeByKey(8);
        boolean isDelete = bst.DeleteNodeByKey(8);
        BSTFind<Integer> interimResultFindKeyAfterDelete = bst.FindNodeByKey(8);

        assertEquals(interimResultFindKeyBeforeDelete.NodeHasKey, true);
        assertEquals(isDelete, true);
        assertEquals(interimResultFindKeyAfterDelete.NodeHasKey, false);
        assertEquals(bst.Count(), 5);
    }

    @Test public void testDeleteNotExistKey(){
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
        BST<Integer> bst = new BST<>(root);

        boolean isDelete = bst.DeleteNodeByKey(1000);

        assertEquals(isDelete, false);
        assertEquals(bst.Count(), 9);
    }

    @Test public void testDeleteWithTwoChild(){
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
        BST<Integer> bst = new BST<>(root);

        BSTFind<Integer> interimResultFindKeyBeforeDelete = bst.FindNodeByKey(10);
        boolean isDelete = bst.DeleteNodeByKey(10);
        BSTFind<Integer> interimResultFindKeyAfterDelete = bst.FindNodeByKey(10);

        assertEquals(interimResultFindKeyBeforeDelete.NodeHasKey, true);
        assertEquals(isDelete, true);
        assertEquals(interimResultFindKeyAfterDelete.NodeHasKey, false);
        assertEquals(bst.Count(), 8);
    }

    @Test public void testDeleteWithOneChildRight(){
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
        BST<Integer> bst = new BST<>(root);

        BSTFind<Integer> interimResultFindKeyBeforeDelete = bst.FindNodeByKey(5);
        boolean isDelete = bst.DeleteNodeByKey(5);
        BSTFind<Integer> interimResultFindKeyAfterDelete = bst.FindNodeByKey(5);

        assertEquals(interimResultFindKeyBeforeDelete.NodeHasKey, true);
        assertEquals(isDelete, true);
        assertEquals(interimResultFindKeyAfterDelete.NodeHasKey, false);
        assertEquals(bst.Count(), 8);
    }

    @Test public void testDeleteWithOneChildLeft(){
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
        BST<Integer> bst = new BST<>(root);

        BSTFind<Integer> interimResultFindKeyBeforeDelete = bst.FindNodeByKey(3);
        boolean isDelete = bst.DeleteNodeByKey(3);
        BSTFind<Integer> interimResultFindKeyAfterDelete = bst.FindNodeByKey(3);

        assertEquals(interimResultFindKeyBeforeDelete.NodeHasKey, true);
        assertEquals(isDelete, true);
        assertEquals(interimResultFindKeyAfterDelete.NodeHasKey, false);
        assertEquals(bst.Count(), 8);
    }
}
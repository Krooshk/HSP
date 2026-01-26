import org.junit.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class BSTNodeTest {
    @Test public void testWideAllEmpty(){
        BST<Integer> bst = new BST<>(null);

        assertEquals(bst.WideAllNodes().size(), 0);
    }

    @Test public void testWideAllOne(){
        BSTNode<Integer> root = new BSTNode<Integer>(8, 8, null);
        BST<Integer> bst = new BST<>(root);

        assertEquals(bst.WideAllNodes().size(), 1);
    }

    @Test public void testWideAll(){
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
        BST<Integer> bst = new BST<>(root);

        ArrayList<BSTNode> actual = new ArrayList<>();
        actual.add(root);
        actual.add(two1);
        actual.add(two2);
        actual.add(three1);
        actual.add(three2);
        actual.add(three3);
        actual.add(three4);
        ArrayList<BSTNode> result = bst.WideAllNodes();
        assertEquals(result.size(), 7);
        assertEquals(result, actual);
    }

    @Test public void testDeepAllEmpty(){
        BST<Integer> bst = new BST<>(null);

        assertEquals(bst.WideAllNodes().size(), 0);
    }

    @Test public void testDeepAllOne(){
        BSTNode<Integer> root = new BSTNode<Integer>(8, 8, null);
        BST<Integer> bst = new BST<>(root);

        assertEquals(bst.WideAllNodes().size(), 1);
    }

    @Test public void testDeepAllInOrder(){
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
        BST<Integer> bst = new BST<>(root);

        ArrayList<BSTNode> actual = new ArrayList<>();
        actual.add(three1);
        actual.add(two1);
        actual.add(three2);
        actual.add(root);
        actual.add(three3);
        actual.add(two2);
        actual.add(three4);
        ArrayList<BSTNode> result = bst.DeepAllNodes(0);
        assertEquals(result.size(), 7);
        assertEquals(result, actual);
    }

    @Test public void testDeepAllPostOrder(){
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
        BST<Integer> bst = new BST<>(root);

        ArrayList<BSTNode> actual = new ArrayList<>();
        actual.add(three1);
        actual.add(three2);
        actual.add(two1);
        actual.add(three3);
        actual.add(three4);
        actual.add(two2);
        actual.add(root);
        ArrayList<BSTNode> result = bst.DeepAllNodes(1);
        assertEquals(result.size(), 7);
        assertEquals(result, actual);
    }

    @Test public void testDeepAllPreOrder(){
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
        BST<Integer> bst = new BST<>(root);

        ArrayList<BSTNode> actual = new ArrayList<>();
        actual.add(root);
        actual.add(two1);
        actual.add(three1);
        actual.add(three2);
        actual.add(two2);
        actual.add(three3);
        actual.add(three4);
        ArrayList<BSTNode> result = bst.DeepAllNodes(2);
        assertEquals(result.size(), 7);
        assertEquals(result, actual);
    }

    @Test public void testSpeedFind(){
        BSTNode<Integer> root = new BSTNode<Integer>(50, 50, null);
        BSTNode<Integer> two1 = new BSTNode<Integer>(25, 25, root);
        BSTNode<Integer> two2 = new BSTNode<Integer>(75, 75, root);
        BSTNode<Integer> three1 = new BSTNode<Integer>(10, 10, two1);
        BSTNode<Integer> three2 = new BSTNode<Integer>(37, 37, two1);
        BSTNode<Integer> three3 = new BSTNode<Integer>(62, 62, two2);
        BSTNode<Integer> three4 = new BSTNode<Integer>(84, 84, two2);
        BSTNode<Integer> four1 = new BSTNode<Integer>(5, 5, three1);
        BSTNode<Integer> four2 = new BSTNode<Integer>(11, 11, three1);
        BSTNode<Integer> four3 = new BSTNode<Integer>(31, 31, three2);
        BSTNode<Integer> four4 = new BSTNode<Integer>(43, 43, three2);
        BSTNode<Integer> four5 = new BSTNode<Integer>(55, 55, three3);
        BSTNode<Integer> four6 = new BSTNode<Integer>(65, 65, three3);
        BSTNode<Integer> four7 = new BSTNode<Integer>(80, 80, three4);
        BSTNode<Integer> four8 = new BSTNode<Integer>(92, 92, three4);
        root.LeftChild = two1;
        root.RightChild = two2;
        two1.LeftChild = three1;
        two1.RightChild = three2;
        two2.LeftChild = three3;
        two2.RightChild = three4;
        three1.LeftChild = four1;
        three1.RightChild = four2;
        three2.LeftChild = four3;
        three2.RightChild = four4;
        three3.LeftChild = four5;
        three3.RightChild = four6;
        three4.LeftChild = four7;
        three4.RightChild = four8;
        BST<Integer> bst = new BST<>(root);

        long startTime = System.nanoTime();
        bst.FindNodeByKey(92);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("Время выполнения: " + duration + " нс"); // 265576 152511 139366  ~ 185817 нс
    }

}
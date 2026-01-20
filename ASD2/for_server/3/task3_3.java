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

}

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

    @Test public void testPrefixInfixConverterNull(){
        Integer[] prefix = { };
        Integer[] infix = { };

        BSTAdditional bstBase = new BSTAdditional<>(null);
        BSTAdditional BSTfromConverter = bstBase.getBst(prefix, infix);

        ArrayList<BSTNode> result = BSTfromConverter.WideAllNodes();
        int[] numberFromNodes =  result.stream()
                .mapToInt(el -> el.NodeKey)
                .toArray();

        assertArrayEquals(numberFromNodes, new int[]{});
    }

    @Test public void testPrefixInfixConverterOne(){
        Integer[] prefix = { 1 };
        Integer[] infix = { 1 };

        BSTAdditional bstBase = new BSTAdditional<>(null);
        BSTAdditional BSTfromConverter = bstBase.getBst(prefix, infix);

        ArrayList<BSTNode> result = BSTfromConverter.WideAllNodes();
        int[] numberFromNodes =  result.stream()
                .mapToInt(el -> el.NodeKey)
                .toArray();

        assertArrayEquals(numberFromNodes, new int[]{1});
    }

    @Test public void testPrefixInfixConverterEasyTree(){
        Integer[] prefix = { 1, 2 };
        Integer[] infix = { 2, 1 };

        BSTAdditional bstBase = new BSTAdditional<>(null);
        BSTAdditional BSTfromConverter = bstBase.getBst(prefix, infix);

        ArrayList<BSTNode> result = BSTfromConverter.WideAllNodes();
        int[] numberFromNodes =  result.stream()
                .mapToInt(el -> el.NodeKey)
                .toArray();

        assertArrayEquals(numberFromNodes, new int[]{1, 2});
    }

    @Test public void findIndex(){
        Integer[] prefix = { 1, 2};
        Integer[] infix = { 2, 1 };

        Integer localRoot = prefix[0];
        Integer index =  Arrays.asList(infix).indexOf(localRoot);

        assertEquals(index, 1);
    }

    @Test public void testPrefixInfixConverter(){
        Integer[] prefix = { 1, 2 ,4, 5, 3, 6, 7 };
        Integer[] infix = { 4, 2, 5, 1, 6, 3, 7};

        BSTAdditional bstBase = new BSTAdditional<>(null);
        BSTAdditional BSTfromConverter = bstBase.getBst(prefix, infix);

        ArrayList<BSTNode> result = BSTfromConverter.WideAllNodes();
        int[] numberFromNodes =  result.stream()
                .mapToInt(el -> el.NodeKey)
                .toArray();

        assertArrayEquals(numberFromNodes, new int[]{1,2,3,4,5,6,7});
    }

    @Test public void testMaximumLevel(){
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

        assertEquals(bst.getMaximumSumLevel(), 2);
    }

    @Test public void testMaximumEmpty(){
        BSTAdditional<Integer> bst = new BSTAdditional<>(null);

        assertEquals(bst.getMaximumSumLevel(), null);
    }

    @Test public void testMaximumOne(){
        BSTNode<Integer> root = new BSTNode<Integer>(8, 8, null);
        BSTAdditional<Integer> bst = new BSTAdditional<>(root);

        assertEquals(bst.getMaximumSumLevel(), 0);
    }

    @Test public void testMaximumRegress(){
        BSTNode<Integer> root = new BSTNode<Integer>(1, 1, null);
        BSTNode<Integer> two1 = new BSTNode<Integer>(2, 3, root);
        BSTNode<Integer> two2 = new BSTNode<Integer>(3, 3, root);
        root.LeftChild = two1;
        root.RightChild = two2;
        BSTAdditional<Integer> bst = new BSTAdditional<>(root);

        assertEquals(bst.getMaximumSumLevel(), 1);
    }
}
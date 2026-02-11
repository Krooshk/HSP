import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class SimpleTreeTest {
    @Test public void testRegres(){
        SimpleTreeNode root = new SimpleTreeNode(1, null);
        SimpleTreeNode two = new SimpleTreeNode(2, root);
        SimpleTreeNode three = new SimpleTreeNode(3, root);
        SimpleTreeNode six = new SimpleTreeNode(6, root);
        SimpleTreeNode five = new SimpleTreeNode(5, root);
        SimpleTreeNode seven = new SimpleTreeNode(7, root);
        SimpleTreeNode four = new SimpleTreeNode(4, root);
        SimpleTreeNode eight = new SimpleTreeNode(8, root);
        SimpleTreeNode nine = new SimpleTreeNode(9, root);
        SimpleTreeNode ten = new SimpleTreeNode(10, root);
        root.Children = new ArrayList();
        two.Children = new ArrayList();
        two.Children.add(five);
        two.Children.add(seven);
        root.Children.add(two);

        three.Children = new ArrayList();
        three.Children.add(four);
        root.Children.add(three);

        eight.Children = new ArrayList();
        eight.Children.add(nine);
        eight.Children.add(ten);
        six.Children = new ArrayList();
        six.Children.add(eight);
        root.Children.add(six);


        SimpleTree st = new SimpleTree<Integer>(root);

        assertEquals(st.Count(), 10);
        assertEquals(st.CountNodes(six), 4);

        Integer[] result = new Integer[]{ 1, 3, 1, 6 };
        assertArrayEquals(st.EvenTrees().toArray(), result);
    }

    @Test public void testRegres2(){
        SimpleTreeNode root = new SimpleTreeNode(1, null);
        SimpleTreeNode two = new SimpleTreeNode(2, root);
        SimpleTreeNode three = new SimpleTreeNode(3, root);
        SimpleTreeNode four = new SimpleTreeNode(4, two);
        SimpleTreeNode five = new SimpleTreeNode(5, three);
        SimpleTreeNode six = new SimpleTreeNode(6, three);
        SimpleTreeNode seven = new SimpleTreeNode(7, four);
        SimpleTreeNode eight = new SimpleTreeNode(8, six);

        six.Children = new ArrayList();
        six.Children.add(eight);


        three.Children = new ArrayList();
        three.Children.add(five);
        three.Children.add(six);

        root.Children = new ArrayList();
        root.Children.add(three);


        four.Children = new ArrayList();
        four.Children.add(seven);

        two.Children = new ArrayList();
        two.Children.add(four);

        root.Children.add(two);

        SimpleTree st = new SimpleTree<Integer>(root);

        Integer[] result = new Integer[]{ 1, 3, 3, 6, 2, 4 };
        assertArrayEquals(st.EvenTrees().toArray(), result);
    }

    @Test public void testEmptyEdge(){
        SimpleTreeNode root = new SimpleTreeNode(1, null);
        SimpleTreeNode two = new SimpleTreeNode(2, root);
        SimpleTreeNode three = new SimpleTreeNode(3, root);

        root.Children = new ArrayList();
        root.Children.add(three);
        root.Children.add(two);

        SimpleTree st = new SimpleTree<Integer>(root);

        Integer[] result = new Integer[]{ };
        assertArrayEquals(st.EvenTrees().toArray(), result);
    }

    @Test public void testEmptyTree(){
        SimpleTree st = new SimpleTree<Integer>(null);

        Integer[] result = new Integer[]{ };
        assertArrayEquals(st.EvenTrees().toArray(), result);
    }

    @Test public void testTreeOneNode(){
        SimpleTreeNode root = new SimpleTreeNode(1, null);
        SimpleTree st = new SimpleTree<Integer>(root);

        Integer[] result = new Integer[]{ };
        assertArrayEquals(st.EvenTrees().toArray(), result);
    }

}


class AdditionalTreeNodeTest {
    @Test public void testRegresGetCount(){
        SimpleTreeNode root = new SimpleTreeNode(1, null);
        SimpleTreeNode two = new SimpleTreeNode(2, root);
        SimpleTreeNode three = new SimpleTreeNode(3, root);
        SimpleTreeNode six = new SimpleTreeNode(6, root);
        SimpleTreeNode five = new SimpleTreeNode(5, root);
        SimpleTreeNode seven = new SimpleTreeNode(7, root);
        SimpleTreeNode four = new SimpleTreeNode(4, root);
        SimpleTreeNode eight = new SimpleTreeNode(8, root);
        SimpleTreeNode nine = new SimpleTreeNode(9, root);
        SimpleTreeNode ten = new SimpleTreeNode(10, root);
        root.Children = new ArrayList();
        two.Children = new ArrayList();
        two.Children.add(five);
        two.Children.add(seven);
        root.Children.add(two);

        three.Children = new ArrayList();
        three.Children.add(four);
        root.Children.add(three);

        eight.Children = new ArrayList();
        eight.Children.add(nine);
        eight.Children.add(ten);
        six.Children = new ArrayList();
        six.Children.add(eight);
        root.Children.add(six);


        AdditionalTreeNode st = new AdditionalTreeNode<Integer>(root);

        assertEquals(st.getCountEvenTreeForNode(root), 3);
        assertEquals(st.getCountEvenTreeForNode(six), 1);
        assertEquals(st.getCountEvenTreeForNode(two), 0);
        assertEquals(st.getCountEvenTreeForNode(three), 1);
    }

    @Test public void testRegresBalanse(){
        SimpleTreeNode root = new SimpleTreeNode(1, null);
        SimpleTreeNode two = new SimpleTreeNode(2, root);
        SimpleTreeNode three = new SimpleTreeNode(3, root);
        SimpleTreeNode six = new SimpleTreeNode(6, root);
        SimpleTreeNode five = new SimpleTreeNode(5, root);
        SimpleTreeNode seven = new SimpleTreeNode(7, root);
        SimpleTreeNode four = new SimpleTreeNode(4, root);
        SimpleTreeNode eight = new SimpleTreeNode(8, root);
        SimpleTreeNode nine = new SimpleTreeNode(9, root);
        SimpleTreeNode ten = new SimpleTreeNode(10, root);
        root.Children = new ArrayList();
        two.Children = new ArrayList();
        two.Children.add(five);
        two.Children.add(seven);
        root.Children.add(two);

        three.Children = new ArrayList();
        three.Children.add(four);
        root.Children.add(three);

        eight.Children = new ArrayList();
        eight.Children.add(nine);
        eight.Children.add(ten);
        six.Children = new ArrayList();
        six.Children.add(eight);
        root.Children.add(six);


        AdditionalTreeNode st = new AdditionalTreeNode<Integer>(root);

        st.balanceTree();
        List<SimpleTreeNode<Integer>> list = st.GetAllNodes();
        Integer[] array = list.stream().map(el -> el.level).toArray(Integer[]::new);
        assertTrue(Arrays.stream(array).allMatch(el -> el < 4));
        assertTrue(st.checkChildren(st.Root, 2));
    }

}


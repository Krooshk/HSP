import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

// _____1_____
// ___/_|__\__
// _2___3___4_
// /\___/\____
// 5_6__7_8___
// |__________
// 9__________

public class SimpleTreeNodeTest {
    @Test public void testList(){
        SimpleTreeNode<Integer> root = new SimpleTreeNode<Integer>(1, null);
        SimpleTreeNode<Integer> two = new SimpleTreeNode<Integer>(2, root);
        SimpleTreeNode<Integer> three = new SimpleTreeNode<Integer>(3, root);
        SimpleTreeNode<Integer> four = new SimpleTreeNode<Integer>(4, root);
        SimpleTreeNode<Integer> five = new SimpleTreeNode<Integer>(5, two);
        SimpleTreeNode<Integer> six = new SimpleTreeNode<Integer>(6, two);
        SimpleTreeNode<Integer> seven = new SimpleTreeNode<Integer>(7, three);
        SimpleTreeNode<Integer> eight = new SimpleTreeNode<Integer>(8, three);
        SimpleTreeNode<Integer> nine = new SimpleTreeNode<Integer>(9, five);
        root.Children = List.of(two,three,four);
        two.Children = List.of(five,six);
        three.Children = List.of(seven,eight);
        five.Children = List.of(nine);
        SimpleTree<Integer> tree = new  SimpleTree(root);
        int[] result = {1,2,3,4,5,6,7,8,9};

        int[] array = tree.GetAllNodes().stream().map(el -> el.NodeValue).mapToInt(Integer::intValue).sorted().toArray();

        assertArrayEquals(result, array);
    }

    @Test public void testAddingChild(){
        SimpleTreeNode<Integer> root = new SimpleTreeNode<Integer>(1, null);
        SimpleTreeNode<Integer> two = new SimpleTreeNode<Integer>(2, root);
        SimpleTreeNode<Integer> three = new SimpleTreeNode<Integer>(3, root);
        SimpleTreeNode<Integer> four = new SimpleTreeNode<Integer>(4, root);
        SimpleTreeNode<Integer> five = new SimpleTreeNode<Integer>(5, two);
        SimpleTreeNode<Integer> six = new SimpleTreeNode<Integer>(6, two);
        SimpleTreeNode<Integer> seven = new SimpleTreeNode<Integer>(7, three);
        SimpleTreeNode<Integer> eight = new SimpleTreeNode<Integer>(8, three);
        SimpleTreeNode<Integer> nine = new SimpleTreeNode<Integer>(9, five);
        root.Children = List.of(two,three,four);
        two.Children = List.of(five,six);
        three.Children = List.of(seven,eight);
        five.Children = List.of(nine);
        SimpleTree<Integer> tree = new  SimpleTree(root);
        SimpleTreeNode<Integer> ten = new SimpleTreeNode<Integer>(10, null);
        int[] result = {1,2,3,4,5,6,7,8,9,10};

        tree.AddChild(eight, ten);

        int[] array = tree.GetAllNodes().stream().map(el -> el.NodeValue).mapToInt(Integer::intValue).sorted().toArray();
        assertArrayEquals(result, array);
    }

    @Test public void testRemoveChild(){
        SimpleTreeNode<Integer> root = new SimpleTreeNode<Integer>(1, null);
        SimpleTreeNode<Integer> two = new SimpleTreeNode<Integer>(2, root);
        SimpleTreeNode<Integer> three = new SimpleTreeNode<Integer>(3, root);
        SimpleTreeNode<Integer> four = new SimpleTreeNode<Integer>(4, root);
        SimpleTreeNode<Integer> five = new SimpleTreeNode<Integer>(5, two);
        SimpleTreeNode<Integer> six = new SimpleTreeNode<Integer>(6, two);
        SimpleTreeNode<Integer> seven = new SimpleTreeNode<Integer>(7, three);
        SimpleTreeNode<Integer> eight = new SimpleTreeNode<Integer>(8, three);
        SimpleTreeNode<Integer> nine = new SimpleTreeNode<Integer>(9, five);
        root.Children = List.of(two,three,four);
        two.Children = List.of(five,six);
        three.Children = List.of(seven,eight);
        five.Children = List.of(nine);
        SimpleTree<Integer> tree = new SimpleTree(root);

        tree.DeleteNode(two);

        assertEquals(tree.GetAllNodes().size(), 5);
    }

    @Test public void testFindNodesByValue(){
        SimpleTreeNode<Integer> root = new SimpleTreeNode<Integer>(1, null);
        SimpleTreeNode<Integer> two = new SimpleTreeNode<Integer>(2, root);
        SimpleTreeNode<Integer> three = new SimpleTreeNode<Integer>(10, root);
        SimpleTreeNode<Integer> four = new SimpleTreeNode<Integer>(4, root);
        SimpleTreeNode<Integer> five = new SimpleTreeNode<Integer>(10, two);
        SimpleTreeNode<Integer> six = new SimpleTreeNode<Integer>(6, two);
        SimpleTreeNode<Integer> seven = new SimpleTreeNode<Integer>(7, three);
        SimpleTreeNode<Integer> eight = new SimpleTreeNode<Integer>(10, three);
        SimpleTreeNode<Integer> nine = new SimpleTreeNode<Integer>(9, five);
        root.Children = List.of(two,three,four);
        two.Children = List.of(five,six);
        three.Children = List.of(seven,eight);
        five.Children = List.of(nine);
        SimpleTree<Integer> tree = new  SimpleTree(root);

        assertEquals(tree.FindNodesByValue(10).size(), 3);
    }

    @Test public void testMoveNode(){
        SimpleTreeNode<Integer> root = new SimpleTreeNode<Integer>(1, null);
        SimpleTreeNode<Integer> two = new SimpleTreeNode<Integer>(2, root);
        SimpleTreeNode<Integer> three = new SimpleTreeNode<Integer>(3, root);
        SimpleTreeNode<Integer> four = new SimpleTreeNode<Integer>(4, root);
        SimpleTreeNode<Integer> five = new SimpleTreeNode<Integer>(5, two);
        SimpleTreeNode<Integer> six = new SimpleTreeNode<Integer>(6, two);
        SimpleTreeNode<Integer> seven = new SimpleTreeNode<Integer>(7, three);
        SimpleTreeNode<Integer> eight = new SimpleTreeNode<Integer>(8, three);
        SimpleTreeNode<Integer> nine = new SimpleTreeNode<Integer>(9, five);
        root.Children = List.of(two,three,four);
        two.Children = List.of(five,six);
        three.Children = List.of(seven,eight);
        five.Children = List.of(nine);
        SimpleTree<Integer> tree = new  SimpleTree(root);
        int[] result = {1,2,3,4,5,6,7,8,9};

        tree.MoveNode(two, three);

        int[] array = tree.GetAllNodes().stream().map(el -> el.NodeValue).mapToInt(Integer::intValue).sorted().toArray();
        assertArrayEquals(result, array);
        assertEquals(root.Children.size(), 2);
    }

    @Test public void testCount(){
        SimpleTreeNode<Integer> root = new SimpleTreeNode<Integer>(1, null);
        SimpleTreeNode<Integer> two = new SimpleTreeNode<Integer>(2, root);
        SimpleTreeNode<Integer> three = new SimpleTreeNode<Integer>(3, root);
        SimpleTreeNode<Integer> four = new SimpleTreeNode<Integer>(4, root);
        SimpleTreeNode<Integer> five = new SimpleTreeNode<Integer>(5, two);
        SimpleTreeNode<Integer> six = new SimpleTreeNode<Integer>(6, two);
        SimpleTreeNode<Integer> seven = new SimpleTreeNode<Integer>(7, three);
        SimpleTreeNode<Integer> eight = new SimpleTreeNode<Integer>(8, three);
        SimpleTreeNode<Integer> nine = new SimpleTreeNode<Integer>(9, five);
        root.Children = List.of(two,three,four);
        two.Children = List.of(five,six);
        three.Children = List.of(seven,eight);
        five.Children = List.of(nine);
        SimpleTree<Integer> tree = new  SimpleTree(root);

        assertEquals(tree.Count(), 9);
    }

    @Test public void testCountLeaf(){
        SimpleTreeNode<Integer> root = new SimpleTreeNode<Integer>(1, null);
        SimpleTreeNode<Integer> two = new SimpleTreeNode<Integer>(2, root);
        SimpleTreeNode<Integer> three = new SimpleTreeNode<Integer>(3, root);
        SimpleTreeNode<Integer> four = new SimpleTreeNode<Integer>(4, root);
        SimpleTreeNode<Integer> five = new SimpleTreeNode<Integer>(5, two);
        SimpleTreeNode<Integer> six = new SimpleTreeNode<Integer>(6, two);
        SimpleTreeNode<Integer> seven = new SimpleTreeNode<Integer>(7, three);
        SimpleTreeNode<Integer> eight = new SimpleTreeNode<Integer>(8, three);
        SimpleTreeNode<Integer> nine = new SimpleTreeNode<Integer>(9, five);
        root.Children = List.of(two,three,four);
        two.Children = List.of(five,six);
        three.Children = List.of(seven,eight);
        five.Children = List.of(nine);
        SimpleTree<Integer> tree = new SimpleTree(root);

        assertEquals(tree.LeafCount(), 5);
    }

    @Test public void testLevel(){
        SimpleTreeNode<Integer> root = new SimpleTreeNode<Integer>(1, null);
        SimpleTreeNode<Integer> two = new SimpleTreeNode<Integer>(2, root);
        SimpleTreeNode<Integer> three = new SimpleTreeNode<Integer>(3, root);
        SimpleTreeNode<Integer> four = new SimpleTreeNode<Integer>(4, root);
        SimpleTreeNode<Integer> five = new SimpleTreeNode<Integer>(5, two);
        SimpleTreeNode<Integer> six = new SimpleTreeNode<Integer>(6, two);
        SimpleTreeNode<Integer> seven = new SimpleTreeNode<Integer>(7, three);
        SimpleTreeNode<Integer> eight = new SimpleTreeNode<Integer>(8, three);
        SimpleTreeNode<Integer> nine = new SimpleTreeNode<Integer>(9, five);
        root.Children = List.of(two,three,four);
        two.Children = List.of(five,six);
        three.Children = List.of(seven,eight);
        five.Children = List.of(nine);
        SimpleTree<Integer> tree = new SimpleTree(root);

        tree.Level();

        assertEquals(root.level, 1);
        assertEquals(two.level, 2);
        assertEquals(three.level, 2);
        assertEquals(four.level, 2);
        assertEquals(five.level, 3);
        assertEquals(six.level, 3);
        assertEquals(seven.level, 3);
        assertEquals(eight.level, 3);
        assertEquals(nine.level, 4);
    }
}
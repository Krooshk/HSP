import org.junit.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class LinkedListTest {

    @Test public void testRemoveEmty(){
        LinkedList list = new  LinkedList();

        assertEquals(list.remove(5), false);
    }

    @Test public void testRemoveOne(){
        LinkedList list = new  LinkedList();
        Node node1 = new Node(1);
        list.addInTail(node1);

        assertEquals(list.remove(1), true);

        assertEquals(list.tail, null);
        assertEquals(list.head, null);
    }

    @Test public void testRemoveEnd(){
        LinkedList list = new  LinkedList();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        list.addInTail(node1);
        list.addInTail(node2);

        assertEquals(list.remove(2), true);

        assertEquals(list.tail, list.head);
        assertEquals(list.head, node1);
    }



    @Test public void testRemoveMiddle(){
        LinkedList list = new  LinkedList();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        list.addInTail(node1);
        list.addInTail(node2);
        list.addInTail(node3);

        assertEquals(list.remove(2), true);

        assertEquals(list.head, node1);
        assertEquals(list.tail, node3);
    }

    //-------------

    @Test public void testRemoveAllSuccess(){
        LinkedList list = new  LinkedList();
        for (int i = 0; i < 3; i++){
            list.addInTail(new Node(1));
        }

        list.removeAll(1);

        assertEquals(list.head, null);
        assertEquals(list.tail, null);
    }

    @Test public void testRemoveAllFailure(){
        LinkedList list = new  LinkedList();
        Node node1 = new Node(1);
        Node node2 = new Node(1);
        Node node3 = new Node(1);
        list.addInTail(node1);
        list.addInTail(node2);
        list.addInTail(node3);

        list.removeAll(2);

        assertEquals(list.head, node1);
        assertEquals(list.tail, node3);
    }

    //-------------

    @Test public void testClear(){
        LinkedList list = new  LinkedList();
        for (int i = 0; i < 3; i++){
            list.addInTail(new Node(1));
        }

        list.clear();

        assertEquals(list.head, null);
        assertEquals(list.tail, null);
    }

    //-------------

    @Test public void testFindAllSuccess(){
        LinkedList list = new  LinkedList();
        ArrayList<Node> nodes = new ArrayList<>();
        for (int i = 0; i < 3; i++){
            Node node1 = new Node(1);
            list.addInTail(node1);
            nodes.add(node1);
        }

        ArrayList nodes2 = list.findAll(1);

        assertArrayEquals(nodes.toArray(), nodes2.toArray());
    }

    @Test public void testFindAllOnlyOne(){
        LinkedList list = new  LinkedList();
        ArrayList<Node> nodes = new ArrayList<>();
        for (int i = 0; i < 3; i++){
            Node node1 = new Node(1);
            list.addInTail(node1);
        }
        Node node2 = new Node(2);
        list.addInTail(node2);
        nodes.add(node2);

        ArrayList nodes2 = list.findAll(2);

        assertArrayEquals(nodes.toArray(), nodes2.toArray());
    }

    //-------------

    @Test public void testLengthEmpty(){
        LinkedList list = new  LinkedList();

        assertEquals(list.count(), 0);
    }

    @Test public void testLengthWithNodes(){
        LinkedList list = new  LinkedList();
        ArrayList<Node> nodes = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            list.addInTail(new Node(i));
        }

        assertEquals(list.count(), 10);
    }

    //-------------

    @Test public void testInsertEmpty(){
        LinkedList list = new  LinkedList();
        Node node = new Node(1);

        list.insertAfter(null, node);

        assertEquals(list.tail, node);
        assertEquals(list.head, node);
    }

    @Test public void testInsertStart(){
        LinkedList list = new  LinkedList();
        Node node1 = new Node(1);
        Node node2 = new Node(3);
        Node node3 = new Node(2);
        list.addInTail(node1);
        list.addInTail(node2);

        list.insertAfter(node1, node3);

        assertEquals(list.count(), 3);
        assertEquals(list.head, node1);
        assertEquals(list.tail, node2);
        assertEquals(node1.next, node3);
    }

    @Test public void testInsertEnd(){
        LinkedList list = new  LinkedList();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        list.addInTail(node1);
        list.addInTail(node2);

        list.insertAfter(node2, node3);

        assertEquals(list.count(), 3);
        assertEquals(list.head, node1);
        assertEquals(list.tail, node3);
        assertEquals(node2.next, node3);
    }

    @Test public void testInsertMiddle(){
        LinkedList list = new  LinkedList();
        Node node1 = new Node(1);
        Node node2 = new Node(3);
        Node node3 = new Node(2);
        list.addInTail(node1);
        list.addInTail(node2);

        list.insertAfter(node1, node3);

        assertEquals(list.count(), 3);
        assertEquals(list.head, node1);
        assertEquals(list.tail, node2);
        assertEquals(node1.next, node3);
    }
}
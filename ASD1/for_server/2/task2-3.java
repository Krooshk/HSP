import org.junit.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

// 2-8 Tests

public class LinkedList2Test {

    @Test public void testFind(){
        LinkedList2 list = new  LinkedList2();

        Node node1 = new Node(1);
        list.addInTail(node1);
        Node node2 = new Node(1);
        list.addInTail(node2);
        Node node3 = new Node(1);
        list.addInTail(node3);

        assertEquals(list.find(1), node1);
    }

    @Test public void testFindEmpty(){
        LinkedList2 list = new  LinkedList2();

        Node node1 = new Node(1);
        list.addInTail(node1);
        Node node2 = new Node(1);
        list.addInTail(node2);
        Node node3 = new Node(1);
        list.addInTail(node3);

        assertEquals(list.find(2), null);
    }

    //----------------------

    @Test public void testFindAllSuccess(){
        LinkedList2 list = new  LinkedList2();
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
        LinkedList2 list = new  LinkedList2();
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

    //----------------------

    @Test public void testRemoveEmty(){
        LinkedList2 list = new  LinkedList2();

        assertEquals(list.remove(5), false);
    }

    @Test public void testRemoveOne(){
        LinkedList2 list = new  LinkedList2();
        Node node1 = new Node(1);
        list.addInTail(node1);

        assertEquals(list.remove(1), true);

        assertEquals(list.tail, null);
        assertEquals(list.head, null);
    }

    @Test public void testRemoveEnd(){
        LinkedList2 list = new  LinkedList2();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        list.addInTail(node1);
        list.addInTail(node2);

        assertEquals(list.remove(2), true);

        assertEquals(list.tail, list.head);
        assertEquals(list.head, node1);
    }

    @Test public void testRemoveMiddle(){
        LinkedList2 list = new  LinkedList2();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        list.addInTail(node1);
        list.addInTail(node2);
        list.addInTail(node3);

        assertEquals(list.remove(2), true);

        assertEquals(list.head, node1);
        assertEquals(list.tail, node3);
        assertEquals(node1.next, node3);
        assertEquals(node3.prev, node1);
    }

    @Test public void testRemoveStart(){
        LinkedList2 list = new  LinkedList2();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        list.addInTail(node1);
        list.addInTail(node2);
        list.addInTail(node3);

        assertEquals(list.remove(1), true);

        assertEquals(list.head, node2);
        assertEquals(list.tail, node3);
        assertEquals(node2.prev, null);
    }

    //-------------

    @Test public void testClear(){
        LinkedList2 list = new  LinkedList2();
        for (int i = 0; i < 3; i++){
            list.addInTail(new Node(1));
        }

        list.clear();

        assertEquals(list.head, null);
        assertEquals(list.tail, null);
    }

    //-------------

    @Test public void testRemoveAllSuccess(){
        LinkedList2 list = new  LinkedList2();
        for (int i = 0; i < 3; i++){
            list.addInTail(new Node(1));
        }

        list.removeAll(1);

        assertEquals(list.head, null);
        assertEquals(list.tail, null);
    }

    @Test public void testRemoveAllFailure(){
        LinkedList2 list = new  LinkedList2();
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

    @Test public void testRemoveAllRegress(){
        LinkedList2 list = new  LinkedList2();
        Node node1 = new Node(2);
        Node node2 = new Node(1);
        Node node3 = new Node(2);
        Node node4 = new Node(1);
        Node node5 = new Node(2);
        list.addInTail(node1);
        list.addInTail(node2);
        list.addInTail(node3);
        list.addInTail(node4);
        list.addInTail(node5);

        list.removeAll(1);

        assertEquals(list.head, node1);
        assertEquals(list.tail, node5);
        assertEquals(node1.next, node3);
        assertEquals(node3.next, node5);
        assertEquals(node5.prev, node3);
        assertEquals(node3.prev, node1);
    }

    //-------------

    @Test public void testInsertEmpty(){
        LinkedList2 list = new  LinkedList2();
        Node node = new Node(1);

        list.insertAfter(null, node);

        assertEquals(list.tail, node);
        assertEquals(list.head, node);
        assertEquals(node.prev, null);
    }

    @Test public void testInsertStartUseNull(){
        LinkedList2 list = new  LinkedList2();
        Node node2 = new Node(1);
        list.addInTail(node2);

        Node node = new Node(2);

        list.insertAfter(null, node);

        assertEquals(list.tail, node2);
        assertEquals(list.head, node);
        assertEquals(node.prev, null);
        assertEquals(node2.prev, node);
    }

    @Test public void testInsertStart(){
        LinkedList2 list = new  LinkedList2();
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
        assertEquals(node3.prev, node1);
        assertEquals(node2.prev, node3);
    }

    @Test public void testInsertEnd(){
        LinkedList2 list = new  LinkedList2();
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
        assertEquals(node3.prev, node2);
    }

    @Test public void testInsertMiddle(){
        LinkedList2 list = new  LinkedList2();
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
        assertEquals(node3.prev, node1);
        assertEquals(node2.prev, node3);
    }

}
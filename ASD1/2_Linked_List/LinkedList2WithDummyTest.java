import org.junit.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedList2WithDummyTest {
    @Test public void testFind(){
        LinkedList2WithDummy list = new  LinkedList2WithDummy();

        Node2 node1 = new Node2(1);
        list.addInTail(node1);
        Node2 node2 = new Node2(1);
        list.addInTail(node2);
        Node2 node3 = new Node2(1);
        list.addInTail(node3);

        assertEquals(list.find(1), node1);
    }

    @Test public void testFindEmpty(){
        LinkedList2WithDummy list = new  LinkedList2WithDummy();

        Node2 node1 = new Node2(1);
        list.addInTail(node1);
        Node2 node2 = new Node2(1);
        list.addInTail(node2);
        Node2 node3 = new Node2(1);
        list.addInTail(node3);

        assertEquals(list.find(2), null);
    }

    //----------------------

    @Test public void testFindAllSuccess(){
        LinkedList2WithDummy list = new  LinkedList2WithDummy();
        ArrayList<Node2> nodes = new ArrayList<>();
        for (int i = 0; i < 3; i++){
            Node2 node1 = new Node2(1);
            list.addInTail(node1);
            nodes.add(node1);
        }

        ArrayList nodes2 = list.findAll(1);

        assertArrayEquals(nodes.toArray(), nodes2.toArray());
    }

    @Test public void testFindAllOnlyOne(){
        LinkedList2WithDummy list = new  LinkedList2WithDummy();
        ArrayList<Node2> nodes = new ArrayList<>();
        for (int i = 0; i < 3; i++){
            Node2 node1 = new Node2(1);
            list.addInTail(node1);
        }
        Node2 node2 = new Node2(2);
        list.addInTail(node2);
        nodes.add(node2);

        ArrayList nodes2 = list.findAll(2);

        assertArrayEquals(nodes.toArray(), nodes2.toArray());
    }

    //----------------------

    @Test public void testRemoveEmty(){
        LinkedList2WithDummy list = new  LinkedList2WithDummy();

        assertEquals(list.remove(5), false);
    }

    @Test public void testRemoveOne(){
        LinkedList2WithDummy list = new  LinkedList2WithDummy();
        Node2 node1 = new Node2(1);
        list.addInTail(node1);

        assertEquals(list.remove(1), true);

        assertEquals(list.count(), 0);
    }

    @Test public void testRemoveEnd(){
        LinkedList2WithDummy list = new  LinkedList2WithDummy();
        Node2 node1 = new Node2(1);
        Node2 node2 = new Node2(2);
        list.addInTail(node1);
        list.addInTail(node2);

        assertEquals(list.remove(2), true);
    }

    @Test public void testRemoveMiddle(){
        LinkedList2WithDummy list = new  LinkedList2WithDummy();
        Node2 node1 = new Node2(1);
        Node2 node2 = new Node2(2);
        Node2 node3 = new Node2(3);
        list.addInTail(node1);
        list.addInTail(node2);
        list.addInTail(node3);

        assertEquals(list.remove(2), true);

        assertEquals(node1.next, node3);
        assertEquals(node3.prev, node1);
    }

    @Test public void testRemoveStart(){
        LinkedList2WithDummy list = new  LinkedList2WithDummy();
        Node2 node1 = new Node2(1);
        Node2 node2 = new Node2(2);
        Node2 node3 = new Node2(3);
        list.addInTail(node1);
        list.addInTail(node2);
        list.addInTail(node3);

        assertEquals(list.remove(1), true);

        assertEquals(node2.prev.value, null);
    }

    //-------------


    @Test public void testRemoveAllSuccess(){
        LinkedList2WithDummy list = new  LinkedList2WithDummy();
        for (int i = 0; i < 3; i++){
            list.addInTail(new Node2(1));
        }

        list.removeAll(1);

        assertEquals(list.count(), 0);
    }

    @Test public void testRemoveAllRegress(){
        LinkedList2WithDummy list = new LinkedList2WithDummy();
        Node2 node1 = new Node2(2);
        Node2 node2 = new Node2(1);
        Node2 node3 = new Node2(2);
        Node2 node4 = new Node2(1);
        Node2 node5 = new Node2(2);
        list.addInTail(node1);
        list.addInTail(node2);
        list.addInTail(node3);
        list.addInTail(node4);
        list.addInTail(node5);

        list.removeAll(1);

        assertEquals(node1.next, node3);
        assertEquals(node3.next, node5);
        assertEquals(node5.prev, node3);
        assertEquals(node3.prev, node1);
    }

    //-------------

    @Test public void testInsertEmpty(){
        LinkedList2WithDummy list = new  LinkedList2WithDummy();
        Node2 node = new Node2(1);

        list.insertAfter(null, node);

        assertEquals(node.prev.value, null);
    }

    @Test public void testInsertStartUseNull(){
        LinkedList2WithDummy list = new  LinkedList2WithDummy();
        Node2 node2 = new Node2(1);
        list.addInTail(node2);

        Node2 node = new Node2(2);

        list.insertAfter(null, node);

        assertEquals(node.prev.value, null);
        assertEquals(node2.prev, node);
    }

    @Test public void testInsertStart(){
        LinkedList2WithDummy list = new  LinkedList2WithDummy();
        Node2 node1 = new Node2(1);
        Node2 node2 = new Node2(3);
        Node2 node3 = new Node2(2);
        list.addInTail(node1);
        list.addInTail(node2);

        list.insertAfter(node1, node3);

        assertEquals(list.count(), 3);
        assertEquals(node1.next, node3);
        assertEquals(node3.prev, node1);
        assertEquals(node2.prev, node3);
    }

    @Test public void testInsertEnd(){
        LinkedList2WithDummy list = new  LinkedList2WithDummy();
        Node2 node1 = new Node2(1);
        Node2 node2 = new Node2(2);
        Node2 node3 = new Node2(3);
        list.addInTail(node1);
        list.addInTail(node2);

        list.insertAfter(node2, node3);

        assertEquals(list.count(), 3);
        assertEquals(node2.next, node3);
        assertEquals(node3.prev, node2);
    }

    @Test public void testInsertMiddle(){
        LinkedList2WithDummy list = new  LinkedList2WithDummy();
        Node2 node1 = new Node2(1);
        Node2 node2 = new Node2(3);
        Node2 node3 = new Node2(2);
        list.addInTail(node1);
        list.addInTail(node2);

        list.insertAfter(node1, node3);

        assertEquals(list.count(), 3);
        assertEquals(node1.next, node3);
        assertEquals(node3.prev, node1);
        assertEquals(node2.prev, node3);
    }
}
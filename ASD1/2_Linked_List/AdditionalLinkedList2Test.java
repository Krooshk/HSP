import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AdditionalLinkedList2Test {

    // reverseLinkedList
    @Test public void reverse(){
        LinkedList2 list = new LinkedList2();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        list.addInTail(node1);
        list.addInTail(node2);
        list.addInTail(node3);

        AdditionalLinkedList2.reverseLinkedList(list);

        assertEquals(list.head, node3);
        assertEquals(list.tail, node1);
        assertEquals(node1.prev, node2);
        assertEquals(node2.prev, node3);
        assertEquals(node3.next, node2);
        assertEquals(node2.next, node1);
    }

    @Test public void reverseOne(){
        LinkedList2 list = new LinkedList2();
        Node node1 = new Node(1);
        list.addInTail(node1);

        AdditionalLinkedList2.reverseLinkedList(list);

        assertEquals(list.head, node1);
        assertEquals(list.tail, node1);
        assertEquals(node1.prev, null);
        assertEquals(node1.next, null);
    }

    // circular
    @Test public void circularFalse(){
        LinkedList2 list = new LinkedList2();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        list.addInTail(node1);
        list.addInTail(node2);
        list.addInTail(node3);

        assertEquals(AdditionalLinkedList2.circular(list), false);
    }

    @Test public void circularTrue(){
        LinkedList2 list = new LinkedList2();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        list.addInTail(node1);
        list.addInTail(node2);
        list.addInTail(node3);
        node3.next = node1;
        node1.prev = node3;

        assertEquals(AdditionalLinkedList2.circular(list), true);
    }

    // sort

    @Test public void sortRegres(){
        LinkedList2 list = new LinkedList2();
        Node node5 = new Node(5);
        Node node4 = new Node(4);
        Node node3 = new Node(3);
        Node node2 = new Node(2);
        Node node1 = new Node(1);
        list.addInTail(node5);
        list.addInTail(node4);
        list.addInTail(node3);
        list.addInTail(node2);
        list.addInTail(node1);

        AdditionalLinkedList2.sort(list);

        assertEquals(list.head, node1);
        assertEquals(list.tail, node5);
        assertEquals(node1.next, node2);
        assertEquals(node2.next, node3);
        assertEquals(node3.next, node4);
        assertEquals(node4.next, node5);
        assertEquals(node5.prev, node4);
        assertEquals(node4.prev, node3);
        assertEquals(node3.prev, node2);
        assertEquals(node2.prev, node1);
    }

    @Test public void sortRegres2(){
        LinkedList2 list = new LinkedList2();
        Node node5 = new Node(5);
        Node node4 = new Node(4);
        Node node3 = new Node(3);
        Node node2 = new Node(2);
        Node node1 = new Node(1);
        list.addInTail(node5);
        list.addInTail(node3);
        list.addInTail(node1);
        list.addInTail(node4);
        list.addInTail(node2);

        AdditionalLinkedList2.sort(list);

        assertEquals(list.head, node1);
        assertEquals(list.tail, node5);
        assertEquals(node1.next, node2);
        assertEquals(node2.next, node3);
        assertEquals(node3.next, node4);
        assertEquals(node4.next, node5);
        assertEquals(node5.prev, node4);
        assertEquals(node4.prev, node3);
        assertEquals(node3.prev, node2);
        assertEquals(node2.prev, node1);
    }

    // merge
    @Test public void mergeRegres(){
        LinkedList2 list1 = new LinkedList2();
        LinkedList2 list2 = new LinkedList2();
        Node node3 = new Node(3);
        Node node2 = new Node(2);
        Node node1 = new Node(1);
        list1.addInTail(node3);
        list1.addInTail(node2);
        list1.addInTail(node1);

        Node node5 = new Node(5);
        Node node4 = new Node(4);
        Node node6 = new Node(6);
        list2.addInTail(node5);
        list2.addInTail(node4);
        list2.addInTail(node6);

        LinkedList2 list =  AdditionalLinkedList2.merge(list1, list2);

        assertEquals(list.count(), 6);
        assertEquals(list.head, node1);
        assertEquals(list.tail, node6);
        assertEquals(list.getStringView(), "123456");
    }
}
import java.util.ArrayList;
import java.util.HashSet;

public class AdditionalLinkedList2 {

    public static LinkedList2 reverseLinkedList(LinkedList2 list) {
        Node node = list.head;
        list.head = list.tail;
        list.tail = node;
        while (node != null) {
            Node prev = node.prev;
            node.prev = node.next;
            node.next = prev;
            node = node.prev;
        }

        return list;
    }

    public static boolean circular(LinkedList2 list){
        HashSet<Node> set = new HashSet<>();
        Node node = list.head;

        while (node != null) {
            if (set.contains(node)) {
                return true;
            }
            set.add(node);
            node = node.next;
        }

        return false;
    }

    public static LinkedList2 sort(LinkedList2 list) {
        Node prev = list.head;
        Integer length = null;
        int iter = 0;

        while (length == null || length > 1) {
            Node curr = prev.next;
            iter++;
            boolean isFirstEnd = curr == null;
            boolean isReachSamePosition = length != null && iter == length;
            if (isFirstEnd || isReachSamePosition) {
                length = iter - 1;
                iter = 0;
                prev = list.head;
                continue;
            }
            if (prev.value > curr.value) {
                swap(list, prev, curr);
            } else {
                prev = curr;
            }
        }

        return list;
    }

    public static void swap(LinkedList2 list, Node left, Node right) {
        if (left.prev != null) {
            left.prev.next = right;
        }
        if (right.next != null) {
            right.next.prev = left;
        }

        if (left.prev == null) {
            list.head = right;
        }
        if (right.next == null) {
            list.tail = left;
        }
        Node temp = left.prev;
        left.next = right.next;
        left.prev = right;
        right.prev = temp;
        right.next = left;
    }

    public static LinkedList2 merge(LinkedList2 list1, LinkedList2 list2){
        LinkedList2 list = new LinkedList2();
        sort(list1);
        sort(list2);

        Node pointer1 = list1.head;
        Node pointer2 = list2.head;

        while (pointer1 != null | pointer2 != null) {
            if (pointer1 == null) {
                Node next = pointer2.next;
                list.addInTail(pointer2);
                pointer2 = next;
                continue;
            }

            if (pointer2 == null) {
                Node next = pointer1.next;
                list.addInTail(pointer1);
                pointer1 = next;
                continue;
            }

            if (pointer1.value <  pointer2.value) {
                Node next = pointer1.next;
                list.addInTail(pointer1);
                pointer1 = next;
            } else {
                Node next = pointer2.next;
                list.addInTail(pointer2);
                pointer2 = next;
            }
        }

        return list;
    }
}

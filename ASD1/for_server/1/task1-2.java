public class SumTwoList {

    // 1-8 Sum, time-O(n), space-O(n)
    // В данном случае память занимает O(n), и в любом случае надо будет пройтись по всем узлам, поэтому временная сложность также O(n).

    static public LinkedList sumTwoList(LinkedList list1, LinkedList list2){
        LinkedList newList = new LinkedList();

        if (list1.count() == list2.count()) {
            Node node1 = list1.head;
            Node node2 = list2.head;
            while (node1 != null) {
                int value = node1.value + node2.value;
                Node node = new Node(value);
                newList.addInTail(node);
                node1 = node1.next;
                node2 = node2.next;
            }
        }

        return newList;
    }
}

import org.junit.jupiter.api.Order;

public class MergeOrderedList<T> {
    //7-9* merge
    public OrderedList<T> merge(OrderedList<T> list1, OrderedList<T> list2){
        OrderedList<T> orderedList = new OrderedList<>(list1.isAsc());
        Node<T> first = list1.head;
        Node<T> second = list2.head;
        boolean isReverse = false;
        if (list1.isAsc() != list2.isAsc()) {
            second = list2.tail;
            isReverse = true;
        }

        for (;first != null || second != null;) {
            if (first == null) {
                orderedList.add(second.value);
                if (isReverse) {
                    second = second.prev;
                } else {
                    second = second.next;
                }
                continue;
            }
            if (second == null) {
                orderedList.add(first.value);
                first = first.next;
                continue;
            }
            if (list1.isAsc() && orderedList.compare(second.value, first.value) > 0)  {
                orderedList.add(first.value);
                first = first.next;
                continue;
            } else if (list1.isAsc()) {
                orderedList.add(second.value);
                if (isReverse) {
                    second = second.prev;
                } else {
                    second = second.next;
                }
                continue;
            }
            if (!list1.isAsc() && orderedList.compare(second.value, first.value) > 0) {
                orderedList.add(second.value);
                if (isReverse) {
                    second = second.prev;
                } else {
                    second = second.next;
                }
            } else {
                orderedList.add(first.value);
                first = first.next;
            }
        }

        return orderedList;
    }

    //7-10* findSubList
    public boolean findSubList(OrderedList<T> sub, OrderedList<T> orderedList) {
        Node<T> substart = sub.head;
        Node<T> orderListPointer = orderedList.head;
        boolean isReverse = false;
        if (orderedList.isAsc() != sub.isAsc()) {
            isReverse = true;
            substart = sub.tail;
        }

        for ( ;orderListPointer != null;) {
            if (substart.value == orderListPointer.value) {
                substart  =  isReverse ? substart.prev : substart.next;
            } else {
                substart = orderedList.isAsc() != sub.isAsc() ? sub.tail : sub.head;
            }
            orderListPointer = orderListPointer.next;

            if (substart == null) {
                return true;
            }
        }

        return false;
    }


}

import org.junit.jupiter.api.Order;

import java.util.ArrayList;
import java.util.Optional;

public class MergeOrderedList<T> {
    //7-9* merge
    public OrderedList<T> merge(OrderedList<T> list1, OrderedList<T> list2){
        OrderedList<T> orderedList = new OrderedList<>(list1.isAsc());
        Optional<Node<T>> first = Optional.ofNullable(list1.head);
        Optional<Node<T>> second = Optional.ofNullable(list2.head);
        boolean isReverse = false;
        if (list1.isAsc() != list2.isAsc()) {
            second = Optional.ofNullable(list2.tail);
            isReverse = true;
        }

        return traverse(first, second, isReverse, list1.isAsc(), orderedList);
    }

    private OrderedList<T> traverse(Optional<Node<T>> first, Optional<Node<T>> second, boolean isReverse, boolean isAsc, OrderedList<T> orderedList){
        if (first.isEmpty() && second.isEmpty()) {
            return orderedList;
        }

        if (first.isEmpty()) {
            second.ifPresent(sec -> orderedList.add(sec.value));
            return traverse(first, Optional.ofNullable( isReverse ? second.get().prev : second.get().next), isReverse, isAsc, orderedList);
        }
        if (second.isEmpty()) {
            first.ifPresent(f -> orderedList.add(f.value));
            return traverse(Optional.ofNullable(first.get().next), second, isReverse, isAsc, orderedList);
        }

        boolean isFirstBigger = orderedList.compare(second.get().value, first.get().value) > 0;
        boolean addFirst = ((isAsc && isFirstBigger) || (!isAsc && !isFirstBigger));

        if (addFirst) {
            orderedList.add(first.get().value);
            return traverse(Optional.ofNullable(first.get().next), second, isReverse, isAsc, orderedList);
        }

        orderedList.add(second.get().value);
        return traverse(first, Optional.ofNullable(isReverse ? second.get().prev : second.get().next), isReverse, isAsc, orderedList);
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


//merge 337% Изначально
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


public OrderedList<T> merge(OrderedList<T> list1, OrderedList<T> list2){
    OrderedList<T> orderedList = new OrderedList<>(list1.isAsc());
    boolean isReverse = list1.isAsc() != list2.isAsc();
    Node<T> first = list1.head;
    Node<T> second = isReverse ? list2.tail : list2.head;

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

        boolean compareBln = orderedList.compare(second.value, first.value) > 0;

        if (compareBln){
            orderedList.add
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



import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//    BigMinusRightOrder 175% изначально
    public static String BigMinusRightOrder(String s1, String s2){
        String result = "";

        int len1 = s1.length();
        int len2 = s2.length();
        int[] arr1 = new int[len1];
        int[] arr2 = new int[len2];

        for (int u = 0; u < len1; u++){
            arr1[u] = getNum(s1, u);
        }

        for (int j = 0; j < len2; j++){
            arr2[j] = getNum(s2, j);
        }

        int debt = 0;
        for (int i = 0; i < len1; i++) {
            int secondElem = 0;
            if (len2 - 1 - i >= 0) secondElem = arr2[len2 - 1 - i];
            int diff = arr1[len1 - 1 - i] - secondElem - debt;
            if (diff >= 0) {
                arr1[len1 - 1 - i] = diff;
                debt = 0;
            } else {
                arr1[len1 - 1 - i] = diff + 10;
                debt = 1;
            }
        }

        boolean write = false;
        for (int k = 0; k < len1; k++){
            if (arr1[k] != 0) {
                write = true;
            }
            if (write) {
                result += arr1[k];
            }
        }

        if (result.length() == 0) {
            result = "0";
        }

        return result;
    }


//   BigMinusRightOrder 75% после рефакторинга
public static String BigMinusRightOrder(String s1, String s2){
    String result = "0";

    int len1 = s1.length();
    int len2 = s2.length();
    int[] arr1 = IntStream.range(0, len1)
            .map(i -> getNum(s1, i))
            .toArray();
    int[] arr2 = IntStream.range(0, len2)
            .map(i -> getNum(s2, i))
            .toArray();

    int debt = 0;
    for (int i = 0; i < len1; i++) {
        int secondElem = 0;
        if (len2 - 1 - i >= 0) secondElem = arr2[len2 - 1 - i];
        int diff = arr1[len1 - 1 - i] - secondElem - debt;
        if (diff >= 0) {
            arr1[len1 - 1 - i] = diff;
            debt = 0;
            continue;
        }
        arr1[len1 - 1 - i] = diff + 10;
        debt = 1;
    }

    result += Arrays.stream(arr1)
            .mapToObj(String::valueOf)
            .collect(Collectors.joining(""));

    if (result.length() == 0) {
        result = "0";
        return result;
    }

    return result.replaceFirst("^0+", "");
}


//__________________________________merge 337% Изначально

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

// _______________ merge(12%) и отдельный метод traverse(150%);

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




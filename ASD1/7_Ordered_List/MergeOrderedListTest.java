import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MergeOrderedListTest {
    @Test public void merge() {
        OrderedList<Integer> orderedList1 = new OrderedList<>(true);
        orderedList1.add(7);
        orderedList1.add(3);
        orderedList1.add(10);
        OrderedList<Integer> orderedList2 = new OrderedList<>(true);
        orderedList1.add(6);
        orderedList1.add(8);
        orderedList1.add(9);

        MergeOrderedList<Integer>  mergeClass= new MergeOrderedList<>();

        OrderedList<Integer> orderedList = mergeClass.merge(orderedList1, orderedList2);
        Integer[] expected = {3, 6, 7, 8, 9, 10};
        Integer[] result = Arrays.stream(orderedList.getAll().toArray())
                .map(node -> ((Node<Integer>) node).value)
                .toArray(Integer[]::new);

        assertArrayEquals(result, expected);
    }

    @Test public void sublistTrue() {
        OrderedList<Integer> orderedList1 = new OrderedList<>(true);
        orderedList1.add(7);
        orderedList1.add(3);
        orderedList1.add(10);
        orderedList1.add(9);
        OrderedList<Integer> sublist = new OrderedList<>(true);
        sublist.add(7);
        sublist.add(3);

        MergeOrderedList<Integer>  mergeClass= new MergeOrderedList<>();
        assertEquals(mergeClass.findSubList(sublist, orderedList1), true);
    }

    @Test public void sublistFalse() {
        OrderedList<Integer> orderedList1 = new OrderedList<>(true);
        orderedList1.add(7);
        orderedList1.add(3);
        orderedList1.add(10);
        orderedList1.add(9);
        OrderedList<Integer> sublist = new OrderedList<>(true);
        sublist.add(1);
        sublist.add(3);

        MergeOrderedList<Integer>  mergeClass= new MergeOrderedList<>();
        assertEquals(mergeClass.findSubList(sublist, orderedList1), false);
    }
}
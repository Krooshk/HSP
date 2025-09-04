
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

// 7-7 Tests
class OrderedListTest {
    @Test public void addAsc(){
        OrderedList<Integer> orderedList = new OrderedList<>(true);
        Integer[] sortedArray = new Integer[11];

        for (int i = 10; i >= 0; i--){
            orderedList.add(i);
            sortedArray[i] = i;
        }
        Arrays.sort(sortedArray);

        Integer[] result = Arrays.stream(orderedList.getAll().toArray())
                .map(node -> ((Node<Integer>) node).value)
                .toArray(Integer[]::new);

        assertArrayEquals(result, sortedArray);
    }

    @Test public void addNotAsc(){
        OrderedList<Integer> orderedList = new OrderedList<>(false);
        Integer[] sortedArray = new Integer[11];

        for (int i = 0; i <= 10; i++){
            orderedList.add(i);
            sortedArray[i] = i;
        }
        Arrays.sort(sortedArray, Collections.reverseOrder());

        Integer[] result = Arrays.stream(orderedList.getAll().toArray())
                .map(node -> ((Node<Integer>) node).value)
                .toArray(Integer[]::new);

        assertArrayEquals(result, sortedArray);
    }

    @Test public void addDuplicatesAsc() {
        OrderedList<Integer> orderedList = new OrderedList<>(true);
        orderedList.add(5);
        orderedList.add(5);
        orderedList.add(5);

        Integer[] expected = {5, 5, 5};
        Integer[] result = Arrays.stream(orderedList.getAll().toArray())
                .map(node -> ((Node<Integer>) node).value)
                .toArray(Integer[]::new);

        assertArrayEquals(result, expected);
    }

    @Test public void addSmallestToAsc() {
        OrderedList<Integer> orderedList = new OrderedList<>(true);
        orderedList.add(10);
        orderedList.add(5);
        orderedList.add(1);

        Integer[] expected = {1, 5, 10};
        Integer[] result = Arrays.stream(orderedList.getAll().toArray())
                .map(node -> ((Node<Integer>) node).value)
                .toArray(Integer[]::new);

        assertArrayEquals(result, expected);
    }

    @Test public void deleteFromAsc() {
        OrderedList<Integer> orderedList = new OrderedList<>(true);
        orderedList.add(1);
        orderedList.add(3);
        orderedList.add(5);
        orderedList.add(7);
        orderedList.delete(5);

        Integer[] expected = {1, 3, 7};
        Integer[] result = Arrays.stream(orderedList.getAll().toArray())
                .map(node -> ((Node<Integer>) node).value)
                .toArray(Integer[]::new);

        assertArrayEquals(expected, result);
        assertEquals(3, orderedList.count());
    }

    @Test public void deleteFromDescending() {
        OrderedList<Integer> orderedList = new OrderedList<>(false);
        orderedList.add(10);
        orderedList.add(8);
        orderedList.add(6);
        orderedList.delete(10);

        Integer[] expected = {8, 6};
        Integer[] result = Arrays.stream(orderedList.getAll().toArray())
                .map(node -> ((Node<Integer>) node).value)
                .toArray(Integer[]::new);

        assertArrayEquals(expected, result);
        assertEquals(2, orderedList.count());
    }

    @Test public void findInAsc() {
        OrderedList<Integer> orderedList = new OrderedList<>(true);
        orderedList.add(2);
        orderedList.add(4);
        orderedList.add(6);

        Node<Integer> found = orderedList.find(4);
        Node<Integer> notFound = orderedList.find(10);

        assertEquals(4, found.value);
        assertNotNull(found);
        assertNull(notFound);
    }

    @Test public void findInDesc() {
        OrderedList<Integer> orderedList = new OrderedList<>(false);
        orderedList.add(10);
        orderedList.add(7);
        orderedList.add(3);

        Node<Integer> found = orderedList.find(7);
        Node<Integer> notFound = orderedList.find(1);

        assertEquals(7, found.value);
        assertNotNull(found);
        assertNull(notFound);
    }

    @Test public void removeDuplicate() {
        OrderedList<Integer> orderedList = new OrderedList<>(true);
        orderedList.add(10);
        orderedList.add(7);
        orderedList.add(3);
        orderedList.add(10);
        orderedList.add(7);
        orderedList.add(3);

        orderedList.removeDuplicate();

        Integer[] expected = { 3, 7, 10 };
        Integer[] result = Arrays.stream(orderedList.getAll().toArray())
                .map(node -> ((Node<Integer>) node).value)
                .toArray(Integer[]::new);
        assertArrayEquals(expected, result);
    }

    @Test public void mostFrequently() {
        OrderedList<Integer> orderedList = new OrderedList<>(true);
        orderedList.add(7);
        orderedList.add(3);
        orderedList.add(10);
        orderedList.add(10);
        orderedList.add(10);
        orderedList.add(7);
        orderedList.add(3);

        assertEquals(orderedList.mostFrequently(), 10);
    }


}
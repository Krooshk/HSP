import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DictionaryWithOrderedListTest {
    @Test public void add(){
        DictionaryWithOrderedList<Integer> dict = new DictionaryWithOrderedList<>(10);

        dict.put("one", 1);
        dict.put("two", 2);
        dict.put("three", 3);
        dict.put("four", 4);

        assertEquals(dict.get("five"), null);
    }

    @Test public void size(){
        DictionaryWithOrderedList<Integer> dict = new DictionaryWithOrderedList<>(10);

        dict.put("one", 1);
        dict.put("two", 2);
        dict.put("three", 3);
        dict.put("four", 4);

        assertEquals(dict.getCount(), 4);
    }

    @Test public void sizeWithDelete(){
        DictionaryWithOrderedList<Integer> dict = new DictionaryWithOrderedList<>(10);

        dict.put("one", 1);
        dict.put("two", 2);
        dict.put("three", 3);
        dict.put("four", 4);

        dict.delete("four");
        dict.delete("four");
        dict.delete("two");

        assertEquals(dict.getCount(), 2);
    }

    @Test public void rightOrder(){
        DictionaryWithOrderedList<Integer> dict = new DictionaryWithOrderedList<>(10);
        dict.put("b", 1);
        dict.put("d", 2);
        dict.put("a", 3);
        dict.put("c", 4);

        String[] result = {"a", "b",  "c",  "d"};

        for (String k : dict.getKey()) {
            System.out.println(k);
        }

        assertArrayEquals(dict.getKey(), result);
    }
}
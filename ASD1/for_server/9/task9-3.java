import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// 9-4 Tests
class NativeDictionaryTest {
    @Test public void addNewValue(){
        NativeDictionary<Integer> nv = new NativeDictionary<>(10, Integer.class);

        nv.put("five", 5);

        assertEquals(nv.get("five"), 5);
    }

    @Test public void addExistValue(){
        NativeDictionary<Integer> nv = new NativeDictionary<>(10, Integer.class);

        nv.put("five", 5);
        nv.put("five", 55);

        assertEquals(nv.get("five"), 55);
    }

    @Test public void checkExistValue(){
        NativeDictionary<Integer> nv = new NativeDictionary<>(10, Integer.class);

        nv.put("six", 6);

        assertEquals(nv.isKey("six"), true);
    }

    @Test public void checkNoneExistValue(){
        NativeDictionary<Integer> nv = new NativeDictionary<>(10, Integer.class);

        nv.put("six", 6);

        assertEquals(nv.isKey("one"), false);
    }

    @Test public void getValueExist(){
        NativeDictionary<Integer> nv = new NativeDictionary<>(10, Integer.class);

        nv.put("six", 6);

        assertEquals(nv.get("six"), 6);
    }

    @Test public void getNoneExistValue(){
        NativeDictionary<Integer> nv = new NativeDictionary<>(10, Integer.class);

        nv.put("six", 6);

        assertEquals(nv.get("one"), null);
    }
}


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

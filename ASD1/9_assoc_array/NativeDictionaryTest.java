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

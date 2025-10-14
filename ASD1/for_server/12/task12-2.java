import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class NativeCacheTest {
    @Test public void addNewValue(){
        NativeCache<Integer> nc = new NativeCache<>(3, Integer.class);

        nc.put("one", 1);
        nc.put("two", 2);
        nc.put("two", 2);
        nc.put("two", 2);
        nc.put("three", 3);
        nc.put("three", 3);
        nc.put("three", 3);
        nc.put("four", 4);

        assertEquals(nc.isKey("one"), false);
    }
}
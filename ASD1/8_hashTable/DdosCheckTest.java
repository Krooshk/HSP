import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class DdosCheckTest {
    @Test public void checkCollisionWithoutSalt(){
        DdosCheck hashTable = new DdosCheck(19, 3, false);
        int[] result = new int[10];
        for (int i = 0; i < 10; i++) {
            StringBuilder builder = new StringBuilder();
            String str = "0" + builder.repeat('&', i);
            result[i] = hashTable.hashFun(str);
        }

        int[] expect = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};

        assertArrayEquals(result, expect);
    }

    @Test public void checkCollisionWithSalt(){
        DdosCheck hashTable = new DdosCheck(19, 3, true);
        HashSet set = new HashSet<>();
        int[] result = new int[10];
        for (int i = 0; i < 10; i++) {
            StringBuilder builder = new StringBuilder();
            String str = "0" + builder.repeat('&', i);
            result[i] = hashTable.hashFun(str);
            set.add(result[i]);
        }

        assertEquals(set.size() > 5, true);
    }
}
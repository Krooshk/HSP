import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {
    @Test public void hashFun(){
        HashTable hashTable = new HashTable(19, 3);

        assertEquals(hashTable.hashFun("0"), 10);
    }

    @Test public void seekSlotFull(){
        HashTable hashTable = new HashTable(19, 3);
        for (int i = 0; i < 19; i++){
            hashTable.put(String.valueOf(i));
        }

        assertEquals(hashTable.seekSlot("example"), -1);
    }

    @Test public void seekSlot(){
        HashTable hashTable = new HashTable(19, 3);

        assertEquals(hashTable.seekSlot("example") >= 0, true);
    }

    @Test public void putFailure(){
        HashTable hashTable = new HashTable(19, 3);
        for (int i = 0; i < 19; i++){
            hashTable.put(String.valueOf(i));
        }

        assertEquals(hashTable.put("example"), -1);
    }

    @Test public void put(){
        HashTable hashTable = new HashTable(19, 3);

        assertEquals(hashTable.put("example") >= 0, true);
    }

    @Test public void findFailure(){
        HashTable hashTable = new HashTable(19, 3);
        for (int i = 0; i < 19; i++){
            hashTable.put(String.valueOf(i));
        }

        assertEquals(hashTable.put("example"), -1);
    }

    @Test public void find(){
        HashTable hashTable = new HashTable(19, 3);
        for (int i = 0; i < 10; i++){
            hashTable.put(String.valueOf(i));
        }

        assertEquals(hashTable.put("10") >= 0, true);
    }
}


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
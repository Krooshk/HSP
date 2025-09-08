import org.junit.jupiter.api.Test;

import java.util.Arrays;

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
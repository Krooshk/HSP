import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BloomFilterTest {
    @Test public void testHasBit(){
        BloomFilter blum = new BloomFilter(32);
        blum.bitArray = 27; // 11011 - 27
        int pos = 2;

        assertEquals(blum.hasBit(pos), false);
    }

    @Test public void testSetBit(){
        BloomFilter blum = new BloomFilter(32);
        blum.bitArray = 27; // 11011 - 27

        blum.setBit(2);

        assertEquals(blum.bitArray, 31);
    }

    @Test public void test1(){
        BloomFilter blum = new BloomFilter(32);

        assertEquals(blum.isValue("0123456789"), false);
    }

    @Test public void test2(){
        BloomFilter blum = new BloomFilter(32);

        String curr = "0123456789";

        for (int i = 0; i < 10; i++) {
            blum.add(curr);
            curr = curr.substring(1) + curr.substring(0, 1);
        }

        assertEquals(blum.isValue("1234567890"), true);
    }

}

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MultiDimensionalArrayTest {
    @Test public void createArray1(){
        MultiDimensionalArray multi = new MultiDimensionalArray(Integer.class,2, 10);
        multi.set(5, 1, 4);
        assertEquals(multi.get(1, 4), 5);
    }

    @Test public void createArray2(){
        MultiDimensionalArray multi = new MultiDimensionalArray(Integer.class,3, 12);
        multi.set(10, 7, 100, 8);
        assertEquals(multi.get(7, 100, 8), 10);
    }

    @Test public void createArrayExtend(){
        MultiDimensionalArray multi = new MultiDimensionalArray(Integer.class,3, 12);
        multi.set(10, 7, 7, 100);
        assertEquals(multi.get( 7, 7, 100), 10);
    }

    @Test public void createArrayExtend2(){
        MultiDimensionalArray multi = new MultiDimensionalArray(Integer.class,3, 12);
        multi.set(10, 7, 7, 12);
        assertEquals(multi.get(7, 7, 12), 10);
    }

    @Test public void getOutBinds(){
        MultiDimensionalArray multi = new MultiDimensionalArray(Integer.class,3, 12);
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> multi.get(7, 7, 12));
    }

    @Test public void getOutBinds2(){
        MultiDimensionalArray multi = new MultiDimensionalArray(Integer.class,3, 12);
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> multi.get(7, 7, 7, 8, 3));
    }
}
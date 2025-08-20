import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// 3-6 Tests
public class DynArrayTest {
    @Test public void insert(){
        DynArray<Integer> dyn = new DynArray<>(Integer.class);

        dyn.insert(1, 0);

        assertEquals(dyn.array.length, 16);
        assertEquals(dyn.count, 1);
    }

    @Test public void insertWithReallocate(){
        DynArray<Integer> dyn = new DynArray<>(Integer.class);

        for (int i = 0; i < 16; i++) {
            dyn.append(1);
        }

        dyn.insert(5, 5);

        assertEquals(dyn.array.length, 32);
        assertEquals(dyn.count, 17);
    }

    @Test public void insertNotCorrectPlace(){
        DynArray<Integer> dyn = new DynArray<>(Integer.class);

        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> dyn.insert(1, 33));
    }

    @Test public void insertNotCorrectPlace2(){
        DynArray<Integer> dyn = new DynArray<>(Integer.class);

        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> dyn.insert(1, -3));
    }

    @Test public void remove(){
        DynArray<Integer> dyn = new DynArray<>(Integer.class);

        for (int i = 0; i < 16; i++) {
            dyn.append(1);
        }

        dyn.remove(5);

        assertEquals(dyn.array.length, 16);
        assertEquals(dyn.count, 15);
    }

    @Test public void removeWithRellocate(){
        DynArray<Integer> dyn = new DynArray<>(Integer.class);

        for (int i = 0; i < 8; i++) {
            dyn.append(1);
        }

        dyn.remove(5);

        assertEquals(dyn.array.length, 16);
        assertEquals(dyn.count, 7);
    }

    @Test public void removeWithRellocate2(){
        DynArray<Integer> dyn = new DynArray<>(Integer.class);

        for (int i = 0; i < 17; i++) {
            dyn.append(1);
        }

        dyn.remove(5);
        dyn.remove(5);

        assertEquals(dyn.array.length, 21);
        assertEquals(dyn.count, 15);
    }

    @Test public void removeNotAllowedPosition(){
        DynArray<Integer> dyn = new DynArray<>(Integer.class);
        for (int i = 0; i < 16; i++) {
            dyn.append(1);
        }

        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> dyn.remove(25));
    }

    @Test public void removeNotAllowedPosition2(){
        DynArray<Integer> dyn = new DynArray<>(Integer.class);
        for (int i = 0; i < 16; i++) {
            dyn.append(1);
        }

        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> dyn.remove(-3));
    }
}

class DynArrayBankTest {
    @Test public void removeWithRellocate2(){
        DynArrayBank<Integer> dyn = new DynArrayBank<>(Integer.class);

        for (int i = 0; i < 17; i++) {
            dyn.append(1);
        }

        dyn.remove(5);
        dyn.remove(5);

        assertEquals(dyn.bank > 0, true);
    }

    @Test public void insertWithReallocate(){
        DynArrayBank<Integer> dyn = new DynArrayBank<>(Integer.class);

        for (int i = 0; i < 16; i++) {
            dyn.append(1);
        }

        dyn.insert(5, 5);

        assertEquals(dyn.bank > 0, true);
    }
}

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


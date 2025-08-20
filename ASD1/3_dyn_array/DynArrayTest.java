import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
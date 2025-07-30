import org.junit.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class WhiteWalkersTest {

    @Test public void testEmpty() {
        assertEquals(WhiteWalkers.white_walkers(""), false);
    }

    @Test public void testRegres() {
        assertEquals(WhiteWalkers.white_walkers("axxb6===4xaf5===eee5"), true);
    }

    @Test public void testRegres2() {
        assertEquals(WhiteWalkers.white_walkers("5==ooooooo=5=5"), false);
    }

    @Test public void testRegres3() {
        assertEquals(WhiteWalkers.white_walkers("abc=7==hdjs=3gg1=======5"), true);
    }

    @Test public void testRegres4() {
        assertEquals(WhiteWalkers.white_walkers("aaS=8"), false);
    }

    @Test public void testRegres5() {
        assertEquals(WhiteWalkers.white_walkers("9===1===9===1===9"), true);
    }

}
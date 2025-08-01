import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MatrixTest {

    @Test
    public void testRegres() {
        assertEquals(Matrix.digital_rain("1111000"), "111000");
    }

    @Test
    public void testRegres2() {
        assertEquals(Matrix.digital_rain("11101000"), "11101000");
    }

    @Test
    public void testRegres3() {
        assertEquals(Matrix.digital_rain("011111110"), "10");
    }

    @Test
    public void testEmpty() {
        assertEquals(Matrix.digital_rain("11111111"), "");
    }

    @Test
    public void testEmpty2() {
        assertEquals(Matrix.digital_rain(""), "");
    }

}
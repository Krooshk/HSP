import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RecurTest {

    @Test public void testZeroDegree(){
        assertEquals(Recur.degree(5, 0), 1);
    }

    @Test public void testRegres(){
        assertEquals(Recur.degree(5, 3), 125);
    }

    @Test public void testRegres2(){
        assertEquals(Recur.degree(2, 10), 1024);
    }

    @Test public void testSumOfDigitRegres(){
        assertEquals(Recur.sumOfDigit(5), 5);
    }

    @Test public void testSumOfDigitRegres2(){
        assertEquals(Recur.sumOfDigit(125), 8);
    }

    @Test public void testSumOfDigitRegres3(){
        assertEquals(Recur.sumOfDigit(10000), 1);
    }

    @Test public void testSumOfDigitRegres4(){
        assertEquals(Recur.sumOfDigit(11111), 5);
    }
}
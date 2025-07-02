import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.Test;
import java.util.Random;

public class Task3Test {

    @RepeatedTest(10)
     public void testRandom() {
        Random rand = new Random();
        int size = rand.nextInt(20) + 1;
        int[] battalion = new int[]{ 1, 1 };

        assertTrue(Task3.ConquestCampaign(size, size, 1, battalion) == size * 2 - 1);

    }

    @Test public void testRegres() {
        int[] battalion = new int[]{ 2, 2, 3, 4 };
        assertEquals(Task3.ConquestCampaign(3, 4, 2, battalion), 3);
    }
}
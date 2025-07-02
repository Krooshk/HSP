import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.Test;
import java.util.Random;

public class Level2Test {

    @RepeatedTest(10)
     public void testRandom() {
        Random rand = new Random();
        int[] arr = new int[20];
        int time = 1;
        int mileage = 0;

        for (int i = 0; i < 19; i+=2){
            int velocity = rand.nextInt(101);
            mileage += velocity;
            arr[i] = velocity;
            arr[i + 1] = time;
            time++;
        }
        assertTrue(Level2.odometer(arr) == mileage);

    }

    @Test public void testZero() {
        int[] arr = new int[0];
        assertTrue(Level2.odometer(arr) == 0);
    }

    @Test public void testOdd() {
        int[] arr = new int[] { 10, 1, 20 };
        assertTrue(Level2.odometer(arr) == 10);
    }

    @Test public void testEven() {
        int[] arr = new int[] { 10, 1, 20, 2 };
        assertTrue(Level2.odometer(arr) == 30);
    }
}
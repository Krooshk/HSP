import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Task20Test {

    @Test public void testRegres(){
        Task20.BastShoe("1 Привет");
        Task20.BastShoe("1 , Мир!");
        Task20.BastShoe("1 ++");

        assertEquals(Task20.current, "Привет, Мир!++");

        Task20.BastShoe("2 2");
        assertEquals(Task20.current, "Привет, Мир!");

        Task20.BastShoe("4");
        assertEquals(Task20.current, "Привет, Мир!++");
        Task20.BastShoe("4");
        Task20.BastShoe("1 *");

        assertEquals(Task20.current, "Привет, Мир!*");

        Task20.BastShoe("4");

        Task20.BastShoe("4");
        assertEquals(Task20.current, "Привет, Мир!");

        Task20.BastShoe("4");
        assertEquals(Task20.current, "Привет, Мир!");

        assertEquals(Task20.BastShoe("3 6"), ",");
        Task20.BastShoe("2 100");

        assertEquals(Task20.current, "");


        Task20.BastShoe("1 Привет");
        assertEquals(Task20.current, "Привет");

        Task20.BastShoe("1 , Мир!");
        assertEquals(Task20.current, "Привет, Мир!");

        Task20.BastShoe("1 ++");
        assertEquals(Task20.current, "Привет, Мир!++");

        Task20.BastShoe("4");
        assertEquals(Task20.current, "Привет, Мир!");

        Task20.BastShoe("4");
        assertEquals(Task20.current, "Привет");

        Task20.BastShoe("5");
        assertEquals(Task20.current, "Привет, Мир!");

        Task20.BastShoe("4");
        assertEquals(Task20.current, "Привет");



        Task20.BastShoe("5");
        assertEquals(Task20.current, "Привет, Мир!");

        Task20.BastShoe("5");
        assertEquals(Task20.current, "Привет, Мир!++");

        Task20.BastShoe("5");
        assertEquals(Task20.current, "Привет, Мир!++");

        Task20.BastShoe("5");
        assertEquals(Task20.current, "Привет, Мир!++");

        Task20.BastShoe("4");
        assertEquals(Task20.current, "Привет, Мир!");

        Task20.BastShoe("4");
        assertEquals(Task20.current, "Привет");

        Task20.BastShoe("2 2");
        assertEquals(Task20.current, "Прив");

        Task20.BastShoe("4");
        assertEquals(Task20.current, "Привет");

        Task20.BastShoe("5");
        assertEquals(Task20.current, "Прив");

        Task20.BastShoe("5");
        assertEquals(Task20.current, "Прив");

        Task20.BastShoe("5");
        assertEquals(Task20.current, "Прив");


    }

}



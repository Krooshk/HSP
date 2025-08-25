import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class AdditionalStackTest {
    @Test public void stackWithMinOnlyPush(){
        AdditionalStack stack = new AdditionalStack();
        stack.push(4);
        stack.push(7);
        stack.push(3);
        stack.push(89);
        stack.push(77);

        assertEquals(stack.getMin(), Integer.valueOf(3));
    }

    @Test public void stackWithMinPushPop(){
        AdditionalStack stack = new AdditionalStack();
        stack.push(7);
        stack.push(6);
        stack.push(55);
        stack.push(54);
        stack.push(65);
        stack.push(6);
        stack.pop();
        stack.pop();

        assertEquals(stack.getMin(), Integer.valueOf(6));
    }

    @Test public void stackWithMinPushPop2(){
        AdditionalStack stack = new AdditionalStack();
        stack.push(7);
        stack.push(6);
        stack.push(55);
        stack.push(54);
        stack.push(65);
        stack.push(6);
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();

        assertEquals(stack.getMin(), Integer.valueOf(7));
    }

    @Test public void stackEmpty(){
        AdditionalStack stack = new AdditionalStack();

        assertEquals(stack.getMin(), null);
    }

    @Test public void stackAverage(){
        AdditionalStack stack = new AdditionalStack();
        for (int i = 1; i <= 10; i++) {
            stack.push(i);
        }
        for (int i = 11; i <= 20; i++) {
            stack.push(i);
        }

        assertEquals(stack.getAverage(), Integer.valueOf(10));
    }

    @Test public void stackAverage2(){
        AdditionalStack stack = new AdditionalStack();
        for (int i = 1; i <= 10; i++) {
            stack.push(i);
        }
        for (int i = 0; i < 5; i++) {
            stack.pop();
        }

        assertEquals(stack.getAverage(), Integer.valueOf(3));
    }
}
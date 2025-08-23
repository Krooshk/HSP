import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AdditionalStackWithMinTest {
    @Test public void stackWithMinOnlyPush(){
        AdditionalStackWithMin stack = new AdditionalStackWithMin<>();
        stack.push(4);
        stack.push(7);
        stack.push(3);
        stack.push(89);
        stack.push(77);

        assertEquals(stack.getMin(), 3);
    }

    @Test public void stackWithMinPushPop(){
        AdditionalStackWithMin stack = new AdditionalStackWithMin<>();
        stack.push(7);
        stack.push(6);
        stack.push(55);
        stack.push(54);
        stack.push(65);
        stack.push(6);
        stack.pop();
        stack.pop();

        assertEquals(stack.getMin(), 6);
    }

    @Test public void stackWithMinPushPop2(){
        AdditionalStackWithMin stack = new AdditionalStackWithMin<>();
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

        assertEquals(stack.getMin(), 7);
    }
}
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {
    @Test public void pushRegres(){
        Stack stack = new Stack<>();
        for (int i = 0; i < 4; i++){
            stack.push(i + 1);
        }

        assertEquals(stack.size(), 4);
        assertEquals(stack.peek(), 4);
        assertEquals(stack.size(), 4);
    }

    @Test public void popRegres(){
        Stack stack = new Stack<>();
        for (int i = 0; i < 4; i++){
            stack.push(i + 1);
        }
        for (int i = 0; i < 4; i++){
            stack.pop();
        }

        assertEquals(stack.size(), 0);
        assertEquals(stack.peek(), null);
        assertEquals(stack.pop(), null);
    }

    @Test public void peekRegres(){
        Stack stack = new Stack<>();
        for (int i = 0; i < 4; i++){
            stack.push(i + 1);
        }
        for (int i = 0; i < 2; i++){
            stack.pop();
        }

        assertEquals(stack.peek(), 2);
    }

    @Test public void sizeRegres(){
        Stack stack = new Stack<>();
        for (int i = 0; i < 4; i++){
            stack.push(i + 1);
        }
        assertEquals(stack.size(), 4);
    }

    @Test public void sizeRegres2(){
        Stack stack = new Stack<>();

        assertEquals(stack.size(), 0);
    }

    @Test public void pushDifferentType(){
        Stack stack = new Stack<>();
        stack.push(1);
        stack.push("2");
        stack.push(3.14);

        assertEquals(stack.size(), 3);
        assertEquals(stack.pop().getClass().getName(), "java.lang.Double");
        assertEquals(stack.pop().getClass().getName(), "java.lang.String");
        assertEquals(stack.pop().getClass().getName(), "java.lang.Integer");
    }
}

class AdditionalTest {
    @Test public void parenthesesValidatorRegres(){
        assertEquals(Additional.parenthesesValidator("(()((())()))"), true);
    }

    @Test public void parenthesesValidatorRegres2(){
        assertEquals(Additional.parenthesesValidator("(()()(()"), false);
    }

    @Test public void parenthesesValidatorRegres3(){
        assertEquals(Additional.parenthesesValidator("())("), false);
    }

    @Test public void parenthesesValidatorRegres4(){
        assertEquals(Additional.parenthesesValidator("))(("), false);
    }

    @Test public void parenthesesValidatorRegres5(){
        assertEquals(Additional.parenthesesValidator("((())"), false);
    }

    @Test public void parenthesesValidatorRegresV2(){
        assertEquals(Additional.parenthesesValidatorV2("((([[{{}}]])))"), true);
    }

    @Test public void parenthesesValidatorRegresV2_2(){
        assertEquals(Additional.parenthesesValidatorV2("[()(())()(())[{()}][()]{{{}}}]"), true);
    }

    @Test public void parenthesesValidatorRegresV2_3(){
        assertEquals(Additional.parenthesesValidatorV2("((({{{}}}))]"), false);
    }

    @Test public void parenthesesValidatorRegresV2_4(){
        assertEquals(Additional.parenthesesValidatorV2("{[(({}))]"), false);
    }
}

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

class PostfixTest {
    @Test public void postfixOperation(){
        assertEquals(Postfix.postfixCount("8 2 + 5 * 9 + = "), Integer.valueOf(59));
    }
}


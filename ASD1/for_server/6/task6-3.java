import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// 6-3 Tests
class DequeTest {
    @Test public void addFirstSizeRegress(){
        Deque deque = new Deque<>();

        for (int i = 0; i < 4; i++){
            deque.addFront(i + 1);
        }

        assertEquals(deque.size(), 4);
    }

    @Test public void addLastSizeRegress(){
        Deque deque = new Deque<>();

        for (int i = 0; i < 4; i++){
            deque.addTail(i + 1);
        }

        assertEquals(deque.size(), 4);
    }

    @Test public void removeFirstRegress(){
        Deque deque = new Deque<>();

        for (int i = 0; i < 4; i++){
            deque.addTail(i + 1);
        }

        assertEquals(deque.removeFront(), 1);
        assertEquals(deque.size(), 3);
        assertEquals(deque.removeTail(), 4);
        assertEquals(deque.size(), 2);
    }


    @Test public void removeLastRegress(){
        Deque deque = new Deque<>();

        for (int i = 0; i < 4; i++){
            deque.addFront(i + 1);
        }

        assertEquals(deque.removeTail(), 1);
        assertEquals(deque.size(), 3);
        assertEquals(deque.removeFront(), 4);
        assertEquals(deque.size(), 2);
    }
}

class AdditionalDequeTest {
    @Test public void palindromeTestOdd(){
        assertEquals(AdditionalDeque.isPalindrome("qwerewq"), true);
    }

    @Test public void palindromeTestEven(){
        assertEquals(AdditionalDeque.isPalindrome("asdffdsa"), true);
    }

    @Test public void notPalindromeTestOdd(){
        assertEquals(AdditionalDeque.isPalindrome("sun"), false);
    }

    @Test public void notPalindromeTestEven(){
        assertEquals(AdditionalDeque.isPalindrome("qwerty"), false);
    }
}

class DequeMinTest {
    @Test public void addFirstMinRegress(){
        DequeMin minDeque = new DequeMin<>();

        for (int i = 0; i < 5; i++){
            minDeque.addFront(i + 1);
        }

        assertEquals(minDeque.getMin(), 1);
    }

    @Test public void addTailMinRegress(){
        DequeMin minDeque = new DequeMin<>();

        for (int i = 0; i < 5; i++){
            minDeque.addTail(i + 1);
        }

        assertEquals(minDeque.getMin(), 1);
    }

    @Test public void addFirstMinRegress2(){
        DequeMin minDeque = new DequeMin<>();

        for (int i = 0; i < 5; i++){
            minDeque.addFront(i + 1);
        }
        minDeque.removeFront();

        assertEquals(minDeque.getMin(), 1);
    }

    @Test public void regresMinDeque1(){
        DequeMin minDeque = new DequeMin<>();

        minDeque.addTail(1);
        minDeque.addTail(3);
        minDeque.addTail(2);
        minDeque.addTail(4);


        assertEquals(minDeque.getMin(), 1);
    }

    @Test public void regresMinDeque2(){
        DequeMin minDeque = new DequeMin<>();

        minDeque.addFront(1);
        minDeque.addFront(3);
        minDeque.addFront(2);
        minDeque.addFront(4);


        assertEquals(minDeque.getMin(), 1);
    }

    @Test public void regresMinDeque3(){
        DequeMin minDeque = new DequeMin<>();

        minDeque.addTail(1);
        minDeque.addTail(3);
        minDeque.addTail(2);
        minDeque.addTail(4);

        minDeque.removeFront();

        assertEquals(minDeque.getMin(), 2);
    }

    @Test public void regresMinDeque4(){
        DequeMin minDeque = new DequeMin<>();

        minDeque.addFront(1);
        minDeque.addFront(3);
        minDeque.addFront(2);
        minDeque.addFront(4);

        minDeque.removeTail();

        assertEquals(minDeque.getMin(), 2);
    }
}
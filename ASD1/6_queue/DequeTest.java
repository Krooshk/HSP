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
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
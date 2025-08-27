import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BufferQueueTest {
    @Test public void bufferRegres(){
        BufferQueue queue = new BufferQueue(10);
        for (int i = 0; i < 20; i++){
            queue.enqueue(i + 1);
        }

        assertEquals(queue.amount(), 10);
        assertEquals(queue.isFull(), true);
        assertEquals(queue.dequeue(), 1);
    }

    @Test public void bufferEnqueRegres(){
        BufferQueue queue = new BufferQueue(10);
        for (int i = 0; i < 10; i++){
            queue.enqueue(i + 1);
        }
        queue.dequeue();

        queue.enqueue(11);

        assertEquals(queue.amount(), 10);
        assertEquals(queue.isFull(), true);
        assertEquals(queue.dequeue(), 2);
    }

    @Test public void bufferEnqueRegres2(){
        BufferQueue queue = new BufferQueue(10);
        for (int i = 0; i < 10; i++){
            queue.enqueue(i + 1);
        }
        queue.dequeue();
        queue.enqueue(11);
        for (int i = 0; i < 9; i++){
            queue.dequeue();
        }

        assertEquals(queue.amount(), 1);
        assertEquals(queue.isFull(), false);
        assertEquals(queue.dequeue(), 11);
    }

    @Test public void bufferEnqueRegres3(){
        BufferQueue queue = new BufferQueue(10);
        queue.enqueue(1);
        queue.dequeue();
        queue.enqueue(2);

        assertEquals(queue.amount(), 1);
        assertEquals(queue.isFull(), false);
        assertEquals(queue.dequeue(), 2);
        assertEquals(queue.amount(), 0);
    }

    @Test public void bufferDequeueRegres(){
        BufferQueue queue = new BufferQueue(10);
        for (int i = 0; i < 10; i++){
            queue.enqueue(i + 1);
        }
        for (int i = 0; i < 9; i++){
            queue.dequeue();
        }
        queue.enqueue(11);
        queue.dequeue();

        assertEquals(queue.start, 0);
        assertEquals(queue.isFull(), false);
        assertEquals(queue.amount(), 1);
    }
}
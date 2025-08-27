import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {
    @Test public void enqueueRegress(){
        Queue queue = new Queue<>();

        for (int i = 0; i < 4; i++){
            queue.enqueue(i + 1);
        }

        assertEquals(queue.size(), 4);
    }

    @Test public void qequeueRegress(){
        Queue queue = new Queue<>();
        for (int i = 0; i < 4; i++){
            queue.enqueue(i + 1);
        }

        queue.dequeue();
        queue.dequeue();

        assertEquals(queue.size(), 2);
    }
}


class AdditionalQueueTest {
    @Test public void roundRegres(){
        Queue<Integer> queue = new Queue<>();
        AdditionalQueue<Integer> additionalTool = new AdditionalQueue<>();
        for (int i = 0; i < 10; i++){
            queue.enqueue(i + 1);
        }

        additionalTool.round(queue, 5);

        assertEquals(queue.size(), 10);
        assertEquals(queue.dequeue(), 6);
    }

    @Test public void reverseRegres(){
        Queue<Integer> queue = new Queue<>();
        AdditionalQueue<Integer> additionalTool = new AdditionalQueue<>();
        for (int i = 0; i < 10; i++){
            queue.enqueue(i + 1);
        }

        additionalTool.reverse(queue);

        for (int i = 10; i > 0; i--){
            assertEquals(queue.dequeue(), i);
        }
    }

}


class QueueBasedOnTwoStackTest {
    @Test  public void enqueueRegress(){
        QueueBasedOnTwoStack queue = new QueueBasedOnTwoStack<>();

        for (int i = 0; i < 4; i++){
            queue.enqueue(i + 1);
        }

        assertEquals(queue.size(), 4);
        assertEquals(queue.dequeue(), 1);
    }

    @Test public void qequeueRegress(){
        QueueBasedOnTwoStack queue = new QueueBasedOnTwoStack<>();
        for (int i = 0; i < 4; i++){
            queue.enqueue(i + 1);
        }

        queue.dequeue();
        queue.dequeue();

        assertEquals(queue.size(), 2);
        assertEquals(queue.dequeue(), 3);
    }

    @Test public void queueRegress(){
        QueueBasedOnTwoStack queue = new QueueBasedOnTwoStack<>();
        for (int i = 0; i < 10; i++){
            queue.enqueue(i + 1);
        }
        for (int i = 0; i < 5; i++){
            queue.dequeue();
        }
        for (int i = 10; i < 20; i++){
            queue.enqueue(i + 1);
        }
        for (int i = 0; i < 4; i++){
            queue.dequeue();
        }

        assertEquals(queue.size(), 11);
        assertEquals(queue.dequeue(), 10);
    }
}


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
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
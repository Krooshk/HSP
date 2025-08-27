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
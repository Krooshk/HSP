import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
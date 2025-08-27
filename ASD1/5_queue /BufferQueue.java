// 5-6 BufferQueue
public class BufferQueue {
    int[] array;
    Integer start = null;
    Integer end = null;
    BufferQueue(int size){
        array = new int[size];
    }

    public void enqueue(int item)
    {
        if (isFull()) return;
        if (start == null) {
            array[0] = item;
            start = 0;
            end = 0;
            return;
        }
        if (end == array.length - 1 ) {
            array[0] = item;
            end = 0;
        } else {
            array[++end] = item;
        }
    }

    public Integer dequeue()
    {
        if (amount() == 0) {
            return null;
        }
        if (start == end) {
            int elem = array[start];
            end = null;
            start = null;
            return elem;
        }
        if (start == array.length -1) {
            int elem = array[start];
            start = 0;
            return elem;
        }

        return array[start++];
    }

    public boolean isFull(){

        return amount() == array.length;
    }

    public int amount()
    {
        if (start == null) return 0;
        return end >= start ? (end - start + 1) : (end + 1 + array.length - start);
    }
}

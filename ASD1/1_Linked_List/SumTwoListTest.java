import org.junit.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class SumTwoListTest {
    @Test public void testSum(){
        LinkedList list1 = new  LinkedList();
        LinkedList list2 = new  LinkedList();
        int[] result = new int[10];
        for (int i = 0; i < 10; i++) {
            Node node = new Node(i);
            list1.addInTail(node);
            result[i] = 10;
        }
        for (int i = 10; i > 0 ; i--) {
            Node node = new Node(i);
            list2.addInTail(node);
        }

        LinkedList list3 = SumTwoList.sumTwoList(list1, list2);
        ArrayList<Node> listArray = list3.findAll(10);

        int[] listArrayNum = listArray.stream()
                .mapToInt(n -> n.value)
                .toArray();

        assertEquals(list3.count(), 10);
        assertArrayEquals(listArrayNum, result);
    }

}
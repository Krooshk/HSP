import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class BalancedBSTTest {
    @Test public void test(){
        BalancedBST bst = new BalancedBST();
        int[] array = { 1, 3, 5, 7, 6, 4, 2 };
        bst.GenerateTree(array);

        Integer[] result = { 4, 2, 6, 1, 3, 5, 7 };
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(result));
        assertEquals(bst.WideAllNodes(), expected);
    }
}
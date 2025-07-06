import org.junit.jupiter.api.RepeatedTest;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class Task7Test {

    @Test public void testLongWord(){
        String str = "длинноеслово кот тост свет поезд свет"; // длинно - еслово - кот - тост - свет - поезд - свет
        String word = "свет";
        int[] arr = new int[]{ 0, 0, 0, 0, 1, 0, 1 };
        assertArrayEquals(Task7.WordSearch(6, str, word), arr);
    }

    @Test public void testEmpty() {
        String str = "";
        String word = "строк";
        int[] arr = new int[0];
        assertArrayEquals(Task7.WordSearch(12, str, word), arr);
    }

    @Test public void testRegres(){
        String str = " строка разбивается на набор строк через выравнивание по заданной ширине.";
        String word = "строк";
        int[] arr = new int[]{ 0, 0, 0, 1, 0, 0, 0 };
        assertArrayEquals(Task7.WordSearch(12, str, word), arr);
    }

    @Test public void testGetList(){
        String str = "выравнивание";
        ArrayList<String> list = new ArrayList<>();
        list.add("выравнивание");

        assertEquals(list, Task7.getList(str, 12));
    }

    @Test public void testGetListFull(){
        String str = " строка разбивается на набор строк через выравнивание по заданной ширине.";
        String[] arr = new String[]{ " строка ", "разбивается ", "на набор ", "строк через ", "выравнивание", " по заданной", " ширине." };
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++){
            list.add(arr[i]);
        }

        assertEquals(list, Task7.getList(str, 12));
    }

    @Test public void testFindInRow(){
        String[] arr = new String[]{ "длинно", "еслово", "кот", "тост", "свет", "поезд", "свет" };
        ArrayList<String> list = new ArrayList<>(Arrays.asList(arr));
        String word = "свет";
        int[] result = new int[]{ 0, 0, 0, 0, 1, 0, 1 };
        assertArrayEquals(Task7.findInRow( word, list), result);
    }
}
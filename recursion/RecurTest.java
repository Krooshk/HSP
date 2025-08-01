import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class RecurTest {

    @Test public void testZeroDegree(){
        assertEquals(Recur.degree(5, 0), 1);
    }

    @Test public void testRegres(){
        assertEquals(Recur.degree(5, 3), 125);
    }

    @Test public void testRegres2(){
        assertEquals(Recur.degree(2, 10), 1024);
    }

    @Test public void testSumOfDigitRegres(){
        assertEquals(Recur.sumOfDigit(5), 5);
    }

    @Test public void testSumOfDigitRegres2(){
        assertEquals(Recur.sumOfDigit(125), 8);
    }

    @Test public void testSumOfDigitRegres3(){
        assertEquals(Recur.sumOfDigit(10000), 1);
    }

    @Test public void testSumOfDigitRegres4(){
        assertEquals(Recur.sumOfDigit(11111), 5);
    }

    @RepeatedTest(10) public void testGetLengthOfList(){
        LinkedList<String> list = new LinkedList<>();
        Random rand = new Random();
        int N = rand.nextInt(20) + 1;

        for (int i = 0; i < N; i++){
            list.add("q");
        }
        assertEquals(Recur.getLengthOfList(list), N);
    }

    @Test public void testPalindromeRegresOdd(){
        assertEquals(Recur.isPalindrome("madam"), true);
    }

    @Test public void testPalindromeRegresEven(){
        assertEquals(Recur.isPalindrome("abccba"), true);
    }

    @Test public void testPalindromeRegresOddFalse(){
        assertEquals(Recur.isPalindrome("qwert"), false);
    }

    @Test public void testPalindromeRegresEvenFalse(){
        assertEquals(Recur.isPalindrome("balzam"), false);
    }

    @Test public void testPalindromeEmpty(){
        assertEquals(Recur.isPalindrome(""), true);
    }

    @Test public void testOnlyEvenVelue(){
        LinkedList<Integer> list = new LinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        Recur.printOnlyEvenValue(list);
    }

    @Test public void testOnlyEvenIndex(){
        LinkedList<Integer> list = new LinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        Recur.printOnlyEvenIndex(list);
    }

    @Test public void testMaxRegres(){
        int[] arr = new int[] { 2, 5, 4, 3, 5 };
        assertEquals(Recur.secondMax(arr), 5);
    }

    @Test public void testMaxRegres2(){
        int[] arr = new int[] { 2, 3, 5, 4 };
        assertEquals(Recur.secondMax(arr), 4);
    }

    @Test public void testFilesRegres(){
        System.out.println(Recur.getFiles("/home/kirill/Desktop/bbr/HSP/jv1"));
    }

    @Test public void testParen(){
        System.out.println(Recur.generateParens(3));
    }

}
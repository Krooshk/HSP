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

}
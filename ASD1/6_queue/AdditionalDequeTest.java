import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdditionalDequeTest {
    @Test public void palindromeTestOdd(){
        assertEquals(AdditionalDeque.isPalindrome("qwerewq"), true);
    }

    @Test public void palindromeTestEven(){
        assertEquals(AdditionalDeque.isPalindrome("asdffdsa"), true);
    }

    @Test public void notPalindromeTestOdd(){
        assertEquals(AdditionalDeque.isPalindrome("sun"), false);
    }

    @Test public void notPalindromeTestEven(){
        assertEquals(AdditionalDeque.isPalindrome("qwerty"), false);
    }
}
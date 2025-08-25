import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

class AdditionalTest {
    @Test public void parenthesesValidatorRegres(){
        assertEquals(Additional.parenthesesValidator("(()((())()))"), true);
    }

    @Test public void parenthesesValidatorRegres2(){
        assertEquals(Additional.parenthesesValidator("(()()(()"), false);
    }

    @Test public void parenthesesValidatorRegres3(){
        assertEquals(Additional.parenthesesValidator("())("), false);
    }

    @Test public void parenthesesValidatorRegres4(){
        assertEquals(Additional.parenthesesValidator("))(("), false);
    }

    @Test public void parenthesesValidatorRegres5(){
        assertEquals(Additional.parenthesesValidator("((())"), false);
    }

    @Test public void parenthesesValidatorRegresV2(){
        assertEquals(Additional.parenthesesValidatorV2("((([[{{}}]])))"), true);
    }

    @Test public void parenthesesValidatorRegresV2_2(){
        assertEquals(Additional.parenthesesValidatorV2("[()(())()(())[{()}][()]{{{}}}]"), true);
    }

    @Test public void parenthesesValidatorRegresV2_3(){
        assertEquals(Additional.parenthesesValidatorV2("((({{{}}}))]"), false);
    }

    @Test public void parenthesesValidatorRegresV2_4(){
        assertEquals(Additional.parenthesesValidatorV2("{[(({}))]"), false);
    }
}
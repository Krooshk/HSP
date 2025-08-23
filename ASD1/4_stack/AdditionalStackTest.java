import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdditionalStackTest {
    @Test public void parenthesesValidatorRegres(){
        assertEquals(AdditionalStack.parenthesesValidator("(()((())()))"), true);
    }

    @Test public void parenthesesValidatorRegres2(){
        assertEquals(AdditionalStack.parenthesesValidator("(()()(()"), false);
    }

    @Test public void parenthesesValidatorRegres3(){
        assertEquals(AdditionalStack.parenthesesValidator("())("), false);
    }

    @Test public void parenthesesValidatorRegres4(){
        assertEquals(AdditionalStack.parenthesesValidator("))(("), false);
    }

    @Test public void parenthesesValidatorRegres5(){
        assertEquals(AdditionalStack.parenthesesValidator("((())"), false);
    }

    @Test public void parenthesesValidatorRegresV2(){
        assertEquals(AdditionalStack.parenthesesValidatorV2("((([[{{}}]])))"), true);
    }

    @Test public void parenthesesValidatorRegresV2_2(){
        assertEquals(AdditionalStack.parenthesesValidatorV2("[()(())()(())[{()}][()]{{{}}}]"), true);
    }

    @Test public void parenthesesValidatorRegresV2_3(){
        assertEquals(AdditionalStack.parenthesesValidatorV2("((({{{}}}))]"), false);
    }

    @Test public void parenthesesValidatorRegresV2_4(){
        assertEquals(AdditionalStack.parenthesesValidatorV2("{[(({}))]"), false);
    }
}
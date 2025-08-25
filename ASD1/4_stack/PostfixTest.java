import org.junit.jupiter.api.Test;

import java.util.regex.PatternSyntaxException;

import static org.junit.Assert.assertEquals;

class PostfixTest {
    @Test public void postfixOperation(){
        assertEquals(Postfix.postfixCount("8 2 + 5 * 9 + = "), Integer.valueOf(59));
    }
}
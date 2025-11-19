import java.util.*;

public class WhiteWalkers
{
    final static Character[] DIGITS = new Character[]{ '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
    public static boolean white_walkers(String village){
        List<Character> digitsList = Arrays.asList(DIGITS);
        Integer left = null;
        int currentWalker = 0;
        int amountWalker = 0;

        for (int i = 0; i < village.length(); i++){
            Character ch = village.charAt(i);
            boolean isNumber = digitsList.contains(ch);
            boolean isWalker = village.charAt(i) == '=';
            int numericValue = Character.getNumericValue(ch);

            if (isNumber && left == null) {
                left = numericValue;
                currentWalker = 0;
                continue;
            }

            if (isWalker) {
                currentWalker++;
            }

            if (isNumber && (left + numericValue != 10)) {
                currentWalker = 0;
                left = numericValue;
                continue;
            }

            if (isNumber && (left + numericValue == 10) && currentWalker < 3) {
                return false;
            }

            if (isNumber && (left + numericValue == 10) && currentWalker >= 3) {
                currentWalker = 0;
                amountWalker++;
                left = numericValue;
            }
        }

        return amountWalker > 0;
    }
}
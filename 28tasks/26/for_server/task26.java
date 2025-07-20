//import java.util.*;
//
//public class Level1
//{
//    public static boolean white_walkers(String village){
//        Character[] digits = new Character[]{ '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
//        List<Character> digitsList = Arrays.asList(digits);
//        Integer left = null;
//        int currentWalker = 0;
//        int amountWalker = 0;
//
//        for (int i = 0; i < village.length(); i++){
//            Character ch = village.charAt(i);
//            boolean isNumber = digitsList.contains(ch);
//            boolean isWalker = village.charAt(i) == '=';
//            boolean firstMeetNumber = isNumber && left == null;
//            int numericValue = Character.getNumericValue(ch);
//
//            if (firstMeetNumber) {
//                left = Character.getNumericValue(ch);
//                currentWalker = 0;
//                continue;
//            }
//
//            if (isWalker) {
//                currentWalker++;
//            }
//
//            if (isNumber && (left + numericValue != 10)) {
//                currentWalker = 0;
//                left = numericValue;
//                continue;
//            }
//
//            if (isNumber && (left + numericValue == 10) && currentWalker < 3) {
//                return false;
//            }
//
//            if (isNumber && (left + numericValue == 10) && currentWalker >= 3) {
//                currentWalker = 0;
//                amountWalker++;
//                left = numericValue;
//            }
//        }
//
//        return amountWalker > 0;
//    }
//}
//
//

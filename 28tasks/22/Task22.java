import java.util.*;

public class Task22
{
    static public boolean SherlockValidString(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> amount = new HashMap<>();
        int sign = 0;

        for (int i = 0; i < s.length(); i++){
            Character ch = s.charAt(i);
            Integer value = map.get(ch);
            if (value != null) {
                map.put(ch, value + 1);
            } else {
                map.put(ch, 1);
            }
        }

        for (Integer value : map.values()) {
            Integer quantity = amount.get(value);
            if (quantity != null) {
                amount.put(value, quantity + 1);
            } else {
                amount.put(value, 1);
            }
        }

        if (amount.size() <= 1) {
            return true;
        }

        if (amount.size() > 2) {
            return false;
        }

        int moreTwo = 0;

        int result = 0;
        for (Integer key : amount.keySet()) {
            if (amount.get(key) >= 2) {
                moreTwo++;
            }

            if (moreTwo > 1) {
                return false;
            }

            int multiply = 1;
            if (sign % 2 == 0) {
                multiply *= -1;
            }
            sign++;
            result += key * multiply;
        }

        return Math.abs(result) == 1;
    }

}




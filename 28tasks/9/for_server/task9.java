import java.util.*;

public class Level1
{
    public static String TheRabbitsFoot(String s, boolean encode) {
        if (!encode) return decode(s);

        String[] arrStr = s.split(" ");
        String withoutSpaceStr = String.join("", arrStr);
        int len = withoutSpaceStr.length();

        double sqrt = Math.sqrt(len);
        int raw = (int) Math.floor(sqrt);
        int column = (int) Math.ceil(sqrt);

        int area = raw * column;

        if (area < len) {
            int additionalRows = (int) Math.ceil(1.0 * (len - area) / column);
            raw += additionalRows;
        }

        String[] elems = new String[column];

        for (int i = 0; i < column; i++) {
            for (int j = 0; j < raw; j++) {
                int position = i + j * raw;
                String letter = "";
                if (position < len) {
                    letter = String.valueOf(withoutSpaceStr.charAt(position));
                }

                if (j == 0) {
                    elems[i] = letter;
                } else {
                    elems[i] += letter;
                }
            }
        }

        return String.join(" ", elems);
    }

    public static String decode(String s) {
        String[] arrStr = s.split(" ");
        String res = "";

        for (int i = 0; i < arrStr[0].length(); i++) {
            for (int j = 0; j < arrStr.length; j++){
                if (arrStr[j].length() >= i + 1) {
                    res+= arrStr[j].charAt(i);
                }
            }
        }

        return res;
    }
}




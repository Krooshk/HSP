import java.util.HashMap;

public class Level1
{
    public static int PrintingCosts(String Line) {
        int res = 0;
        String tonerValue = "!  9\n" +
                "\"  6\n" +
                "#  24\n" +
                "$  29\n" +
                "%  22\n" +
                "&  24\n" +
                "'  3\n" +
                "(  12\n" +
                ")  12\n" +
                "*  17\n" +
                "+  13\n" +
                ",  7\n" +
                "-  7\n" +
                ".  4\n" +
                "/  10\n" +
                "0  22\n" +
                "1  19\n" +
                "2  22\n" +
                "3  23\n" +
                "4  21\n" +
                "5  27\n" +
                "6  26\n" +
                "7  16\n" +
                "8  23\n" +
                "9  26\n" +
                ":  8\n" +
                ";  11\n" +
                "<  10\n" +
                "=  14\n" +
                ">  10\n" +
                "?  15\n" +
                "@  32\n" +
                "A  24\n" +
                "B  29\n" +
                "C  20\n" +
                "D  26\n" +
                "E  26\n" +
                "F  20\n" +
                "G  25\n" +
                "H  25\n" +
                "I  18\n" +
                "J  18\n" +
                "K  21\n" +
                "L  16\n" +
                "M  28\n" +
                "N  25\n" +
                "O  26\n" +
                "P  23\n" +
                "Q  31\n" +
                "R  28\n" +
                "S  25\n" +
                "T  16\n" +
                "U  23\n" +
                "V  19\n" +
                "W  26\n" +
                "X  18\n" +
                "Y  14\n" +
                "Z  22\n" +
                "[  18\n" +
                "\\  10\n" +
                "]  18\n" +
                "^  7\n" +
                "_  8\n" +
                "`  3\n" +
                "a  23\n" +
                "b  25\n" +
                "c  17\n" +
                "d  25\n" +
                "e  23\n" +
                "f  18\n" +
                "g  30\n" +
                "h  21\n" +
                "i  15\n" +
                "j  20\n" +
                "k  21\n" +
                "l  16\n" +
                "m  22\n" +
                "n  18\n" +
                "o  20\n" +
                "p  25\n" +
                "q  25\n" +
                "r  13\n" +
                "s  21\n" +
                "t  17\n" +
                "u  17\n" +
                "v  13\n" +
                "w  19\n" +
                "x  13\n" +
                "y  24\n" +
                "z  19\n" +
                "{  18\n" +
                "|  12\n" +
                "}  18\n" +
                "~  9";

        String[] arr = tonerValue.split("\n");
        HashMap<String, Integer> map = new HashMap<>();
        int DEFAULT_VALUE = 23;

        for (int i = 0; i < arr.length; i++){
            String[] charValueArr = arr[i].split("  ");
            map.put(charValueArr[0], Integer.parseInt(charValueArr[1]));
        }

        for (int i = 0; i < Line.length(); i++){
            String symbol = String.valueOf(Line.charAt(i));
            if (symbol.equals(" ")) {
                continue;
            }
            Integer elem = map.get(symbol);

            if (elem != null) {
                res += elem;
            } else {
                res += DEFAULT_VALUE;
            }
        }

        return res;
    }
}



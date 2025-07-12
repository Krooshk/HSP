import java.util.*;

public class Level1
{
    public static boolean LineAnalysis(String line) {
        int len = line.length();
        int mid = len / 2;

        if (len == 0) return false;

        for (int i = 0; i <= mid; i++ ) {
            Character left = line.charAt(i);
            Character right = line.charAt(len - 1 - i);
            if (left != right) {
                return false;
            }
        }
        return true;
    }
}



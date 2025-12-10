import java.util.*;

public class Task17
{
    public static boolean LineAnalysis(String line) {
        int len = line.length();
        int mid = len / 2;

        if (len == 0) return false;

        // Достаточно сравнивать до середины, чтобы определить палиндром
        for (int i = 0; i <= len / 2; i++ ) {
            Character left = line.charAt(i);
            Character right = line.charAt(len - 1 - i);
            if (left != right) {
                return false;
            }
        }
        return true;
    }
}


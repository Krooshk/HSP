import java.util.*;

public class Level1
{
    public static boolean TankRush(int H1, int W1, String S1, int H2, int W2, String S2) {
        if (H1 == 0 || W1 == 0) {
            return false;
        }

        if (H2 == 0 || W2 == 0) {
            return false;
        }

        String[] arr1 = S1.split(" ");
        String[] arr2 = S2.split(" ");

        for (int i = 0; i <= H1 - H2; i++){
            for(int j = 0; j <= W1 - W2; j++){
                boolean hasOverlap = checkPos(i, j, arr1, arr2);
                if (hasOverlap) {
                    return true;
                }
            }
        }

        return false;

    }

    public static boolean checkPos(int startH, int startW, String[] arr1, String[] arr2 ){
        for (int i = 0; i < arr2.length; i++){
            for(int j = 0; j < arr2[0].length(); j++){
                if (arr2[i].charAt(j) != arr1[startH + i].charAt(startW + j)) {
                    return false;
                }
            }
        }
        return true;
    }
}



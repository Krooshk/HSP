import java.util.*;

public class Task14
{
    public static int Unmanned(int L, int N, int [][] track){
        int absolute = 0;
        int prev = 0;
        for (int i = 0; i < N; i++) {
            int point = track[i][0];
            int red = track[i][1];
            int green = track[i][2];

            absolute += point - prev;
            prev = point;

            if (point >= L) {
                continue;
            }

            absolute += countUnitTime(absolute, red, green);

        }

        absolute += L - prev;

        return absolute;

    }

    public static int countUnitTime(int absolutTime, int red, int green){
        int mod = absolutTime % (red + green);
        if (mod > red) {
            return 0;
        }

        return red - mod;
    }

}


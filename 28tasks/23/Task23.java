import java.util.*;

public class Task23
{
    public static String [] TreeOfLife(int H, int W, int N, String [] tree) {
        int[][] arr = new int[H][W];
        String[] result = new String[H];

        boolean isGrowth = true;

        for (int i = 0; i < H; i++){
            for ( int j = 0; j < W; j++){
                if (tree[i].charAt(j) == '+'){
                    arr[i][j] = 1;
                }
                if (tree[i].charAt(j) == '.'){
                    arr[i][j] = 0;
                }
            }
        }

        for (int k = 0; k < N; k++) {
            if (isGrowth) {
                grow(H, W, arr, true);
            } else {
                grow(H, W, arr, false);
                destroy(H, W, arr);
            }

            isGrowth = !isGrowth;
        }

        for (int i = 0; i < H; i++){
            String str = "";
            for (int j = 0; j < W; j++){
                if (arr[i][j] == 0) {
                    str += ".";
                } else {
                    str += "+";
                }

            }
            result[i] = str;
        }

        return result;

    }

    public static void grow(int H, int W, int[][] arr, boolean addNew ){
        for (int i = 0; i < H; i++){
            for (int j = 0; j < W; j++){
                int value = arr[i][j];
                if (addNew || value != 0 ){
                    arr[i][j] = value + 1;
                }
            }
        }
    }

    public static void destroy(int H, int W, int[][] arr) {
        ArrayList<int []> positions = new ArrayList<>();

        for (int i = 0; i < H; i++){
            for (int j = 0; j < W; j++){
                if (arr[i][j] >= 3) {
                    positions.add(new int[]{i, j});
                    arr[i][j] = 0;
                }
            }
        }

        for (int k = 0; k < positions.size(); k++){
            int[] pos = positions.get(k);
            int i = pos[0];
            int j = pos[1];

            if (i + 1 < H) {
                arr[i + 1][j] = 0;
            }

            if (i - 1 >= 0) {
                arr[i - 1][j] = 0;
            }

            if (j + 1 < W) {
                arr[i][j + 1] = 0;
            }

            if (j - 1 >= 0) {
                arr[i][j - 1] = 0;
            }
        }
    }

}




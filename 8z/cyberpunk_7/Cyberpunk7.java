import java.util.*;

public class Cyberpunk7 {
    public static int[] matrix(int n, int m, int [][] matrix) {
        int min = getMin(m, n);
        int quantityRings = min / 2;
        int[] result = new int[n * m];
        int count = 0;

        for (int i = 0; i < quantityRings; i++){
            for (int j = i; j < n - i - 1; j++){
                result[count++] = matrix[i][j];
            }
            for (int k = i; k < n - i - 1; k++){
                result[count++] = matrix[k][n - 1 - i];
            }
            for (int l = n - 1 - i; l > i; l--){
                result[count++] = matrix[m - 1 - i][l];
            }
            for (int o = m - 1 - i; o > i; o--){
                result[count++] = matrix[o][i];
            }
        }

        return result;
    }

    public static int getMin(int M, int N) {
        if (M > N) return N;
        return M;
    }
}
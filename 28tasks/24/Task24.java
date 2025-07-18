import java.util.*;

public class Task24
{
    public static void MatrixTurn(String Matrix[], int M, int N, int T) {
        int min = getMin(M, N);
        int quantityRings = min / 2;
        String[] rings = new String[quantityRings];

        for (int i = 0; i < quantityRings; i++){
            String str = "";
            for (int j = i; j < N - i - 1; j++){
                str += Matrix[i].charAt(j);
            }

            for (int k = i; k < M - i - 1; k++){
                str += Matrix[k].charAt(N - 1 - i);
            }

            for (int l = N - 1 - i; l > i; l--){
                str += Matrix[M - 1 - i].charAt(l);
            }

            for (int m = M - 1 - i; m > i; m--){
                str += Matrix[m].charAt(i);
            }
            rings[i] = str;
        }

        for (int i = 0; i < quantityRings; i++){
            rings[i] = offsetRing(rings[i], T);
        }

        for (int i = 0; i < quantityRings; i++){
            String str = rings[i];

            int index = 0;
            for (int j = i; j < N - i - 1; j++){
                Matrix[i] = Matrix[i].substring(0, j) + str.charAt(index) + Matrix[i].substring(j + 1);
                index++;
            }

            for (int k = i; k < M - i - 1; k++){
                Matrix[k] = Matrix[k].substring(0, N - 1 - i) + str.charAt(index) + Matrix[k].substring(N - i);
                index++;
            }

            for (int l = N - 1 - i; l > i; l--){
                Matrix[M - 1 - i] = Matrix[M - 1 - i].substring(0, l) + str.charAt(index) + Matrix[M - 1 - i].substring(l + 1);
                index++;
            }

            for (int m = M - 1 - i; m > i; m--){
                Matrix[m] = Matrix[m].substring(0, i) + str.charAt(index) + Matrix[m].substring(i + 1);
                index++;
            }
        }
    }

    public static int getMin(int M, int N) {
        if (M > N) return N;
        return M;
    }

    public static String offsetRing(String ring, int amountTurn) {
        if (amountTurn == 0) return ring;
        int minTurnCount = amountTurn;
        if (amountTurn >= ring.length()) {
            minTurnCount = amountTurn % ring.length();
        }

        int pivot = ring.length() - minTurnCount;

        String newStr = ring.substring(pivot) + ring.substring(0, pivot);

        return newStr;
    }
}




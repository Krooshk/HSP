import java.util.*;

public class Level1
{
    public static int SumOfThe(int N, int [] data){
        int sum = 0;

        for (int i = 0; i < N; i++) {
            sum = 0;
            for (int j = 0; j < N; j++){
                if (j != i) {
                    sum += data[j];
                }
            }

            if (data[i] == sum) {
                return data[i];
            }
        }

        return sum;
    }
}




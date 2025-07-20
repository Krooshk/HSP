import java.util.*;

public class Task27
{
    static public boolean Football(int F[], int N){
        int[] sorted = Arrays.copyOf(F, N);
        Arrays.sort(sorted);
        int[] copy = Arrays.copyOf(F, N);
        ArrayList<Integer> notEqualIndex = new ArrayList<>();

        for (int i = 0; i < N; i++){
            if (F[i] != sorted[i]){
                notEqualIndex.add(i);
            }
        }

        int sizeNotEqual = notEqualIndex.size();

        if (sizeNotEqual == 2) {
            int a = notEqualIndex.get(0);
            int b = notEqualIndex.get(1);
            int temp = copy[a];
            copy[a] = copy[b];
            copy[b] = temp;

            return Arrays.equals(sorted, copy);
        }

        for (int i = 0; i < sizeNotEqual; i++){
            if (i != 0 && notEqualIndex.get(i) - 1 != notEqualIndex.get(i)){
                return false;
            }
        }

        int start = notEqualIndex.get(0);
        int finish = notEqualIndex.get(sizeNotEqual - 1);

        int[] part = Arrays.copyOfRange(copy, start, finish + 1);
        Arrays.sort(part);
        int count = 0;

        for (int i = start; i <= finish; i++) {
            copy[i] = part[count];
            count++;
        }

        return Arrays.equals(sorted, copy);
    }

}




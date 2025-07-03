import java.util.*;

public class Task5
{
    public static int [] SynchronizingTables(int N, int [] ids, int [] salary){
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] copyIds = Arrays.copyOf(ids, N);
        int[] copySalary = Arrays.copyOf(salary, N);

        Arrays.sort(copyIds);
        Arrays.sort(copySalary);

        for (int i = 0; i < N; i++) {
            map.put(copyIds[i], copySalary[i]);
        }

        for (int i = 0; i < N; i++) {
            int id = ids[i];
            salary[i] = map.get(id);
        }

        return salary;
    }
}



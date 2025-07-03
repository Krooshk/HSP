//import java.util.*;
//
//public class Level1
//{
//    public static int ConquestCampaign(int N, int M, int L, int [] battalion)
//    {
//        HashMap<String, Boolean> map = new HashMap<>();
//        int size = N * M;
//        int days = 1;
//        int sizeQueue;
//        Queue<int []> queue = new LinkedList<>();
//
//        for (int i = 0; i < L; i++) {
//            handlePoint(battalion[2 * i], battalion[2 * i + 1], map, queue, N, M);
//        }
//
//        while (map.size() != size) {
//            sizeQueue = queue.size();
//            days++;
//
//            for (int i = 0; i < sizeQueue; i++){
//                int[] point = queue.poll();
//
//                int x = point[0];
//                int y = point[1];
//                handlePoint( x + 1, y, map, queue, N, M);
//                handlePoint(x - 1, y, map, queue, N, M);
//                handlePoint(x, y + 1, map, queue, N, M);
//                handlePoint(x, y - 1, map, queue, N, M);
//            }
//        }
//
//        return days;
//    }
//
//    public static void handlePoint(int x,  int y, HashMap map, Queue queue, int N, int M) {
//
//        if ((x <= 0) || (x > N )|| (y <= 0) || (y > M)) {
//            return;
//        }
//        int[] coordArray = new int[] { x, y };
//        String coord = x+ "|" + y;
//        if (map.get(coord) == null) {
//            queue.add(coordArray);
//            map.put(coord, true);
//        }
//    }
//
//}
//
//

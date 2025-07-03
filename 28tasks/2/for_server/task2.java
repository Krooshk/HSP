//import java.util.*;
//
//public class Level1
//{
//    public static int odometer(int [] oksana)
//    {
//        int res = 0;
//        int timeSpent = 0;
//        int finish;
//        if (oksana.length % 2 == 0) {
//            finish = oksana.length - 1;
//        } else {
//            finish = oksana.length - 2;
//        }
//
//        for (int i = 0; i < finish; i+= 2) {
//            int diff = oksana[i + 1] - timeSpent;
//            res += oksana[i] * diff;
//            timeSpent = oksana[i + 1];
//        }
//
//        return res;
//    }
//}
//
//

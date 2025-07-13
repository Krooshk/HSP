//import java.util.*;
//
//public class Level1
//{
//    public static String [] ShopOLAP(int N, String [] items) {
//        HashMap<String, Integer> map = new HashMap<String, Integer>();
//        int index = 0;
//
//        for (int i = 0; i < N; i ++){
//            String[] currItem = items[i].split(" ");
//            String key = currItem[0];
//            Integer count = Integer.parseInt(currItem[1]);
//
//            Integer currValue = map.get(key);
//            if (currValue == null) {
//                currValue = 0;
//            }
//            map.put(key, count + currValue);
//        }
//
//        String [] result = new String[map.size()];
//
//        for (String key : map.keySet()) {
//            result[index] = key + " " + map.get(key);
//            index++;
//        }
//
//        customSort(result);
//
//        return result;
//    }
//
//    public static String[] customSort(String[] arr) {
//        for (int i = 0; i < arr.length; i++){
//            for (int j = 0; j < arr.length - i - 1; j++){
//                boolean shouldSwap = swap(arr[j], arr[j+1]);
//                if (shouldSwap) {
//                    String temp = arr[j];
//                    arr[j] = arr[j+1];
//                    arr[j+1] = temp;
//                }
//            }
//        }
//
//        return arr;
//    }
//
//
//    public static boolean swap(String a, String b) {
//        String[] arr1 = a.split(" ");
//        String[] arr2 = b.split(" ");
//
//        int num1 = Integer.parseInt(arr1[1]);
//        int num2 = Integer.parseInt(arr2[1]);
//        String name1 = arr1[0];
//        String name2 = arr2[0];
//        if (num1 < num2) {
//            return true;
//        }
//
//        if (num1 == num2 && name1.compareTo(name2) > 0) {
//            return true;
//        }
//
//        return false;
//    }
//}
//
//

//import java.util.*;
//
//public class Level1
//{
//    public static String BiggerGreater(String input) {
//        int len = input.length();
//        String result = "";
//        int[] arrCodes = new int[len];
//
//        for (int i = 0; i < len; i++) {
//            arrCodes[i] = (int) input.charAt(i);
//        }
//
//        int point = -1;
//
//        for (int i = len - 1; i > 0; i--) {
//            if (arrCodes[i] > arrCodes[i - 1]) {
//                point = i - 1;
//                int index = bitMoreNum(arrCodes[i - 1], i, arrCodes);
//                int temp = arrCodes[index];
//                arrCodes[index] = arrCodes[i - 1];
//                arrCodes[i - 1] = temp;
//                break;
//            }
//        }
//
//
//        if (point == -1) {
//            return result;
//        }
//
//        int[] rightArray = Arrays.copyOfRange(arrCodes, point + 1, len);
//        Arrays.sort(rightArray);
//
//        for (int k = 0; k <= point; k++){
//            result += (char) arrCodes[k];
//        }
//
//        for (int j = 0; j < rightArray.length; j++){
//            result += (char) rightArray[j];
//        }
//
//        return result;
//    };
//
//    public static int bitMoreNum(int goal, int start, int[] arr){
//        int index = -1;
//        boolean notInitial = true;
//
//        for (int i = start; i < arr.length; i++){
//            if (notInitial && arr[i] > goal) {
//                notInitial = false;
//                index = i;
//            }
//
//            if (!notInitial && arr[i] > goal && arr[i] < arr[index]){
//                index = i;
//            }
//        }
//
//        return index;
//    }
//}
//
//

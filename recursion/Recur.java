import java.util.*;
import java.io.File;

class Recur {
    public static int degree(int N, int M) {
        if (M == 0) {
            return 1;
        }
        return N * degree(N, M - 1);
    }

    public static int sumOfDigit(int N) {
        if (N / 10 == 0) {
            return N % 10;
        }

        int main = N / 10;
        int remainder = N % 10;

        return remainder + sumOfDigit(main);
    }

    public static int getLengthOfList(LinkedList<String> list){
        if (list.size() == 0) {
            return 0;
        }
        list.pop();

        return 1 + getLengthOfList(list);
    }

    public static boolean isPalindrome(String str){
        return helperIsPalindrome(str, 0);
    }

    public static boolean helperIsPalindrome(String str, int offset) {
        int end = str.length() - 1;

        if (offset >= str.length() / 2) {
            return true;
        }

        if (str.charAt(offset) != str.charAt(end - offset)){
            return false;
        }

        return helperIsPalindrome(str, offset + 1);
    }

    public static void printOnlyEvenValue(LinkedList<Integer> list) {
        helperPrintOnlyEvenValue(list, 0);
    }

    public static void helperPrintOnlyEvenValue(LinkedList<Integer> list, int index){
        if (index >= list.size()) {
            return;
        }

        int currentNum = list.get(index);
        if (currentNum % 2 == 0) {
            System.out.println(currentNum);
        }

        helperPrintOnlyEvenValue(list, index + 1);
    }

    public static void printOnlyEvenIndex(LinkedList<Integer> list) {
        helperPrintOnlyEvenIndex(list, 0);
    }

    public static void helperPrintOnlyEvenIndex(LinkedList<Integer> list, int index){
        if (index >= list.size()) {
            return;
        }
        System.out.println(list.get(index));

        helperPrintOnlyEvenIndex(list, index + 2);
    }

    public static int secondMax(int[] arr){
        return helperSecondMax(arr, null, null, 0);
    }

    public static int helperSecondMax(int[] arr, Integer max, Integer exMax, int index){
        if (max == null) {
            max = arr[index];
        }

        if (arr[index] > max) {
            int temp = max;
            max = arr[index];
            exMax = temp;
        } else if (exMax == null || arr[index] > exMax) {
            exMax = arr[index];
        }

        if (index == arr.length - 1) {
            return exMax;
        }

        return helperSecondMax(arr, max, exMax, index + 1);
    }

    public static ArrayList<String> getFiles(String path){
        ArrayList<String> store = new ArrayList<String>();
        File obj = new File(path);
        return helperGetFiles(obj, store);
    }

    public static ArrayList<String> helperGetFiles(File obj, ArrayList<String> store){
        if (!obj.isDirectory()){
            store.add(obj.getName());
        } else {
            File[] files = obj.listFiles();
            if (files != null) {
                for (File file : files) {
                    helperGetFiles(file, store);
                }
            }
        }

        return store;
    }


}

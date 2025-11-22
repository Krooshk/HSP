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

        boolean isOvercomeMiddleOfStr = offset >= str.length() / 2;
        if (isOvercomeMiddleOfStr) {
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
        boolean isEven = currentNum % 2 == 0;
        if (isEven) {
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

    public static Integer secondMax(int[] arr){
        if (arr.length <= 2) {
            return null;
        }

        int max;
        int exMax;

        if(arr[0] > arr[1]) {
            max = arr[0];
            exMax = arr[1];
        } else {
            max = arr[1];
            exMax = arr[0];
        }


        return helperSecondMax(arr, max, exMax, 2);
    }

    public static Integer helperSecondMax(int[] arr, Integer max, Integer exMax, int index){
        if (arr[index] > max) {
            int temp = max;
            max = arr[index];
            exMax = temp;
        } else if (arr[index] > exMax) {
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
        if (!obj.isDirectory()){
            store.add(obj.getName());
        } else {
            File[] files = obj.listFiles();
            if (files != null) {
                for (File file : files) {
                    ArrayList<String> insideStore = getFiles(file.getAbsolutePath());
                    store.addAll(insideStore);
                }
            }
        }

        return store;
    }

    public static ArrayList<String> generateParens(int count) {
        ArrayList<String> list = new ArrayList<String>();
        addParen(list, count, count, "", 0);
        return list;
    }

    public static void addParen(ArrayList<String> list, int leftRem, int rightRem, String str, int count) {
        if (leftRem < 0 || rightRem < leftRem) return;

        if (leftRem == 0 && rightRem == 0) {
            list.add(str);
            return;
        }

        if (leftRem > 0) {
            String copyStr = str;
            copyStr += '(';
            addParen(list, leftRem - 1, rightRem, copyStr, count + 1);
        }

        if (rightRem > leftRem) {
            String copyStr = str;
            copyStr += ')';
            addParen(list, leftRem, rightRem - 1, copyStr, count + 1);
        }
    }



}

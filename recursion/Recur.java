import java.util.*;

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

    public static boolean isPalindrome(String str, int offset){
        int end = str.length() - 1;

        if (offset >= str.length() / 2) {
            return true;
        }

        if (str.charAt(offset) != str.charAt(end - offset)){
            return false;
        }

        return isPalindrome(str, offset + 1);
    }

    public static void printOnlyEvenValue(LinkedList<Integer> list, int index) {
        if (index >= list.size()) {
            return;
        }

        int currentNum = list.get(index);
        if (currentNum % 2 == 0) {
            System.out.println(currentNum);
        }

        printOnlyEvenValue(list, index + 1);
    }

    public static void printOnlyEvenIndex(LinkedList<Integer> list, int index) {
        if (index >= list.size()) {
            return;
        }

        if (index % 2 == 0) {
            System.out.println(list.get(index));
        }

        printOnlyEvenIndex(list, index + 1);
    }

    public static int secondMax(int[] arr){
        return traverseMaxSecond(arr, null, null, 0);
    }

    public static int traverseMaxSecond(int[] arr, Integer max, Integer exMax, int index){
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

        return traverseMaxSecond(arr, max, exMax, index + 1);
    }


}

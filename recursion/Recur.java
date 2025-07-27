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

    public static boolean isPalindrome(String str){
        int end = str.length() - 1;
        if (str.length() <= 1) {
            return true;
        }

        if (str.charAt(0) != str.charAt(end)){
            return false;
        }

        return isPalindrome(str.substring(1, end));
    }


}

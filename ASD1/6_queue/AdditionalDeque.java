// 6-2 Можно использовать двунаправленный связный список. Добавление в голову и в хвост происходит за О(1), в отличие от реаализации с массивом.

public class AdditionalDeque {

// 6 -4 isPalindrome time - O(n) space - O(n)
public static boolean isPalindrome(String str){
    Deque<Character> dequeStr = new Deque<>();

    for (int i = 0; i < str.length(); i++){
        dequeStr.addTail(str.charAt(i));
    }

    for (int i = 0; i < str.length() / 2; i++) {
        Character left = dequeStr.removeFront();
        Character right = dequeStr.removeTail();

        if (left != right) {
            return false;
        }
    }

    return true;
}
}


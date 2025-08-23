// 4-3 Если стек пустой, то цикл не запустится. Если его размер больше или равен 1, то будет выполняться пока не очистится полностью.

import java.util.HashMap;
import java.util.HashSet;

public class AdditionalStack {
     public static boolean parenthesesValidator(String str) {
        Stack<Character> stack = new Stack();
        for (char ch: str.toCharArray()){
            if (ch == '(') {
                stack.push('(');
            } else if (stack.pop() == null) {
                return false;
            }
        }

        return stack.size() == 0;
    }

    public static boolean parenthesesValidatorV2(String str) {
        Stack<Character> stack = new Stack();
        HashMap<Character, Character> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        set.add('(');
        set.add('[');
        set.add('{');
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        for (char ch: str.toCharArray()){
            if (set.contains(ch)) {
                stack.push(ch);
            } else if (stack.pop() != map.get(ch)) {
                return false;
            }
        }

        return stack.size() == 0;
    }
}

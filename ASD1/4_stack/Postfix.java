import java.util.*;

public class Postfix {

    private Postfix(){}
    final static String DIVIDER = " ";
    final static String EQUAL_STR = "=";
    public static Integer postfixCount(String str) {
        Stack<String> s1 = new Stack<String>();
        Stack<String> s2 = new Stack<String>();
        String[] arr = str.split(DIVIDER);
        HashSet<String> operations = new HashSet<String>(Arrays.asList("+", "-", "*"));

        for (int i = arr.length - 1; i >= 0; i--){
            s1.push(arr[i]);
        }

        for (String curr = s1.pop(); curr != null; curr = s1.pop()){
            if (curr.equals(EQUAL_STR)) {
                return Integer.valueOf(s2.pop());
            }
            if (operations.contains(curr)) {
                operation(curr, s2);
                continue;
            }

            Integer numericValue = Integer.valueOf(curr);
            s2.push(String.valueOf(numericValue));
        }

        return null;
    }

    public static void operation(String str, Stack<String> stack) {
        Integer operand1 = Integer.valueOf(stack.pop());
        Integer operand2 = Integer.valueOf(stack.pop());
        switch (str) {
            case "*":
                stack.push(String.valueOf(operand1 * operand2));
                break;
            case "+":
                stack.push(String.valueOf(operand1 + operand2));
                break;
            case "-":
                stack.push(String.valueOf(operand1 - operand2));
                break;
            default:
                break;
        }
    }


}

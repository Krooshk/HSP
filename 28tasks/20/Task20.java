import java.util.*;

public class Task20
{
    final static String ERROR_MESSAGE = "Not such command";
    static String current = "";
    static Stack<String> stackUndo = new Stack<>();
    static Stack<String> stackRedo = new Stack<>();
    static boolean isLastUndo = false;
    public static String BastShoe(String command) {
        try {
            int commandNumber = Integer.parseInt(command.substring(0, 1));
            if (commandNumber < 1 || commandNumber > 5) {
                throw new Exception(ERROR_MESSAGE);
            }

            if (commandNumber == 1) {
                return add(command.substring(2));
            }

            if (commandNumber == 2) {
                return remove(command.substring(2));
            }

            if (commandNumber == 3) {
                return get(command.substring(2));
            }

            if (commandNumber == 4) {
                return undo();
            }

            if (commandNumber == 5) {
                return redo();
            }

        } catch (Exception e) {
            return "";
        }

        return "";
    }

    public static String add(String right) {
        clearStacks();

        current += right;
        return current;
    }

    public static String remove(String right) {
        clearStacks();
        int count = Integer.parseInt(right);
        int len = current.length();

        if (count >= len){
            current = "";
        }

        if (count < len) {
            current = current.substring(0, len - count);
        }

        return current;
    }

    public static void clearStacks() {
        if (isLastUndo) {
            stackUndo.clear();
            stackRedo.clear();
        }
        stackUndo.push(current);
        isLastUndo = false;
    }

    public static String get(String right){
        int len = current.length();
        int position = Integer.parseInt(right);
        if (position >= len) {
            return "";
        }

        return current.substring(position, position + 1);
    }

    public static String undo(){
        boolean isUndoStackEmpty = stackUndo.size() == 0;
        if (!isUndoStackEmpty) {
            String str = stackUndo.pop();
            stackRedo.push(current);
            isLastUndo = true;
            current = str;
        }

        return current;
    }


    public static String redo(){
        if (stackRedo.size() > 0) {
            stackUndo.push(current);
            String str = stackRedo.pop();
            current = str;
        }
        isLastUndo = false;

        return current;
    }


}




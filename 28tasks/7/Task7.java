import java.util.*;

public class Task7
{
    public static int[] WordSearch(int len, String s, String subs){
        ArrayList<String> list = getList(s, len);

        return findInRow(subs, list);
    }

    public static ArrayList<String> getList(String s, int len){
        ArrayList<String> list = new ArrayList<>();
        String copyStr = s;

        while(copyStr.length() > 0) {
            if (copyStr.length() <= len) {
                list.add(copyStr);
                copyStr = "";
            } else {
                String slice = copyStr.substring(0, len);
                int index = slice.lastIndexOf(' ');
                if (copyStr.charAt(len) != ' ' && index != -1) {
                    slice = slice.substring(0, index + 1);
                    copyStr = copyStr.substring(index + 1);
                    list.add(slice);
                } else {
                    list.add(slice);
                    copyStr = copyStr.substring(len);
                }
            }
        }

        return list;
    }

    public static int[] findInRow(String subs, ArrayList<String> list) {
        int size = list.size();
        int[] res = new int[size];

        for (int i = 0; i < size; i++){
            String currentStr = list.get(i);
            int index = currentStr.indexOf(subs);
            int currentStrLength = currentStr.length();

            boolean isExistStr = index != -1;
            boolean isStartCorrect = (index == 0) || (isExistStr && currentStr.charAt(index - 1) == ' ');
            int endOfStr = index + subs.length();
            boolean isFinishCorrect = (endOfStr == currentStrLength) || currentStr.charAt(endOfStr) == ' ' || currentStr.charAt(endOfStr) == '.';

            if (isExistStr && isStartCorrect && isFinishCorrect){
                res[i] = 1;
            } else {
                res[i] = 0;
            }
        }

        return res;
    }
}



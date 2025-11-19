import java.util.*;

public class Cyberpunk8 {
    final String DIRECTION_UP = "up";
    final String DIRECTION_DOWN = "down";
    final String DIRECTION_LEFT = "left";
    final String DIRECTION_RIGHT = "right";
    public static String army_communication_matrix(int n, int [][] matrix) {
        HashMap<String, Integer> map = new HashMap<>();


        for (int size = n - 1; size >= 2; size--){
            boolean isRightDirection = true;
            int iteration = (n - size + 1) * (n - size + 1);
            int currSum = fisrtSum(size, matrix);
            int curr_x = 0;
            int curr_y = 0;
            setValueInMap(size, curr_x, curr_y, currSum, map);

            for(int i = 1; i < iteration; i++) {
                if (isRightDirection && curr_x + size == n){
                    int prevStrip = stripSum(size, DIRECTION_UP, curr_x, curr_y, matrix);
                    curr_y++;
                    int currStrip = stripSum(size, DIRECTION_DOWN, curr_x, curr_y, matrix);
                    currSum = currSum - prevStrip + currStrip;
                    setValueInMap(size, curr_x, curr_y, currSum, map);

                    isRightDirection = false;
                    continue;
                } else if (isRightDirection){
                    int prevStrip = stripSum(size, DIRECTION_LEFT, curr_x, curr_y, matrix);
                    curr_x++;
                    int currStrip = stripSum(size, DIRECTION_RIGHT, curr_x, curr_y, matrix);
                    currSum = currSum - prevStrip + currStrip;
                    setValueInMap(size, curr_x, curr_y, currSum, map);
                }

                if (!isRightDirection && curr_x == 0) {
                    int prevStrip = stripSum(size, DIRECTION_UP, curr_x, curr_y, matrix);
                    curr_y++;
                    int currStrip = stripSum(size, DIRECTION_DOWN, curr_x, curr_y, matrix);
                    currSum = currSum - prevStrip + currStrip;
                    setValueInMap(size, curr_x, curr_y, currSum, map);

                    isRightDirection = true;
                } else if (!isRightDirection) {
                    int prevStrip = stripSum(size, DIRECTION_RIGHT, curr_x, curr_y, matrix);
                    curr_x--;
                    int currStrip = stripSum(size, DIRECTION_LEFT, curr_x, curr_y, matrix);
                    currSum = currSum - prevStrip + currStrip;
                    setValueInMap(size, curr_x, curr_y, currSum, map);
                }

            }

        }

        return map.get("x") + " " + map.get("y") + " " + map.get("size");
    }

    public static void setValueInMap(int size, int x, int y, int max, HashMap<String, Integer> map){
        Integer maximus = map.get("max");
        if (maximus == null || max >= maximus) {
            map.put("x", x);
            map.put("y", y);
            map.put("max", max);
            map.put("size", size);
        }
    }


    public static int fisrtSum(int size, int[][] matrix){
        int sum = 0;
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++) {
                sum+= matrix[i][j];
            }
        }

        return sum;
    }

    public static Integer stripSum(int size, String place, int x, int y, int[][] matrix) {
        int sum = 0;
        switch (place) {
            case DIRECTION_RIGHT: {
                for (int i = y; i < y + size; i++){
                    sum += matrix[i][x + size - 1];
                }
                return sum;
            }
            case DIRECTION_LEFT: {
                for (int i = y; i < y + size; i++){
                    sum += matrix[i][x];
                }
                return sum;
            }
            case DIRECTION_UP: {
                for (int i = x; i < x + size; i++){
                    sum += matrix[y][i];
                }
                return sum;
            }
            case DIRECTION_DOWN:{
                for (int i = x; i < x + size; i++){
                    sum += matrix[y + size - 1][i];
                }
                return sum;
            }
            default:
                return null;
        }
    }

}
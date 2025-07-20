import java.util.*;

public class Level1
{
    static public String Keymaker(int k) {
        String[] doors = new String[k];

        for (int i = 0; i < k; i++){
            doors[i] = "0";
        }

        for (int i = 1; i <= k; i++) {
            for (int j = i - 1; j < k; j+= i) {
                if (doors[j] == "1") {
                    doors[j] = "0";
                } else {
                    doors[j] = "1";
                }
            }
        }

        return String.join("", doors);
    }
}



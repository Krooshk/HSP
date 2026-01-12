
    public static String BigMinusRightOrder(String s1, String s2){
        String result = "";

        int len1 = s1.length();
        int len2 = s2.length();
        int[] arr1 = new int[len1];
        int[] arr2 = new int[len2];

        for (int u = 0; u < len1; u++){
            arr1[u] = getNum(s1, u);
        }

        for (int j = 0; j < len2; j++){
            arr2[j] = getNum(s2, j);
        }

        int debt = 0;
        for (int i = 0; i < len1; i++) {
            int secondElem = 0;
            if (len2 - 1 - i >= 0) secondElem = arr2[len2 - 1 - i];
            int diff = arr1[len1 - 1 - i] - secondElem - debt;
            if (diff >= 0) {
                arr1[len1 - 1 - i] = diff;
                debt = 0;
                continue;
            }
            arr1[len1 - 1 - i] = diff + 10;
            debt = 1;
        }

        boolean write = false;
        for (int k = 0; k < len1; k++){
            if (arr1[k] != 0) {
                write = true;
            }
            if (write) {
                result += arr1[k];
            }
        }

        return result.length() == 0 ? "0" : result;
    }

    175% изначально


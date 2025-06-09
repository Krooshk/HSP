public class MyCode {
    public static int[] sort(int[] array) {
        int[] arr = MyCode.copy(array);
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex])
                    minIndex = j;
            }

            int x = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = x;
        }

        return arr;
    }

    public static boolean equal(int[] arr1, int[] arr2){
        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0; i < arr1.length; i ++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }

        return true;
    }

    public static int[] copy(int[] array) {
        int [] copyArr = new int[array.length];

        for (int i = 0; i < array.length; i++){
            copyArr[i] = array[i];
        }

        return copyArr;
    }

}

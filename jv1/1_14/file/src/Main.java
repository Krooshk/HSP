import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import Pets.Cat;

// Задание 3.1
class NewFiles {
    static String path = "/home/kirill/Desktop/bbr/HSP/jv1/1_14/file/";

    public static boolean create() {
        Random rand = new Random();
        boolean successExecution = true;

        for (int i = 1; i <= 10; i++) {
            BufferedWriter bw = null;
            try {
                File my_file = new File(path + i + ".txt");
                bw = new BufferedWriter(new FileWriter(my_file));

                for (int j = 0; j < 3; j++) {
                    int num = rand.nextInt(100);
                    bw.write(String.valueOf(num));
                    bw.newLine();
                }
                bw.close();
            } catch (Exception e) {
                successExecution = false;
            }
        }
        return successExecution;
    }
}

// Задание 3.2
class SumOfTwoFiles {
    static String path = "/home/kirill/Desktop/bbr/HSP/jv1/1_14/file/";

    public static int[] sum(int a, int b) {
        int[] res = new int[2];
        res[1] = 0;
        
        boolean aIsNotValid = a < 1 || a > 10;
        boolean bIsNotValid = b < 1 || b > 10;
        if (aIsNotValid || bIsNotValid) {
            res[1] = 1; // Заданные числа файлов не валидны
        }

        File file1 = new File(path + a + ".txt");
        File file2 = new File(path + b + ".txt");
        try {
            BufferedReader br1 = new BufferedReader(new FileReader(file1));
            BufferedReader br2 = new BufferedReader(new FileReader(file2));
            int[] firstSum = SumOfTwoFiles.sumOneFile(br1);
            int[] secondSum = SumOfTwoFiles.sumOneFile(br2);
            if (firstSum[1] == 0) {
                res[0] += firstSum[0];
            } else {
                res[1] = 2; // Первый файл вернулся с ошибкой
            }

            if (secondSum[1] == 0) {
                res[0] += secondSum[0];
            } else {
                res[1] = 3; // Второй файл вернулся с ошибкой
            }
        } catch (Exception e) {
            res[1] = 4; // Ошибка при чтении файла
        }

        return res;
    }

    public static int[] sumOneFile(BufferedReader br) {
        int count = 0;
        int[] res = new int[2];
        res[1] = 0;

        try {
            String st = br.readLine();
            while (st != null && count < 3) {
                count++;
                res[0] += Integer.parseInt(st);
                st = br.readLine();
            }

            if (count < 3) {
                res[1] = 1; // Не хватает числа
            }

            br.close();
        } catch (Exception e) {
            res[1] = 2; // Неизвестная ошибка
        }
        return res;
    }
}

// Задание 3.3
class NewCats {
    static String path = "/home/kirill/Desktop/bbr/HSP/jv1/1_14/file/";

    public static void createPets() {
        BufferedReader br = null;

        try {
            File file = new File(path + "cats.txt");
            br = new BufferedReader(new FileReader(file));
            String st = br.readLine();
            ArrayList<Cat> arrayList = new ArrayList<Cat>();

            while(st != null) {
                String[] characteristic = st.split(" ");
                String name = characteristic[0];
                double weight = Double.parseDouble(characteristic[1]);
                int freq = Integer.parseInt(characteristic[2]);
                Cat newCat = new Cat(name, weight, freq);

                arrayList.add(newCat);

                st = br.readLine();
            }
        } catch (Exception e) {
        } finally {
            if (br != null){
                try {
                    br.close();
                } catch (IOException e) { }
            }
        }
        }
}

// Задание 3.4
// Сделано внутри функций.

public class Main {
    public static void main (String[]args) {
        Random rand = new Random();

        // Вызов для задания 3.1
        System.out.println(NewFiles.create());

        // Вызов для задания 3.2
        int first = rand.nextInt(10) + 1;
        int second = rand.nextInt(10) + 1;
        System.out.println(first + ";" + second);

        int[] res = SumOfTwoFiles.sum(first, second);
        System.out.println(res[0]);
        System.out.println(res[1]);

        // Вызов для задания 3.3
        NewCats.createPets();
    }
}


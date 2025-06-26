import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import Pets.Cat;

// Задание 3.1
class NewFiles {
    public static boolean create(String path) {
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
    public static HashMap<String, Integer> sum(int a, int b, String path) {
        HashMap<String, Integer> res = new HashMap<>();
        res.put("error", 0);
        res.put("sum", 0);

        boolean aIsNotValid = a < 1 || a > 10;
        boolean bIsNotValid = b < 1 || b > 10;
        if (aIsNotValid || bIsNotValid) {
            res.put("error", 1); // Заданные числа файлов не валидны
            return res;
        }

        File file1 = new File(path + a + ".txt");
        File file2 = new File(path + b + ".txt");
        try {
            BufferedReader br1 = new BufferedReader(new FileReader(file1));
            BufferedReader br2 = new BufferedReader(new FileReader(file2));
            HashMap<String, Integer> firstFile = SumOfTwoFiles.sumOneFile(br1);
            HashMap<String, Integer> secondFile = SumOfTwoFiles.sumOneFile(br2);
            if (firstFile.get("error") == 0) {
                res.put("sum", firstFile.get("sum") + res.get("sum"));
            } else {
                res.put("error", 2); // Первый файл вернулся с ошибкой
                return res;
            }

            if (secondFile.get("error") == 0) {
                res.put("sum", secondFile.get("sum") + res.get("sum"));
            } else {
                res.put("error", 3); // Второй файл вернулся с ошибкой
            }
        } catch (Exception e) {
            res.put("error", 4); // Ошибка при чтении файла
        }

        return res;
    }

    public static HashMap<String, Integer> sumOneFile(BufferedReader br) {
        int count = 0;
        HashMap<String, Integer> res = new HashMap<>();
        res.put("error", 0);
        res.put("sum", 0);

        try {
            String st = br.readLine();
            while (st != null && count < 3) {
                count++;
                res.put("sum", res.get("sum") + Integer.parseInt(st));
                st = br.readLine();
            }

            if (count < 3) {
                res.put("error", 1); // Не хватает числа
                return res;
            }

            br.close();
        } catch (Exception e) {
            res.put("error", 2); // Ошибка при закрытии потока
            return res;
        }
        return res;
    }
}

// Задание 3.3
class NewCats {
    public static void createPets(String path) {
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
        String path = "/home/kirill/Desktop/bbr/HSP/jv1/1_14/file/";
        Random rand = new Random();

        // Вызов для задания 3.1
        System.out.println(NewFiles.create(path));

        // Вызов для задания 3.2
        int first = rand.nextInt(10) + 1;
        int second = rand.nextInt(10) + 1;
        System.out.println(first + ";" + second);

        HashMap<String, Integer> res = SumOfTwoFiles.sum(first, second, path);
        System.out.println(res.get("error"));
        System.out.println(res.get("sum"));

        // Вызов для задания 3.3
        NewCats.createPets(path);
    }
}


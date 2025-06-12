import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import Pets.Cat;

// Задание 3.1
class NewFiles {
    static String path = "/home/kirill/Desktop/bbr/HSP/jv1/1_14/file/";

    public static void create() {
        Random rand = new Random();

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
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                if (bw != null) {
                    try {
                        bw.close();
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }

        }
    }
}

// Задание 3.2
class SumOfTwoFiles {
    static String path = "/home/kirill/Desktop/bbr/HSP/jv1/1_14/file/";

    public static int sum(int a, int b) throws Exception {
        boolean aIsNotValid = a < 1 || a > 10;
        boolean bIsNotValid = b < 1 || b > 10;
        if (aIsNotValid || bIsNotValid) {
            throw new Exception("Заданные числа файлов не валидны");
        }

        File file1 = new File(path + a + ".txt");
        File file2 = new File(path + b + ".txt");
        try {
            BufferedReader br1 = new BufferedReader(new FileReader(file1));
            BufferedReader br2 = new BufferedReader(new FileReader(file2));
            return SumOfTwoFiles.sumOneFile(br1) + SumOfTwoFiles.sumOneFile(br2);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public static int sumOneFile(BufferedReader br) {
        int count = 0;
        int sumThreeNum = 0;

        try {
            String st = br.readLine();
            while (st != null && count < 3) {
                count++;
                sumThreeNum+= Integer.parseInt(st);
                st = br.readLine();
            }

            if (count < 3) {
                throw new Exception("Не хватает числа");
            }

            return sumThreeNum;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
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
            System.out.println(e.getMessage());
        } finally {
            if (br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
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
        NewFiles.create();

        // Вызов для задания 3.2
        int first = rand.nextInt(10) + 1;
        int second = rand.nextInt(10) + 1;
        System.out.println(first + ";" + second);
        try {
            System.out.println(SumOfTwoFiles.sum(first, second));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Вызов для задания 3.3
        NewCats.createPets();
    }
}


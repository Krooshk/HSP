import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

// Задание 4.1
class Example1 {
    public static void runOne(){
        File root = new File("."); // Устанавливается связь с файлом, в linux файлом является также директория
        ArrayList<File> expand = new ArrayList<File>(); // Создание ArrayList, где тип значений  File с размером по умолчанию 10
        expand.add(root); // Добавление в expand root

        for(int depth = 0; depth < 10; depth++) { // Цикл от 0 до 9 включительно
            File[] expandCopy = expand.toArray(new File[expand.size()]); // Методу toArray передается массив с размером идентичным expand, туда запишутся значения
            expand.clear(); // Удаляет все элементы из ArrayList
            for (File file : expandCopy) { // Цикл по элементам expandCopy, текущий элемент - file типа File
                System.out.println(depth + " " + file); // Вывод глубины и файла
                if (file.isDirectory()) { // Проверка на то, что файл - директория
                    expand.addAll(Arrays.asList(file.listFiles())); // Добавляем внутренние файлы (директории или файлы) в ArrayList; listFiles возвращается массив;
                    // asList преобразует массив в список
                }
            }
        }
    }
}

// Задание 4.2
class FilePathfinder {
    public static ArrayList<ArrayList> getFiles(String path, String ext, boolean useSubdir){
        File startPoint = new File(path);
        ArrayList<File> expand = new ArrayList<File>();
        expand.addAll(Arrays.asList(startPoint.listFiles()));

        ArrayList<String> files = new ArrayList<String>();
        ArrayList<String> dirs = new ArrayList<String>();
        ArrayList<ArrayList> result = new ArrayList<ArrayList>();

        result.add(files);
        result.add(dirs);

        int limitDepth = 0;
        if (useSubdir) {
            limitDepth = 1;
        }

        for (int depth = 0; depth <= limitDepth; depth++){
            File[] expandCopy = expand.toArray(new File[expand.size()]);
            expand.clear();

            for (File file: expandCopy) {
                String name = file.getName();
                if (file.isDirectory()) {
                    dirs.add(name);
                    expand.addAll(Arrays.asList(file.listFiles()));
                } else if (ext.equals(FilePathfinder.getExt(name))) {
                    files.add(name);
                }
            }
        }

        return result;
    }

    public static String getExt(String filename) {
        int index = filename.lastIndexOf('.');
        if (index == -1) {
            throw new Error("Нет расширения");
        }

        return filename.substring(index + 1);
    }
}

// Задание 4.3
class FileDestroy {
    public static boolean deleteDir(String path) {
        File startPoint = new File(path);
        ArrayList<File> expand = new ArrayList<File>();
        expand.addAll(Arrays.asList(startPoint.listFiles()));

        if (FileDestroy.hasDir(expand)) {
            return false;
        }

        for (File file: expand) {
            file.delete();
        }

        return startPoint.delete();
    }

    public static boolean hasDir(ArrayList<File>  files) {
        for (File file: files) {
            if (file.isDirectory()) {
                return true;
            }
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        // Вызов для задания 4.2
        System.out.println(FilePathfinder.getFiles("/home/kirill/Desktop/bbr/HSP/jv1/1_15/src/examples", "txt", true));
        // Вызов для задания 4.3
        System.out.println(FileDestroy.deleteDir("/home/kirill/Desktop/bbr/HSP/jv1/1_15/src/del"));
    }
}
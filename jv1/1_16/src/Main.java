import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
// Импорт необходимых пакетов

class Zip {
    static public void addFilesWithZip(String pathZip, String[] pathFiles) throws Exception {
        File fileZip = new File("/home/kirill/Desktop/bbr/HSP/jv1/1_16/src/temporary.zip"); // Создаем ссылку на файл, прокидываю абсолютный путь
        File newFileZip = new File(pathZip); // Создаем ссылку на файл, прокидываю абсолютный путь

        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(fileZip)); // Создает новый выходной поток ZIP, принимает stream в качестве аргумента

        Zip.addFilesFromCurrentZip(zipOutputStream, pathZip); // Добавляем в текущий поток временного файла ZIP файлы из исходного архива
        Zip.addFiles(zipOutputStream, pathFiles); // Добавлем в текущий поток временного файла ZIP желаемые файлы

        if (!fileZip.renameTo(newFileZip)){
            throw new Exception('Cannot rename file');
        } // Перезаписываем исходный архив, присваивая имя временному архиву

        zipOutputStream.close(); // Закрываем поток архива
    }

    static public void addFilesFromCurrentZip(ZipOutputStream zipOutputStream, String pathZip) throws Exception {
        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(pathZip)); // Создаем поток из исходного архива для чтения
        ZipEntry zipEntry = zipInputStream.getNextEntry(); // Получаем сущность из архива

        while (zipEntry != null) { // Если метод getNextEntry вернул null, то сущностей больше нет
            if(!zipEntry.isDirectory()) { // Если не директория, то запишем файл во временный архив
                File file = new File("qwe.xyz");  // Создаем ссылку на файл, прокидываю абсолютный путь
                FileOutputStream fileOutputStream = new FileOutputStream(file); // Создаем поток для записи файла из архива
                byte[] buffer = new byte[1024]; // Задаем массив из байтов размером 1024
                int length; // Инициализируем переменную для длины
                while ((length = zipInputStream.read(buffer)) > 0) { // Пытаемся записать данные в buffer, если получаем 1, значит успешно записали, иначе выходим
                    fileOutputStream.write(buffer, 0, length); // По одному байту записываем данные в файл
                }
                zipInputStream.closeEntry(); // Закрытие текущей сущности в архиве
                fileOutputStream.close(); // Закрытие потока файла, так как запись закончили

                addFile(zipOutputStream, zipEntry, file); // Добавляем файл во временный архив
                file.delete(); // Удаляем временный файл
            }
            zipEntry = zipInputStream.getNextEntry(); // Пытаемся получить следующую сущность в архиве
        }

        zipInputStream.close(); // Закрываем поток исходного архива после прочтения
    }


    static public void addFiles(ZipOutputStream zipOutputStream, String[] pathFiles) throws Exception{
        for(String path: pathFiles) { // Цикл по элементам массива
            File file = new File(path); // Создаем ссылку на файл, прокидываю абсолютный путь
            ZipEntry zipEntry = new ZipEntry(file.getName()); // Создаем будущую сущность внутри архива с именем файла
            addFile(zipOutputStream, zipEntry, file); // Вызов метода для добавления файла в массив
        }
    }

    static public void addFile(ZipOutputStream zipOutputStream, ZipEntry zipEntry, File file) throws Exception{
        zipOutputStream.putNextEntry(zipEntry); // Добавляем новую сущность в архив

        FileInputStream fileInputStream = new FileInputStream(file); // Копируем файл в архив, передавая файл
        int length; // Задаем длину
        byte[] buffer = new byte[1024]; // Задаем массив из байтов размером 1024
        while ((length = fileInputStream.read(buffer)) > 0) { // Пытаемся записать данные в buffer, если получаем 1, значит успешно записали, иначе выходим
            zipOutputStream.write(buffer, 0, length); // По одному байту записываем данные в файл
        }

        fileInputStream.close(); // Закрывем входной поток
        zipOutputStream.closeEntry(); // Закрываем сущность архива
    }
}

public class Main {
    public static void main(String[] args) {
        String[] paths = {"/home/kirill/Desktop/bbr/HSP/jv1/1_16/src/fileForAdding.txt", "/home/kirill/Desktop/bbr/HSP/jv1/1_16/src/fileForAdding1.txt" }; // Пути добавляемых файлов
        String zip = "/home/kirill/Desktop/bbr/HSP/jv1/1_16/src/test2.zip"; // Имя текущего архива
        try {
            Zip.addFilesWithZip(zip,paths); // Вызов метода для добавления файлов в архив
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
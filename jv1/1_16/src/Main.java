import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

class Zip {
    static public void addFilesWithZip(String pathZip, String[] pathFiles) throws Exception {
        File fileZip = new File("/home/kirill/Desktop/bbr/HSP/jv1/1_16/src/temporary.zip");
        File newFileZip = new File(pathZip);

        ZipOutputStream zipOutputStream = new ZipOutputStream(
                new FileOutputStream(fileZip));

        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(pathZip));
        ZipEntry zipEntry = zipInputStream.getNextEntry();

        Zip.addFiles(zipOutputStream, pathFiles);

        while (zipEntry != null) {
            if(!zipEntry.isDirectory()) {
                File file = new File("qwe.xyz");
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                byte[] buffer = new byte[1024];
                int length;
                while ((length = zipInputStream.read(buffer)) > 0) {
                    fileOutputStream.write(buffer, 0, length);
                }
                zipInputStream.closeEntry();
                fileOutputStream.close();

                addFile(zipOutputStream, zipEntry, file);
            }
            zipEntry = zipInputStream.getNextEntry();
        }

        zipInputStream.close();
        fileZip.renameTo(newFileZip);

        zipOutputStream.close();
    }


    static public void addFiles(ZipOutputStream zipOutputStream, String[] pathFiles) throws Exception{
        for(String path: pathFiles) {
            File file = new File(path); // Создаем ссылку на файл, прокидываю абсолютный путь
            ZipEntry zipEntry = new ZipEntry(file.getName()); // Создаем будущую сущность внутри архива с именем файла
            addFile(zipOutputStream, zipEntry, file);
        }
    }

    static public void addFile(ZipOutputStream zipOutputStream, ZipEntry zipEntry, File file) throws Exception{
        zipOutputStream.putNextEntry(zipEntry); // Добавляем новую сущность в архив

        FileInputStream fileInputStream = new FileInputStream(file); // Копируем файл в архив, передавая файл
        int length; // Задаем длину
        byte[] buffer = new byte[1024]; // Задаем массив из байтов размером 1024
        while ((length = fileInputStream.read(buffer)) > 0) {
            zipOutputStream.write(buffer, 0, length);
        }

        fileInputStream.close();
        zipOutputStream.closeEntry();
    }
}

public class Main {
    public static void main(String[] args) throws Exception{
        String[] paths = {"/home/kirill/Desktop/bbr/HSP/jv1/1_16/src/fileForAdding.txt", "/home/kirill/Desktop/bbr/HSP/jv1/1_16/src/fileForAdding1.txt" };
        String zip = "/home/kirill/Desktop/bbr/HSP/jv1/1_16/src/wer.zip";

        Zip.addFilesWithZip(zip,paths);
    }
}
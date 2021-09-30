import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class WorkFile {
// из домашнего задания IO-streams_serialization_files_HomeWork сделала тест на 2 метода createFolder и createFile

        public static void createFolder(String obj, StringBuilder builder, String str) {
            File newFolder = new File(obj);
            if (newFolder.mkdir())
                builder.append(str);

        }

        public static void createFile(String obj, StringBuilder builder, String str) {
            File newFile = new File(obj);
            try {
                if (newFile.createNewFile())
                    builder.append(str);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }


        public static void main(String[] args) {

            StringBuilder strBuilder = new StringBuilder();

            //создаем директории в папке Games
            createFolder("/Users/SIREN-A/Games/src", strBuilder, "Folder src has been created \n");
            createFolder("/Users/SIREN-A/Games/res", strBuilder, "Folder res has been created \n");
            createFolder("/Users/SIREN-A/Games/savegames", strBuilder, "Folder savegames has been created \n");
            createFolder("/Users/SIREN-A/Games/temp", strBuilder, "Folder temp has been created \n");

            //в каталоге src создаем две директории: main, test
            createFolder("/Users/SIREN-A/Games/src/main", strBuilder, "Folder main (in src) has been created \n");
            createFolder("/Users/SIREN-A/Games/src/test", strBuilder, "Folder test (in src) has been created \n");

            //В подкаталоге main создаем два файла: Main.java, Utils.java.
            createFile("/Users/SIREN-A/Games/src/main/Main.java", strBuilder, "File Main.java has been created  \n");
            createFile("/Users/SIREN-A/Games/src/main/Utils.java", strBuilder, "File Utils.java has been created  \n");

            //В каталоге res создаем три директории: drawables, vectors, icons
            createFolder("/Users/SIREN-A/Games/res/drawables", strBuilder, "Folder drawables (in res) has been created \n");
            createFolder("/Users/SIREN-A/Games/res/vectors", strBuilder, "Folder vectors (in res) has been created \n");
            createFolder("/Users/SIREN-A/Games/res/icons", strBuilder, "Folder icons (in res) has been created \n");

            //В директории temp создаем файл temp.txt
            createFile("/Users/SIREN-A/Games/temp/temp.txt", strBuilder, "File temp.txt has been created  \n");

            // создание FileWriter
            String text = strBuilder.toString();
            System.out.println(text);
            try (FileWriter writer = new FileWriter("/Users/SIREN-A/Games/temp/temp.txt", false)) {

                writer.write(text);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

}

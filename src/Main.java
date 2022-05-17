import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        StringBuilder temp = new StringBuilder();
        String isCreated = null;
        String isNotCreated = null;

        String[] paths = {
                "D://Games/src",
                "D://Games/src/main",
                "D://Games/src/test",
                "D://Games/res",
                "D://Games/res/drawables",
                "D://Games/res/vectors",
                "D://Games/res/icons",
                "D://Games/savegames",
                "D://Games/temp",
        };

        for (String path : paths) {
            File dir = new File(path);
            if (dir.mkdirs()) {
                isCreated = ("Директория создана по адресу: " + path + "\r\n");
                System.out.print(isCreated);
                temp.append(isCreated);
            } else {
                isNotCreated = ("Директорию не удалось создать по адресу: " + path + "\r\n");
                temp.append(isNotCreated);
            }
        }

        String[] pathsFiles = {
                "D://Games/src/main/Main.java",
                "D://Games/src/main/Utils.java",
                "D://Games/temp/temp.txt",
        };

        for (String path : pathsFiles) {
            File file = new File(path);
            try {
                if (file.createNewFile()) {
                    isCreated = ("Файл был создан по адресу: " + path + "\r\n");
                    System.out.print(isCreated);
                    temp.append(isCreated);
                } else {
                    isNotCreated = ("Файл не удалось создать по адресу: " + path + "\r\n");
                    temp.append(isNotCreated);
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }

        try (FileWriter writer = new FileWriter("D://Games/temp/temp.txt", false)) {
            String string = temp.toString();
            writer.write(string);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

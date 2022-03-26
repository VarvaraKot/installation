package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        File file = new File("Games");
        file.mkdir();
        File src = new File("Games//src");
        createDirectory(src);
        File res = new File("Games//res");
        createDirectory(res);
        File savegames = new File("Games//savegames");
        createDirectory(savegames);
        File temp = new File("Games//temp");
        createDirectory(temp);
        File mainDirectory = new File("Games//src//main");
        createDirectory(mainDirectory);
        File test = new File("Games//src//test");
        createDirectory(test);

        File main = new File("Games//src//main//Main.java");
        createFile(main);
        File utils = new File("Games//src//main//Utils.java");
        createFile(utils);

        File drawables = new File("Games//res//drawables");
        createDirectory(drawables);
        File vectors = new File("Games//res//vectors");
        createDirectory(vectors);
        File icons = new File("Games//res//icons");
        createDirectory(icons);

        File tempFile = new File("Games//temp//temp.txt");
        createFile(tempFile);

        try (FileWriter writer = new FileWriter("Games//temp//temp.txt", true)) {
            writer.write(String.valueOf(sb));
            writer.flush();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static void createDirectory(File newDirectory) {
        if (newDirectory.exists()) {
            sb.append(newDirectory.getName() + " - каталог уже существует\n");
        } else if (newDirectory.mkdir()) {
            sb.append(newDirectory.getName() + " - каталог был создан\n");
        }
    }

    public static void createFile(File newFile) {
        try {
            if (newFile.exists()) {
                sb.append(newFile.getName() + " - файл уже существует\n");
            } else if (newFile.createNewFile()) {
                sb.append(newFile.getName() + " - файл был создан\n");
            }
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
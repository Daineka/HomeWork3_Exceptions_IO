package com.daineka.IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/*
4. Задан файл с java-кодом.
Прочитать текст программы из файла и все слова public
в объявлении атрибутов и методов класса заменить на слово private.
Результат сохранить в другой заранее созданный файл.
 */
public class Task4 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File("resources/JavaCodeInput.java"));
             PrintWriter printWriter = new PrintWriter("resources/JavaCodeOutputTask4.java")) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("class")) {
                    printWriter.print(line.substring(0, line.indexOf("class")));
                    line = line.substring(line.indexOf("class"));
                    if (line.contains("public")) {
                        line = swapPublicOnPrivate(line);
                    }
                    int countBraceBrackets = countBraceBrackets(line);
                    printWriter.println(line);
                    while (scanner.hasNextLine()) {
                        line = scanner.nextLine();
                        if (line.contains("public")) {
                            line = swapPublicOnPrivate(line);
                        }
                        printWriter.println(line);
                        countBraceBrackets += countBraceBrackets(line);
                        if (countBraceBrackets == 0) break;
                    }
                } else {
                    printWriter.println(line);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static int countBraceBrackets(String line) {
        int countBraceBrackets = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '{') countBraceBrackets++;
            if (line.charAt(i) == '}') countBraceBrackets--;
        }
        return countBraceBrackets;
    }

    private static String swapPublicOnPrivate(String line) {
        if (!line.contains("public")) return line;
        int index = line.indexOf("public");
        line = line.replace(line.substring(index, index + 6), "private");
        return swapPublicOnPrivate(line);
    }
}

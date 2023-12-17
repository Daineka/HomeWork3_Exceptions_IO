package com.daineka.IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/*
5. Задан файл с java-кодом.
Прочитать текст программы из файла и
записать в другой файл в обратном порядке символы каждой строки.
 */
public class Task5 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File("resources/JavaCodeInput.java"));
             PrintWriter printWriter = new PrintWriter("resources/JavaCodeOutputTask5.java")) {
            while (scanner.hasNextLine()) {
                StringBuilder line = new StringBuilder(scanner.nextLine());
                line.reverse();
                printWriter.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

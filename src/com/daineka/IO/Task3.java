package com.daineka.IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
3. Задан файл с текстом.
В каждой строке найти и вывести наибольшее число цифр, идущих подряд.
 */
public class Task3 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File("resources/Input.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                int count = 0;
                int countMax = 0;
                int i = 0;
                int lengthLine = line.length();
                while (i < lengthLine) {
                    while (i < lengthLine && Character.isDigit(line.charAt(i))) {
                        count++;
                        i++;
                    }
                    if (countMax < count) {
                        countMax = count;
                        count = 0;
                    }
                    i++;
                }
                System.out.println(countMax);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

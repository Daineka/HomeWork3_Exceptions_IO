package com.daineka.IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/*
2. Задан файл с текстом, найти и вывести в консоль все слова,
для которых последняя буква одного слова совпадает с первой буквой следующего слова
 */
public class Task2 {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("resources/Input.txt"))) {
            StringBuilder stringBuilder;
            while (scanner.hasNext()) {
                stringBuilder = new StringBuilder(scanner.next());
                Task1.replacePunctuation(stringBuilder);
                if (Task1.isEmpty(stringBuilder)) {
                    continue;
                }
                arrayList.add(String.valueOf(stringBuilder));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for (int i = 0, size = arrayList.size() - 1; i < size; i++) {
            String firstString = arrayList.get(i);
            String secondString = arrayList.get(i + 1);
            if (firstString.toLowerCase().charAt(firstString.length() - 1) ==
                    secondString.toLowerCase().charAt(0)) {
                System.out.println(firstString + " " + secondString);
            }
        }
    }
}

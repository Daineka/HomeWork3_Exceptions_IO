package com.daineka.IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
1. Задан файл с текстом, найти и вывести в консоль все слова, начинающиеся с гласной буквы.
 */
public class Task1 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File("resources/Input.txt"))) {
            StringBuilder stringBuilder;
            while (scanner.hasNext()) {
                stringBuilder = new StringBuilder(scanner.next());
                replacePunctuation(stringBuilder);
                if (isEmpty(stringBuilder)) {
                    continue;
                }
                if (isStartVowel(stringBuilder)) {
                    System.out.println(stringBuilder);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public static void replacePunctuation(StringBuilder stringBuilder) {
        int index = 0;
        while (!Character.isLetter(stringBuilder.charAt(index))) {
            stringBuilder.deleteCharAt(index);
            if (isEmpty(stringBuilder)) {
                return;
            }
        }
        index = stringBuilder.length() - 1;
        while (!Character.isLetter(stringBuilder.charAt(index))) {
            stringBuilder.deleteCharAt(index);
            index--;
        }
    }

    public static boolean isEmpty(StringBuilder stringBuilder) {
        return stringBuilder == null || stringBuilder.isEmpty();
    }

    public static boolean isStartVowel(StringBuilder stringBuilder) {
        final String VOWELS = "aeuioуеэоаыяиюAEUIOУЕЭОАЫЯИЮ";
        return VOWELS.indexOf(stringBuilder.charAt(0)) != -1;
    }
}

package com.daineka.exceptions;

import java.util.Random;

/*
5. Создать метод случайным образом выбрасывающий одно из 3-х видов исключений.
Вызвать этот метод в блоке try-catch, отлавливающим любое из 3-х.
 */
public class Task5 {
    public static void main(String[] args) {
        try {
            throwRandomExceptions();
        } catch (ArrayIndexOutOfBoundsException | NullPointerException | ArrayStoreException e) {
            e.printStackTrace();
        }
    }

    static void throwRandomExceptions() {
        Random random = new Random();
        int i = random.nextInt(3);
        switch (i) {
            case 0:
                throw new ArrayIndexOutOfBoundsException();
            case 1:
                throw new NullPointerException();
            case 2:
                throw new ArrayStoreException();
        }
    }
}

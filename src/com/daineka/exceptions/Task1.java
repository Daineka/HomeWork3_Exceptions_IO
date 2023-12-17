package com.daineka.exceptions;

/*
1. Объявите ссылочную переменную со значением null.
Вызовите метод у этой переменной.
Отловить возникшее исключение c помощью блока try-catch.
 */

public class Task1 {
    public static void main(String[] args) {
        String s = null;
        try {
            s.length();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}

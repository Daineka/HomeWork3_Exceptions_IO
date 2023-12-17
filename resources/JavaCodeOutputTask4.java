package com.daineka.exceptions;

/*
3. Создать собственный класс-исключение - наследник класса Exception.
Создать метод, выбрасывающий это исключение.
Вызвать этот метод и отловить исключение.
Вывести stack trace в консоль.
 */
public class Task3 { private static void main(String[] args) {
        try {
            validateInput("");
        } catch (InvalidInputException e) {
            e.printStackTrace();
        }
    }

    private static void validateInput(String input) throws InvalidInputException {
        if (input == null || input.isEmpty()) {
            throw new InvalidInputException("Пустая строка.");
        }
    }
}

class InvalidInputException extends Exception { private InvalidInputException(String message) {
        super(message);
    }}

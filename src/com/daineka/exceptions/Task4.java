package com.daineka.exceptions;

/*
4. Бросить одно из существующих в JDK исключений,
отловить его и оберните его в свое кастомное исключение указав в качестве причины отловленное.
 */
public class Task4 {
    public static void main(String[] args) throws CustomException {
        try {
            throw new ArrayIndexOutOfBoundsException();
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new CustomException("Сообщение с описанием ошибки", e);
        }
    }
}

class CustomException extends Exception {
    public CustomException(String message, Exception e) {
        super(message, e);
    }
}

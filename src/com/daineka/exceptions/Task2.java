package com.daineka.exceptions;

/*
2. Написать код, который создаст, а затем отловит ArrayIndexOutOfBoundsException.
 */
public class Task2 {
    public static void main(String[] args) {
        int[] arrays = new int[0];
        try {
            arrays[0] = 1;
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }
}

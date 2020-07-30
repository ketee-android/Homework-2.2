package ru.geekbrains.java_core_level2;

public class MyArraySizeException extends RuntimeException {

    int i;
    int j;

    public MyArraySizeException(int i, int j) {
        super("Неверный размер массива. Создайте массив 4х4.");
        this.i = i;
        this.j = j;
    }
}

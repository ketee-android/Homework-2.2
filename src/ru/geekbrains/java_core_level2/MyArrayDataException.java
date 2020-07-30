package ru.geekbrains.java_core_level2;

public class MyArrayDataException extends RuntimeException {

    int i;
    int j;

    public MyArrayDataException(int i, int j) {
        super("Неверно введены данные в элемент массива, находящийся на пересечении строки " + i + " и столбца " + j + ".");
        this.i = i;
        this.j = j;
    }
}

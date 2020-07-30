// ДОМАШНЕЕ ЗАДАНИЕ:
//
//  1. Напишите метод, на вход которого подается двумерный строковый массив размером 4х4, при подаче массива другого
//     размера необходимо бросить исключение MyArraySizeException.
//
//  2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать. Если в каком-то
//     элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа), должно быть
//     брошено исключение MyArrayDataException – с детализацией, в какой именно ячейке лежат неверные данные.
//
//  3. В методе main() вызвать полученный метод, обработать возможные исключения MyArraySizeException и
//     MyArrayDataException и вывести результат расчета.

package ru.geekbrains.java_core_level2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int i;
        int j;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Создайте массив (допустимый размер - 4х4): ");
        System.out.print("Число строк i = ");
        i = scanner.nextInt();
        System.out.print("Число столбцов j = ");
        j = scanner.nextInt();

        String[][] arr = new String[i][j];
        try {
            buildArray(arr, scanner, i, j);
            System.out.println("\nСумма элементов массива равна " + arraySum(arr, i, j) + ".");
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }
    }

    private static void buildArray(String[][] arr, Scanner sc, int a, int b) {
        if (a != 4 || b != 4) throw new MyArraySizeException(a, b);
        System.out.println("\nВведите поочередно элементы строк массива через пробел (для начала новой строки нажмите Enter): ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = sc.next();
            }
        }
        arraySum(arr, a, b);
    }

    private static int arraySum(String[][] array, int a, int b) {
        int sum = 0;
        int[][] arr = new int[a][b];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    arr[i][j] = Integer.parseInt(array[i][j]);
                    sum += arr[i][j];
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return sum;
    }

}
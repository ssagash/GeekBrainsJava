package lesson2;

import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {

        int [] numbers = { 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 };
        changeNumbers(numbers);
        int a = 0;
        fillArray(a);
        int[] numbersTwo = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        findSix(numbersTwo);
        int [][] table = new int [ 10 ][ 10 ];
        fillsquare(table);
        minMax(numbersTwo);
        int [] numbersThree = { 2, 2, 2, 1, 2, 2, 10, 1};
        checkBalance(numbersThree);
        displacement(numbersTwo, -5);


    }

    //1. Задать целочисленный массив, состоящий из элементов 0 и
    //Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и
    //условия заменить 0 на 1, 1 на 0.
    public static void changeNumbers(int[] array) {
        int[] copyNumbers = array;
        System.out.println("Before " + Arrays.toString(copyNumbers));
        for (int i = 0; i < copyNumbers.length; i++) {
            if (copyNumbers[i] == 1) {
                copyNumbers[i] = 0;
            } else copyNumbers[i] = 1;
        }
        System.out.println("After  " + Arrays.toString(copyNumbers));
    }

    //2. Задать пустой целочисленный массив размером 8. С
    //помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21.
    public static void fillArray(int b) {
        int[] array = new int[8];
        for (int i = 0; i < array.length; i++) {
            array[i] = b;
            b = b + 3;
        }
        System.out.println(Arrays.toString(array));
    }

    //3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ], пройти по
    //нему циклом и числа меньшие 6 умножить на 2.
    public static void findSix(int[] array) {
        int[] copyNumbers = array;
        System.out.println("Before " + Arrays.toString(copyNumbers));
        for (int i = 0; i < copyNumbers.length; i++) {
            if (copyNumbers[i] < 6) {
                int c = copyNumbers[i] * 2;
                copyNumbers[i] = c;
            }
        }
        System.out.println("After  " + Arrays.toString(copyNumbers));
    }

    //4. Создать квадратный двумерный целочисленный массив
    //(количество строк и столбцов одинаковое) и с помощью цикла
    //(-ов) заполнить его диагональные элементы единицами.
    public static void fillsquare(int[][] tableArray) {
        int[][] table = tableArray;

        for (int i = 0; i < table.length; i++) {
            table[i][i] = 1;
            table[i][(table.length-1)-i] = 1;
            System.out.println(Arrays.toString(table[i]));
        }
    }

    //5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы
    // (без помощи интернета);
    public static void minMax(int[] array) {
        int min = array[0];
        for (int a : array) {
            if (a < min) {
                min = a;
            }
        }
        System.out.println("Min " + min);
        int max = array[0];
        for (int a : array) {
            if (a > max) {
                max = a;
            }
        }
        System.out.println("Max " + max);
    }

    //6. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
    //метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части
    //массива равны. Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, ||
    //2, 1]) → true, граница показана символами ||, эти символы в массив не входят.
    public static void checkBalance(int[] array) {
        int sum = 0;
        int sum2 = 0;
        label:
        for (int i = 0; i < array.length; i++) {
            sum = 0;
            for (int j = 0; j < i; j++) {
                sum = sum + array[j];
            }
            sum2 = 0;
            for (int j = i; j < array.length; j++) {
                sum2 = sum2 + array[j];
            }
            if (sum == sum2) {
                break label;
            }
        }
        if (sum == sum2) System.out.println("true");
        else System.out.println("false");
    }

    //7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть
    //положительным, или отрицательным), при этом метод должен сместить все элементы
    //массива на n позиций. Элементы смещаются циклично. Для усложнения задачи нельзя
    //пользоваться вспомогательными массивами. Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) ->
    //[ 3, 1, 2 ]; [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ]. При каком n в какую сторону сдвиг
    //можете выбирать сами.
    public static void displacement(int[] array, int n) {
        System.out.println("Before " + Arrays.toString(array));
        if (n > 0){
            for (int i = 0; i < n; i++) {
                int last = array[array.length - 1];
                for (int j = 1; j < array.length; j++) {
                    array[array.length - j] = array[(array.length - j) - 1];
                }
                array[0] = last;
            }
        }
        else {
            for (int i = 0; i > n; i--) {
                int first = array[0];
                for (int j = 0; j < (array.length - 1); j++) {
                    array[j] = array[j + 1];
                }
                array[array.length-1] = first;
            }
        }
        System.out.println("After " + Arrays.toString(array));
    }
}

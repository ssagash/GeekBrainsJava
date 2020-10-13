package lesson1;

import java.util.Scanner;

public class Task1 {
    //1. Создать пустой проект в IntelliJ IDEA и прописать метод main().
    public static void main(String[] args) {

        //2. Создать переменные всех пройденных типов данных и инициализировать их значения.
        byte a = 127;
        short b = 32_767;
        int c = 2_147_483_647;
        long d = 9_223_372_036_854_775_807L;
        float e = 2.23f;
        double f = -123.123;
        char g = '*';
        boolean h = false;

        System.out.println(calculation(a, b, c, d));
        findNumbers();
        positiveNumber();
        booleanNumber();
        yourName();
        leapYear();
    }

    //3. Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,
    //где a, b, c, d – входные параметры этого метода.
    public static long calculation(long a, long b, long c, long d){
        return a * (b + (c / d));
    }

    //4. Написать метод, принимающий на вход два числа и проверяющий,
    //что их сумма лежит в пределах от 10 до 20 (включительно),
    //если да – вернуть true, в противном случае – false.
    public static void findNumbers(){
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();
        int z = x + y;
        boolean bool = true;
        if (z >= 10 && z <= 20) System.out.println(bool);
        else System.out.println(!bool);
    }

    //5. Написать метод, которому в качестве параметра передается целое число,
    //метод должен напечатать в консоль положительное ли число передали,
    //или отрицательное; Замечание: ноль считаем положительным числом.
    public static void positiveNumber (){
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        if (x >= 0) System.out.println("Число положительное");
        else System.out.println("Число отрицательное");
    }

    //6. Написать метод, которому в качестве параметра передается целое число,
    //метод должен вернуть true, если число отрицательное;
    public static void booleanNumber(){
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        boolean bool = true;
        if (x >= 0) System.out.println(!bool);
        else System.out.println(bool);
    }

    //7. Написать метод, которому в качестве параметра передается строка,
    //обозначающая имя, метод должен вывести в консоль сообщение «Привет, указанное_имя!»;
    public static void yourName(){
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        System.out.println("Привет, " + name + "!");
    }

    //8. * Написать метод, который определяет является ли год високосным,
    //и выводит сообщение в консоль. Каждый 4-й год является високосным,
    //кроме каждого 100-го, при этом каждый 400-й – високосный.
    public static void leapYear(){
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        if (x%400 == 0) System.out.println("Этот год високостный");
        else if (x%4 == 0 && x%100 != 0) System.out.println("Этот год високостный");
        else System.out.println("Этот год НЕ високостный");
    }
}

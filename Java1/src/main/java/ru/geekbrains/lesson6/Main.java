package ru.geekbrains.lesson6;

public class Main {
    public static void main(String[] args) {
        //1. Создать классы Собака и Кот с наследованием от класса
        //Животное.
        Cat barsik = new Cat(200, 2, 0);
        Dog laika = new Dog(500,0.5,10);
        Dog raxa = new Dog(700,1,1);
        //4. При попытке животного выполнить одно из этих действий оно
        //должно сообщить результат в консоль. (Например,
        //dog1.run(150); -> результат: run: true).
        System.out.println(barsik.run(150));
        System.out.println(laika.swim(150));
        System.out.println(raxa.jump(2));


    }
}

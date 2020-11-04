package ru.geekbrains.lesson6;

public class Main {
    public static void main(String[] args) {

//        Cat barsik = new Cat(200, 2, 0);
//        Dog laika = new Dog(500, 0.5, 10);
//        Dog raxa = new Dog(700, 1, 1);
//
//        System.out.println(barsik.run(150));
//        System.out.println(laika.swim(150));
//        System.out.println(raxa.jump(2));

        //1. Расширить задачу про котов и тарелки с едой.
        //5. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и
        //потом вывести информацию о сытости котов в консоль.

        Cat cat1 = new Cat("Barsik", 20);
        Cat cat2 = new Cat("Somka", 10);
        Cat cat3 = new Cat("Tito", 5);
        Cat[] houseOfCats1 = {cat1, cat2, cat3};
        Plate plate1 = new Plate(15);
        for (Cat c:houseOfCats1) {
            System.out.println(c.getName());
            c.eat(plate1);
            plate1.info();

        }

        //6. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку.
        plate1.setFood(100);
        plate1.info();


    }
}

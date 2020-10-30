package ru.geekbrains.lesson6;

public class Dog extends Animal {

    Dog(int runDistance, double jumpDistance, int swimDistance) {
        super(runDistance, jumpDistance, swimDistance);
    }
    //3. У каждого животного есть ограничения на действия (бег: кот
    //200 м., собака 500 м.; прыжок: кот 2 м., собака 0.5 м.; плавание:
    //кот не умеет плавать, собака 10 м.).

    @Override
    public boolean swim(int d){
        return (d <= getSwimDistance());

    }
}

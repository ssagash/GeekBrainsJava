package ru.geekbrains.lesson6;

public class Dog extends Animal {

    Dog(int runDistance, double jumpDistance, int swimDistance) {
        super(runDistance, jumpDistance, swimDistance);
    }
    Dog(String name, int appetite){
        super(name, appetite);
    }
    @Override
    public boolean swim(int d){
        return (d <= getSwimDistance());

    }
}

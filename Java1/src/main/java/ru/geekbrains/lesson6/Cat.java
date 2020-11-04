package ru.geekbrains.lesson6;

public class Cat extends Animal{


    Cat(int runDistance, double jumpDistance, int swimDistance) {
        super(runDistance, jumpDistance, swimDistance);
    }
    Cat(String name, int appetite){
        super(name, appetite);
    }

}

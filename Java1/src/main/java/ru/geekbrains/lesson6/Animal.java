package ru.geekbrains.lesson6;

import javax.xml.namespace.QName;

public class Animal {

    private int runDistance;
    private double jumpDistance;
    private int swimDistance;
    private String name;
    private int appetite;
    private boolean fullness = false;

    public int getRunDistance() {
        return runDistance;
    }

    public double getJumpDistance() {
        return jumpDistance;
    }

    public int getSwimDistance() {
        return swimDistance;
    }

    public int getAppetite() {
        return appetite;
    }

    public String getName() {
        return name;
    }

    Animal(int runDistance, double jumpDistance, int swimDistance) {
        this.runDistance = runDistance;
        this.jumpDistance = jumpDistance;
        this.swimDistance = swimDistance;
    }

    Animal(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }


    public boolean run(int d) {
        return (d <= runDistance);
    }

    public boolean jump(double h) {
        return (h <= jumpDistance);
    }

    public boolean swim(int d) {
        return false;
    }

    //3. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту
    //удалось покушать (хватило еды), сытость = true.
    public void eat(Plate p) {
        if (p.decreaseFood(appetite)) fullness = true;
        System.out.println("Fullness: " + fullness);

    }

}

package ru.geekbrains.lesson6;

public class Animal {
    //2. Животные могут выполнять действия: бежать, плыть,
    //перепрыгивать препятствие. В качестве параметра каждому
    //методу передается величина, означающая или длину
    //препятствия (для бега и плавания), или высоту (для прыжков).
    private int runDistance;
    private double jumpDistance;
    private int swimDistance;

    public int getRunDistance(){
        return runDistance;
    }
    public double getJumpDistance(){
        return jumpDistance;
    }
    public int getSwimDistance(){
        return swimDistance;
    }

    Animal(int runDistance, double jumpDistance, int swimDistance){
        this.runDistance = runDistance;
        this.jumpDistance = jumpDistance;
        this.swimDistance = swimDistance;
    }


    public boolean run(int d){
        return (d <= runDistance);
    }

    public boolean jump(double h){
        return (h <= jumpDistance);
    }
    public boolean swim(int d){
        return false;
    }

}

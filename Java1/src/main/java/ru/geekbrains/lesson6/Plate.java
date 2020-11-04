package ru.geekbrains.lesson6;

public class Plate {
    private int food;

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public Plate(int food) {
        this.food = food;
    }

    public void info() {
        System.out.println("plate: " + food);
    }
    //2. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды
    //(например, в миске 10 еды, а кот пытается покушать 15-20).
    public boolean decreaseFood(int n) {
        if (n > food) {
            System.out.println("No food! Put more food ");
            return false;
        }
        else {
            food -= n;
            return true;
        }
    }
}

package ru.geekbrains.lesson5;

public class Employee {
    private String name;
    private String position;
    private String email;
    private int phone;
    private int salary;
    private int age;

    Employee(){
    }

    Employee(String name, String position, String email, int phone, int salary, int age){
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public String getName(){
        return this.name;
    }

    public String getPosition() {
        return this.position;
    }

    public String getEmail() {
        return this.email;
    }

    public int getPhone() {
        return this.phone;
    }

    public int getSalary() {
        return this.salary;
    }

    public int getAge() {
        return this.age;
    }

    public void info(){
        System.out.println(this.name +" "+ this.position +" "+ this.email +" "+
                this.phone +" "+ this.salary +" "+ this.age);
    }
}

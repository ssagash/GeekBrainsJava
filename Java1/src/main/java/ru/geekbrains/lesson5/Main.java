package ru.geekbrains.lesson5;

public class Main {
    public static void main(String[] args) {

        Employee[] empArray =  new Employee[5];
        empArray[0] = new Employee("Andre", "Director", "andre@mail.ru",
                81112233, 500000, 30);
        empArray[1] = new Employee("Sahar", "Engineer", "sahar@mail.ru",
                81110033, 30000, 50);
        empArray[2] = new Employee("Dodi", "Manager", "dodi@mail.ru",
                81113333, 200000, 62);
        empArray[3] = new Employee("Sandra", "IT", "sandra@mail.ru",
                81114433, 40000, 25);
        empArray[4] = new Employee("Cara", "Manager", "cara@mail.ru",
                81115533, 200000, 24);
        for (int i = 0; i < empArray.length; i++) {
            if (empArray[i].getAge() > 40) {
                empArray[i].info();
            }
        }

    }
}

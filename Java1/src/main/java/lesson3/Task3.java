package lesson3;

import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class Task3 {
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();

    public static void main(String[] args) {
        //* Создать массив из слов
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
                "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
                "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        //При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
        //сравнивает его с загаданным словом и сообщает, правильно ли ответил пользователь. Если
        //слово не угадано, компьютер показывает буквы, которые стоят на своих местах.
        //apple – загаданное
        //apricot - ответ игрока
        //ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
        //Для сравнения двух слов посимвольно можно пользоваться:
        //String str = "apple";
        //char a = str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
        //Играем до тех пор, пока игрок не отгадает слово.
        //Используем только маленькие буквы.

        int x = rand.nextInt(words.length);
        String randomWorld = words[x];
        //System.out.println(randomWorld);
        findWorld("Угадайте загаданное слово", randomWorld);
        findNumber("Угадайте загаданное число от 0 до 9");
    }

    public static void findWorld(String message, String x) {

        while (true) {

            System.out.println(message);
            String w = sc.nextLine();
            if (w.equals(x)) {
                System.out.println("Поздравляю Вы угадали");
                break;
            } else {
                int num = 15;
                char[] ch = new char[num];
                if (x.length() <= w.length()) {
                    for (int i = 0; i < x.length(); i++) {
                        if (x.charAt(i) == w.charAt(i)) {
                            ch[i] = w.charAt(i);
                        } else
                            ch[i] = '#';
                    }
                    for (int i = x.length() + 1; i < num; i++) {
                        ch[i] = '#';
                    }
                } else if (x.length() > w.length()) {
                    for (int i = 0; i < w.length(); i++) {
                        if (x.charAt(i) == w.charAt(i)) {
                            ch[i] = w.charAt(i);
                        } else
                            ch[i] = '#';
                    }
                    for (int i = w.length() + 1; i < num; i++) {
                        ch[i] = '#';
                    }
                }
                System.out.println(ch);
            }
        }
    }

    //Написать программу, которая загадывает случайное число от 0 до 9 и пользователю дается 3
    //попытки угадать это число. При каждой попытке компьютер должен сообщить, больше ли
    //указанное пользователем число, чем загаданное, или меньше. После победы или проигрыша
    //выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
    private static void findNumber(String message) {
        int attempt = 1;
        int rnd = rand.nextInt(10);
        System.out.println(message);
        label:
        while (true){
            //System.out.println(rnd);
            int num = sc.nextInt();
            if(num == rnd){
                System.out.println("Поздравляю Вы угадали");
                System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
                int yn = sc.nextInt();
                if(yn == 1) {
                    System.out.println(message);
                    rnd = rand.nextInt(10);
                    attempt = 1;
                }
                else if(yn == 0) break label;
            }
            else if(num > rnd && attempt < 3){
                System.out.println("Загаданное число меньше");
                attempt++;
            }
            else if(num < rnd && attempt < 3){
                System.out.println("Загаданное число больше");
                attempt++;
            }
            else {
                System.out.println("К сожалению Вы проиграли");
                System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
                int yn = sc.nextInt();
                if(yn == 1) {
                    System.out.println(message);
                    rnd = rand.nextInt(10);
                    attempt = 1;
                }
                else if(yn == 0) break label;
            }
        }
    }
}


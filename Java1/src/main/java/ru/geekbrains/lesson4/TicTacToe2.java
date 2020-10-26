package ru.geekbrains.lesson4;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe2 {
    //need human
    //need AI
    //need paper
    //pencil for writing dots
    private static Scanner human = new Scanner(System.in);
    private static Random aiComputer = new Random();
    private static char[][] paper;
    private static int paperSize = 7;
    private static char dotX = 'X';
    private static char dotO = 'O';
    private static char emptyDot = '.';
    private static int coordinatesX;
    private static int coordinatesY;
    private static int toWinDot = 3;

    //start game
    //write field on paper
    //human move
    //check answer
    //AI move
    //check win

    private static void initField(int s) {
        paper = new char[s][s];
        for (int i = 0; i < paper.length; i++) {
            for (int j = 0; j < paper.length; j++) {
                paper[i][j] = emptyDot;
            }
        }
    }

    private static void printField(char[][] ar) {
        System.out.print("#");
        for (int i = 1; i <= ar.length; i++) {
            System.out.print(" " + i);
        }
        System.out.println();

        for (int i = 0; i < ar.length; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < ar.length; j++) {
                System.out.print(" " + ar[i][j]);
            }
            System.out.println();
        }
        System.out.println("___________________________________");
    }

    private static void humanMove() {
        do {
            System.out.println("Введите координаты через пробел >>> ");
            coordinatesY = human.nextInt();
            coordinatesX = human.nextInt();
        } while (!validAnswer(coordinatesY, coordinatesX));
        paper[coordinatesY - 1][coordinatesX - 1] = dotX;
    }

    private static boolean validAnswer(int y, int x) {
        return (y < paperSize && x < paperSize && y >= 0 && x >= 0) && (paper[y][x] == emptyDot);
    }

    private static void aiMove() {
        do {
            coordinatesY = aiComputer.nextInt(paperSize);
            coordinatesX = aiComputer.nextInt(paperSize);
        } while (!validAnswer(coordinatesY, coordinatesX));
        paper[coordinatesY][coordinatesX] = dotO;

    }
//        label:
//        for (int i = 0; i < paper.length; i++) {
//            for (int j = 0; j < paper.length; j++) {
//                coordinatesY = i;
//                coordinatesX = j;
//                if(validAnswer(coordinatesY, coordinatesX) && aiBrain(dotX,dotO)){
//                    paper[coordinatesY][coordinatesX] = dotO;
//                    break label;
//                }
//                else {
//                    do {
//                        coordinatesY = aiComputer.nextInt(paperSize + 1);
//                        coordinatesX = aiComputer.nextInt(paperSize + 1);
//                    } while (!validAnswer(coordinatesY, coordinatesX));
//                    paper[coordinatesY - 1][coordinatesX - 1] = dotO;
//                }
//            }
//        }



    private static boolean checkWin(char s, char d, String msg) {
        int count = 0;
        // проверка по горизонтали
        for (int i = 0; i < paper.length; i++) {
            for (int j = 0; j < paper.length; j++) {
                if ((paper[i][j] == s) && (paper[i][j] != emptyDot) && (paper[i][j] != d)) count++;
                else if ((paper[i][j] == emptyDot) || (paper[i][j] == d)) count = 0;
                if (count == toWinDot) {
                    System.out.println(msg);
                    return true;
                }
            }
            count = 0;
        }
        //проверка по вертикали
        for (int i = 0; i < paper.length; i++) {
            for (int j = 0; j < paper.length; j++) {
                if ((paper[j][i] == s) && (paper[j][i] != emptyDot) && (paper[j][i] != d)) count++;
                else if ((paper[j][i] == emptyDot) || (paper[j][i] == d)) count = 0;
                if (count == toWinDot) {
                    System.out.println(msg);
                    return true;
                }
            }
            count = 0;
        }
        //проверка по диагонали слева на право
        int side = paperSize - toWinDot;
        for (int j = 0; j <= side; j++) {
            for (int i = 0; i < toWinDot + j; i++) {
                if ((paper[side - j + i][i] == s) && (paper[side - j + i][i] != emptyDot)
                        && (paper[side - j + i][i] != d)) count++;
                else if ((paper[side - j + i][i] == emptyDot) || (paper[side - j + i][i] == d)) count = 0;
                if (count == toWinDot) {
                    System.out.println(msg);
                    return true;
                }
            }
            if ((paperSize - j) > toWinDot) {
                for (int i = 0; i < paperSize - 1 - j; i++) {
                    if ((paper[j + i][1 + i] == s) && (paper[j + i][1 + i] != emptyDot)
                            && (paper[j + i][1 + i] != d)) count++;
                    else if ((paper[j + i][1 + i] == emptyDot) || (paper[j + i][1 + i] == d)) count = 0;
                    if (count == toWinDot) {
                        System.out.println(msg);
                        return true;
                    }
                }
            }
            count = 0;
        }
        //проверка по диагонали справо на лево
        for (int i = 0; i < paperSize - toWinDot + 1; i++) {
            int sideTwo = paperSize - toWinDot - i;
            for (int j = 0; j < toWinDot + i; j++) {
                if ((paper[paperSize - 1 - j][sideTwo + j] == s) && (paper[paperSize - 1 - j][sideTwo + j] != emptyDot)
                        && (paper[paperSize - 1 - j][sideTwo + j] != d)) count++;
                else if ((paper[paperSize - 1 - j][sideTwo + j] == emptyDot)
                        || (paper[paperSize - 1 - j][sideTwo + j] == d)) count = 0;
                if (count == toWinDot) {
                    System.out.println(msg);
                    return true;
                }
            }
            if ((paperSize - i) > toWinDot) {
                for (int j = 0; j < paperSize - 1 - i; j++) {
                    if ((paper[paperSize - 2 - j - i][j] == s) && (paper[paperSize - 2 - j - i][j] != emptyDot)
                            && (paper[paperSize - 2 - j - i][j] != d)) count++;
                    else if ((paper[paperSize - 2 - j - i][j] == emptyDot)
                            || (paper[paperSize - 2 - j - i][j] == d)) count = 0;
                    if (count == toWinDot) {
                        System.out.println(msg);
                        return true;
                    }
                }
            }

            count = 0;
        }

        return false;
    }

    private static boolean aiBrain(char s, char d) {
        int count = 0;
        // проверка по горизонтали
        for (int i = 0; i < paper.length; i++) {
            for (int j = 0; j < paper.length; j++) {
                if ((paper[i][j] == s) && (paper[i][j] != emptyDot) && (paper[i][j] != d)) count++;
                else if ((paper[i][j] == emptyDot) || (paper[i][j] == d)) count = 0;
                if (count == toWinDot - 1) {
                    return true;
                }
            }
            count = 0;
        }
        //проверка по вертикали
        for (int i = 0; i < paper.length; i++) {
            for (int j = 0; j < paper.length; j++) {
                if ((paper[j][i] == s) && (paper[j][i] != emptyDot) && (paper[j][i] != d)) count++;
                else if ((paper[j][i] == emptyDot) || (paper[j][i] == d)) count = 0;
                if (count == toWinDot - 1) {
                    return true;
                }
            }
            count = 0;
        }
        //проверка по диагонали слева на право
        int side = paperSize - toWinDot;
        for (int j = 0; j <= side; j++) {
            for (int i = 0; i < toWinDot + j; i++) {
                if ((paper[side - j + i][i] == s) && (paper[side - j + i][i] != emptyDot)
                        && (paper[side - j + i][i] != d)) count++;
                else if ((paper[side - j + i][i] == emptyDot) || (paper[side - j + i][i] == d)) count = 0;
                if (count == toWinDot - 1) {
                    return true;
                }
            }
            if ((paperSize - j) > toWinDot) {
                for (int i = 0; i < paperSize - 1 - j; i++) {
                    if ((paper[j + i][1 + i] == s) && (paper[j + i][1 + i] != emptyDot)
                            && (paper[j + i][1 + i] != d)) count++;
                    else if ((paper[j + i][1 + i] == emptyDot) || (paper[j + i][1 + i] == d)) count = 0;
                    if (count == toWinDot - 1) {
                        return true;
                    }
                }
            }
            count = 0;
        }
        //проверка по диагонали справо на лево
        for (int i = 0; i < paperSize - toWinDot + 1; i++) {
            int sideTwo = paperSize - toWinDot - i;
            for (int j = 0; j < toWinDot + i; j++) {
                if ((paper[paperSize - 1 - j][sideTwo + j] == s) && (paper[paperSize - 1 - j][sideTwo + j] != emptyDot)
                        && (paper[paperSize - 1 - j][sideTwo + j] != d)) count++;
                else if ((paper[paperSize - 1 - j][sideTwo + j] == emptyDot)
                        || (paper[paperSize - 1 - j][sideTwo + j] == d)) count = 0;
                if (count == toWinDot - 1) {
                    return true;
                }
            }
            if ((paperSize - i) > toWinDot) {
                for (int j = 0; j < paperSize - 1 - i; j++) {
                    if ((paper[paperSize - 2 - j - i][j] == s) && (paper[paperSize - 2 - j - i][j] != emptyDot)
                            && (paper[paperSize - 2 - j - i][j] != d)) count++;
                    else if ((paper[paperSize - 2 - j - i][j] == emptyDot)
                            || (paper[paperSize - 2 - j - i][j] == d)) count = 0;
                    if (count == toWinDot - 1) {
                        return true;
                    }
                }
            }

            count = 0;
        }

        return false;
    }

    public static void main(String[] args) {
        initField(paperSize);
        printField(paper);

        while (true) {
            humanMove();
            printField(paper);
            if (checkWin(dotX, dotO, "You are a WINNER")) break;

            aiMove();
            printField(paper);
            if (checkWin(dotO, dotX, "You are a LOSER")) break;
        }
    }
}

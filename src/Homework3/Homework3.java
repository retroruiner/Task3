package Homework3;

import java.util.Random;
import java.util.Scanner;

public class Homework3 {
    //first task
    public static int randomize = randomRange(10);
    public static boolean stop = false;
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Угадайте загаданное число:");
        Random rand = new Random();
        randomize = rand.nextInt(10);
//        System.out.println(randomize);
        int attemts = 0;

        while (!stop) {
            int userNum = scanner.nextInt();
            if (userNum > randomize) {
                System.out.println("Набранное число больше загаданного");
                attemts++;
            } else if (userNum < randomize) {
                System.out.println("Набранное число меньше загаданного");
                attemts++;
            } else {
                attemts = 0;
                winOrLose(true);
            }

            if (attemts >= 3) {
                attemts = 0;
                winOrLose(false);
            }
        }
        System.out.println();

        //second task
        String[] words = {"apple", "orange", "lemon", "banana", "apricot",
                "avocado", "broccoli", "carrot", "cherry", "garlic",
                "grape", "melon", "leak", "kiwi", "mango", "mushroom",
                "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple",
                "pumpkin", "potato"};

        randomize = randomRange(words.length);
//        System.out.println(words[randomize]);
        char[] randomWord = words[randomize].toCharArray();
        char[] encoded = new char[randomWord.length];
        Scanner wordScan = new Scanner(System.in);

        for (int i = 0; i < randomWord.length; i++) {
            encoded[i] = '#';
        }

        while (true) {
            System.out.println("Угадайте слово");
            String userWord = wordScan.nextLine();
            if (userWord.equals(words[randomize])) {
                System.out.println("Вы угадали слово");
                break;
            } else {
                System.out.println("Вы не угадали слово");

                char[] userChar = userWord.toCharArray();

                for (int i = 0; i < randomWord.length; i++) {
                    if (i >= userChar.length) {
                        break;
                    }
                    if (randomWord[i] == userChar[i]) {
                        encoded[i] = randomWord[i];
                    }
                }
                String encoChar = new String(encoded);
                System.out.println(encoChar + "##########");
            }
        }
    }

    //make random number
    public static int randomRange(int range) {
        Random rand = new Random();
        return rand.nextInt(range);
    }

    //checks if the number is guessed
    public static void winOrLose(boolean win) {
        if (win) {
            System.out.println("Вы выиграли");
        } else {
            System.out.println("Вы проиграли");
        }
        System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");

        int choice = scanner.nextInt();
        if (choice == 1) {
            randomize = randomRange(10);
            System.out.println("Угадайте загаданное число:");
//            System.out.println(randomize);
        } else {
            stop = true;
        }
    }
}
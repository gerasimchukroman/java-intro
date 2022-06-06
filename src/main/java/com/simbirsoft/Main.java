package com.simbirsoft;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        System.out.println("Привет, мой друг! Это симулятор жучка !");
        System.out.println("Жизнь жучка интересна и занимательна!");
        AdultBug adultBug = new AdultBug(290, 100, 100);
        LarvaBug larvaBug = new LarvaBug(0, 100, 100);


        while (true) {
            System.out.println("Выберете персонажа: ");
            System.out.println("1 - Червячок");
            System.out.println("2 - Жучок");
            System.out.println("3 - Выход");
            Scanner scanner = new Scanner(System.in);
            int command = scanner.nextInt();
            if (command == 1) {
                larvaBug.bugSelector();

            } else if (command == 2) {
                adultBug.bugSelector();
            } else if (command == 3) {
                System.out.println("Вы вышли из симулятора!");
                break;
            } else {
                System.out.println("Неизвестная команда");
            }
        }
    }
}



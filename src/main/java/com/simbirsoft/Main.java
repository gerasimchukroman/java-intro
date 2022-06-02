package com.simbirsoft;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        System.out.println("Привет, мой друг! Это симулятор жучка !");
        System.out.println("Жизнь жучка интересна и занимательна!");
        Bug bug = new Bug(290,100,100);
        while (true) {
            System.out.println(" ");
            System.out.println("Выберите действие: ");
            System.out.println(" ");
            System.out.println("1 - Покушать");
            System.out.println("2 - Поразмножаться");
            System.out.println("3 - Подраться с сородичем");
            System.out.println("4 - Поспать");
            System.out.println("5 - Текущее состояние жучка");
            System.out.println("0 - Выход из симулятора");
            Scanner scanner = new Scanner(System.in);
            int command = scanner.nextInt();
            if (command == 1) {
                bug.eatFood();
            }
            else if (command == 2){
                bug.reproductionBug();
            }
            else if (command == 3){
                bug.bugFight();
            }
            else if (command ==4){
                bug.bugSleep();
            }
            else if (command == 5){
                bug.bugNow();
            }
            else if (command == 0) {
                bug.bugExit();
                break;
            }
            else {
                System.out.println("Неизвестная команда. Попробуйте еще разочек.");
            }
        }
    }
}

package com.simbirsoft;

import java.util.Random;
import java.util.Scanner;

public class LarvaBug extends Bug {

    private int larvaExp;
    private int larvaXp;
    private int larvaStamina;

    public int getLarvaExp() {
        return larvaExp;
    }

    public int getLarvaXp() {
        return larvaXp;
    }

    public int getLarvaStamina() {
        return larvaStamina;
    }

    public LarvaBug(int larvaExp, int larvaXp, int larvaStamina) {
        this.larvaExp = larvaExp;
        this.larvaXp = larvaXp;
        this.larvaStamina = larvaStamina;
    }

    @Override
    public void eatFood() {
        System.out.println("Еда восстанавливает здоровье и дает опыт");
        System.out.println("Выберите еду: ");
        System.out.println();
        System.out.println("1 - Овсянка ");
        System.out.println("2 - Хлебушек");
        System.out.println("3 - Огуречик");
        Scanner scanner = new Scanner(System.in);
        int foodCommand = scanner.nextInt();
        if (foodCommand == 1) {
            larvaExp = larvaExp + 10;
            larvaXp = larvaXp + 5;
            if (larvaXp >= 100) {
                larvaXp = 100;
                System.out.println("Вы съели овсянку. Вы получили 10 опыта. Ваше здоровье полное и равно 100 хр. ");

            } else {
                System.out.println("Вы съели овсянку. Вы получили 10 опыта. Ваше здоровье пополнилось на +5 хр");
            }
        } else if (foodCommand == 2) {
            larvaExp = larvaExp + 15;
            larvaXp = larvaXp + 6;
            if (larvaXp >= 100) {
                larvaXp = 100;
                System.out.println("Вы съели хлебушек. Вы получили 15 опыта. Ваше здоровье полное и равно 100 хр. ");

            } else {
                System.out.println("Вы съели хлебушек. Вы получили 15 опыта. Ваше здоровье пополнилось на +6 хр");
            }
        } else if (foodCommand == 3) {
            larvaExp = larvaExp + 20;
            larvaXp = larvaXp + 7;
            if (larvaXp >= 100) {
                larvaXp = 100;
                System.out.println("Вы съели огуречик. Вы получили 20 опыта. Ваше здоровье полное и равно 100 хр. ");
            } else {
                System.out.println("Вы съели огуречик. Вы получили 20 опыта. Ваше здоровье пополнилось на +7 хр");
            }
        } else {
            System.out.println("Неизвестная команда");
        }
    }

    @Override
    public void bugFight() {
        System.out.println();
        if (larvaStamina > 50) {
            System.out.println("Вы затеяли драку с сородичем");
            System.out.println("Да начнется бой!");
            while (larvaStamina >= 50 & larvaXp >= 50) {
                System.out.println("Выберите чем будете атаковать ");
                System.out.println("");
                System.out.println("1 - Брюшком");
                System.out.println("2 - Ногой");
                System.out.println("3 - Укусить");
                System.out.println("4 - Прекратить драку");
                Scanner scanner = new Scanner(System.in);
                int command = scanner.nextInt();
                if (command == 1) {
                    System.out.println("");
                    System.out.println("Вы атаковали брюшком");
                    boolean defenderEnemy = new Random().nextBoolean();

                    if (!defenderEnemy) {
                        larvaXp = larvaXp - 30;
                        larvaStamina = larvaStamina - 15;
                        System.out.println("");
                        System.out.println("Враг отзащищался.Ваша атака отбита");
                        System.out.println("Вы теряете -30 хр и -15 стамины");

                    } else {
                        larvaStamina = larvaStamina - 10;
                        larvaExp = larvaExp + 25;
                        System.out.println("");
                        System.out.println("Есть попадание!");
                        System.out.println("Вы ударили жука брюхом и нанесли урон врагу");
                        System.out.println("Вы теряете -10 стамины и получаете 25 опыта");
                    }
                } else if (command == 2) {
                    larvaExp = larvaExp - 20;
                    System.out.println("");
                    System.out.println("Вы атаковали ногой!");
                    System.out.println("Эй! Червячок! У тебя нет ног!");
                    System.out.println("Вы потеряли - 20 хр");
                } else if (command == 3) {
                    System.out.println("");
                    System.out.println("Вы укусили врага");
                    boolean defenderEnemy = new Random().nextBoolean();
                    if (!defenderEnemy) {
                        larvaXp = larvaXp - 30;
                        larvaStamina = larvaStamina - 15;
                        System.out.println("");
                        System.out.println("Враг отзащищался.Ваша атака отбита");
                        System.out.println("Вы теряете -30 хр и -15 стамины");
                    } else {
                        larvaStamina = larvaStamina - 10;
                        larvaExp = larvaExp + 35;
                        System.out.println("");
                        System.out.println("Есть попадание!");
                        System.out.println("Вы укусили врага острыми зубками и нанесли урон врагу");
                        System.out.println("Вы теряете - 10 стамины и получаете 35 опыта");
                    }
                } else if (command == 4) {
                    System.out.println("");
                    System.out.println("Хватит насилия! Вы выходите из ожесточенной битвы!");
                    break;
                } else {
                    System.out.println("Неизвестная команда, попробуйте снова");
                }
            }
        }
        if (larvaXp < 50) {
            System.out.println("Ваше хp меньше 50, необходимо восстановить его");
        } else if (larvaStamina < 50) {
            System.out.println("Ваша стамина меньше 50, необходимо восстановить ее");
        }
    }

    @Override
    public void bugSleep() {
        System.out.println("Сон восстанавливает стамину, но не проспите самое важное");
        System.out.println("Выберите сколько будете спать:");
        System.out.println("");
        System.out.println("1 - 30 секунд");
        System.out.println("2 - 60 секунд");
        System.out.println("3 - 1 час");
        Scanner scanner = new Scanner(System.in);
        int command = scanner.nextInt();
        if (command == 1) {
            larvaStamina = larvaStamina + 10;
            System.out.println("Вы поспали 30 секунд, стамина восстановлена на 10");
            if (larvaStamina >= 100) {
                larvaStamina = 100;
                System.out.println("Ваша стамина полностью восстановлена");
            }

        } else if (command == 2) {
            larvaStamina = larvaStamina + 30;
            System.out.println("Вы поспали 60 секунд, стамина восстановлена на 30");
            if (larvaStamina >= 100) {
                larvaStamina = 100;
                System.out.println("Ваша стамина полностью восстановлена");
            }
        } else if (command == 3) {
            larvaStamina = 100;
            larvaXp = larvaXp - 20;
            System.out.println("Вы поспали один час,стамина полностью восстановлена!");
            System.out.println("Но за это время вы сильно проголодались! ХР убавилось на 20");
        } else {
            System.out.println("Неизвестная команда");
        }
    }

    @Override
    public void bugNow() {
        System.out.println("Текущее состояние червячка: ");
        System.out.println("Очков опыта: " + getLarvaExp());
        System.out.println("(При количестве опыта равном 100, можно превратиться в жучка)");
        System.out.println("Состояние здоровья: " + getLarvaXp() + " XP.");
        System.out.println("Cостояние стамины: " + getLarvaStamina() + ".");

    }

    @Override
    public void bugExit() {
        System.out.println("Вы вышли в главное меню. Ваш прогресс сохранен.");
    }

    public void larvaShadow() {
        System.out.println("Вы решили спрятаться от опасности. Стамина уменьшилась на -20, здоровье полностью восстановлено.");
        System.out.println("Вы получили 5 опыта.");
        larvaXp = 100;
        larvaStamina = larvaStamina - 20;
        larvaExp = larvaExp + 5;
    }

    public void transformationToAdultBug() {
        if (larvaExp >= 100) {
            System.out.println("Вы превращаетесь в жука!");
            AdultBug adultBug = new AdultBug(290, 100, 100);
            adultBug.bugSelector();
        } else {
            System.out.println("У вас недостаточно опыта для превращения, необходимо 100 очков опыта.");
        }
    }

    @Override
    public void bugSelector() {
        while (true) {
            System.out.println("Вы играете за червячка. Помните, с накоплением опыта червячок может превратиться в жучка.");
            System.out.println(" ");
            System.out.println("Выберите действие: ");
            System.out.println(" ");
            System.out.println("1 - Покушать");
            System.out.println("2 - Спрятаться");
            System.out.println("3 - Подраться с сородичем");
            System.out.println("4 - Поспать");
            System.out.println("5 - Текущее состояние червячка");
            System.out.println("6 - Превратиться в жучка");
            System.out.println("0 - Выход в меню");
            Scanner scanner = new Scanner(System.in);
            int command = scanner.nextInt();
            if (command == 1) {
                eatFood();
            } else if (command == 2) {
                larvaShadow();
            } else if (command == 3) {
                bugFight();
            } else if (command == 4) {
                bugSleep();
            } else if (command == 5) {
                bugNow();
            } else if (command == 6) {
                transformationToAdultBug();
            } else if (command == 0) {
                bugExit();
                break;
            } else {
                System.out.println("Неизвестная команда. Попробуйте еще разочек.");
            }
        }
    }
}

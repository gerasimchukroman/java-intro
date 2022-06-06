package com.simbirsoft;

import java.util.Random;
import java.util.Scanner;

public class AdultBug extends Bug {

    private int bugCount;
    private int bugXp;
    private int bugStamina;

    public int getBugCount() {
        return bugCount;
    }

    public int getBugXp() {
        return bugXp;
    }

    public int getBugStamina() {
        return bugStamina;
    }

    public AdultBug(int bugCount, int bugXp, int bugStamina) {
        this.bugCount = bugCount;
        this.bugXp = bugXp;
        this.bugStamina = bugStamina;
    }

    @Override

    public void eatFood() {
        System.out.println("Еда восстанавливает здоровье");
        System.out.println("Выберите еду: ");
        System.out.println();
        System.out.println("1 - Овсянка ");
        System.out.println("2 - Хлебушек");
        System.out.println("3 - Огуречик");
        Scanner scanner = new Scanner(System.in);
        int foodCommand = scanner.nextInt();
        if (foodCommand == 1) {
            bugXp = bugXp + 3;
            if (bugXp >= 100) {
                bugXp = 100;
                System.out.println("Вы съели овсянку. Ваше здоровье полное и равно 100 хр");
            } else {
                System.out.println("Вы съели овсянку. Ваше здоровье пополнилось на +3 хр");
                System.out.println("Текущее значение: " + bugXp);
            }
        } else if (foodCommand == 2) {
            bugXp = bugXp + 4;
            if (bugXp >= 100) {
                bugXp = 100;
                System.out.println("Вы съели хлебушек. Ваше здоровье полное и равно 100 хр");
            } else {
                System.out.println("Вы съели хлебушек. Ваше здоровье пополнилось на +4 хр");
                System.out.println("Текущее значение: " + bugXp);
            }
        } else if (foodCommand == 3) {
            bugXp = bugXp + 5;
            if (bugXp >= 100) {
                bugXp = 100;
                System.out.println("Вы съели огуречик. Ваше здоровье полное и равно 100 хр");
            } else {
                System.out.println("Вы съели огуречик. Ваше здоровье пополнилось на +5 хр");
                System.out.println("Текущее значение: " + bugXp);
            }
        } else {
            System.out.println("Неизвестная команда");
        }
    }

    public void reproductionBug() {
        while (bugStamina >= 50) {
            bugStamina = bugStamina - 10;
            bugCount = bugCount + 2;
            System.out.println("Вы родили новых жучков");
            System.out.println("Количество жучков увеличилось на 2");
            System.out.println("Стамина уменьшилась на - 10");
            if (bugCount > 300) {
                bugCount = bugCount - 2;
                bugXp = 100;
                bugStamina = bugStamina / 2;
                System.out.println();
                System.out.println("Количество жучков привысило допустимый лимит");
                System.out.println("Поэтому вам пришлось съесть двух своих сородичей");
                System.out.println("Здоровье полностью восстановлено, но стамина упала вдвое");
            }
            break;
        }
        if (bugStamina < 50) {
            System.out.println("Ваша стамина меньше 50, необходимо пополнить силы.");
        }
    }

    @Override
    public void bugFight() {
        System.out.println();
        if (bugStamina > 50) {
            System.out.println("Вы затеяли драку с сородичем");
            System.out.println("Да начнется бой!");
            while (bugStamina >= 50 & bugXp >= 50) {
                System.out.println("Выберите чем будете атаковать ");
                System.out.println("");
                System.out.println("1 - Ногой");
                System.out.println("2 - Рукой");
                System.out.println("3 - Укусить");
                System.out.println("4 - Прекратить драку");
                Scanner scanner = new Scanner(System.in);
                int command = scanner.nextInt();
                if (command == 1) {
                    System.out.println("");
                    System.out.println("Вы атаковали ногой");
                    boolean defenderEnemy = new Random().nextBoolean();

                    if (!defenderEnemy) {
                        bugXp = bugXp - 5;
                        bugStamina = bugStamina - 5;
                        System.out.println("");
                        System.out.println("Враг отзащищался.Ваша атака отбита");
                        System.out.println("Вы теряете -5 хр и -5 стамины");

                    } else {
                        bugStamina = bugStamina - 5;
                        System.out.println("");
                        System.out.println("Есть попадание!");
                        System.out.println("Вы ударили жука ногой и нанесли урон врагу");
                        System.out.println("Вы теряете - 5 стамины");
                    }
                } else if (command == 2) {
                    bugXp = bugXp - 10;
                    System.out.println("");
                    System.out.println("Вы атаковали рукой!");
                    System.out.println("Эй! Жучок! У тебя нет рук!");
                    System.out.println("Вы потеряли - 10 хр");
                } else if (command == 3) {
                    System.out.println("");
                    System.out.println("Вы укусили врага");
                    boolean defenderEnemy = new Random().nextBoolean();
                    if (!defenderEnemy) {
                        bugXp = bugXp - 10;
                        bugStamina = bugStamina - 10;
                        System.out.println("");
                        System.out.println("Враг отзащищался.Ваша атака отбита");
                        System.out.println("Вы теряете -10 хр и -10 стамины");
                    } else {
                        bugStamina = bugStamina - 10;
                        System.out.println("");
                        System.out.println("Есть попадание!");
                        System.out.println("Вы укусили врага мощными жвалами и нанесли урон врагу");
                        System.out.println("Вы теряете - 10 стамины");
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
        if (bugXp < 50) {
            System.out.println("Ваше хp меньше 50, необходимо восстановить его");
        } else if (bugStamina < 50) {
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
            bugStamina = bugStamina + 10;
            System.out.println("Вы поспали 30 секунд, стамина восстановлена на 10");
            if (bugStamina >= 100) {
                System.out.println("Ваша стамина полностью восстановлена");
            }

        } else if (command == 2) {
            bugStamina = bugStamina + 30;
            System.out.println("Вы поспали 60 секунд, стамина восстановлена на 30");
            if (bugStamina >= 100) {
                System.out.println("Ваша стамина полностью восстановлена");
            }
        } else if (command == 3) {
            bugStamina = 100;
            bugXp = bugXp - 20;
            System.out.println("Вы поспали один час,стамина полностью восстановлена!");
            System.out.println("Но за это время вы сильно проголодались! ХР убавилось на 20");
        } else {
            System.out.println("Неизвестная команда");
        }
    }

    @Override
    public void bugNow() {
        System.out.println("Текущее состояние жучка: ");
        System.out.println("Количество жучков в общине: " + getBugCount() + " жучков.");
        System.out.println("Состояние здоровья: " + getBugXp() + " XP.");
        System.out.println("Cостояние стамины: " + getBugStamina() + ".");

    }

    @Override
    public void bugExit() {
        System.out.println("Вы вышли в главное меню. Ваш прогресс сохранен.");
    }

    @Override
    public void bugSelector() {
        while (true) {
            System.out.println("Вы играете за жучка");
            System.out.println(" ");
            System.out.println("Выберите действие: ");
            System.out.println(" ");
            System.out.println("1 - Покушать");
            System.out.println("2 - Поразмножаться");
            System.out.println("3 - Подраться с сородичем");
            System.out.println("4 - Поспать");
            System.out.println("5 - Текущее состояние жучка");
            System.out.println("0 - Выйти в меню");
            Scanner scanner = new Scanner(System.in);
            int command = scanner.nextInt();
            if (command == 1) {
                eatFood();
            } else if (command == 2) {
                reproductionBug();
            } else if (command == 3) {
                bugFight();
            } else if (command == 4) {
                bugSleep();
            } else if (command == 5) {
                bugNow();
            } else if (command == 0) {
                bugExit();
                break;
            } else {
                System.out.println("Неизвестная команда. Попробуйте еще разочек.");
            }
        }
    }
}


package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static DinnerConstructor dc;
    static Scanner scanner;

    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String command = scanner.nextLine();


            switch (command) {
                case "1":
                    addNewDish();
                    break;
                case "2":
                    generateDishCombo();
                    break;
                case "3":
                    System.out.println("Всего доброго!");
                    return;
                default:
                    System.out.println("Введена неверная команда");
            }

        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }

    private static void addNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();
        dc.addDish(dishType, dishName);

        // добавьте новое блюдо
    }

    private static void generateDishCombo() {
        System.out.println("Начинаем конструировать обед...");
        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");
        String nextItem = scanner.nextLine();
        ArrayList<String> typesInCombo = new ArrayList<>();
        //реализуйте ввод типов блюд

        while (!nextItem.isEmpty()) {

            if (dc.checkDishType(nextItem)) {
                typesInCombo.add(nextItem);
            } else {
                System.out.println("Такого типа блюд нет в списке");
                System.out.println("Введите тип блюда из списка:");
                System.out.println(dc.dishes.keySet());
            }
            nextItem = scanner.nextLine();
        }

        ArrayList<ArrayList<String>> combos = dc.generateCombos(numberOfCombos, typesInCombo);
        for (int i = 0; i < numberOfCombos; i++) {
            System.out.println(STR."Комбо \{i + 1}");
            System.out.println(combos.get(i));
        }
    }
}










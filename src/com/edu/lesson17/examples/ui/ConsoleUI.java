package com.edu.lesson17.examples.ui;

import com.edu.lesson17.examples.manager.CoffeeShopManager;
import com.edu.lesson17.examples.machine.CoffeeMachine;
import com.edu.lesson17.examples.coffee.Drink;

import java.util.Scanner;

public class ConsoleUI {
    private CoffeeShopManager manager;
    private Scanner scanner;

    public ConsoleUI(CoffeeShopManager manager) {
        this.manager = manager;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1. Добавить кофемашину");
            System.out.println("2. Удалить кофемашину");
            System.out.println("3. Пополнить ресурсы кофемашины");
            System.out.println("4. Просмотреть состояние кофемашины");
            System.out.println("5. Приготовить напиток");
            System.out.println("6. Вывести список кофемашин");
            System.out.println("7. Выйти");
            System.out.print("Выберите действие: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addCoffeeMachine();
                case 2 -> removeCoffeeMachine();
                case 3 -> refillCoffeeMachine();
                case 4 -> checkCoffeeMachine();
                case 5 -> makeDrink();
                case 6 -> listMachines();
                case 7 -> exitProgram();
                default -> System.out.println("Неверный выбор, попробуйте снова.");
            }
        }
    }

    private void addCoffeeMachine() {
        System.out.print("Введите название новой кофемашины: ");
        String name = scanner.nextLine();
        manager.addMachine(new CoffeeMachine(name, 500, 500, 500));
        System.out.println("Кофемашина " + name + " добавлена.");
    }

    private void removeCoffeeMachine() {
        System.out.print("Введите название кофемашины для удаления: ");
        String name = scanner.nextLine();
        if (manager.removeMachine(name)) {
            System.out.println("Кофемашина " + name + " удалена.");
        } else {
            System.out.println("Кофемашина " + name + " не найдена.");
        }
    }

    private void refillCoffeeMachine() {
        System.out.print("Введите название кофемашины: ");
        String name = scanner.nextLine();
        CoffeeMachine machine = manager.findMachine(name);
        if (machine != null) {
            System.out.print("Введите количество воды: ");
            int water = scanner.nextInt();
            System.out.print("Введите количество молока: ");
            int milk = scanner.nextInt();
            System.out.print("Введите количество кофе: ");
            int coffee = scanner.nextInt();
            scanner.nextLine();
            machine.refill(water, milk, coffee);
            System.out.println("Ресурсы пополнены.");
        } else {
            System.out.println("Кофемашина не найдена.");
        }
    }

    private void checkCoffeeMachine() {
        System.out.print("Введите название кофемашины: ");
        String name = scanner.nextLine();
        CoffeeMachine machine = manager.findMachine(name);
        if (machine != null) {
            System.out.println(machine.getResourceStatus());
        } else {
            System.out.println("Кофемашина не найдена.");
        }
    }

    private void makeDrink() {
        System.out.print("Введите название кофемашины: ");
        String name = scanner.nextLine();
        CoffeeMachine machine = manager.findMachine(name);
        if (machine != null) {
            System.out.print("Выберите напиток (эспрессо/капучино): ");
            String drinkName = scanner.nextLine();
            Drink drink = drinkName.equalsIgnoreCase("капучино") ?
                    new Drink("Капучино", 100, 100, 50) :
                    new Drink("Эспрессо", 50, 0, 50);

            if (machine.makeDrink(drink)) {
                System.out.println("Напиток " + drink.getName() + " приготовлен.");
            } else {
                System.out.println("Недостаточно ресурсов.");
            }
        } else {
            System.out.println("Кофемашина не найдена.");
        }
    }

    private void listMachines() {
        System.out.println(manager.getMachineList());
    }

    private void exitProgram() {
        System.out.println("Выход из программы.");
        scanner.close();
        System.exit(0);
    }
}

package com.edu.lesson17.examples;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		CoffeeShopManager manager = new CoffeeShopManager();

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
			case 1:
				System.out.print("Введите название новой кофемашины: ");
				String name = scanner.nextLine();
				manager.addMachine(new CoffeeMachine(name, 500, 500, 500));
				break;

			case 2:
				System.out.print("Введите название кофемашины для удаления: ");
				String removeName = scanner.nextLine();
				manager.removeMachine(removeName);
				break;

			case 3:
				System.out.print("Введите название кофемашины: ");
				String refillName = scanner.nextLine();
				CoffeeMachine refillMachine = manager.findMachine(refillName);
				if (refillMachine != null) {
					System.out.print("Введите количество воды: ");
					int water = scanner.nextInt();
					System.out.print("Введите количество молока: ");
					int milk = scanner.nextInt();
					System.out.print("Введите количество кофе: ");
					int coffee = scanner.nextInt();
					scanner.nextLine();
					refillMachine.refill(water, milk, coffee);
				} else {
					System.out.println("Кофемашина не найдена.");
				}
				break;

			case 4:
				System.out.print("Введите название кофемашины: ");
				String machineCheckName = scanner.nextLine();
				CoffeeMachine machineCheck = manager.findMachine(machineCheckName);
				if (machineCheck != null) {
					machineCheck.showResources();
				} else {
					System.out.println("Кофемашина не найдена.");
				}
				break;

			case 5:
				System.out.print("Введите название кофемашины: ");
				String machineName = scanner.nextLine();
				CoffeeMachine machine = manager.findMachine(machineName);
				if (machine != null) {
					System.out.print("Выберите напиток (эспрессо/капучино): ");
					String drinkName = scanner.nextLine();
					Drink drink = drinkName.equalsIgnoreCase("капучино") ? new Drink("Капучино", 100, 100, 50)
							: new Drink("Эспрессо", 50, 0, 50);

					machine.makeDrink(drink);
				} else {
					System.out.println("Кофемашина не найдена.");
				}
				break;

			case 6:
				manager.listMachines();
				break;

			case 7:
				System.out.println("Выход из программы.");
				return;

			default:
				System.out.println("Неверный выбор, попробуйте снова.");
				scanner.close();
			}
		}
	}
}

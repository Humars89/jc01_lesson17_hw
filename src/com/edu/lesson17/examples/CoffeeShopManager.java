package com.edu.lesson17.examples;
import java.util.ArrayList;
import java.util.List;

public class CoffeeShopManager {
    private List<CoffeeMachine> machines = new ArrayList<>();

    public void addMachine(CoffeeMachine machine) {
        machines.add(machine);
        System.out.println("Кофемашина " + machine.getName() + " добавлена.");
    }

    public void removeMachine(String name) {
        machines.removeIf(machine -> machine.getName().equalsIgnoreCase(name));
        System.out.println("Кофемашина " + name + " удалена.");
    }

    public CoffeeMachine findMachine(String name) {
        return machines.stream()
                .filter(machine -> machine.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    public void listMachines() {
        if (machines.isEmpty()) {
            System.out.println("Нет доступных кофемашин.");
        } else {
            System.out.println("Список кофемашин:");
            for (CoffeeMachine machine : machines) {
                System.out.println("- " + machine.getName());
            }
        }
    }
}



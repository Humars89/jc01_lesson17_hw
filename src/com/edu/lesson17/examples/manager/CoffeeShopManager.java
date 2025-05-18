package com.edu.lesson17.examples.manager;

import com.edu.lesson17.examples.machine.CoffeeMachine;
import java.util.ArrayList;
import java.util.List;

public class CoffeeShopManager {
    private final List<CoffeeMachine> machines = new ArrayList<>();

    public void addMachine(CoffeeMachine machine) {
        machines.add(machine);
    }

    public boolean removeMachine(String name) {
        for (CoffeeMachine machine : machines) {
            if (machine.getName().equalsIgnoreCase(name)) {
                machines.remove(machine);
                return true;
            }
        }
        return false;
    }

    public CoffeeMachine findMachine(String name) {
        for (CoffeeMachine machine : machines) {
            if (machine.getName().equalsIgnoreCase(name)) {
                return machine;
            }
        }
        return null;
    }

    public String getMachineList() {
        if (machines.isEmpty()) {
            return "Нет доступных кофемашин.";
        }
        StringBuilder list = new StringBuilder("Список кофемашин:\n");
        for (CoffeeMachine machine : machines) {
            list.append("- ").append(machine.getName()).append("\n");
        }
        return list.toString();
    }
}

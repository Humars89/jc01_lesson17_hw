package com.edu.lesson17.examples;

public class CoffeeMachine {
    private String name;
    private int water;
    private int milk;
    private int coffee;

    public CoffeeMachine(String name, int water, int milk, int coffee) {
        this.name = name;
        this.water = water;
        this.milk = milk;
        this.coffee = coffee;
    }

    public String getName() {
        return name;
    }

    public void refill(int water, int milk, int coffee) {
        this.water += water;
        this.milk += milk;
        this.coffee += coffee;
        System.out.println("Кофемашина " + name + " пополнена: Вода + " + water + "мл, Молоко + " + milk + "мл, Кофе + " + coffee + "г.");
    }

    public void showResources() {
        System.out.println("Состояние кофемашины " + name + ": Вода: " + water + "мл, Молоко: " + milk + "мл, Кофе: " + coffee + "г.");
    }

    public boolean makeDrink(Drink drink) {
        if (water < drink.getWaterNeeded()) {
            System.out.println("❌ Недостаточно воды для приготовления " + drink.getName() + " на " + name);
            return false;
        }
        if (milk < drink.getMilkNeeded()) {
            System.out.println("❌ Недостаточно молока для приготовления " + drink.getName() + " на " + name);
            return false;
        }
        if (coffee < drink.getCoffeeNeeded()) {
            System.out.println("❌ Недостаточно кофе для приготовления " + drink.getName() + " на " + name);
            return false;
        }

        water -= drink.getWaterNeeded();
        milk -= drink.getMilkNeeded();
        coffee -= drink.getCoffeeNeeded();
        System.out.println("✅ Напиток " + drink.getName() + " приготовлен на " + name);
        return true;
    }
}



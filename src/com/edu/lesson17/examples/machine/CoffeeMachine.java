package com.edu.lesson17.examples.machine;

import com.edu.lesson17.examples.coffee.Drink;

public class CoffeeMachine {
    private final String name;
    private int water, milk, coffee;

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
    }

    public String getResourceStatus() {
        return "Состояние " + name + ": Вода: " + water + " мл, Молоко: " + milk + " мл, Кофе: " + coffee + " г.";
    }

    public boolean makeDrink(Drink drink) {
        if (water < drink.getWaterNeeded() || milk < drink.getMilkNeeded() || coffee < drink.getCoffeeNeeded()) {
            return false;
        }
        water -= drink.getWaterNeeded();
        milk -= drink.getMilkNeeded();
        coffee -= drink.getCoffeeNeeded();
        return true;
    }
}

package com.edu.lesson17.examples;

public class Drink {
	private String name;
	private int waterNeeded;
	private int milkNeeded;
	private int coffeeNeeded;

	public Drink(String name, int waterNeeded, int milkNeeded, int coffeeNeeded) {
		this.name = name;
		this.waterNeeded = waterNeeded;
		this.milkNeeded = milkNeeded;
		this.coffeeNeeded = coffeeNeeded;
	}

	public String getName() {
		return name;
	}

	public int getWaterNeeded() {
		return waterNeeded;
	}

	public int getMilkNeeded() {
		return milkNeeded;
	}

	public int getCoffeeNeeded() {
		return coffeeNeeded;
	}
}

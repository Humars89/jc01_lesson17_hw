package com.edu.lesson17.examples.main;

import com.edu.lesson17.examples.manager.CoffeeShopManager;
import com.edu.lesson17.examples.ui.ConsoleUI;

public class Main {
	public static void main(String[] args) {
		CoffeeShopManager manager = new CoffeeShopManager();
		ConsoleUI ui = new ConsoleUI(manager);
		ui.start();
	}
}

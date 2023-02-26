package org.example;

import java.util.Scanner;

public class CoffeeOrder {
    private static Scanner scanner;

    public static void main(String[] args) {
        String[] coffeeTypes = {"Espresso Drink", "Double Espresso Drink", "Cappuccino Drink", "Caffe Latte Drink",
                "Mocha Drink", "Americano Drink", "Hot Water Drink"};
        int[] coffeePrices = {20, 29, 27, 27, 32, 25, 5};
        String[] ingredients = {"Espresso", "Steamed Milk", "Milk Foam", "Hot Chocolate", "Hot Water"};
        int[][] recipe = {{1, 0, 0, 0, 0}, {2, 0, 0, 0, 0}, {1, 2, 2, 0, 0}, {1, 3, 1, 0, 0}, {1, 1, 1, 2, 0},
                {1, 0, 0, 0, 4}, {0, 0, 0, 0, 5}};

        scanner = getScanner();
        // Print the list of coffee types and prices
        System.out.println("Coffee Menu:");
        for (int i = 0; i < coffeeTypes.length; i++) {
            System.out.println((i + 1) + ". " + coffeeTypes[i] + " (" + coffeePrices[i] + " TL)");
        }

        // Get user input for the coffee type
        System.out.print("Please enter the number of the coffee you would like to order: ");
        int coffeeSelection = next();
        scanner.close();

        // Display the order confirmation message
        System.out.println("Thank you, your " + coffeeTypes[coffeeSelection - 1] + " is being prepared.");

        // Display the recipe for the selected coffee
        System.out.print("Your " + coffeeTypes[coffeeSelection - 1] + " contains: ");
        for (int i = 0; i < recipe[coffeeSelection - 1].length; i++) {
            if (recipe[coffeeSelection - 1][i] > 0) {
                System.out.print(recipe[coffeeSelection - 1][i] + " dose(s) of " + ingredients[i] + ", ");
            }
        }
        System.out.println("Enjoy your drink!");
    }

    public static Scanner getScanner() {
        return new Scanner(System.in);
    }

    public static int next() {
        return scanner.nextInt();
    }
}
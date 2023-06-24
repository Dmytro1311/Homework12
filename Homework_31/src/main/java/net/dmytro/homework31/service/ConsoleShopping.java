package net.dmytro.homework31.service;

import java.util.Scanner;

public class ConsoleShopping {
    private ShoppingCartApp shoppingCartApp;
    private Scanner scanner;

    public ConsoleShopping(ShoppingCartApp shoppingCartApp) {
        this.shoppingCartApp = shoppingCartApp;
        this.scanner = new Scanner(System.in);
    }

    public void start(){
        while (true){
            displayMenu();
            String choice = scanner.nextLine();
            switch (choice){
                case "1":
                    addToCart();
                    break;
                case "2":
                    removeFromCart();
                    break;
                case "3":
                    displayCart();
                    break;
                case "4":
                    System.out.println("Exit from program ");
                    return;
                default:
                    System.out.println("Invalid choice. Pleas try again ");
            }

        }
    }

    public void displayMenu(){
        System.out.println(" Cart Menu ");
        System.out.println("1. Add product to cart");
        System.out.println("2. Remove product from cart");
        System.out.println("3. Display cart contents ");
        System.out.println("4. Exit");
        System.out.println("Enter your choice: ");
    }

    private void addToCart(){
        System.out.println("Enter product ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        shoppingCartApp.addToCart(id);
    }
    private void  removeFromCart(){
        System.out.println("Enter product ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        shoppingCartApp.removeFromCart(id);
    }
    private void displayCart(){
        shoppingCartApp.displayList();
    }
}

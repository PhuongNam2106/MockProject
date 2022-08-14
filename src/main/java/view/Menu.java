package view;

import model.Customer;

import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    private static Menu instance;
    public static Menu getInstance(){
        if(instance == null){
            instance = new Menu();
        }
        return instance;
    }
    public int mainmMenu(){
        System.out.println("1. CRUD products.");
        System.out.println("2. Order products.");
        System.out.println("0. Exit.");
        return scanner.nextInt();
    }
    public int crudMenu(){
        System.out.println("1. Create products.");
        System.out.println("2. Show product list");
        System.out.println("3. Update products.");
        System.out.println("4. Delete products.");
        System.out.println("0. Back.");
        return scanner.nextInt();
    }

//    public Customer customerMenu() {
//        System.out.print("Customer name:");
//        String name = scanner.nextLine();
//        System.out.print("Customer email:");
//        String email = scanner.nextLine();
//        System.out.print("Customer phone number:");
//        String phoneNumber = scanner.nextLine();
//        System.out.print("Customer address id:");
//        int addressId = scanner.nextInt();
//
//        return new Customer(name, email, phoneNumber, addressId);
//    }
}

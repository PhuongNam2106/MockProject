package view;

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
        System.out.println("2. Update products.");
        System.out.println("3. Delete products.");
        System.out.println("0. Back.");
        return scanner.nextInt();
    }
}

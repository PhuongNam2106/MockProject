package controller;

import model.Product;
import service.ProductService;
import service.ProductServiceImpl;
import view.Menu;

import java.text.ParseException;

public class Main {
    private static final ProductService productService = new ProductServiceImpl();
    public static void main(String[] args) throws ParseException {
        int menu;
        do {
            menu  = Menu.getInstance().mainmMenu();
            switch (menu){
                case 1:
                    int crudMenu;
                    do {
                        crudMenu = Menu.getInstance().crudMenu();
                        switch (crudMenu){
                            case 1:{
                                Product product = new Product();
                                product.input();
                                productService.save(product);
                            }
                                break;
//                            case 2:
//                                break;
//                            case 3:
//                                break;
//                            case 0:
//                                break;
                            default:
                                System.out.println();
                                System.out.println("Only choice 0 -> 3");
                                break;
                        }
                    }while (crudMenu != 0);
                    break;
                case 2: break;

                case 0: break;

                default:
                    System.out.println("Only choice 0 -> 2");
                    break;
            }

        }while(menu != 0);
    }
}

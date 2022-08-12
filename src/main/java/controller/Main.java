package controller;

import model.Customer;
import model.Product;
import service.CustomerService;
import service.CustomerServiceImpl;
import service.ProductService;
import service.ProductServiceImpl;
import view.Menu;

import java.text.ParseException;
import java.util.List;

public class Main {
    public static void showTitle()
    {
        System.out.printf("%30s %30s %15s %15s %10s %10s %10s\n","Name","Description","Price","Discount percent","Stock","Sold","Status");
    }
    private static final ProductService productService = new ProductServiceImpl();
    private static final CustomerService customerService = new CustomerServiceImpl();
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
                            case 2:{
                                List<Product> products = productService.showAll();
                                showTitle();
                                for (Product product:products) {
                                    product.output();
                                }
                            }
                                break;
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
                case 2:
                    Customer customer = new Customer();
                    customer.input();
                    customerService.createCustomer(customer);
                    break;

                case 0: break;

                default:
                    System.out.println("Only choice 0 -> 2");
                    break;
            }

        }while(menu != 0);
    }
}

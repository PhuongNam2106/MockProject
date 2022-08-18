package controller;

import model.Customer;
import model.Order;
import model.OrderDetail;
import model.Product;
import service.*;
import service.impl.OrderServiceImpl;
import view.Menu;

import java.sql.SQLOutput;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void showTitle()
    {
        System.out.printf("%10s %30s %30s %15s %15s %10s %10s %10s\n","ID","Name","Description","Price","Discount percent","Stock","Sold","Status");
    }

    public static void showTitleCustomer()
    {
        System.out.printf("\n%15s %30s %30s %15s %15s\n","Customer ID","Full name","Email","Phone number","Address ID");
    }
    private static final ProductService productService = new ProductServiceImpl();

    static Scanner sc = new Scanner(System.in);

    private static final CustomerService customerService = new CustomerServiceImpl();

    private static final OrderService_trung ORDER_SERVICE_TRUNG = new OrderServiceTrungImpl();
    private static final OrderDetailService_trung ORDER_DETAIL_SERVICE_TRUNG = new OrderDetailServiceTrungImpl();

    private static final OrderService orderService = new OrderServiceImpl();

    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        int menu;
        do {
            menu  = Menu.getInstance().mainmMenu();
            switch (menu){
                case 1:
                    String pass ;
                    System.out.print("Enter admin pass: ");
                    pass=sc.nextLine();
                    if (pass.compareToIgnoreCase("admin123")==0)
                    {
                        int crudMenu;
                        do {
                            crudMenu = Menu.getInstance().crudMenu();
                            switch (crudMenu){
                                case 1:{
                                    System.out.println("~~~CREATE PRODUCT~~~");
                                    Product product = new Product();
                                    product.input();
                                    productService.save(product);
                                    System.out.println("\t ADD PRODUCT SUCCESS!!!");
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
                                case 3:
                                {
                                    System.out.println("~~~UPDATE PRODUCT~~~");
                                    System.out.print("Enter ID product you want to update: ");
                                    int id = Integer.parseInt(sc.nextLine());
                                    if(productService.checkID(id)==true)
                                    {
                                        Product product = new Product();
                                        product.input();
                                        productService.update(product,id);
                                        System.out.println("\t UPDATE SUCCESS!!!");
                                    }
                                    else System.out.println("\t!!!THERE IS HAS NO THIS PRODUCT ID!!!");

                                }
                                break;
                                case 4:
                                {
                                    System.out.println("~~~DELETE PRODUCT~~~");
                                    System.out.print("Enter ID product you want to update: ");
                                    int id = Integer.parseInt(sc.nextLine());
                                    if(productService.checkID(id)==true)
                                    {
                                        productService.delete(id);
                                        System.out.println("\t DELETE SUCCESS!!!");
                                    }
                                    else System.out.println("\t!!!THERE IS HAS NO THIS PRODUCT ID!!!");
                                }
                                break;
                                default:
                                    System.out.println();
                                    System.out.println("Only choice 0 -> 3");
                                    break;
                            }
                        }while (crudMenu != 0);
                    }
                    else System.out.println("Admin pass incorrect");

                    break;
                case 2:
                    Customer customer = new Customer();
                    Order order = new Order();
                    OrderDetail orderDetail = new OrderDetail();
                    customer.input();
                    customerService.createCustomer(customer);
                    order.input();
                    ORDER_SERVICE_TRUNG.createOrder(order);
                    String ans;
                    do {
                        orderDetail.input();
                        ORDER_DETAIL_SERVICE_TRUNG.createOrderService(orderDetail);
                        System.out.println("Do you want to continue? Y/N");
                        ans = scanner.nextLine();
                    }while (!ans.equals("N") && !ans.equals("n"));
                    break;
                case 3:
                {
                    System.out.print("Enter admin pass: ");
                    pass=sc.nextLine();
                    if (pass.compareToIgnoreCase("admin123")==0)
                    {
                        orderService.showOrder();
                    }
                    else System.out.println("Admin pass incorrect");
                }

                    break;
                case 4:{
                    System.out.print("Enter admin pass: ");
                    pass=sc.nextLine();
                    if (pass.compareToIgnoreCase("admin123")==0)
                    {

                        List<Customer> customerList = customerService.showAll();
                        showTitleCustomer();
                        for (Customer customers :customerList) {
                            customers.output();
                        }
                        System.out.println();
                    }
                    else System.out.println("Admin pass incorrect");

                }break;
                case 0: break;

                default:
                    System.out.println("Only choice 0 -> 2");
                    break;
            }

        }while(menu != 0);
    }

}

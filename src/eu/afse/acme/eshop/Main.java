package eu.afse.acme.eshop;

import eu.afse.acme.eshop.model.Customer;
import eu.afse.acme.eshop.model.Order;
import eu.afse.acme.eshop.model.Product;

import javax.print.attribute.standard.OrientationRequested;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Customer B2C_1 = new Customer(100001, "John", "Chlop", "Avdiron 39", "6875654543", "g.chlo@gmail.com");
        Customer B2C_2 = new Customer(100002, "Giannis", "Antendokoumbo", "Milwake 40", "9595214548", "g.anted@yahoo.com");
        Customer B2B_1 = new Customer(200001, "Andrey", "Middleton", "Makripoli 64", "3048951637", "a.midl@hotmail.com");
        Customer B2B_2 = new Customer(200002, "George", "Town", "Rizoy 864", "5621038479", "gto@gmail.com");
        Customer B2G_1 = new Customer(300001, "Chris", "Fibonacci", "Peperoni 90", "1649785603", "chris.fib@gmail.com");
        Customer B2G_2 = new Customer(300002, "Jason", "Anderson", "Apollon 37", "6944455221", "j.ander@gmail.com");

        System.out.println(B2B_1);
        System.out.println(B2B_2);
        System.out.println(B2C_1);
        System.out.println(B2C_2);
        System.out.println(B2G_1);
        System.out.println(B2G_2);
        System.out.println("--------------------");
        Product product1 = new Product("Dress", 100.00,"long dress", 30, "Cotton");
        Product product2 = new Product("Trousers", 50.00,"bluejean", 42, "Cotton");
        Product product3 = new Product("T-shirt", 20.50,"beautiful t-shirt", 31, "Cotton");

        List<Product> order1 = new ArrayList<>();
        order1.add(product1);
        order1.add(product2);
        order1.add(product3);



//        Order orderC1 = new Order();
//        Order orderB1 = new Order();
//        Order orderG1 = new Order();
//
//        orderB1.create(product1);
//        orderB1.create(product2);

        System.out.println(order1);


    }
}

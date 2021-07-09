package eu.afse.acme.eshop;

import eu.afse.acme.eshop.data.RepositoryCustomer;
import eu.afse.acme.eshop.data.RepositoryOrder;
import eu.afse.acme.eshop.model.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import static eu.afse.acme.eshop.model.CustomerType.*;

public class Main {

    public static void main(String[] args) {
        RepositoryOrder repositoryOrder = new RepositoryOrder();
        RepositoryCustomer repositoryCustomer = new RepositoryCustomer();

        Customer customer1 = new Customer("100002", "Giannis", "Antendokoumbo","Milwake 40", INDIVIDUAL, "9595214548", "g.anted@yahoo.com");
        Customer customer2 = new Customer("200002", "George", "Town", "Rizoy 864", BUSINESS, "5621038479", "gto@gmail.com");
        Customer customer3 = new Customer("300001", "Chris", "Fibonacci", "Peperoni 90", GOVERMENT, "1649785603", "chris.fib@gmail.com");

        Product product1 = new Product("Dress", 100.00,"long dress", 30, "Polyester");
        Product product2 = new Product("Trousers", 50.00,"bluejean", 42, "Cotton");
        Product product3 = new Product("T-shirt", 20.50,"beautiful t-shirt", 31, "Cotton");

        List<Product> prodOrd1 = Arrays.asList(product1,product1,product2);
        Order order1 = new Order(new Date(), "P0000001625", "airplane", prodOrd1, customer1, PaymentType.CREDIT_CARD);

        List<Product> prodOrd2 = new ArrayList<>();
        prodOrd2.add(product1);
        prodOrd2.add(product2);
        Order order2 = new Order(new Date(), "P0040001625", "airplane", prodOrd2, customer2, PaymentType.WIRE_TRANSFER);

        List<Product> prodOrd3 = Arrays.asList(product2, product2, product3, product3);
        Order order3 = new Order(new Date(), "P0000003425", "ship", prodOrd3, customer3, PaymentType.CASH);

        List<Product> prodOrd4 = Arrays.asList(product1,product1,product2);
        Order order4 = new Order(new Date(), "P0000001625", "airplane", prodOrd4, customer1, PaymentType.CREDIT_CARD);


        repositoryCustomer.addNewOrderStatistics(order1);
        repositoryCustomer.addNewOrderStatistics(order2);
        repositoryCustomer.addNewOrderStatistics(order4);
        repositoryCustomer.addNewOrderStatistics(order1);
        repositoryCustomer.addNewOrderStatistics(order3);

        repositoryCustomer.addTypeOrderStatistics(order2);
        repositoryCustomer.addTypeOrderStatistics(order2);
        repositoryCustomer.addTypeOrderStatistics(order3);
        repositoryCustomer.addTypeOrderStatistics(order1);

        repositoryCustomer.addPaymentMethodStatistics(order2);
        repositoryCustomer.addPaymentMethodStatistics(order2);
        repositoryCustomer.addPaymentMethodStatistics(order1);

        System.out.println(repositoryCustomer);

        repositoryOrder.averageOrderCost(repositoryCustomer.getTotNumber(),repositoryCustomer.getTotCost());

    }

}
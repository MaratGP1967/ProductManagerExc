package ru.netology.ProductManager.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.ProductManager.domain.Product;

public class ProductManagerTest {

    @Test
    public void addFilmTest() {
        ProductRepository mass = new ProductRepository();
        ProductManager manager = new ProductManager(mass);

        Product product1 = new Product(1, "Book1", 100);
        Product product2 = new Product(2, "Book2", 200);
        Product product3 = new Product(3, "Book3", 300);
        Product product4 = new Product(4, "Book4", 400);
        Product product5 = new Product(5, "Book5", 500);

        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);
        manager.add(product5);


        Product[] expected = {product1, product2, product3, product4, product5};
        Product[] actual = manager.allProduct();

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void searchByForAllTest() {
        ProductRepository mass = new ProductRepository();
        ProductManager manager = new ProductManager(mass);

        Product product1 = new Product(1, "Book1", 100);
        Product product2 = new Product(2, "Book2", 200);
        Product product3 = new Product(3, "Book3", 300);
        Product product4 = new Product(4, "Book4", 400);
        Product product5 = new Product(5, "Book5", 500);

        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);
        manager.add(product5);

        Product[] expected = {product1, product2, product3, product4, product5};
        Product[] actual = manager.searchBy("Book");;

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByForOneTest() {
        ProductRepository mass = new ProductRepository();
        ProductManager manager = new ProductManager(mass);

        Product product1 = new Product(1, "Book1", 100);
        Product product2 = new Product(2, "Book2", 200);
        Product product3 = new Product(3, "Book3", 300);
        Product product4 = new Product(4, "Book4", 400);
        Product product5 = new Product(5, "Book5", 500);

        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);
        manager.add(product5);

        Product[] expected = {product3};
        Product[] actual = manager.searchBy("Book3");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByForNullTest() {
        ProductRepository mass = new ProductRepository();
        ProductManager manager = new ProductManager(mass);

        Product product1 = new Product(1, "Book1", 100);
        Product product2 = new Product(2, "Book2", 200);
        Product product3 = new Product(3, "Book3", 300);
        Product product4 = new Product(4, "Book4", 400);
        Product product5 = new Product(5, "Book5", 500);

        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);
        manager.add(product5);

        Product[] expected = {};
        Product[] actual = manager.searchBy("Book8");

        Assertions.assertArrayEquals(expected, actual);
    }

}

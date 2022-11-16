package ru.netology.ProductManager.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.ProductManager.domain.Product;

public class ProductRepositoryTest {
    //Product(int id, String name, int price)
    Product product1 = new Product(1, "Book1", 100);
    Product product2 = new Product(2, "Book2", 200);
    Product product3 = new Product(3, "Book3", 300);
    Product product4 = new Product(4, "Book4", 400);
    Product product5 = new Product(5, "Book5", 500);

    @Test
    public void saveTest() {
        ProductRepository mass = new ProductRepository();
        mass.save(product1);
        mass.save(product2);
        mass.save(product3);
        mass.save(product4);
        mass.save(product5);

        Product[] expected = {product1, product2, product3, product4, product5};
        Product[] actual = mass.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void notSaveTest() {
        ProductRepository mass = new ProductRepository();
        mass.save(product1);
        mass.save(product2);
        mass.save(product3);
        mass.save(product4);
        mass.save(product5);

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            mass.save(product3);
        });
    }

    @Test
    public void removeByIdTest() {
        ProductRepository mass = new ProductRepository();
        mass.save(product1);
        mass.save(product2);
        mass.save(product3);
        mass.save(product4);
        mass.save(product5);
        mass.removeById(2);

        Product[] expected = {product1, product3, product4, product5};
        Product[] actual = mass.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void notRemoveByIdTest() {
        ProductRepository mass = new ProductRepository();
        mass.save(product1);
        mass.save(product2);
        mass.save(product3);
        mass.save(product4);
        mass.save(product5);

        Assertions.assertThrows(NotFoundException.class, () -> {
            mass.removeById(7);
        });
    }

}

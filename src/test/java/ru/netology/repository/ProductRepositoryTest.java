package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.NotFoundException;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;


class ProductRepositoryTest {
    private final ProductRepository repository = new ProductRepository();


    private final Book first = new Book(1, "Анна Каренина", 1000, "Толстой");
    private final Book second = new Book(2, "Война и мир", 1100, "Толстой");
    private final Book third = new Book(3, "Человек футляр", 800, "Чехов");
    private final Smartphone fourth = new Smartphone(4, "Apple", 4100, "IND");
    private final Smartphone fifth = new Smartphone(5, "Sony", 3300, "RTF");


    @BeforeEach
    public void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
    }


    @Test
    public void shouldRemoveById() {
        repository.removeById(1);
        Product[] expected = {second, third, fourth, fifth};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdException() {
        assertThrows(NotFoundException.class, () -> {
            repository.removeById(8);
        });
    }

}

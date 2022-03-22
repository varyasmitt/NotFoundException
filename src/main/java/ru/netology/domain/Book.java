package ru.netology.domain;

import java.util.Objects;

public class Book extends Product {
    private String autor;

    public Book() {
        super();
    }

    public Book(String autor) {
        this.autor = autor;
    }

    public Book(int id, String name, int price, String autor) {
        super(id, name, price);
        this.autor = autor;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Book book = (Book) o;
        return Objects.equals(autor, book.autor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), autor);
    }


}
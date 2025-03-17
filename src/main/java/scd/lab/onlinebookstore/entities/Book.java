package scd.lab.onlinebookstore.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Double price;
    private boolean inStock;

    // Constructors
    public Book() {}

    public Book(Long id, String title, Double price, boolean inStock) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.inStock = inStock;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public boolean isInStock() { return inStock; }
    public void setInStock(boolean inStock) { this.inStock = inStock; }

    @Override
    public String toString() {
        return "Book{id=" + id + ", title='" + title + "', price=" + price + ", inStock=" + inStock + "}";
    }
}


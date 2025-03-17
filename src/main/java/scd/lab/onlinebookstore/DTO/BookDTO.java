package scd.lab.onlinebookstore.DTO;

public class BookDTO {
    private String title;
    private Double price;

    // Constructors
    public BookDTO() {}

    public BookDTO(String title, Double price) {
        this.title = title;
        this.price = price;
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "BookDTO{title='" + title + "', price=" + price + "}";
    }
}

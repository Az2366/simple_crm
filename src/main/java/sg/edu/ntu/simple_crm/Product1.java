package sg.edu.ntu.simple_crm;

import java.util.UUID;

public class Product1 {
    private final String id;
    private String name;
    private String description;
    private double price;

    public Product1() {
        this.id = UUID.randomUUID().toString();
    }

    public Product1(String name, String description, double price) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}

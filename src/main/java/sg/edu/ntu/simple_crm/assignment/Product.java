package sg.edu.ntu.simple_crm.assignment;

public class Product {
    private String id;
    private String name;
    private double price;
    private String desc;

    public Product() {
    }

    public Product(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Product(String id, String name, double price, String desc) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.desc = desc;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}

package sg.edu.ntu.simple_crm;

public class ProductNotFound1 extends RuntimeException {
    ProductNotFound1(String id) {
        super("Could not found the product id " + id + ".");
    }
}

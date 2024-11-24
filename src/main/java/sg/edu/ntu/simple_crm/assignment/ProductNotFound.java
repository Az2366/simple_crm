package sg.edu.ntu.simple_crm.assignment;

public class ProductNotFound extends RuntimeException {
    ProductNotFound(String id) {
        super("Could not found the product id " + id + ".");
    }
}

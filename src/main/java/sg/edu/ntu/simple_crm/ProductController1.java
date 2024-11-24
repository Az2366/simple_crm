package sg.edu.ntu.simple_crm;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products1")
public class ProductController1 {
    private ArrayList<Product1> products = new ArrayList<>();

    public ProductController1() {
        products.add(new Product1("Monster Hunter World", "PC/PS4/PS5", 199));
        products.add(new Product1("Monster Hunter Wild", "PC/PS4/PS5", 299));
    }

    // Add Product
    @PostMapping("")
    public Product1 createProduct(@RequestBody Product1 product) {
        products.add(product);
        return product;
    }

    // Read - get all product
    @GetMapping("")
    public ArrayList<Product1> getAllProducts() {
        return products;
    }

    // Read - get one product
    @GetMapping("{id}")
    public Product1 getProduct(@PathVariable String id) {
        int index = getProductIndex(id);
        return products.get(index);
    }

    // Update
    @PutMapping("/{id}")
    public Product1 updateProduct(@PathVariable String id, @RequestBody Product1 product) {
        int index = getProductIndex(id);
        products.set(index, product);
        return product;
    }

    // Delete
    @DeleteMapping("/{id}")
    public Product1 deleteProduct(@PathVariable String id) {
        int index = getProductIndex(id);
        return products.remove(index);
    }

    // Helper
    private int getProductIndex(String id) {
        for (Product1 product : products) {
            if (product.getId().equals(id)) {
                return products.indexOf(product);
            }
        }
        return -1;
    }

}

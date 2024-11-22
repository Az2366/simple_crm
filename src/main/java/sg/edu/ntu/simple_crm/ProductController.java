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
@RequestMapping("/products")
public class ProductController {
    private ArrayList<Product> products = new ArrayList<>();

    public ProductController() {
        products.add(new Product("Monster Hunter World", "PC/PS4/PS5", 199));
        products.add(new Product("Monster Hunter Wild", "PC/PS4/PS5", 299));
    }

    // Add Product
    @PostMapping("")
    public Product createProduct(@RequestBody Product product) {
        products.add(product);
        return product;
    }

    // Read - get all product
    @GetMapping("")
    public ArrayList<Product> getAllProducts() {
        return products;
    }

    // Read - get one product
    @GetMapping("{id}")
    public Product getProduct(@PathVariable String id) {
        int index = getProductIndex(id);
        return products.get(index);
    }

    // Update
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable String id, @RequestBody Product product) {
        int index = getProductIndex(id);
        products.set(index, product);
        return product;
    }

    // Delete
    @DeleteMapping("/{id}")
    public Product deleteProduct(@PathVariable String id) {
        int index = getProductIndex(id);
        return products.remove(index);
    }

    // Helper
    private int getProductIndex(String id) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return products.indexOf(product);
            }
        }
        return -1;
    }

}

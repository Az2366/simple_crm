package sg.edu.ntu.simple_crm.assignment;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController2 {
    private ArrayList<Product2> products = new ArrayList<>();

    public ProductController2() {
        // products.add(new Product("1", "Apple"));
        // products.add(new Product("2", "Banana"));
        // products.add(new Product("3", "Carrot"));
        products.add(new Product2("1", "Apple", 3, "From UK"));
        products.add(new Product2("2", "Banana", 2, "From Thailand"));
        products.add(new Product2("3", "Carrot", 1, "Local"));
    }

    // Add Product
    @PostMapping("")
    public ResponseEntity<Product2> createProduct(@RequestBody Product2 product) {
        products.add(product);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    // Get All Product
    @GetMapping("")
    public ResponseEntity<ArrayList<Product2>> getAllProducts() {
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    // Get one product
    @GetMapping("{id}")
    public ResponseEntity<Product2> getProduct(@PathVariable String id) {
        try {
            int index = getProductIndex(id);
            return new ResponseEntity<>(products.get(index), (HttpStatus.OK));
        } catch (ProductNotFound e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Product2> deleteProduct(@PathVariable String id) {
        try {
            int index = getProductIndex(id);
            products.remove(index);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (ProductNotFound e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Helper
    private int getProductIndex(String id) {
        for (Product2 product : products) {
            if (product.getId().equals(id)) {
                return products.indexOf(product);
            }
        }
        // return -1;
        throw new ProductNotFound(id);
    }
}

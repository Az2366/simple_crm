package sg.edu.ntu.simple_crm.assignment;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ArrayList<Product> products = new ArrayList<>();

    public ProductController() {
        products.add(new Product("1", "Apple"));
        products.add(new Product("2", "Banana"));
        products.add(new Product("3", "Carrot"));
    }

    // Get All Product
    @GetMapping("")
    public ResponseEntity<ArrayList<Product>> getAllProducts() {
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    // Get one product
    @GetMapping("{id}")
    public ResponseEntity<Product> getProduct(@PathVariable String id) {
        try {
            int index = getProductIndex(id);
            return new ResponseEntity<>(products.get(index), (HttpStatus.OK));
        } catch (ProductNotFound e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Helper
    private int getProductIndex(String id) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return products.indexOf(product);
            }
        }
        // return -1;
        throw new ProductNotFound(id);
    }
}

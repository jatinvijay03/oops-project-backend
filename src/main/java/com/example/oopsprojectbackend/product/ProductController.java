package com.example.oopsprojectbackend.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "oops/api/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @CrossOrigin
    @GetMapping
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    @CrossOrigin
    @PostMapping
    public void registerNewProduct(@RequestBody Product[] products) {
        productService.addNewProducts(products);
    }
}

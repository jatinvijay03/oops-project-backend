package com.example.oopsprojectbackend.product;

import com.example.oopsprojectbackend.cartItem.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public Optional<Product[]> getProductFromQuery(String query){
        return productRepository.findProductsFromQuery(query);
    }

    public Optional<Product[]> getProductFromCategory(Long cat){
        return productRepository.findProductsFromCategory(cat);
    }

    public Optional<Product> getProductFromPid(Long pid){
        return productRepository.findProductById(pid);
    }

    public void addNewProducts(Product[] products) {
        for(int i =0; i<products.length; i++) {
            Optional<Product> productOptional = productRepository.findProductById(products[i].getId());
            if (productOptional.isPresent()) {
                throw new IllegalStateException("product exists");
            }
            productRepository.save(products[i]);
        }
    }

    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }
}

package com.example.oopsprojectbackend.product;

import com.example.oopsprojectbackend.cartItem.CartItem;
import com.example.oopsprojectbackend.wallet.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Component
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public Optional<Product[]> getProducts(){
        return productRepository.findProductsToShow("true");
    }

    public Optional<Product[]> getProductFromQuery(String query){
        return productRepository.findProductsFromQuery(query, "true");
    }

    public Optional<Product[]> getProductFromCategory(Long cat){
        return productRepository.findProductsFromCategory(cat, "true");
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

    @Transactional
    public void deleteProduct(Long id){
        Optional<Product> prod = productRepository.findById(id);
        prod.get().setShowstatus("false");
    }

    @Transactional
    public Optional<Product> updateStock(Long id, Integer stock, String name){
        Optional<Product> prod = productRepository.findById(id);
        String n = "no";
        if(name.equals(n)) {
            System.out.println("hello");
            throw new IllegalStateException("No");
        }
        else{
            prod.get().setStock(stock);
            return prod;
        }
    }
}

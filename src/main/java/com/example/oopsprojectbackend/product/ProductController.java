package com.example.oopsprojectbackend.product;

import com.example.oopsprojectbackend.cartItem.CartItem;
import com.example.oopsprojectbackend.cartItem.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.print.DocFlavor;
import java.util.List;
import java.util.Optional;



@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(path = "oops/api/product")
    @CrossOrigin("http://localhost:3000/")
    public Optional<Product[]> getProducts(){
        return productService.getProducts();
    }

    @RequestMapping(path = "oops/api/product/q={query}")
    @CrossOrigin("http://localhost:3000/")
    public Optional<Product[]> getProductFromQuery(@PathVariable String query){return productService.getProductFromQuery(query);
    }

    @RequestMapping(path = "oops/api/product/category={cat}")
    @CrossOrigin("http://localhost:3000/")
    public Optional<Product[]> getProductFromCategory(@PathVariable Long cat){return productService.getProductFromCategory(cat);
    }

    @RequestMapping(path = "oops/api/product/pid={pid}")
    @CrossOrigin("http://localhost:3000/")
    public Optional<Product> getProductFromPid(@PathVariable Long pid){return productService.getProductFromPid(pid);
    }

    @RequestMapping(path = "oops/api/product", method = RequestMethod.POST)
    @CrossOrigin("http://localhost:3000/")
    public void registerNewProduct(@RequestBody Product[] products) {
        productService.addNewProducts(products);
    }

    @RequestMapping(path = "oops/api/product/updatestock", method = RequestMethod.POST)
    @CrossOrigin("http://localhost:3000/")
    public void updateStock(@RequestBody Product product) {
        productService.updateStock(product.getId(), product.getStock(), product.getName());
    }

    @RequestMapping(path = "oops/api/product/delete", method = RequestMethod.DELETE)
    @CrossOrigin("http://localhost:3000/")
    public void deleteProduct(@RequestBody Product product) {
        productService.deleteProduct(product.getId());
    }
}


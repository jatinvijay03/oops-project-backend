package com.example.oopsprojectbackend.cartItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CartItemService {

    private final CartItemRepository cartItemRepository;

    @Autowired
    public CartItemService(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }


    public List<CartItem> getCartItems(){
        return cartItemRepository.findAll();
    }

    public Optional<CartItem[]> getCartItemsForUser(Long uid){
        return cartItemRepository.findCartItemsbyUid(uid);
    }

    public void addNewCartItems(CartItem[] cartItems) {
        for(int i = 0; i< cartItems.length; i++) {
            Optional<CartItem> categoryOptional = cartItemRepository.findCartItembyId(cartItems[i].getId());
            if (categoryOptional.isPresent()) {
                //it should ideally increase the quantity of the cart item
                throw new IllegalStateException("cart item exists");
            }
            cartItemRepository.save(cartItems[i]);
        }
    }
}

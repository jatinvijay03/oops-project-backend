package com.example.oopsprojectbackend.cartItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
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

    @Transactional
    public void updateCartItem(Long id, Integer q){
        CartItem cartItem = cartItemRepository.findCartItembyid(id).orElseThrow(() -> new IllegalStateException("doesn't exist"));
        cartItem.setQuantity(q + 1);
    }

    @Transactional
    public void addNewCartItems(CartItem[] cartItems) {
        for(int i = 0; i< cartItems.length; i++) {
            Optional<CartItem> cartItemOptional = cartItemRepository.findCartItembyIds(cartItems[i].getUid(), cartItems[i].getPid());
            if (cartItemOptional.isPresent()) {
                Long id = cartItemOptional.get().getId();
                Integer q = cartItemOptional.get().getQuantity();
                updateCartItem(id, q);
                //throw new IllegalStateException("cart item exists");
            }
            else{
                cartItemRepository.save(cartItems[i]);
            }
        }
    }
}

package com.example.oopsprojectbackend.cartItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CartItemController {



    @Autowired
    private CartItemService cartItemService;

    @RequestMapping(path = "oops/api/cartItem")
    public List<CartItem> getCartItems(){return cartItemService.getCartItems();
    }

    @RequestMapping(path = "oops/api/cartItem/{uid}")
    public Optional<CartItem[]> getCartItemsForUser(@PathVariable Long uid){return cartItemService.getCartItemsForUser(uid);
    }

    @RequestMapping(path = "oops/api/cartItem", method = RequestMethod.POST)
    public void registerNewCartItem(@RequestBody CartItem[] cartItems) {
        cartItemService.addNewCartItems(cartItems);
    }
}

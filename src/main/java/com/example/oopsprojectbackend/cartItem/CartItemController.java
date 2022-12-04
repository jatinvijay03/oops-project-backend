package com.example.oopsprojectbackend.cartItem;

import com.example.oopsprojectbackend.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CartItemController {

    @Autowired
    private CartItemService cartItemService;

    @CrossOrigin("http://localhost:3000/")
    @RequestMapping(path = "oops/api/cartItem")
    public List<CartItem> getCartItems(){return cartItemService.getCartItems();
    }

    @RequestMapping(path = "oops/api/cartItem/{uid}")
    @CrossOrigin("http://localhost:3000/")
    public Optional<CartItem[]> getCartItemsForUser(@PathVariable Long uid){return cartItemService.getCartItemsForUser(uid);
    }

    @RequestMapping(path = "oops/api/cartItem", method = RequestMethod.POST)
    @CrossOrigin("http://localhost:3000/")
    public void registerNewCartItem(@RequestBody CartItem[] cartItems) {
        cartItemService.addNewCartItems(cartItems);
    }

    @RequestMapping(path = "oops/api/cartItem/delete", method = RequestMethod.DELETE)
    @CrossOrigin("http://localhost:3000/")
    public void deleteCartItem(@RequestBody CartItem item) {
        cartItemService.deleteCartItem(item.getId());
    }
}

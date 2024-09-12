package org.bazaarBackend.Cart.Controllers;

import org.bazaarBackend.Cart.Model.Cart;
import org.bazaarBackend.Cart.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cart")
public class CartController {

    @Autowired
    CartService cartService;

    public Cart createCart(Cart cart) {
        Cart c = cartService.createCart(cart);
        return c;
    }
}

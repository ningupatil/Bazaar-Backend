package org.bazaarBackend.Cart.Service;

import org.bazaarBackend.Cart.Model.Cart;
import org.bazaarBackend.Cart.Repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    CartRepository cartRepo;

    public Cart createCart(Cart cart) {
        Cart c = cartRepo.createCart(cart);
        return c;
    }
}

package org.bazaarBackend.Seller.Controllers;

import org.bazaarBackend.Seller.Models.Seller;
import org.bazaarBackend.Seller.Services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sellers")
public class SellerController {

    @Autowired
    SellerService sellerService;

    @PostMapping
    public Seller createSeller(@RequestBody Seller seller) {
        Seller s = sellerService.createSeller(seller);
        return s;
    }
}

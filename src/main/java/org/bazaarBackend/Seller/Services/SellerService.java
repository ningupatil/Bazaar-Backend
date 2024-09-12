package org.bazaarBackend.Seller.Services;

import org.bazaarBackend.Seller.Models.Seller;
import org.bazaarBackend.Seller.Repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerService {

    @Autowired
    SellerRepository sellerRepo;

    public Seller createSeller(Seller seller) {
        Seller s = sellerRepo.createSeller(seller);
        return s;
    }
}

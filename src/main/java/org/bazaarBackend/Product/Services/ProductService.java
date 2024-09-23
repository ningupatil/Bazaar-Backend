package org.bazaarBackend.Product.Services;

import org.bazaarBackend.Models.ProductImages;
import org.bazaarBackend.Product.Models.Product;
import org.bazaarBackend.Product.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepo;

    public Product createProduct(Product product) {
        Product P = productRepo.createProduct(product);

        for(String imagePath : product.getImages()) {
            ProductImages productImage = new ProductImages();
            productImage.setImagePath(imagePath);
            productImage.setProduct(P);
            productRepo.createProductImage(productImage);
        }

        return P;
    }

    public List<Product> getAllProducts(String category) {
        if (category == null || category.isEmpty()) {
            return productRepo.getAllProducts();
        } else {
            return productRepo.getCategoryProducts(category);
        }
    }

    public Product findById(Long id) {
        Product p = productRepo.findById(id);
        return p;
    }

}

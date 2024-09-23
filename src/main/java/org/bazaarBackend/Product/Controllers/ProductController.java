package org.bazaarBackend.Product.Controllers;

import org.bazaarBackend.Product.Models.Product;
import org.bazaarBackend.Product.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        System.out.println("---- "+ product.getImages());
        Product P = productService.createProduct(product);
        return P;
    }

    @GetMapping
    public @ResponseBody List<Product> getAllProducts(@RequestParam("category") Optional<String> category) {
        if(category.isPresent()) {
            return productService.getAllProducts(category.get());
        } else {
            return productService.getAllProducts(null);
        }

    }

    @GetMapping("products/{productId}")
    public @ResponseBody Product findById(@PathVariable("productId") Long id) {
        Product p = productService.findById(id);
        return p;
    }
}

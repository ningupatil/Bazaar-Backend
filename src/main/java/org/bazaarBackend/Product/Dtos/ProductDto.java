package org.bazaarBackend.Product.Dtos;

import org.bazaarBackend.Product.Models.Product;

import java.util.List;

public class ProductDto {

    private int id;

    private String title;

    private int price;

    private String description;

    private List<String> images;

    private String brand;

    private String category;

    public ProductDto(Product product) {
        id = product.getId();
        title = product.getTitle();
        price = product.getPrice();
        description = product.getDescription();


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}

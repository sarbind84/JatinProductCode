// src/main/java/com/example/demo/entity/Product.java
package com.ecommerce.end.models;

// import javax.persistence.*;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String brand;
    private double price;
    private String colors;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Image> image;

    @Column(length = 1000)
    private String description;
    
    private String category;
    private boolean featured;
    private boolean slider;
    private boolean shipping;
    private int stock;
    private int review;
    private double stars;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getColors() {
        return colors;
    }
    public void setColors(String colors) {
        this.colors = colors;
    }
    public List<Image> getImage() {
        return image;
    }
    public void setImage(List<Image> image) {
        this.image = image;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public boolean isFeatured() {
        return featured;
    }
    public void setFeatured(boolean featured) {
        this.featured = featured;
    }
    public boolean isSlider() {
        return slider;
    }
    public void setSlider(boolean slider) {
        this.slider = slider;
    }
    public boolean isShipping() {
        return shipping;
    }
    public void setShipping(boolean shipping) {
        this.shipping = shipping;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    public int getReview() {
        return review;
    }
    public void setReview(int review) {
        this.review = review;
    }
    public double getStars() {
        return stars;
    }
    public void setStars(double stars) {
        this.stars = stars;
    }

    // Getters and Setters
    //...
}

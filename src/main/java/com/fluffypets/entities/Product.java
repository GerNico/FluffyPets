package com.fluffypets.entities;

import java.math.BigDecimal;

public class Product {

    private Integer id;
    private String name;
    private String producer;
    private BigDecimal price;
    private String description;
    private String pictureURL;
    private Category category;

    public Product(Integer id, String name, String producer, BigDecimal price, String description, String pictureURL, Category category) {
        this.id = id;
        this.name = name;
        this.producer = producer;
        this.price = price;
        this.description = description;
        this.pictureURL = pictureURL;
        this.category = category;
    }

    public Product(Integer id, String name, BigDecimal price, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public Product(String name, String producer, BigDecimal price, String description, String pictureURL, Category category) {
        this.name = name;
        this.producer = producer;
        this.price = price;
        this.description = description;
        this.pictureURL = pictureURL;
        this.category = category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getProducer() {
        return producer;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        if (!getName().equals(product.getName())) return false;
        if (!getProducer().equals(product.getProducer())) return false;
        return getPrice().equals(product.getPrice());
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getProducer().hashCode();
        result = 31 * result + getPrice().hashCode();
        return result;
    }
}

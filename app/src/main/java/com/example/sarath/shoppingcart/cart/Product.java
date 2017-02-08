package com.example.sarath.shoppingcart.cart;

import android.graphics.drawable.Drawable;

import com.example.sarath.shoppingcart.R;

/**
 * Created by sarath on 1/18/2017.
 */

public class Product {

    public String title;
    public String description;

    public Product() {
    }

    @Override
    public String toString() {
        return "Product{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", selected=" + selected +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }

    public double price;
    public boolean selected;
    private String imageUrl="http://square.github.io/picasso/static/icon-github.png";


    public Product(String title, String description, double price, String imageUrl) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.selected = selected;
        this.imageUrl = imageUrl;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}

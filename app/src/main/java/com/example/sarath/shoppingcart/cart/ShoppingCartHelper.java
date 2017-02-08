package com.example.sarath.shoppingcart.cart;

import android.content.res.Resources;

import com.example.sarath.shoppingcart.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created by sarath on 1/18/2017.
 */

public class ShoppingCartHelper {
    public static final String PRODUCT_INDEX = "PRODUCT_INDEX";

    private static List<Product> catalog;
    private static List<Product> cart;

    public static List<Product> getCatalog(){
        if(catalog == null) {
            catalog = new ArrayList<Product>();

            catalog.add(new Product("title","des",123.93,"http://square.github.io/picasso/static/icon-github.png"));

       }

        return catalog;
    }

    public static List<Product> getCart() {
        if(cart == null) {
            cart = new Vector<Product>();
        }

        return cart;
    }
}

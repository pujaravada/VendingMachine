package com.Puja.Inuyasha;

/**
 * Created by Puja on 3/20/17.
 */
public enum Product {
//
//    int productId;
//    String productName;
//    double productPrice;
//    int productCount;

        COKE("Coke", 25), PEPSI("Pepsi", 35), FANTA("Fanta", 35), SPRITE("Sprite",45);

        private String name;
        private int price;

        private Product(String name, int price){
            this.name = name;
            this.price = price;
        }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

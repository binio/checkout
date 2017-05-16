package com.shop.domain;

import com.shop.domain.offers.Offers;


public class Product {
    private String productName;
    private double price;
    private Offers offerName;

    public Product(Builder builder){
        this.productName = builder.productName;
        this.price = builder.price;
        this.offerName = builder.offerName;
    }

    public static class Builder{
        private String productName;
        private double price;
        private  Offers offerName;

        public Builder productName(String productName) {
            this.productName = productName;
            return this;
        }

        public Builder productPrice(double price) {
            this.price = price;
            return this;
        }

        public Builder offerName(Offers offerName) {
            this.offerName = offerName;
            return this;
        }

        public Product build(){
            return new Product(this);
        }

    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public Offers getOfferName() {
        return offerName;
    }
}


package com.shop.domain.offers;

import com.shop.domain.Product;

/**
 * Created by Tomasz.Biniecki on 16/05/2017.
 */
public class BuyOneGetOne implements OfferCalculation {

    public double applyOffer(Product product, int quantity) {
        double discountPrice;
        if (quantity < 1) return 0.0;
        if((quantity % 2)== 0){
            discountPrice = (quantity / 2) * product.getPrice();
        }else{
            discountPrice = (Math.floor(quantity / 2) + 1) * product.getPrice();
        }
        return discountPrice;
    }
}

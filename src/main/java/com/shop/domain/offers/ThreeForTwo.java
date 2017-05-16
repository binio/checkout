package com.shop.domain.offers;

import com.shop.domain.Product;

/**
 * Created by Tomasz.Biniecki on 16/05/2017.
 */
public class ThreeForTwo implements OfferCalculation {

    public double applyOffer(Product product, int quantity) {
        double discountPrice;
        if(quantity < 0)
            return 0.0;
        if((quantity % 3) == 0){
            discountPrice = ((quantity/3) * 2) * product.getPrice();
        }else{
            discountPrice = (((quantity/3) * 2) + 1) * product.getPrice();
        }
        return discountPrice;
    }
}

package com.shop.domain.offers;

import com.shop.domain.Product;

/**
 * Created by Tomasz.Biniecki on 16/05/2017.
 */
public class EmptyOffer implements OfferCalculation{
    public double applyOffer(Product product, int quantity) {
        return product.getPrice()*quantity;
    }
}

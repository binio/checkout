package com.shop.domain;

import com.shop.domain.offers.OfferFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Tomasz.Biniecki on 16/05/2017.
 */
public class ProductCheckout {

    private Map<String, Product> listProduct;

    public ProductCheckout(Map<String, Product> listProduct){
       this.listProduct = listProduct;
    }

    public double checkoutCalculation(List<String> basket) {
        Map<String, Integer> quantity = new HashMap();
        if(basket.isEmpty())
            return 0.0;
        for (String product: basket) {
            if(quantity.containsKey(product)){
                quantity.put(product, quantity.get(product).intValue() + 1);
            }else{
                quantity.put(product, quantity.get(product).intValue());
            }
        }
        
        double totalPrice = 0.0;
        for (Map.Entry<String, Integer> entry: quantity.entrySet() ) {
            String key = entry.getKey();
            Integer noOfItem = entry.getValue();
            double price = new OfferFactory(listProduct.get(key).getOfferName()).getInstance().applyOffer(listProduct.get(key), noOfItem);
            totalPrice += price;
        }
        return totalPrice;
    }
}


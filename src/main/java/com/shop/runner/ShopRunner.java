package com.shop.runner;

import com.shop.domain.Product;
import com.shop.domain.ProductCheckout;
import com.shop.domain.offers.Offers;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by Tomasz.Biniecki on 16/05/2017.
 */
public class ShopRunner {

    public static void main(String[] args){
        System.out.println("Running basket calculations...");
        Map<String, Product> productsWithOffers = createProductWithOffers();
        Map<String, Product> productsWithoutOffers = createProductWithoutOffers();




        Scanner sc = new Scanner(System.in);
        System.out.println("Do you want to apply offers Y/N ?");
        String offerRequired = sc.next();

        System.out.println("Please enter products items comma separated (Apple,Orange,Orange...)");
        String basketInput = sc.next();
        ProductCheckout product;
        if(offerRequired.equalsIgnoreCase("Y"))
            product = new ProductCheckout(productsWithOffers);
        else{
            product = new ProductCheckout(productsWithoutOffers);
        }

        String[] items = basketInput.split(",");
        List<String> basketList = Arrays.asList(items);
        double totalPrice = product.checkoutCalculation(basketList);

        System.out.println("Total price: £"+totalPrice);


    }

    private static Map<String, Product> createProductWithOffers() {
        Product orange = new Product.Builder().productName("Orange").productPrice(0.25).offerName(Offers.THREE_FOR_TWO).build();
        Product apple = new Product.Builder().productName("Apple").productPrice(0.60).offerName(Offers.BUY_ONE_GET_ONE).build();

        Map<String, Product> productList = new HashMap();
        productList.put("Orange",orange);
        productList.put("Apple",apple);

        return productList;
    }

    private static Map<String, Product> createProductWithoutOffers() {
        Product orange = new Product.Builder().productName("Orange").productPrice(0.25).offerName(Offers.EMPTY_OFFER).build();
        Product apple = new Product.Builder().productName("Apple").productPrice(0.60).offerName(Offers.EMPTY_OFFER).build();

        Map<String, Product> productList = new HashMap();
        productList.put("Orange",orange);
        productList.put("Apple",apple);

        return productList;
    }
}

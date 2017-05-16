package com.shop.domain;

import com.shop.domain.offers.Offers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;


public class ProductCheckoutTest {

    private ProductCheckout product;
    @Before
    public void setUp() throws Exception {

    }

    private Map<String, Product> createProductWithOffers() {
        Product orange = new Product.Builder().productName("Orange").productPrice(0.25).offerName(Offers.THREE_FOR_TWO).build();
        Product apple = new Product.Builder().productName("Apple").productPrice(0.60).offerName(Offers.BUY_ONE_GET_ONE).build();

        Map<String, Product> productList = new HashMap();
        productList.put("Orange",orange);
        productList.put("Apple",apple);
        product = new ProductCheckout(productList);
        return productList;
    }

    private Map<String, Product> createProductWithOutOffers() {
        Product orange = new Product.Builder().productName("Orange").productPrice(0.25).offerName(Offers.EMPTY_OFFER).build();
        Product apple = new Product.Builder().productName("Apple").productPrice(0.60).offerName(Offers.EMPTY_OFFER).build();

        Map<String, Product> productList = new HashMap();
        productList.put("Orange",orange);
        productList.put("Apple",apple);
        return productList;
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testCheckoutCalculation_two_apples_three_oranges() throws Exception {
        Map<String, Product> productList = createProductWithOffers();
        product = new ProductCheckout(productList);
        List<String> basket =Arrays.asList("Apple", "Apple", "Orange", "Orange", "Orange");
        double totalPrice = product.checkoutCalculation(basket);
        assertEquals(Double.valueOf(1.1), Double.valueOf(totalPrice));
    }

    @Test
    public void testCheckoutCalculation_five_apples_seven_oranges() throws Exception {
        Map<String, Product> productList = createProductWithOffers();
        product = new ProductCheckout(productList);
        List<String> basket = Arrays.asList("Apple", "Apple", "Apple", "Apple", "Apple", "Orange", "Orange", "Orange", "Orange", "Orange", "Orange", "Orange");
        double totalPrice = product.checkoutCalculation(basket);
        assertEquals(Double.valueOf(3.05), Double.valueOf(totalPrice));
    }

    @Test
    public void testCheckoutCalculation_three_apples_one_orange() throws Exception {
        Map<String, Product> productList = createProductWithOffers();
        product = new ProductCheckout(productList);
        List<String> basket = Arrays.asList("Apple", "Apple", "Orange", "Apple");
        double totalPrice = product.checkoutCalculation(basket);
        assertEquals(Double.valueOf(1.45), Double.valueOf(totalPrice));
    }

    @Test
    public void testCheckoutCalculation_three_apples_one_orange_no_offers() throws Exception {
        Map<String, Product> productList = createProductWithOutOffers();
        product = new ProductCheckout(productList);
        List<String> basket = Arrays.asList("Apple", "Apple", "Orange", "Apple");
        double totalPrice = product.checkoutCalculation(basket);
        assertEquals(Double.valueOf(2.05), Double.valueOf(totalPrice));
    }


}
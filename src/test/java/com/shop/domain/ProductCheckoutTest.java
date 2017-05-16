package com.shop.domain;

import com.shop.domain.offers.Offers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Tomasz.Biniecki on 16/05/2017.
 */
public class ProductCheckoutTest {

    private ProductCheckout product;
    @Before
    public void setUp() throws Exception {
        Product orange = new Product.Builder().productName("Orange").productPrice(2.0).offerName(Offers.THREE_FOR_TWO).build();
        Product apple = new Product.Builder().productName("Apple").productPrice(2.0).offerName(Offers.BUY_ONE_GET_ONE).build();

        productList =
        product = new ProductCheckout();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testCheckoutCalculation() throws Exception {
        List<String> basket =Arrays.asList("Apple", "Apple","Orange");
        double totalPrice = product.checkoutCalculation(basket);
        assertEquals(Double.valueOf(1.0), Double.valueOf(totalPrice));
    }

}
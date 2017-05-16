package com.shop.domain.offers;

import com.shop.domain.Product;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Tomasz.Biniecki on 16/05/2017.
 */
public class BuyOneGetOneTest {

    private BuyOneGetOne offer;
    @Before
    public void setUp() throws Exception {
        offer = new BuyOneGetOne();
    }


    @Test
    public void testOfferCalculation_with_even_quantity(){
        Product product = new Product.Builder().productName("Apple").productPrice(2.0).build();
        Double actualprice = offer.applyOffer(product,10);
        assertEquals(Double.valueOf(10.0), actualprice);

    }

    @Test
    public void testOfferCalculation_with_odd_quantity(){
        Product product = new Product.Builder().productName("Apple").productPrice(2.0).build();
        Double actualprice = offer.applyOffer(product,11);
        assertEquals(Double.valueOf(12.0), actualprice);

    }

    @Test
    public void testOfferCalculation_with_zero_quantity(){
        Product product = new Product.Builder().productName("Apple").productPrice(2.0).build();
        Double actualprice = offer.applyOffer(product,0);
        assertEquals(Double.valueOf(0.0), actualprice);

    }


    @After
    public void tearDown() throws Exception {

    }

}
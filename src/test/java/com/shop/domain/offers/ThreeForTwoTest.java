package com.shop.domain.offers;

import com.shop.domain.Product;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ThreeForTwoTest {

    private ThreeForTwo threeForTwo;

    @Before
    public void setUp() throws Exception {
        threeForTwo = new ThreeForTwo();
    }

    @Test
    public void testOfferCalculation_with_Odd_quantity() {

        Product product = new Product.Builder().productName("Orange").productPrice(2.0).build();
        Double actualPrice = threeForTwo.applyOffer(product, 3);
        assertEquals(Double.valueOf(4.0), actualPrice);

    }


    @Test
    public void testOfferCalculation_with_Zero_quantity() {

        Product product = new Product.Builder().productName("Orange").productPrice(2.0).build();
        Double actualPrice = threeForTwo.applyOffer(product, 0);
        assertEquals(Double.valueOf(0.0), actualPrice);

    }

    @Test
    public void testOfferCalculation_with_Even_quantity() {

        Product product = new Product.Builder().productName("Orange").productPrice(2.0).build();
        Double actualPrice = threeForTwo.applyOffer(product, 4);
        assertEquals(Double.valueOf(6.0), actualPrice);

    }

}
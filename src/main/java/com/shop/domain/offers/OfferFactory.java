package com.shop.domain.offers;

/**
 * Created by Tomasz.Biniecki on 16/05/2017.
 */
public class OfferFactory {
    private static Offers offer;

    public OfferFactory(Offers offer){
        this.offer = offer;
    }

    public OfferCalculation getInstance(){
        OfferCalculation offerObj = null;
        switch (offer){
            case BUY_ONE_GET_ONE:
                offerObj = new BuyOneGetOne();
                break;
            case THREE_FOR_TWO:
                offerObj = new ThreeForTwo();
                break;
            case EMPTY_OFFER:
                offerObj = new EmptyOffer();
                break;
        }
        return offerObj;
    }



}

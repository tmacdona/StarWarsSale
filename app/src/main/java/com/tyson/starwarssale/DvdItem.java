package com.tyson.starwarssale;

/**
 * Created by Tyson on 3/15/2017.
 *
 * Model for the DVD sale items to display
 */

public class DvdItem {

    public final float rating;
    public final String title;
    public final float price;
    public final float oldPrice;

    public DvdItem(String title, float rating, float price, float oldPrice){

        this.title = title;
        this.rating = rating;
        this.price = price;
        this.oldPrice = oldPrice;
    }
}

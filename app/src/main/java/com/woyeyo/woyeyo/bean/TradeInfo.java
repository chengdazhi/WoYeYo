package com.woyeyo.woyeyo.bean;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

/**
 * Created by fam_000 on 2016/2/24.
 */
public class TradeInfo {
    private Bitmap photo;
    private String description;
    private float price;
    private int starNum;

    private long SquareId;
    private long personId;

    public Bitmap getPhoto() {
        return photo;
    }
    public void setPhoto(Bitmap photo) {
        this.photo = photo;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getPrice() {
        return ""+price;
    }
    public int getStarNum(){
        return starNum;
    }
    public void setStarNum(int starNum){
        this.starNum=starNum;
    }

    public long getSquareId() {
        return SquareId;
    }

    public void setSquareId(long squareId) {
        SquareId = squareId;
    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }
}

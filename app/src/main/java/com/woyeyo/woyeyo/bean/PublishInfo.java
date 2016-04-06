package com.woyeyo.woyeyo.bean;

/**
 * Created by fam_000 on 2016/3/18.
 */
public class PublishInfo {

    private String desc;
    private float price;
    private long publisherId;
    private long publishTime;
    private long couponId;
    private long squareId;
    private long publishId;



    private boolean isBuy;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public long getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(long publisherId) {
        this.publisherId = publisherId;
    }

    public long getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(long publishTime) {
        this.publishTime = publishTime;
    }

    public long getCouponId() {
        return couponId;
    }

    public void setCouponId(long couponId) {
        this.couponId = couponId;
    }

    public long getSquareId() {
        return squareId;
    }

    public void setSquareId(long squareId) {
        this.squareId = squareId;
    }

    public long getPublishId() {
        return publishId;
    }

    public void setPublishId(long publishId) {
        this.publishId = publishId;
    }

    public boolean isBuy() {
        return isBuy;
    }

    public void setIsBuy(boolean isBuy) {
        this.isBuy = isBuy;
    }

}

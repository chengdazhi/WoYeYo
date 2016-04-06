package com.woyeyo.woyeyo.bean;

/**
 * Created by fam_000 on 2016/3/6.
 */
public class Trade {
    private long tradeId;
    private long buyerId;
    private long sellerId;
    private long couponId;
    private long squareId;


    //以下用于在交易记录中显示,均为对方的
    private String nickname;//TODO:判断是seller 还是buyer
    private String couponImageUrl;
    private String userImageUrl;
    private String desc;
    private float price;

    //private static final int STATE_INPUBLISH=0;
    private int tradeState;
    private static final int STATE_ORDER=0;
    private static final int STATE_PAID=1;
    private static final int STATE_SENT=2;
    private static final int STATE_RECIVED=3;
    private static final int STATE_COMMENT=4;
    private static final int STATE_COMPLETE=5;
    private static final int STATE_CLOSE=6;

    private long publishTime;
    private long payTime;
    private long sentTime;
    private long reciveTime;

    public long getTradeId() {
        return tradeId;
    }

    public void setTradeId(long tradeId) {
        this.tradeId = tradeId;
    }

    public long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(long buyerId) {
        this.buyerId = buyerId;
    }

    public long getSellerId() {
        return sellerId;
    }

    public void setSellerId(long sellerId) {
        this.sellerId = sellerId;
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

    public int getTradeState() {
        return tradeState;
    }

    public void setTradeState(int tradeState) {
        this.tradeState = tradeState;
    }


    public long getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(long publishTime) {
        this.publishTime = publishTime;
    }

    public long getPayTime() {
        return payTime;
    }

    public void setPayTime(long payTime) {
        this.payTime = payTime;
    }

    public long getSentTime() {
        return sentTime;
    }

    public void setSentTime(long sentTime) {
        this.sentTime = sentTime;
    }

    public long getReciveTime() {
        return reciveTime;
    }

    public void setReciveTime(long reciveTime) {
        this.reciveTime = reciveTime;
    }
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getCouponImageUrl() {
        return couponImageUrl;
    }

    public void setCouponImageUrl(String couponImageUrl) {
        this.couponImageUrl = couponImageUrl;
    }

    public String getUserImageUrl() {
        return userImageUrl;
    }

    public void setUserImageUrl(String userImageUrl) {
        this.userImageUrl = userImageUrl;
    }

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

}

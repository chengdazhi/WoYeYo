package com.woyeyo.woyeyo.bean;

/**
 * Created by fam_000 on 2016/3/6.
 */
public class Coupon {

    private long couponId;
    private String couponImageUrl;
    private String couponDesc;
    private String merchantName;
    private String merchantLogoUrl;
    private String merchantJumpUrl;
    private String couponJumpUrl;
    private String couponDetail;//活动详情
    private String bargainRule;//交易规则
    private int category;//类别，有待添加具体类目

    public long getCouponId() {
        return couponId;
    }

    public void setCouponId(long couponId) {
        this.couponId = couponId;
    }

    public String getCouponImageUrl() {
        return couponImageUrl;
    }

    public void setCouponImageUrl(String couponImageUrl) {
        this.couponImageUrl = couponImageUrl;
    }

    public String getCouponDesc() {
        return couponDesc;
    }

    public void setCouponDesc(String couponDesc) {
        this.couponDesc = couponDesc;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getMerchantLogoUrl() {
        return merchantLogoUrl;
    }

    public void setMerchantLogoUrl(String merchantLogoUrl) {
        this.merchantLogoUrl = merchantLogoUrl;
    }

    public String getMerchantJumpUrl() {
        return merchantJumpUrl;
    }

    public void setMerchantJumpUrl(String merchantJumpUrl) {
        this.merchantJumpUrl = merchantJumpUrl;
    }

    public String getCouponJumpUrl() {
        return couponJumpUrl;
    }

    public void setCouponJumpUrl(String couponJumpUrl) {
        this.couponJumpUrl = couponJumpUrl;
    }

    public String getCouponDetail() {
        return couponDetail;
    }

    public void setCouponDetail(String couponDetail) {
        this.couponDetail = couponDetail;
    }

    public String getBargainRule() {
        return bargainRule;
    }

    public void setBargainRule(String bargainRule) {
        this.bargainRule = bargainRule;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

}

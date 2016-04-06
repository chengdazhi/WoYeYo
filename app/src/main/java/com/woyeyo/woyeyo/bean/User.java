package com.woyeyo.woyeyo.bean;

/**
 * Created by fam_000 on 2016/3/6.
 */
public class User {
    private long personId;
    private float useableSum;
    private float pendingSum;
    private String imageUrl;
    private String nickName;
    private String gender;
    private int starNum;
    private int commentNum;
    private int DealNum;

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public float getUseableSum() {
        return useableSum;
    }

    public void setUseableSum(float useableSum) {
        this.useableSum = useableSum;
    }

    public float getPendingSum() {
        return pendingSum;
    }

    public void setPendingSum(float pendingSum) {
        this.pendingSum = pendingSum;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getStarNum() {
        return starNum;
    }

    public void setStarNum(int starNum) {
        this.starNum = starNum;
    }

    public int getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(int commentNum) {
        this.commentNum = commentNum;
    }
    public int getDealNum() {
        return DealNum;
    }

    public void setDealNum(int dealNum) {
        DealNum = dealNum;
    }
}

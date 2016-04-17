package com.woyeyo.woyeyo.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by fam_000 on 2016/3/13.
 */
public class CheckEditText {
    public static boolean isMobileNum(String mobileNum){
        String strPattern="^1[3|4|5|7|8]\\d{9}$";
        Pattern p = Pattern
                .compile(strPattern);
        Matcher m = p.matcher(mobileNum);
        return m.matches();
}
    public static boolean isEmailAdress(String emailAd){
        String strPattern = "^[a-zA-Z][\\w\\.-]*[a-zA-Z0-9]@[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]$";
        Pattern p = Pattern.compile(strPattern);
        Matcher m = p.matcher(emailAd);
        return m.matches();
    }
    public static boolean isPositiveFloat(String price){
        String strPattern="^[1-9]\\d*\\.\\d*|0\\.\\d*[1-9]\\d*$";
        Pattern p=Pattern.compile(strPattern);
        Matcher m=p.matcher(price);
        return m.matches();
    }
    public static boolean isPositiveInt(String price){
        String strPattern="^[1-9]\\d*$";
        Pattern p=Pattern.compile(strPattern);
        Matcher m=p.matcher(price);
        return m.matches();
    }
}

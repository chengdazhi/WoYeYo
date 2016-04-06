package com.woyeyo.woyeyo.presenter;

import com.woyeyo.woyeyo.bean.Address;

import java.util.List;

/**
 * Created by fam_000 on 2016/3/19.
 */
public interface OnGetAddressListener{
    void getInfoSuccess(List<Address> addressList);
    void getInfoFailed();
}

package com.woyeyo.woyeyo.model;

import com.woyeyo.woyeyo.presenter.OnGetAddressListener;

/**
 * Created by fam_000 on 2016/3/19.
 */
public interface IGetAddress {
    void getItemAddress(String id,OnGetAddressListener listener);
}

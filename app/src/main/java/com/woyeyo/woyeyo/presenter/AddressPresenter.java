package com.woyeyo.woyeyo.presenter;

import android.os.Handler;

import com.woyeyo.woyeyo.bean.Address;
import com.woyeyo.woyeyo.model.GetAddress;
import com.woyeyo.woyeyo.model.IGetAddress;
import com.woyeyo.woyeyo.view.IGetInfoView;
import com.woyeyo.woyeyo.view.IGetListInfoView;

import java.util.ArrayDeque;
import java.util.List;

/**
 * Created by fam_000 on 2016/3/19.
 */
public class AddressPresenter {
    private IGetAddress iGetAddress;
    private IGetListInfoView<Address> iGetListInfoView;
    private Handler mHandler=new Handler();
    public AddressPresenter(IGetListInfoView<Address> iGetListInfoView){
        this.iGetListInfoView=iGetListInfoView;
        iGetAddress=new GetAddress();
    }
    public void getItemAddress(final String id){
        iGetAddress.getItemAddress(id,new OnGetAddressListener() {
            @Override
            public void getInfoSuccess(final List<Address> addressList) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        iGetListInfoView.showInfo(addressList);
                    }
                });
            }

            @Override
            public void getInfoFailed() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        iGetListInfoView.showError();
                    }
                });
            }
        });
    }
}

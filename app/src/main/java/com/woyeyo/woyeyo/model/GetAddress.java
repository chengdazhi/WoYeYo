package com.woyeyo.woyeyo.model;

import com.woyeyo.woyeyo.bean.Address;
import com.woyeyo.woyeyo.presenter.OnGetAddressListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fam_000 on 2016/3/19.
 */
public class GetAddress implements IGetAddress {
    @Override
    public void getItemAddress(String id,final OnGetAddressListener listener){
        new Thread(){
            @Override
            public void run(){
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                if(true){
                    //TODO judge if get proper info
                    List<Address> addressList=new ArrayList<Address>();
                    for(int i=0;i<3;i++){
                        Address address=new Address();
                        address.setName("John"+i);
                        address.setPhone("1312111529" + i);
                        address.setAddressDetail("beijing" + i);
                        addressList.add(address);
                    }
                    listener.getInfoSuccess(addressList);
                }
                else {
                    listener.getInfoFailed();
                }
            }
        }.start();
    }
}

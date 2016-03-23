package com.woyeyo.woyeyo.ui.Activity;

import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.woyeyo.woyeyo.R;
import com.woyeyo.woyeyo.adapter.AddressAdapter;
import com.woyeyo.woyeyo.bean.Address;
import com.woyeyo.woyeyo.presenter.AddressPresenter;
import com.woyeyo.woyeyo.view.IGetInfoView;
import com.woyeyo.woyeyo.view.IGetListInfoView;

import java.net.PortUnreachableException;
import java.util.List;

/**
 * Created by fam_000 on 2016/3/19.
 */
public class ChooseAddressActivity extends KBaseActivity implements IGetListInfoView<Address> {
    private ListView listView;
    private String id;
    private AddressAdapter adapter;
    @Override
    public void setResId(){
        mainResId= R.layout.activity_choose_address;
    }
    @Override
    public void setToolBarTitle(){
        title=R.string.choose_address_title;
    }
    @Override
    public void initSpecialView(){
        listView=(ListView)findViewById(R.id.address_listView);
        adapter=new AddressAdapter(mContext);
        AddressPresenter presenter=new AddressPresenter(ChooseAddressActivity.this);
        presenter.getItemAddress(id);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Address address=(Address)listView.getAdapter().getItem(position);
                Toast.makeText(mContext,address.getAddressDetail(),Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public void showInfo(List<Address> addressList){
        adapter.setItems(addressList);
    }
    @Override
    public void showError(){

    }
}

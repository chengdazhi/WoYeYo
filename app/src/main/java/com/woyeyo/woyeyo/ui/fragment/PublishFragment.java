package com.woyeyo.woyeyo.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.woyeyo.woyeyo.R;
import com.woyeyo.woyeyo.bean.PublishInfo;
import com.woyeyo.woyeyo.presenter.PublishPresenter;
import com.woyeyo.woyeyo.utils.CheckEditText;
import com.woyeyo.woyeyo.view.ISendInfoView;

/**
 * Created by fam_000 on 2016/3/18.
 */
public abstract class PublishFragment extends Fragment implements ISendInfoView{
    public static float maxPrice=999;
    private Context context;
    private boolean isbuy;
    private int toastResId;
    private int mainResId;

    /*** iml setImp by setBuyFragment or setSellFragment
     * to set the special attribute sell or buy of
     * this fragment
     */
    abstract void setImp();
    protected void setBuyFragment(){
        isbuy=true;
        toastResId=R.string.empty_buy_desc;
        mainResId=R.layout.trade_info_buy;
    }
    protected void setSellFragment(){
        isbuy=false;
        toastResId=R.string.empty_sell_desc;
        mainResId=R.layout.trade_info_sell;
    }
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle saveInstanceState){
        setImp();
        context=getActivity();
        View view=inflater.inflate(mainResId,container,false);
        super.onCreate(saveInstanceState);
        final EditText descText=(EditText)view.findViewById(R.id.desc);
        final EditText priceText=(EditText)view.findViewById(R.id.price);
        final LinearLayout publish=(LinearLayout)view.findViewById(R.id.publish);
        publish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rawPrice=priceText.getText().toString();
                String desc=descText.getText().toString();
                if(rawPrice.equals("")){
                    Toast.makeText(context,
                            R.string.empty_price, Toast.LENGTH_SHORT).show();
                    return;
                } else if(!((CheckEditText.isPositiveFloat(rawPrice))||
                        (CheckEditText.isPositiveInt(rawPrice)))){
                    Toast.makeText(context,R.string.wrong_price,Toast.LENGTH_SHORT).show();
                    return;
                }
                else if(desc.equals("")){
                    Toast.makeText(context,toastResId
                            ,Toast.LENGTH_SHORT).show();
                    return;
                }
                final float price=Float.parseFloat(rawPrice);
                if(price<0||price>maxPrice){
                    Toast.makeText(context,
                            R.string.wrong_price,Toast.LENGTH_SHORT).show();
                }
                PublishInfo publishInfo=new PublishInfo();
                publishInfo.setIsBuy(isbuy);
                publishInfo.setDesc(desc);
                publishInfo.setPrice(price);
                PublishPresenter presenter=new PublishPresenter(PublishFragment.this);
                presenter.sendPublish(publishInfo);
            }
        });
        return view;
    }
    @Override
    public void showSendSuccess(){
        Toast.makeText(context,"提交成功",Toast.LENGTH_SHORT).show();
    }
    @Override
    public void showSendError(){
        Toast.makeText(context,"提交失败，请检查网络后重试",Toast.LENGTH_SHORT).show();
    }
}

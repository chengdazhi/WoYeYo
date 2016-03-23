package com.woyeyo.woyeyo.ui.Activity;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.woyeyo.woyeyo.R;
import com.woyeyo.woyeyo.bean.User;
import com.woyeyo.woyeyo.presenter.UserInfoPresenter;
import com.woyeyo.woyeyo.utils.ImageUtil;
import com.woyeyo.woyeyo.view.IUserInfoView;

import org.w3c.dom.Text;

/**
 * Created by DongBaishun on 2016/3/18.
 */
public class SellerInfoActivity extends KBaseActivity implements IUserInfoView {
    private UserInfoPresenter presenter;
    private String token;
    private TextView dealNumText;
    private TextView commentNumText;
    private TextView nickName;
    private ImageView photo;
    public void setResId() {
        mainResId = R.layout.activity_seller_info;
    }

    public void setToolBarTitle() {
        title = R.string.seller_info_title;
    }
    @Override
    public void initSpecialView(){
        token="123123";
        //TODO:get token

        dealNumText=(TextView)findViewById(R.id.dealNum);
        commentNumText=(TextView)findViewById(R.id.commentNum);
        nickName =(TextView)findViewById(R.id.nickname);
        photo=(ImageView)findViewById(R.id.coupon_activity_image);
        LinearLayout accusation=(LinearLayout)findViewById(R.id.accusation);
        accusation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, AccusationActivity.class);
                mContext.startActivity(intent);
            }
        });
        Button sendMessage=(Button)findViewById(R.id.sendInfo);
        sendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "message not ready", Toast.LENGTH_SHORT).show();
            }
        });
        presenter=new UserInfoPresenter(SellerInfoActivity.this);
        presenter.getSellerInfofromServer(token);
    }
    @Override
    public void showUserInfo(User user){
        dealNumText.setText(user.getDealNum()+"");
        commentNumText.setText(user.getCommentNum()+"");
        nickName.setText(user.getNickName());
        ImageUtil.displayMyImage(user.getImageUrl(),photo);
    }
    @Override
    public void showError(){

    }


}
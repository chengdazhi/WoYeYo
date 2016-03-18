package com.woyeyo.woyeyo.ui.Activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
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
import com.woyeyo.woyeyo.utils.Token;
import com.woyeyo.woyeyo.view.IUserInfoView;

public class UserInfoActivity extends KBaseActivity implements IUserInfoView{
    private UserInfoPresenter presenter=new UserInfoPresenter(this);
    private String token= Token.getToken();
    public void setResId() {
        mainResId = R.layout.activity_user_info;
    }

    public void setToolBarTitle() {
        title = R.string.user_info_title;
    }
    public void initSpecialView(){
        presenter.getUserInfofromServer(token);
        LinearLayout feedback=(LinearLayout)findViewById(R.id.user_feed_back);
        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext,FeedbackActivity.class);
                mContext.startActivity(intent);
            }
        });
        LinearLayout userAbout=(LinearLayout)findViewById(R.id.userAbout);
        userAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext,AboutActivity.class);
                mContext.startActivity(intent);
            }
        });
    }
    @Override
    public void showUserInfo(User user){
        ImageView photo=(ImageView)findViewById(R.id.userImageAvatar);
        displayMyImage(user.getImageUrl(), photo);
        TextView userNickName=(TextView)findViewById(R.id.userNickname);
        userNickName.setText(user.getNickName());
        TextView userSex=(TextView)findViewById(R.id.userSexyIs);
        String sex=user.getGender();
        if(sex.equals("male")){
            userSex.setText(R.string.male);
        }
        else if(sex.equals("female")){
            userSex.setText(R.string.female);
        }
        TextView comment=(TextView)findViewById(R.id.userCommentContent);
        int com=user.getCommentNum();
        String mComment=com+"条评价";
        comment.setText(mComment);
        //TODO:还差星的显示

    }
    @Override
    public void showError(){
        Toast.makeText(UserInfoActivity.this, "获取失败", Toast.LENGTH_SHORT).show();
    }
    public void displayMyImage(String url,ImageView imageView){
        DisplayImageOptions options = new DisplayImageOptions.Builder().cacheInMemory(true)
                .cacheOnDisk(true).imageScaleType(ImageScaleType.IN_SAMPLE_INT).build();
        ImageLoader.getInstance().displayImage(
                url, imageView, options);
    }

}
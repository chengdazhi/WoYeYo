package com.woyeyo.woyeyo.ui.Activity;

import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import com.woyeyo.woyeyo.R;
import com.woyeyo.woyeyo.presenter.CommentPresenter;
import com.woyeyo.woyeyo.utils.ToastUtil;
import com.woyeyo.woyeyo.view.ISendInfoView;

public class CommentActivity extends KBaseActivity implements ISendInfoView{
    private RatingBar ratingBar;
    private TextView commentContent;
    private Button submit;
    private CommentPresenter presenter;
    public void setResId() {
        mainResId = R.layout.activity_comment;
    }

    public void setToolBarTitle() {
        title = R.string.comment_title;
    }
    public void initSpecialView(){
        ratingBar=(RatingBar)findViewById(R.id.ratingBar);
        commentContent=(TextView)findViewById(R.id.commentContent);
        submit=(Button)findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float rating=ratingBar.getRating();
                String content=commentContent.getText().toString();
                //TODO:check the content is legal or not
                if(rating==0){
                    ToastUtil.KToast(mContext,R.string.empty_starNum);
                    return;
                } else if(content.equals("")){
                    ToastUtil.KToast(mContext,R.string.empty_comment);
                    return;
                }
                presenter=new CommentPresenter(CommentActivity.this);
                presenter.sendCommenttoServer(content,rating);
            }
        });

    }
    @Override
    public void showSendSuccess(){
        ToastUtil.KToast(mContext,R.string.submit_comment_succ);
    }
    public void showSendError(){
        ToastUtil.KToast(mContext,R.string.no_network);
    }
}
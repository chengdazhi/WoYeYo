package com.woyeyo.woyeyo.ui.Activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.woyeyo.woyeyo.R;
import com.woyeyo.woyeyo.presenter.AccusationPresenter;
import com.woyeyo.woyeyo.presenter.FeedBackPresenter;
import com.woyeyo.woyeyo.utils.CheckEditText;
import com.woyeyo.woyeyo.view.ISendInfoView;

public class FeedbackActivity extends KBaseActivity implements ISendInfoView {
    private FeedBackPresenter presenter;
    public void setResId(){
        mainResId=R.layout.activity_feedback;
    }
    public void setToolBarTitle(){
        title=R.string.feedback_title;
    }
    public void initSpecialView(){
        final EditText contentText=(EditText)findViewById(R.id.feedbackContent);
        final EditText contactText=(EditText)findViewById(R.id.feedbackContact);

        Button submit=(Button)findViewById(R.id.feedbackSubmit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = contentText.getText().toString();
                String contact = contactText.getText().toString();
                if (content.equals("")) {
                    Toast.makeText(mContext,
                            R.string.feedback_no_content, Toast.LENGTH_SHORT).show();
                } else if (contact.equals("")) {
                    Toast.makeText(mContext,
                            R.string.no_mobile_number, Toast.LENGTH_SHORT).show();
                } else if (!CheckEditText.isMobileNum(contact)) {
                    Toast.makeText(mContext,
                            R.string.wrong_mobile_number, Toast.LENGTH_SHORT).show();
                } else {
                    presenter = new FeedBackPresenter(FeedbackActivity.this);
                    presenter.sendFeedBacktoServer(content, contact);
                }
            }
        });

    }
    @Override
    public void showSendSuccess(){
        Toast.makeText(mContext,"提交成功",Toast.LENGTH_SHORT).show();
    }
    @Override
    public void showSendError(){
        Toast.makeText(mContext,"提交失败，请检查网络后重试",Toast.LENGTH_SHORT).show();
    }





}

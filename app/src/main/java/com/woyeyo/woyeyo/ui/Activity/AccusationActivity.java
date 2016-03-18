package com.woyeyo.woyeyo.ui.Activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.woyeyo.woyeyo.R;
import com.woyeyo.woyeyo.presenter.AccusationPresenter;
import com.woyeyo.woyeyo.utils.CheckEditText;
import com.woyeyo.woyeyo.view.ISendInfoView;

/**
 * Created by DongBaishun on 2016/3/4.
 */

public class AccusationActivity extends KBaseActivity implements ISendInfoView{
    private AccusationPresenter presenter;
    public void setResId(){
        mainResId=R.layout.activity_accusation;
    }
    public void setToolBarTitle(){
        title=R.string.accusation_title;
    }
    public void initSpecialView(){
        final EditText contentText=(EditText)findViewById(R.id.accusationContent);
        final EditText contactText=(EditText)findViewById(R.id.accusationContact);

        Button submit=(Button)findViewById(R.id.accusationSubmit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content=contentText.getText().toString();
                String contact=contactText.getText().toString();
                if(content.equals("")){
                    Toast.makeText(mContext,
                            R.string.accusation_no_content,Toast.LENGTH_SHORT).show();
                }
                else if(contact.equals("")){
                    Toast.makeText(mContext,
                            R.string.no_mobile_number,Toast.LENGTH_SHORT).show();
                }
                else if(!CheckEditText.isMobileNum(contact)){
                    Toast.makeText(mContext,
                            R.string.wrong_mobile_number,Toast.LENGTH_SHORT).show();
                }
                else{
                    presenter=new AccusationPresenter(AccusationActivity.this);
                    presenter.sendAccsationtoServer(content,contact);
                }
            }
        });

    }
    @Override
    public void showSendSuccess(){
        Toast.makeText(mContext,"提交成功",Toast.LENGTH_SHORT).show();
    }
    public void showSendError(){
        Toast.makeText(mContext,"提交失败，请检查网络后重试",Toast.LENGTH_SHORT).show();
    }


}

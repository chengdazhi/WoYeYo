package com.woyeyo.woyeyo.ui.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.woyeyo.woyeyo.R;

/**
 * Created by DongBaishun on 2016/3/21.
 */
public class CommentDetailActivity extends KBaseActivity {

    int flag = 0;//标记点击次数

    public void setResId(){
        mainResId= R.layout.activity_comment_detail;
        toolbarResId=R.id.test_main_page_toolbar;
    }
    public void setToolBarTitle(){
        title=R.string.comment_detail_title;
    }

    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Button reply = (Button) findViewById(R.id.reply);
        final EditText content = (EditText) findViewById(R.id.replyContent);

        reply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag == 0){
                    content.setVisibility(View.VISIBLE);
                }else if(flag == 1){
                    content.setVisibility(View.INVISIBLE);
                }
                flag = (flag+1) % 2;
            }
        });
    }

}

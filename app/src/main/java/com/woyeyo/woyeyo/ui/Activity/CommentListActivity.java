package com.woyeyo.woyeyo.ui.Activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.woyeyo.woyeyo.R;

/**
 * Created by DongBaishun on 2016/3/21.
 */
public class CommentListActivity extends KBaseActivity {



    public void setResId(){
        mainResId= R.layout.activity_comment_list;
    }
    public void setToolBarTitle(){
        title=R.string.comment_detail_title;
    }

    public void initSpecialView(){
        Button reply = (Button) findViewById(R.id.reply);
        final EditText content = (EditText) findViewById(R.id.replyContent);


    }

}

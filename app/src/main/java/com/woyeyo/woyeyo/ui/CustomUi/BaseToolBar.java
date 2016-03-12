package com.woyeyo.woyeyo.ui.CustomUi;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;


import com.woyeyo.woyeyo.R;


/**
 * Created by fam_000 on 2016/3/12.
 */
public class BaseToolBar extends LinearLayout {
    private CharSequence title;
    private Drawable back;
    private Drawable message;
    public BaseToolBar(Context context){
       this(context, null);
    }
    public BaseToolBar(Context context,AttributeSet attrs){
        super(context, attrs);
//        TypedArray a=context.obtainStyledAttributes(attrs, R.styleable.BaseToolBar);
//        title=a.getText(R.styleable.BaseToolBar_titleText);
//        back=a.getDrawable(R.styleable.BaseToolBar_backIconSrc);
//        message=a.getDrawable(R.styleable.BaseToolBar_messageIconSrc);
//        a.recycle();

    }
    @Override
    protected void onFinishInflate(){
        super.onFinishInflate();
        LayoutInflater.from(getContext()).inflate(R.layout.base_tool_bar, this);
        Toolbar toolbar=(Toolbar)findViewById(R.id.base_toolbar);
        toolbar.setNavigationIcon(back);
        toolbar.setNavigationOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Activity activity = (Activity) getContext();
                activity.onBackPressed();
            }
        });

    }

}

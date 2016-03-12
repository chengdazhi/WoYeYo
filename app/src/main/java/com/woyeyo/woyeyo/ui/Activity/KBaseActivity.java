package com.woyeyo.woyeyo.ui.Activity;


import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.woyeyo.woyeyo.R;
import com.woyeyo.woyeyo.utils.Clog;


/**
 * Created by fam_000 on 2016/3/12.
 */
public abstract class KBaseActivity extends AppCompatActivity {
    protected int mainResId=0;
    protected int toolbarResId=0;
    protected int menuResId=0;
    protected Toolbar toolbar;
    protected int title=0;
    private TextView titleTextView;
    private Toolbar.OnMenuItemClickListener newListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setResId();
        setContentView(mainResId);
        toolbar=(Toolbar)findViewById(toolbarResId);

        titleTextView=(TextView)findViewById(R.id.my_toolbar_title);

        setToolBarTitle();
        if(title!=0){
            titleTextView.setText(title);
        }
        else{
            titleTextView.setText(title);
        }

        setSupportActionBar(toolbar);

        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayShowTitleEnabled(false);
        }
        else{
            Clog.e("KbaseActivity", "no toolbar!");
        }

        newListener=setOnMenuItemClickListener();
        setBackButton();


        if(newListener!=null){
            toolbar.setOnMenuItemClickListener(newListener);
        }
        else{
            toolbar.setOnMenuItemClickListener(onMenuItemClickListener);
        }
        initSpecialView();
    }
    protected Toolbar.OnMenuItemClickListener onMenuItemClickListener=
            new Toolbar.OnMenuItemClickListener(){
                @Override
                public boolean onMenuItemClick(MenuItem menuItem){
                    switch (menuItem.getItemId()){
                        case R.id.toolbar_message:
                            Toast.makeText(getApplicationContext()
                                    ,"not ready",Toast.LENGTH_SHORT).show();
                            break;
                    }
                    return true;
                }
            };
    //must set mainResouceId,toolbarId,menuResId
    abstract void setResId();
    abstract void setToolBarTitle();
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        if(menuResId!=0){
            getMenuInflater().inflate(menuResId,menu);
            return true;
        }
        //set baseToolBar for default
        else {
            getMenuInflater().inflate(R.menu.base_tool_bar_menu,menu);
            return true;
        }
    }
    //just for override if need
    public Toolbar.OnMenuItemClickListener setOnMenuItemClickListener(){
        return null;
    }
    //just for override if need
    public void initSpecialView(){

    }
    public void setBackButton(){
        toolbar.setNavigationIcon(R.drawable.back_icon);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

}

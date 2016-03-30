package com.woyeyo.woyeyo.ui.CustomUi;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.woyeyo.woyeyo.R;
import com.woyeyo.woyeyo.presenter.UserInfoPresenter;

/**
 * Created by fam_000 on 2016/3/30.
 */
public class PopupGenderMenu extends BasePopupView {
    private Button setMan,setWoman;
    @Override
    protected void setResId(){
        mainResId=R.layout.popup_window_change_sex;
    }
    public PopupGenderMenu(Activity context, final UserInfoPresenter presenter){
        super(context);
        setMan=(Button)menuView.findViewById(R.id.man);
        setWoman=(Button)menuView.findViewById(R.id.woman);
        final TextView userSex=(TextView)context.findViewById(R.id.userSexyIs);
        setMan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.changeSex(true);
                userSex.setText(R.string.male);
            }
        });
        setWoman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.changeSex(false);
                userSex.setText(R.string.female);
            }
        });
    }

}

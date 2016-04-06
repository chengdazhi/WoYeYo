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
public abstract class BasePopupView extends PopupWindow {
    protected int mainResId;
    protected View menuView;
    abstract protected void setResId();
    public BasePopupView(Activity context){
        super(context);
        setResId();
        menuView=context.getLayoutInflater().
                inflate(mainResId, null);
        this.setContentView(menuView);
        this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        this.setFocusable(true);
        this.setAnimationStyle(R.style.Animation_AppCompat_DropDownUp);
        ColorDrawable dw = new ColorDrawable(0xb0000000);
        this.setBackgroundDrawable(dw);
        menuView.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {

                int height = menuView.findViewById(R.id.outLayout).getTop();
                int y = (int) event.getY();
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (y < height) {
                        dismiss();
                    }
                }
                return true;
            }
        });

    }
}

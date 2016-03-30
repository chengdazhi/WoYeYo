package com.woyeyo.woyeyo.ui.CustomUi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

import com.woyeyo.woyeyo.R;
import com.woyeyo.woyeyo.presenter.UserInfoPresenter;

import java.io.File;
import java.io.IOException;

/**
 * Created by fam_000 on 2016/3/30.
 */
public class PopupPhoto extends BasePopupView {
    @Override
    protected void setResId(){
        mainResId= R.layout.change_photo_menu;
    }
    public PopupPhoto(final Activity context,final UserInfoPresenter presenter){
        super(context);

    }
    public View getMenuView(){
        return menuView;
    }
}

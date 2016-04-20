package com.woyeyo.woyeyo.ui.Activity;

import android.annotation.TargetApi;
import android.content.ContentUris;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.woyeyo.woyeyo.R;
import com.woyeyo.woyeyo.bean.User;
import com.woyeyo.woyeyo.presenter.UserInfoPresenter;
import com.woyeyo.woyeyo.ui.CustomUi.PopupGenderMenu;
import com.woyeyo.woyeyo.ui.CustomUi.PopupPhoto;
import com.woyeyo.woyeyo.utils.ToastUtil;
import com.woyeyo.woyeyo.utils.Token;
import com.woyeyo.woyeyo.view.IUserInfoView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class UserInfoActivity extends KBaseActivity implements IUserInfoView {
    private Uri imageUri;
    private ImageView photo;
    public static final int TAKE_PHOTO=0;
    public static final int CROP_PHOTO=1;
    public static final int CHOOSE_PHOTO=2;
    private boolean isMe;
    private UserInfoPresenter presenter=new UserInfoPresenter(this);
    private String token= Token.getToken();
    public void setResId() {
        mainResId = R.layout.activity_user_info;
    }

    public void setToolBarTitle() {
        title = R.string.user_info_title;
    }
    public void initSpecialView(){
        isMe=getIntent().getBooleanExtra("isMe",false);
        presenter.getUserInfofromServer(token);
        LinearLayout feedback=(LinearLayout)findViewById(R.id.user_feed_back);
        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext,FeedbackActivity.class);
                mContext.startActivity(intent);
            }
        });
        LinearLayout userAbout=(LinearLayout)findViewById(R.id.userAbout);
        userAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext,AboutActivity.class);
                mContext.startActivity(intent);
            }
        });
    }
    @Override
    public void showUserInfo(User user){
        photo=(ImageView)findViewById(R.id.userImageAvatar);
        displayMyImage(user.getImageUrl(), photo);
        TextView userNickName=(TextView)findViewById(R.id.userNickname);
        userNickName.setText(user.getNickName());
        final TextView userSex=(TextView)findViewById(R.id.userSexyIs);
        String sex=user.getGender();
        if(sex.equals("male")){
            userSex.setText(R.string.male);
        }
        else if(sex.equals("female")){
            userSex.setText(R.string.female);
        }
        TextView comment=(TextView)findViewById(R.id.userCommentContent);
        int com=user.getCommentNum();
        final String mComment=com+"条评价";
        comment.setText(mComment);

        LinearLayout userComment=(LinearLayout)findViewById(R.id.userComment);
        userComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext,CommentListActivity.class);
                mContext.startActivity(intent);
            }
        });
        RatingBar ratingBar=(RatingBar)findViewById(R.id.ratingBar);
        ratingBar.setRating(user.getStarNum());

        if(isMe){
            userSex.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    PopupGenderMenu popupGenderMenu =new PopupGenderMenu(UserInfoActivity.this,presenter);
                    popupGenderMenu.showAtLocation(UserInfoActivity.
                                    this.findViewById(R.id.outLayout),
                            Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL,0,0);

                }
            });
            photo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    PopupPhoto popupPhoto=new PopupPhoto(UserInfoActivity.this,presenter);
                    View menuView=popupPhoto.getMenuView();
                    Button takePhoto=(Button)menuView.findViewById(R.id.take_photo);
                    Button pickPhoto=(Button)menuView.findViewById(R.id.pick_photo);
                    takePhoto.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String SDstate=Environment.getExternalStorageState();
                            if(SDstate.equals(Environment.MEDIA_MOUNTED)){
                                try{
//                                    ContentValues values=new ContentValues();
//                                    imageUri=getContentResolver().insert(MediaStore.
//                                            Images.Media.EXTERNAL_CONTENT_URI,values);
                                    File outputImage=new File(Environment.
                                            getExternalStorageDirectory(),"output_image.jpg");
                                    try{
                                        if(outputImage.exists()){
                                            outputImage.delete();
                                        }
                                        outputImage.createNewFile();
                                    }catch (IOException e){
                                        e.printStackTrace();
                                    }
                                    imageUri= Uri.fromFile(outputImage);
                                    Intent intent=new Intent("android.media.action.IMAGE_CAPTURE");
                                    intent.putExtra(MediaStore.EXTRA_OUTPUT,imageUri);
                                    startActivityForResult(intent, TAKE_PHOTO);
                                } catch (SecurityException e){
                                    ToastUtil.KToast(mContext,R.string.no_sd_card_permission);
                                }

                            }
                            else {
                                ToastUtil.KToast(mContext,R.string.no_sd_card);
                                //TODO:handle the no SD card case
                            }


                        }
                    });
                    pickPhoto.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent=new Intent(
                                    "android.intent.action.GET_CONTENT");
                            intent.setType("image/*");
                            startActivityForResult(intent,CHOOSE_PHOTO);

                        }
                    });
                    popupPhoto.showAtLocation(UserInfoActivity.
                                    this.findViewById(R.id.outLayout),
                            Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL,0,0);
                }
            });
        }

    }
    @Override
    public void showError(){
        Toast.makeText(UserInfoActivity.this, "获取失败", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void showChangeSucc(){
        ToastUtil.KToast(mContext, R.string.change_succ);

    }
    @Override
    public void showChangeFail(){
        ToastUtil.KToast(mContext,R.string.change_fail);
    }
    public void displayMyImage(String url,ImageView imageView){
        DisplayImageOptions options = new DisplayImageOptions.Builder().cacheInMemory(true)
                .cacheOnDisk(true).imageScaleType(ImageScaleType.IN_SAMPLE_INT).build();
        ImageLoader.getInstance().displayImage(
                url, imageView, options);
    }
    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        switch (requestCode){
            case TAKE_PHOTO:
                if(resultCode==RESULT_OK){
                    Intent intent=new Intent("com.android.camera.action.CROP");
                    intent.setDataAndType(imageUri,"image/*");
                    intent.putExtra("scale", true);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT,imageUri);
                    startActivityForResult(intent,CROP_PHOTO);
                }
                break;
            case CROP_PHOTO:
                if(resultCode==RESULT_OK){
                    try {
                        Bitmap bitmap= BitmapFactory.decodeStream
                                (getContentResolver().openInputStream(imageUri));
                        photo.setImageBitmap(bitmap);
                        presenter.changePhoto(bitmap);
                    } catch (FileNotFoundException e){
                        e.printStackTrace();
                    }
                }
                break;
            case CHOOSE_PHOTO:
                if(resultCode==RESULT_OK){
                    if(Build.VERSION.SDK_INT>=19){
                        handleImageOnKitKat(data);
                    } else {
                        handleImageBeforeKitKat(data);
                    }
                }
                break;
            default:
                break;
        }
    }
    @TargetApi(19)
    private void handleImageOnKitKat(Intent data){
        String imagePath=null;
        Uri uri=data.getData();
        if(DocumentsContract.isDocumentUri(this,uri)){
            String docId=DocumentsContract.getDocumentId(uri);
            if("com.android.providers.media.documents".equals(
                    uri.getAuthority()
            )){
                String id= docId.split(":")[1];
                String selection=MediaStore.Images.Media._ID+"="+id;
                imagePath=getImagePath(MediaStore.Images.Media.
                        EXTERNAL_CONTENT_URI,selection);
            } else if("com.android.providers.downloads.documents".
                    equals(uri.getAuthority())) {
                Uri contentUri = ContentUris.withAppendedId(
                        Uri.parse("content://downloads/public_downloads"),Long.valueOf(docId)
                );
                imagePath=getImagePath(contentUri,null);
            } else if ("content".equalsIgnoreCase(uri.getScheme())){
                imagePath=getImagePath(uri,null);
            }
            displayImage(imagePath);
        }
    }
    private void handleImageBeforeKitKat(Intent data){
        Uri uri=data.getData();
        String imagePath =getImagePath(uri, null);
        displayImage(imagePath);
    }
    private String getImagePath(Uri uri,String selection) {
        String path=null;
        Cursor cursor=getContentResolver().
                query(uri, null, selection, null, null);
        if(cursor!=null){
            if(cursor.moveToFirst()){
                path=cursor.getString(
                        cursor.getColumnIndex(MediaStore.Images.Media.DATA)
                );
                cursor.close();
            }
        }
        return path;
    }
    private void displayImage(String imagePath){
        if(imagePath!=null){
            Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
            photo.setImageBitmap(bitmap);
            presenter.changePhoto(bitmap);
        } else {
            ToastUtil.KToast(mContext,R.string.fail_to_get_photo);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        if(menuResId!=0){
            getMenuInflater().inflate(menuResId, menu);
            return true;
        }
        //set baseToolBar for default
        else {
            getMenuInflater().inflate(R.menu.user_info_toolbar, menu);
            return true;
        }
    }
    @Override
    public Toolbar.OnMenuItemClickListener setOnMenuItemClickListener(){
        Toolbar.OnMenuItemClickListener listener=new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.toolbar_message:
                        Toast.makeText(getApplicationContext()
                                ,"not ready",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.edit:
                        Intent intent=new Intent(UserInfoActivity.this,SettingActivity.class);
                        startActivity(intent);
                }
                return true;
            }
        };
        return listener;
    }


}
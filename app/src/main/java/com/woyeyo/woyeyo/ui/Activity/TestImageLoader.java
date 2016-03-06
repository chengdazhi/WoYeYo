package com.woyeyo.woyeyo.ui.Activity;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.woyeyo.woyeyo.R;
import com.woyeyo.woyeyo.utils.Clog;

public class TestImageLoader extends AppCompatActivity {
    private String url="http://static9.depositphotos.com/thumbs/1144687/image/1170/11708428/api_thumb_450.jpg";
    private ImageView imageView;
    private DisplayImageOptions options;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_my_image_loader);
        imageView=(ImageView)findViewById(R.id.test_my_img);
        ImageLoader imageLoader=ImageLoader.getInstance();
        options = new DisplayImageOptions.Builder()
                .showImageForEmptyUri(R.drawable.button_up)
                .showImageOnFail(R.drawable.button_up)
                .resetViewBeforeLoading(true)
                .cacheOnDisk(true)
                .imageScaleType(ImageScaleType.EXACTLY)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .considerExifParams(true)
                .displayer(new FadeInBitmapDisplayer(300))
                .build();
        imageLoader.displayImage(url, imageView,options, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {
                Clog.d("f","start loading");
            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                Clog.d("f","fail loading");
            }


            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                Clog.d("f","complete loading");
            }
            @Override
            public void onLoadingCancelled(String imageUri, View view) {
                Clog.d("f","cancel loading");
            }
        });
    }
}

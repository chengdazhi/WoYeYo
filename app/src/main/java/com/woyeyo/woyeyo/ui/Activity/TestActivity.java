package com.woyeyo.woyeyo.ui.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.woyeyo.woyeyo.R;
import com.woyeyo.woyeyo.adapter.ScrollViewPageAdapter;
import com.woyeyo.woyeyo.utils.AutoScrollViewPager;

import java.util.Arrays;

public class TestActivity extends AppCompatActivity {
    private String[] imgs= {"http://h.hiphotos.baidu.com/image/w%3D1920%3Bcrop%3D0%2C0%2C1920%2C1080/sign=fed1392e952bd40742c7d7f449b9a532/e4dde71190ef76c6501a5c2d9f16fdfaae5167e8.jpg",
            "http://a.hiphotos.baidu.com/image/w%3D1920%3Bcrop%3D0%2C0%2C1920%2C1080/sign=25d477ebe51190ef01fb96d6fc2ba675/503d269759ee3d6df51a20cd41166d224e4adedc.jpg",
            "http://c.hiphotos.baidu.com/image/w%3D1920%3Bcrop%3D0%2C0%2C1920%2C1080/sign=70d2b81e60d0f703e6b291d53aca6a5e/0ff41bd5ad6eddc4ab1b5af23bdbb6fd5266333f.jpg"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        AutoScrollViewPager pager=(AutoScrollViewPager)findViewById(R.id.scroll_pager);
        ScrollViewPageAdapter viewPageAdapter=new ScrollViewPageAdapter(Arrays.asList(imgs));
        pager.setAdapter(viewPageAdapter);
        pager.setScrollFactor(5);
        pager.setOffscreenPageLimit(4);
        pager.startAutoScroll(2000);
        pager.setOnPageClickListener(new AutoScrollViewPager.OnPageClickListener() {
            @Override
            public void onPageClick(AutoScrollViewPager autoScrollPager, int position) {
            }
        });
    }

}

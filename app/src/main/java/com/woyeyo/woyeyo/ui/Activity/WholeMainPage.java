package com.woyeyo.woyeyo.ui.Activity;

import android.content.Intent;
import android.view.View;

import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;
import com.woyeyo.woyeyo.R;

/**
 * Created by fam_000 on 2016/3/12.
 */
public class WholeMainPage extends KBaseActivity {
    private Drawer result;
    public void setResId(){
        mainResId= R.layout.activity_test_whole_main_page;
        toolbarResId=R.id.test_main_page_toolbar;
    }
    public void setToolBarTitle(){
        title=R.string.mainpage_title;
    }
    @Override
    public void initSpecialView(){
        new DrawerBuilder().withActivity(this).build();
        PrimaryDrawerItem item1 = new PrimaryDrawerItem().withName(R.string.drawer_item1_name).withIdentifier(1);
        SecondaryDrawerItem item2 = new SecondaryDrawerItem().
                withName(R.string.drawer_item2_name).withIdentifier(2);
        PrimaryDrawerItem item3=new PrimaryDrawerItem().withName("测试交易广场").withIdentifier(3);


        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.header)
                .addProfiles(
                        new ProfileDrawerItem().withName("Mike Penz")
                                //.withEmail("mikepenz@gmail.com")
                                .withIcon(getResources().
                                getDrawable(R.drawable.profile6))

                )
                .withOnAccountHeaderProfileImageListener(new AccountHeader.
                        OnAccountHeaderProfileImageListener(){
                    @Override
                    public boolean onProfileImageClick(View view, IProfile profile, boolean current){
                        Intent intent=new Intent(mContext,UserInfoActivity.class);
                        intent.putExtra("isMe",true);
                        mContext.startActivity(intent);
                        return true;
                    }
                    @Override
                    public boolean onProfileImageLongClick(View view,
                                                           IProfile profile, boolean current){
                        return onProfileImageClick(view,profile,current);
                    }

                })
                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                    @Override
                    public boolean onProfileChanged(View view, IProfile profile, boolean currentProfile) {
                        return false;
                    }
                })
                .build();

        result = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .withAccountHeader(headerResult)
                .addDrawerItems(
                        item1,
                        new DividerDrawerItem(),
                        item2,
                        item3,
                        new PrimaryDrawerItem().withName(R.string.app_name).withIdentifier(5)
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        // do something with the clicked item :D
                        return true;
                    }
                })
                .withOnDrawerItemClickListener(
                        new Drawer.OnDrawerItemClickListener() {
                            @Override
                            public boolean onItemClick(
                                    View view, int position, IDrawerItem drawerItem) {
                                if (drawerItem != null) {
                                    Intent intent = null;
                                    if (drawerItem.getIdentifier() == 3) {
                                        intent = new Intent(
                                                WholeMainPage.this, TestTradeSquare.class);
                                    } else if (drawerItem.getIdentifier() == 1) {
                                        intent = new Intent(
                                                WholeMainPage.this, CategoryCouponActivity.class);
                                        intent.putExtra("category","mov");
                                    }
                                    else if(drawerItem.getIdentifier()==2){
                                        intent = new Intent(WholeMainPage.this,
                                                CategoryCouponActivity.class);
                                        intent.putExtra("category","buy");
                                    }
                                    else if(drawerItem.getIdentifier()==5){
                                        intent = new Intent(
                                                WholeMainPage.this, MyAccountActivity.class);
                                    }
                                    if (intent != null) {
                                        WholeMainPage.this.startActivity(intent);
                                    }
                                }
                                return false;
                            }
                        }).build();
    }

    @Override
    public void onBackPressed() {
        //handle the back press :D close the drawer first and if the drawer is closed close the activity
        if (result != null && result.isDrawerOpen()) {
            result.closeDrawer();
        } else {
            super.onBackPressed();
        }
    }
}

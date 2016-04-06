package com.woyeyo.woyeyo.model;

import com.woyeyo.woyeyo.bean.Comment;
import com.woyeyo.woyeyo.bean.Trade;
import com.woyeyo.woyeyo.presenter.OnInfoListener;
import com.woyeyo.woyeyo.utils.Token;
import com.woyeyo.woyeyo.utils.UrlConstants;
import com.woyeyo.woyeyo.view.IGetInfoView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fam_000 on 2016/3/23.
 */
public class GetComment implements IGetComment {
    public void getComment(final int itemCount,final OnInfoListener listener){
        new Thread(){
            @Override
            public void run(){
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                if(true){
                    //TODO judge if get proper info
                    String token= Token.getToken();
                    //TODO:get token
                    List<Comment> list=new ArrayList<Comment>();
                    for(int i=1;i<=5;i++){
                        int j=i+itemCount;
                        Comment comment=new Comment();
                        comment.setStarNum(j%5);
                        comment.setReview("good" + j);
                        comment.setPersonImgUrl(UrlConstants.userAva[j%3]);
                        comment.setPersonNickname("Nico"+j);
                        list.add(comment);
                    }
                    listener.getInfoSuccess(list);
                }
                else {
                    listener.getInfoFailed();
                }
            }
        }.start();
    }
}

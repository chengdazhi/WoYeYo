package com.woyeyo.woyeyo.presenter;

import android.os.Handler;

import com.woyeyo.woyeyo.bean.Comment;
import com.woyeyo.woyeyo.bean.Trade;
import com.woyeyo.woyeyo.model.GetComment;
import com.woyeyo.woyeyo.model.GetTrade;
import com.woyeyo.woyeyo.model.GetTradeInfo;
import com.woyeyo.woyeyo.model.IGetComment;
import com.woyeyo.woyeyo.view.IListView;

import java.util.List;

/**
 * Created by fam_000 on 2016/3/23.
 */
public class CommentListPresenter {
    private IListView<Comment> iGetInfoView;
    private IGetComment iGetComment;
    private Handler mHandler=new Handler();
    public CommentListPresenter(IListView<Comment> iGetInfoView){
        this.iGetInfoView=iGetInfoView;
        iGetComment=new GetComment();
    }
    public void getInfointoView(final int itemCount){
        iGetComment.getComment(itemCount,new OnInfoListener() {
            @Override
            public void getInfoSuccess(final List list) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (itemCount == 0) {
                            iGetInfoView.toPullFresh(list);
                        } else {
                            iGetInfoView.toLoadMore(list);
                        }
                    }
                });
            }

            @Override
            public void getInfoFailed() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        iGetInfoView.showFailedError();
                    }
                });
            }
        });

    }
}

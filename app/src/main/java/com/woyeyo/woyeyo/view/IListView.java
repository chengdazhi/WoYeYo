package com.woyeyo.woyeyo.view;

import com.woyeyo.woyeyo.bean.Coupon;

import java.util.List;

/**
 * Created by fam_000 on 2016/3/7.
 */
public interface IListView<T> {
    void toPullFresh(List<T> list);
    void toLoadMore(List<T> list);
    void showFailedError();
}

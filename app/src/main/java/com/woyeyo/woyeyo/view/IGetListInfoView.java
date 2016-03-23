package com.woyeyo.woyeyo.view;

import java.util.List;

/**
 * Created by fam_000 on 2016/3/19.
 */
public interface IGetListInfoView<T> {
    void showInfo(List<T> list);
    void showError();

}

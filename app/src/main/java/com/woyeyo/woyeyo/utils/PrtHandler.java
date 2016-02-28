package com.woyeyo.woyeyo.utils;

import android.view.View;

import in.srain.cube.views.ptr.PtrFrameLayout;

/**
 * Created by fam_000 on 2016/2/27.
 */
public interface PrtHandler {
    /**
     * 检查是否可以执行下来刷新，比如列表为空或者列表第一项在最上面时。
     * <p/>
     * {@link in.srain.cube.views.ptr.PtrDefaultHandler#checkContentCanBePulledDown}
     */
    public boolean checkCanDoRefresh(final PtrFrameLayout frame, final View content, final View header);

    /**
     * 需要加载数据时触发
     *
     * @param frame
     */
    public void onRefreshBegin(final PtrFrameLayout frame);
}

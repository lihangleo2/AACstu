package com.lihang.viewmodelstu.viewmodel;

import com.lihang.viewmodelstu.utils.LogUtils;

import androidx.lifecycle.ViewModel;

/**
 * Created by leo
 * on 2019/10/8.
 */
public class MyViewModel extends ViewModel {

    @Override
    protected void onCleared() {
        super.onCleared();
        LogUtils.i("MyViewModel的相关","Activity被杀死后也会被销毁！");
    }
}

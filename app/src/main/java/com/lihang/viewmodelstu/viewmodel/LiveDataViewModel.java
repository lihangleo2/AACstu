package com.lihang.viewmodelstu.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Created by leo
 * on 2019/10/8.
 */
public class LiveDataViewModel extends ViewModel {
    private MutableLiveData<String> nameLiveData = new MutableLiveData<>();

    public MutableLiveData<String> getData() {
        return nameLiveData;
    }

}

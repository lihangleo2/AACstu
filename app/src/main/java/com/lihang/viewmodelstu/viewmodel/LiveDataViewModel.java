package com.lihang.viewmodelstu.viewmodel;

import com.lihang.viewmodelstu.bean.User;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Created by leo
 * on 2019/10/8.
 */
public class LiveDataViewModel extends ViewModel {
    private MutableLiveData<User> userLiveData = new MutableLiveData<>();

    public LiveData<User> getData() {
        return userLiveData;
    }

    public void update(User user) {
        userLiveData.postValue(user);
//        userLiveData.setValue(user);
    }


}

package com.lihang.viewmodelstu.ui.activity;

import android.app.Activity;
import android.os.Bundle;

import com.lihang.viewmodelstu.R;
import com.lihang.viewmodelstu.observer.MyObserver;
import com.lihang.viewmodelstu.utils.LogUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

/**
 * Created by leo
 * on 2019/10/14.
 */
public class LifecyclesActivity extends Activity implements LifecycleOwner {
    private MutableLiveData<String> liveData = new MutableLiveData<>();
    private LifecycleRegistry mLifecycleRegistry = new LifecycleRegistry(this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycles);
        LogUtils.i("观察LiveData", " 没有走吗啊！");
        liveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                LogUtils.i("观察LiveData", " ==> " + s);
            }
        });
        getLifecycle().addObserver(new MyObserver());

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        mLifecycleRegistry.markState(Lifecycle.State.CREATED);
        super.onSaveInstanceState(outState);
    }

    @NonNull
    @Override
    public Lifecycle getLifecycle() {
        return mLifecycleRegistry;
    }

    @Override
    protected void onStop() {
        super.onStop();
        liveData.postValue("运行试试");
    }
}

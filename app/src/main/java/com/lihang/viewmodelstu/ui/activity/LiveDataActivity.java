package com.lihang.viewmodelstu.ui.activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import com.lihang.viewmodelstu.R;
import com.lihang.viewmodelstu.bean.TestBean;
import com.lihang.viewmodelstu.databinding.ActivityLivedataBinding;
import com.lihang.viewmodelstu.utils.LogUtils;
import com.lihang.viewmodelstu.utils.ToastUtils;
import com.lihang.viewmodelstu.viewmodel.LiveDataViewModel;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

/**
 * Created by leo
 * on 2019/10/8.
 */
public class LiveDataActivity extends AppCompatActivity {
    ActivityLivedataBinding binding;
    private MutableLiveData<String> liveData = new MutableLiveData<>();
    private TestBean testBean = new TestBean();
    private LiveDataViewModel model;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livedata);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_livedata);
        binding.setOnlyLive(liveData.getValue());
        binding.setDataBsource(testBean);
        binding.setLifecycleOwner(this);
        model = ViewModelProviders.of(this).get(LiveDataViewModel.class);
        binding.setLiveViewModel(model);
        addLiveObserve();
        addTextViewChange();

    }

    private void addTextViewChange() {
        binding.txtOnlyLive.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                LogUtils.i("TextView的变化", "单独使用LiveData ==> " + s);
            }
        });


        binding.txtDataBinding.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                LogUtils.i("TextView的变化", "DataBinding双向绑定 ==> " + s);
            }
        });


        binding.txtViewmodelLivedata.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                LogUtils.i("TextView的变化", "ViewModel配合LiveData使用 ==> " + s);
            }
        });


    }

    private void addLiveObserve() {
        liveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.setOnlyLive(s);
                LogUtils.i("观察LiveData", "单独使用LiveData ==> " + s);
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        liveData.postValue("单独LiveData使用");
        testBean.name.set("我是DataBinding双向绑定");
        model.getData().postValue("ViewModel配合LiveData使用");
    }
}

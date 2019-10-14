package com.lihang.viewmodelstu;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.view.View;

import com.lihang.viewmodelstu.databinding.ActivityMainBinding;
import com.lihang.viewmodelstu.roomabout.DBInstance;
import com.lihang.viewmodelstu.roomabout.withrxjava.Dog;
import com.lihang.viewmodelstu.ui.activity.LifecyclesActivity;
import com.lihang.viewmodelstu.ui.activity.LiveDataActivity;
import com.lihang.viewmodelstu.ui.activity.RoomActivity;
import com.lihang.viewmodelstu.ui.activity.ViewModelActivity;
import com.lihang.viewmodelstu.ui.activity.WithRxJavaActivity;
import com.lihang.viewmodelstu.utils.ActivityUtils;
import com.lihang.viewmodelstu.utils.ToastUtils;

import java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_viewModel:
                ActivityUtils.transfer(MainActivity.this, ViewModelActivity.class);
                break;

            case R.id.btn_liveData:
                ActivityUtils.transfer(MainActivity.this, LiveDataActivity.class);
                break;

            case R.id.btn_room:
                ActivityUtils.transfer(MainActivity.this, RoomActivity.class);
                break;

            case R.id.btn_with_rxjava:
                ActivityUtils.transfer(MainActivity.this, WithRxJavaActivity.class);
                break;

            case R.id.btn_with_livedata:
                DBInstance.getInstance().getDogDao().getToLiveData(2, 12).observe(this, new Observer<List<Dog>>() {
                    @Override
                    public void onChanged(List<Dog> dogs) {
                        ToastUtils.showToast("查出来的当前size长度 ==> " + dogs.size());
                    }
                });
                break;

            case R.id.btn_with_lifecycles:
                ActivityUtils.transfer(MainActivity.this, LifecyclesActivity.class);
                break;
        }
    }
}

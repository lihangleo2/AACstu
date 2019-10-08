package com.lihang.viewmodelstu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.lihang.viewmodelstu.databinding.ActivityMainBinding;
import com.lihang.viewmodelstu.ui.activity.LiveDataActivity;
import com.lihang.viewmodelstu.ui.activity.ViewModelActivity;
import com.lihang.viewmodelstu.utils.ActivityUtils;


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
        }
    }
}

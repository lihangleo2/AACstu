package com.lihang.viewmodelstu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.lihang.viewmodelstu.databinding.ActivityMainBinding;
import com.lihang.viewmodelstu.ui.ViewModelActivity;
import com.lihang.viewmodelstu.utils.ActivityUtils;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setOnClickListener(this);
////        MyViewModel myViewModel = ViewModelProviders.of(this).get(MyViewModel.class);
//        ViewModelProviders.of(this).get(MyViewModel.class).getDatas()
//                .observe(this, new Observer<User>() {
//                    @Override
//                    public void onChanged(User user) {
//                        //获取实体数据
//                        Log.e("实体数据", user.hashCode() + "");
//                    }
//                });
//
//        binding.btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ViewModelProviders.of(MainActivity.this).get(MyViewModel.class).getUser();
//            }
//        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_viewModel:
                ActivityUtils.transfer(MainActivity.this, ViewModelActivity.class);
                break;
        }
    }
}

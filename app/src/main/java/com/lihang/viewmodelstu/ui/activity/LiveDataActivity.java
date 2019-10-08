package com.lihang.viewmodelstu.ui.activity;

import android.os.Bundle;
import android.view.View;

import com.lihang.viewmodelstu.R;
import com.lihang.viewmodelstu.bean.User;
import com.lihang.viewmodelstu.databinding.ActivityLivedataBinding;
import com.lihang.viewmodelstu.utils.ToastUtils;
import com.lihang.viewmodelstu.viewmodel.LiveDataViewModel;

import java.util.Random;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

/**
 * Created by leo
 * on 2019/10/8.
 */
public class LiveDataActivity extends AppCompatActivity {
    ActivityLivedataBinding binding;
    LiveDataViewModel liveDataViewModel;
    User user;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livedata);
        user = new User("岩浆", 18);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_livedata);
        liveDataViewModel = ViewModelProviders.of(this).get(LiveDataViewModel.class);
        binding.setLiveDataViewModel(liveDataViewModel);
        liveDataViewModel.getData().observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                binding.setLiveDataViewModel(liveDataViewModel);
                ToastUtils.showToast(liveDataViewModel.getData().getValue().getName() + liveDataViewModel.getData().getValue().getAge());
            }
        });
        setListener();
    }

    private void setListener() {
        binding.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int number = random.nextInt(100);
                String name = "岩浆 ==> " + number;
                user.setName(name);
                liveDataViewModel.update(user);
            }
        });
    }


    @Override
    protected void onStop() {
        super.onStop();
        User user = new User("stop中的岩浆", 18);
        liveDataViewModel.update(user);
    }
}

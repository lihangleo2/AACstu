package com.lihang.viewmodelstu.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lihang.viewmodelstu.R;
import com.lihang.viewmodelstu.databinding.FragmentOneBinding;
import com.lihang.viewmodelstu.utils.ToastUtils;
import com.lihang.viewmodelstu.viewmodel.MyViewModel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

/**
 * Created by leo
 * on 2019/10/8.
 */
public class OneFragment extends Fragment {
    private int type;
    FragmentOneBinding binding;

    public static OneFragment newInstance(int type) {
        OneFragment fragment = new OneFragment();
        fragment.type = type;
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_one, container, false);
        if (type == 0) {
            binding.relative.setBackgroundColor(getResources().getColor(R.color.color_1));
            binding.btnOne.setText("Fragment - One：打印当前ViewHolder");
        } else {
            binding.relative.setBackgroundColor(getResources().getColor(R.color.color_2));
            binding.btnOne.setText("Fragment - Two：打印当前ViewHolder");
        }
        binding.btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showToast(ViewModelProviders.of(getActivity()).get(MyViewModel.class).hashCode() + "");
            }
        });
        return binding.getRoot();
    }
}

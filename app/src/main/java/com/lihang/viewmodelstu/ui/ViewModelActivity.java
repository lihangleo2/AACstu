package com.lihang.viewmodelstu.ui;

import android.os.Bundle;

import com.lihang.viewmodelstu.R;
import com.lihang.viewmodelstu.databinding.ActivityViewmodelBinding;
import com.lihang.viewmodelstu.ui.fragment.OneFragment;
import com.lihang.viewmodelstu.utils.LogUtils;
import com.lihang.viewmodelstu.viewmodel.MyViewModel;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

/**
 * Created by leo
 * on 2019/10/8.
 */
/*
 *  我们在demo中使用了ViewProviders类。记得添加依赖：implementation 'android.arch.lifecycle:extensions:1.1.1'
 *
 *
 * 【ViewModel】
 *  简介：
 *       ViewModel是以生命周期的方式存储与管理UI相关数据
 *  作用：
 *       1、在MVVM模式中，使Model与View分离
 *       2、存储数据
 *       3、负责为UI准备数据
 *
 * 1、ViewModel只会在Activity存活时，只会创建一次。（我们可以通过Activity生命周期打印，看结果）
 * 2、因为在Activity存活时，只创建一次，那么在此Activity下的所有Fragment都可以共享一个ViewModel
 * 3、由于 ViewModel 生命周期可能长与 activity 生命周期，所以为了避免内存泄漏Google禁止在ViewModel中持有Context或activity或view的引用。如果非得使用Context，
 * 可以继承AndroidViewModel 类中获取ApplicationContext
 *
 *   其他优势：
 * 1、之前我们在activity销毁重建时，可以用activity的onSaveInstanceState（）机制保存和恢复数据，但缺点明显，
 * 只适合保存少量的可以被序列化、反序列化的数据。假如我们需要保存一个比较大的数据，这个时候ViewModel就可以实现。
 *
 * 2、app需要频繁异步请求数据，比如请求网络调接口，这些都是相当耗时。比如Activity被销毁后接口请求才返回，考虑到内存泄漏情况，
 * 会给我们增添好多复杂工作。 但现在我们利用ViewModel处理数据回调，可以解决此问题。
 *
 * 3、分担 UI controller，比如 Activity / Fragment 。为了避免臃肿和难以管理，我们可以分离出数据操作的职责给ViewModel。
 * 也就是使Model和View分离。
 * */
public class ViewModelActivity extends FragmentActivity {
    ActivityViewmodelBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewmodel);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_viewmodel);
        addFragment();
        MyViewModel myViewModel = ViewModelProviders.of(this).get(MyViewModel.class);
        LogUtils.i("MyViewModel的相关", "onCreate ==> " + myViewModel.hashCode());
    }

    private void addFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        OneFragment oneFragment = new OneFragment(0);
        OneFragment oneFragment_other = new OneFragment(1);
        ft.add(R.id.frameLayout, oneFragment);
        ft.add(R.id.frameLayout_other, oneFragment_other);
        ft.commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
        MyViewModel myViewModel = ViewModelProviders.of(this).get(MyViewModel.class);
        LogUtils.i("MyViewModel的相关", "onStart ==> " + myViewModel.hashCode());
    }

    @Override
    protected void onResume() {
        super.onResume();
        MyViewModel myViewModel = ViewModelProviders.of(this).get(MyViewModel.class);
        LogUtils.i("MyViewModel的相关", "onResume ==> " + myViewModel.hashCode());
    }

    @Override
    protected void onPause() {
        super.onPause();
        MyViewModel myViewModel = ViewModelProviders.of(this).get(MyViewModel.class);
        LogUtils.i("MyViewModel的相关", "onPause ==> " + myViewModel.hashCode());
    }

    @Override
    protected void onStop() {
        super.onStop();
        MyViewModel myViewModel = ViewModelProviders.of(this).get(MyViewModel.class);
        LogUtils.i("MyViewModel的相关", "onStop ==> " + myViewModel.hashCode());
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        MyViewModel myViewModel = ViewModelProviders.of(this).get(MyViewModel.class);
        LogUtils.i("MyViewModel的相关", "onDestroy ==> " + myViewModel.hashCode());
    }
}

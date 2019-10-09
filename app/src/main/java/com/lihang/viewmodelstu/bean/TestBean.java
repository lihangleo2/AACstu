package com.lihang.viewmodelstu.bean;

import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;

/**
 * Created by leo
 * on 2019/10/8.
 */
public class TestBean {
    public final ObservableField<String> name = new ObservableField<>();

    private void setName(String name) {
        this.name.set(name);
    }
}

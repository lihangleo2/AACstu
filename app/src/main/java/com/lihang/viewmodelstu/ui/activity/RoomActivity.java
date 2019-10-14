package com.lihang.viewmodelstu.ui.activity;

import android.os.Bundle;
import android.view.View;

import com.lihang.viewmodelstu.R;
import com.lihang.viewmodelstu.databinding.ActivityRoomBinding;
import com.lihang.viewmodelstu.roomabout.Clothes;
import com.lihang.viewmodelstu.roomabout.DBInstance;
import com.lihang.viewmodelstu.roomabout.Person;
import com.lihang.viewmodelstu.utils.ActivityUtils;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

/**
 * Created by leo
 * on 2019/10/10.
 */
public class RoomActivity extends AppCompatActivity implements View.OnClickListener {
    ActivityRoomBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_room);
        binding.setOnClickListener(this);
        checkAll();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btn_insert:
                Person person_ = new Person("Room", 18);
                DBInstance.getInstance().getPersonDao().insert(person_);
                checkAll();
                break;
            case R.id.btn_insert_one:
                Person person = new Person("岩浆", 18);
                person.setUid(100);
                DBInstance.getInstance().getPersonDao().insert(person);
                checkAll();
                break;

            case R.id.btn_insert_clothes_black:
                Clothes clothes = new Clothes();
                clothes.setId(1);
                clothes.setColor("黑色");
                clothes.setFather_id(100);
                DBInstance.getInstance().getClothesDao().insert(clothes);
                checkAll();
                break;

            case R.id.btn_insert_clothes_red:
                Clothes clothes_ = new Clothes();
                clothes_.setId(2);
                clothes_.setColor("红色");
                clothes_.setFather_id(100);
                DBInstance.getInstance().getClothesDao().insert(clothes_);
                checkAll();
                break;

            case R.id.btn_delete_:
                Person person1 = DBInstance.getInstance().getPersonDao().getPersonByUid(100);
                DBInstance.getInstance().getPersonDao().delete(person1);
                checkAll();

                break;
        }
    }

    public void checkAll() {
        int allCount = DBInstance.getInstance().getPersonDao().getAll().size();
        binding.txtAll.setText("当前人总数：" + allCount);

        int clothesCount = DBInstance.getInstance().getClothesDao().getAll().size();
        binding.txtClothesAll.setText("当前衣服总数：" + clothesCount);
    }
}

package com.lihang.viewmodelstu.roomabout;

import android.content.Context;

import com.lihang.viewmodelstu.MyApplication;

import androidx.room.Room;

/**
 * Created by leo
 * on 2019/10/10.
 */
public class DBInstance {
    //    private static final String DB_NAME = "/sdcard/LianSou/room_test.db";
    private static final String DB_NAME = "room_test";
    public static AppDataBase appDataBase;

    public static AppDataBase getInstance() {
        if (appDataBase == null) {
            synchronized (DBInstance.class) {
                if (appDataBase == null) {
                    appDataBase = Room.databaseBuilder(MyApplication.getInstance(), AppDataBase.class, DB_NAME)
                            //不推荐打开这句，但是为了demo展示，我只能打开了
                            .allowMainThreadQueries()
//                            .addMigrations(AppDataBase.MIGRATION_1_2)
                            .build();
                }
            }
        }
        return appDataBase;
    }
}

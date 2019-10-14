package com.lihang.viewmodelstu.roomabout;

import com.lihang.viewmodelstu.roomabout.withrxjava.Dog;
import com.lihang.viewmodelstu.roomabout.withrxjava.DogDao;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

/**
 * Created by leo
 * on 2019/10/10.
 */
//注解指定了database的表映射实体数据以及版本等信息
@Database(entities = {Person.class, Clothes.class,Dog.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {
    public abstract PersonDao getPersonDao();

    public abstract ClothesDao getClothesDao();

    public abstract DogDao getDogDao();

    //数据库变动添加Migration
    public static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            //告诉person表，增添一个String类型的字段 son
            database.execSQL("ALTER TABLE person ADD COLUMN son TEXT");
        }
    };
}


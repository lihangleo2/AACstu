package com.lihang.viewmodelstu.roomabout;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

/**
 * Created by leo
 * on 2019/10/11.
 */
@Dao
public interface ClothesDao {
    //查询所有数据
    @Query("Select * from clothes")
    List<Clothes> getAll();

    //删除全部数据
    @Query("DELETE FROM clothes")
    void deleteAll();

    @Insert
    void insert(Clothes... clothes);
}

package com.lihang.viewmodelstu.roomabout;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

/**
 * Created by leo
 * on 2019/10/10.
 */

@Dao
public interface PersonDao {
    //查询所有数据
    @Query("Select * from person")
    List<Person> getAll();

    //删除全部数据
    @Query("DELETE FROM person")
    void deleteAll();

    //一次插入单条数据 或 多条
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @Insert
    void insert(Person... persons);

    //一次删除单条数据 或 多条
    @Delete
    void delete(Person... persons);

    //一次更新单条数据 或 多条
    @Update
    void update(Person... persons);

    //根据字段去查找数据
    @Query("SELECT * FROM person WHERE uid= :uid")
    Person getPersonByUid(int uid);

    //一次查找多个数据
    @Query("SELECT * FROM person WHERE uid IN (:userIds)")
    List<Person> loadAllByIds(List<Integer> userIds);

    //多个条件查找
    @Query("SELECT * FROM person WHERE name = :name AND age = :age")
    Person getPersonByNameage(String name, int age);


}

package com.lihang.viewmodelstu.roomabout.withrxjava;


import com.lihang.viewmodelstu.roomabout.Person;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;


/**
 * Created by leo
 * on 2019/10/12.
 */
@Dao
public interface DogDao {
    //返回值是插入成功的行id
    @Insert
    List<Long> insert(Dog... dogs);

    @Delete
    void delete(Dog... dogs);

    @Delete
    int delete(Dog dog);


    @Update
    void update(Dog... dogs);

    @Update
    int update(Dog dog);


    //查询所有对象 且 观察数据。用背压Flowable可以实现，如果需要一次性查询，可以用别的类型
    @Query("Select * from dog")
    Flowable<List<Dog>> getAll();


    //删除全部数据
    @Query("DELETE FROM dog")
    void deleteAll();


    //根据字段去查找数据
    @Query("SELECT * FROM dog WHERE id= :id")
    Single<Dog> getDogById(int id);


    @Query("SELECT * FROM dog WHERE id>= :minId AND id<= :maxId")
    LiveData<List<Dog>> getToLiveData(int minId, int maxId);

}

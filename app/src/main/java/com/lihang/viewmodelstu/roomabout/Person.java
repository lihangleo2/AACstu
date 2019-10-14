package com.lihang.viewmodelstu.roomabout;

import java.io.Serializable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.Insert;
import androidx.room.PrimaryKey;

/**
 * Created by leo
 * on 2019/10/10.
 */
//1、@Entity：数据表的实体类
//2、@Entity(tableName = "person") 这样可以自定义表明，如果不设置则默认类名为表名
//3、@Entity(primaryKeys = {"name","age"})，联合主键（不恰当的比喻）：如果一张表以人名为主键，很可能有同名覆盖掉数据，
//   所以这个时候，我们用如果用人名和年龄，或者是人名和出生日期联合起来当主键，那就是唯一的。

//为了能保存数据，使数据持久化且Room必须能够对它进行操作，你可以用public修饰属性，或者你也可以设置成private,但必须提供set和get方法
@Entity
public class Person {
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //@PrimaryKey：每一个实体类都需要唯一的表示，true表示自增长
    @PrimaryKey(autoGenerate = true)
    //@ColumnInfo：数据表中字段名称。如果不设置则默认为属性名
    @ColumnInfo(name = "uid")
    private int uid;

    private String name;
    private int age;

    //@Ignore：标注不需要添加到数据表中的属性
    @Ignore
    private int money;

    //@Embedded 实体类中引用其他实体类。这样的话Address里属性也成为了表字段
    //@Embedded(prefix = "one"),这个是区分唯一性的，比如说一这个人可能有2个地址类似于tag，那么在数据表中就会以prefix+属性值命名
    @Embedded
    private Address address;

//    private String son;
//
//    public String getSon() {
//        return son;
//    }
//
//    public void setSon(String son) {
//        this.son = son;
//    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}

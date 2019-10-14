package com.lihang.viewmodelstu.roomabout.withrxjava;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Created by leo
 * on 2019/10/12.
 */
@Entity
public class Dog {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private int color;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}

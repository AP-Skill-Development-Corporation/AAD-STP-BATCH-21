package com.example.roomdbdemo;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "students")
public class StudentEntity
{
    @ColumnInfo(name = "name")
    String name;

    @PrimaryKey
    @ColumnInfo(name = "rollnumber")
    @NonNull
    String rollnumber;

    /*alt+insert
    * or
    * right here->generate->getters and setters->select all->clock on ok*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollnumber() {
        return rollnumber;
    }

    public void setRollnumber(String rollnumber) {
        this.rollnumber = rollnumber;
    }
}

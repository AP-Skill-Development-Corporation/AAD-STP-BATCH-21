package com.example.roomdbdemo;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
@Database(entities = StudentEntity.class,version = 1,exportSchema = false)
public abstract class StudentDataBase extends RoomDatabase {
    public abstract StudentDAO studentDAO();
    public static StudentDataBase dataBase;
    public static synchronized StudentDataBase getInstance(Context ctx){
        if (dataBase==null) {
            dataBase = Room.databaseBuilder(ctx, StudentDataBase.class, "ap")
                    .allowMainThreadQueries().build();
        }
        return dataBase;
    }
}

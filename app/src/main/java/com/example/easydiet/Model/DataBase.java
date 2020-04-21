package com.example.easydiet.Model;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {WeightEntity.class ,UserEntity.class}, version = 1)
public abstract class DataBase extends RoomDatabase {

    private static DataBase instance;

    public abstract WeightDao weightDao();
    public abstract UserDao userDao();

    public static synchronized DataBase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), DataBase.class, "dataBase")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }




}

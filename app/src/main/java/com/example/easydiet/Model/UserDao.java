package com.example.easydiet.Model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {


    @Insert
    void insert(UserEntity weight);

    @Update
    void update(UserEntity weight);

    @Delete
    void delete(UserEntity weight);

    @Query("DELETE FROM user_table")
    void deleteAllNotes();

    @Query("SELECT * FROM user_table ORDER BY priority DESC")
    LiveData<List<UserEntity>> getAllNotes();
}

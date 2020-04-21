package com.example.easydiet.Model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface WeightDao {

    @Insert
    void insert(WeightEntity weight);

    @Update
    void update(WeightEntity weight);

    @Delete
    void delete(WeightEntity weight);

    @Query("DELETE FROM weight_table")
    void deleteAllNotes();

    @Query("SELECT * FROM weight_table ORDER BY priority DESC")
    LiveData<List<WeightEntity>> getAllNotes();

}

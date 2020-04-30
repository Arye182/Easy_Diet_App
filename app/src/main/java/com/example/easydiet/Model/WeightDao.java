/*
 * Copyright (c) 2020 Arye182
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

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

    //@Query("SELECT * FROM weight_table ORDER BY date(date) DESC Limit 1")
    @Query("SELECT * FROM weight_table")
    LiveData<List<WeightEntity>> getAllNotes();

}

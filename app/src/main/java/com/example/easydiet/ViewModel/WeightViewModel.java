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

package com.example.easydiet.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.easydiet.Model.WeightEntity;
import com.example.easydiet.Model.WeightRepository;

import java.util.List;


public class WeightViewModel extends AndroidViewModel {

    private WeightRepository weightRepository;
    private LiveData<List<WeightEntity>> allWeights;

    public WeightViewModel(@NonNull Application application) {
        super(application);
        weightRepository = new WeightRepository(application);
        allWeights = weightRepository.getAllWeights();
    }

    public void insert(WeightEntity weightEntity) {
        weightRepository.insert(weightEntity);
    }

    public void update(WeightEntity weightEntity) {
        weightRepository.update(weightEntity);
    }

    public void delete(WeightEntity weightEntity) {
        weightRepository.delete(weightEntity);
    }

    public void deleteAllWeights() {
        weightRepository.deleteAllNotes();
    }

    public LiveData<List<WeightEntity>> getAllWeights() {
        return allWeights;
    }




}

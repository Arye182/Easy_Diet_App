/*
 * MIT License
 *
 * Copyright (c) 2020 Arye182
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
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

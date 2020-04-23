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

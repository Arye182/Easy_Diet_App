package com.example.easydiet.Model;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class WeightRepository {
    private WeightDao weightDao;
    private LiveData<List<WeightEntity>> allWeights;

    public WeightRepository(Application application) {
        DataBase dataBase = DataBase.getInstance(application);
        weightDao = dataBase.weightDao();
        allWeights = weightDao.getAllNotes();
    }

    public void insert (WeightEntity weightEntity) {

    }

    public void update (WeightEntity weightEntity) {

    }

    public void delete (WeightEntity weightEntity) {

    }

    public void deleteAllNotes () {

    }

    public LiveData<List<WeightEntity>> getAllWeights() {
        return allWeights;
    }


}

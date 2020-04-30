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

import android.app.Application;
import android.os.AsyncTask;

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
        new InsertWeightEntityAsyncTask(weightDao).execute(weightEntity);
    }

    public void update (WeightEntity weightEntity) {
        new UpdateWeightEntityAsyncTask(weightDao).execute(weightEntity);
    }

    public void delete (WeightEntity weightEntity) {
        new DeleteWeightEntityAsyncTask(weightDao).execute(weightEntity);
    }

    public void deleteAllNotes () {
        new DeleteAllWeightEntityAsyncTask(weightDao).execute();
    }

    public LiveData<List<WeightEntity>> getAllWeights() {
        return allWeights;
    }

    private static class InsertWeightEntityAsyncTask extends AsyncTask<WeightEntity, Void, Void> {
        private WeightDao weightDao;
        private InsertWeightEntityAsyncTask(WeightDao weightDao) {
            this.weightDao = weightDao;
        }
        @Override
        protected Void doInBackground(WeightEntity... weightEntities) {
            weightDao.insert(weightEntities[0]);
            return null;
        }
    }

    private static class UpdateWeightEntityAsyncTask extends AsyncTask<WeightEntity, Void, Void> {
        private WeightDao weightDao;
        private UpdateWeightEntityAsyncTask(WeightDao weightDao) {
            this.weightDao = weightDao;
        }
        @Override
        protected Void doInBackground(WeightEntity... weightEntities) {
            weightDao.update(weightEntities[0]);
            return null;
        }
    }
    private static class DeleteWeightEntityAsyncTask extends AsyncTask<WeightEntity, Void, Void> {
        private WeightDao weightDao;
        private DeleteWeightEntityAsyncTask(WeightDao weightDao) {
            this.weightDao = weightDao;
        }

        @Override
        protected Void doInBackground(WeightEntity... weightEntities) {
            weightDao.delete(weightEntities[0]);
            return null;
        }
    }

    private static class DeleteAllWeightEntityAsyncTask extends AsyncTask<Void, Void, Void> {
        private WeightDao weightDao;
        private DeleteAllWeightEntityAsyncTask(WeightDao weightDao) {
            this.weightDao = weightDao;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            weightDao.deleteAllNotes();
            return null;
        }
    }


}

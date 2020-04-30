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

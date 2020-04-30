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

public class UserRepository {

    private UserDao userDao;
    private LiveData<List<UserEntity>> allUsers;

    public UserRepository(Application application) {
        DataBase dataBase = DataBase.getInstance(application);
        userDao = dataBase.userDao();
        allUsers = userDao.getAllNotes();
    }

    public void insert (UserEntity userEntity) {
        new UserRepository.InsertUserEntityAsyncTask(userDao).execute(userEntity);
    }

    public void update (UserEntity userEntity) {
        new UserRepository.UpdateUserEntityAsyncTask(userDao).execute(userEntity);
    }

    public void delete (UserEntity userEntity) {
        new UserRepository.DeleteUserEntityAsyncTask(userDao).execute(userEntity);
    }

    public void deleteAllNotes () {
        new UserRepository.DeleteUserEntityAsyncTask(userDao).execute();
    }

    public LiveData<List<UserEntity>> getAllusers() {
        return allUsers;
    }

    private static class InsertUserEntityAsyncTask extends AsyncTask<UserEntity, Void, Void> {
        private UserDao userDao;
        private InsertUserEntityAsyncTask(UserDao userDao) {
            this.userDao = userDao;
        }
        @Override
        protected Void doInBackground(UserEntity... userEntities) {
            userDao.insert(userEntities[0]);
            return null;
        }
    }

    private static class UpdateUserEntityAsyncTask extends AsyncTask<UserEntity, Void, Void> {
        private UserDao userDao;
        private UpdateUserEntityAsyncTask(UserDao userDao) {
            this.userDao = userDao;
        }
        @Override
        protected Void doInBackground(UserEntity... userEntities) {
            userDao.update(userEntities[0]);
            return null;
        }
    }
    private static class DeleteUserEntityAsyncTask extends AsyncTask<UserEntity, Void, Void> {
        private UserDao userDao;
        private DeleteUserEntityAsyncTask(UserDao userDao) {
            this.userDao = userDao;
        }
        @Override
        protected Void doInBackground(UserEntity... userEntities) {
            userDao.delete(userEntities[0]);
            return null;
        }
    }
    private static class DeleteAllUserEntityAsyncTask extends AsyncTask<Void, Void, Void> {
        private UserDao userDao;
        private DeleteAllUserEntityAsyncTask(UserDao userDao) {
            this.userDao = userDao;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            userDao.deleteAllNotes();
            return null;
        }
    }
}

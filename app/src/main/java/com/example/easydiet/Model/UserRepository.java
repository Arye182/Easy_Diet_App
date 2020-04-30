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

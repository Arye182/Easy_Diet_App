package com.example.easydiet.Model;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {WeightEntity.class ,UserEntity.class}, version = 1)
public abstract class DataBase extends RoomDatabase {

    private static DataBase instance;

    public abstract WeightDao weightDao();
    public abstract UserDao userDao();

    public static synchronized DataBase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), DataBase.class, "dataBase")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private WeightDao weightDao;
        private UserDao userDao;
        private PopulateDbAsyncTask (DataBase db) {
            weightDao = db.weightDao();
            userDao = db.userDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            weightDao.insert(new WeightEntity(95.3, "10/3/2020"));
            weightDao.insert(new WeightEntity(90.3, "10/3/2020"));
            return null;
        }
    }




}

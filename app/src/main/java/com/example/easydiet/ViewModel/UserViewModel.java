package com.example.easydiet.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.easydiet.Model.UserEntity;
import com.example.easydiet.Model.UserRepository;
import com.example.easydiet.Model.WeightEntity;

import java.util.List;

public class UserViewModel extends AndroidViewModel {
    private UserRepository userRepository;
    private LiveData<List<UserEntity>> allUsers;

    public UserViewModel(@NonNull Application application) {
        super(application);
        userRepository = new UserRepository(application);
        allUsers = userRepository.getAllusers();
    }

    public void insert(UserEntity userEntity) {
        userRepository.insert(userEntity);
    }

    public void update(UserEntity userEntity) {
        userRepository.update(userEntity);
    }

    public void delete(UserEntity userEntity) {
        userRepository.delete(userEntity);
    }

    public void deleteAllUsers() {
        userRepository.deleteAllNotes();
    }

    public LiveData<List<UserEntity>> getAllUsers() {
        return allUsers;
    }

}

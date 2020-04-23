package com.example.easydiet.View.User;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.easydiet.Model.UserEntity;
import com.example.easydiet.R;
import com.example.easydiet.ViewModel.UserViewModel;
import com.example.easydiet.ViewModel.WeightViewModel;

import java.util.ArrayList;
import java.util.List;




public class UserHomeFragment extends Fragment {
    private UserViewModel userViewModel;
    ArrayList<String> users;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        requireActivity().setTitle("User Home Screen");
        // vm

//        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
//        userViewModel.getAllUsers().observe(this, new Observer<List<UserEntity>>() {
//            @Override
//            public void onChanged(List<UserEntity> userEntities) {
//
//            }
//        });

        return inflater.inflate(R.layout.fragment_user_home, container, false);
    }

}

package com.example.easydiet.View.User;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;


import com.example.easydiet.R;

import java.util.ArrayList;

public class UserWeightsHistoryActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    //FloatingActionButton fab;
    ArrayList<String> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_weights_history);


        recyclerView = findViewById(R.id.user_history_view);
        users = new ArrayList<>();
        for (int i = 0; i < 100 ; i++) {
            users.add("Arye Amsalem #" + i);
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new UserHomeScreenAdapter(users);
        recyclerView.setAdapter(adapter);
    }
}

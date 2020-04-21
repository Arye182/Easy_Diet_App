package com.example.easydiet.View.User;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.easydiet.R;

import java.util.ArrayList;

public class UserWeightsHistoryFragment extends Fragment {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    //FloatingActionButton fab;
    ArrayList<String> users;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


       View view = inflater.inflate(R.layout.fragment_weight_history, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.weights_history_list);

        UserWeightsHistoryAdapter adapter = new UserWeightsHistoryAdapter();
        recyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager((layoutManager));

        return view;
    }


}

package com.example.easydiet.View.User;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.example.easydiet.Model.WeightEntity;
import com.example.easydiet.R;
import com.example.easydiet.ViewModel.WeightViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static android.app.Activity.RESULT_OK;

public class UserWeightsHistoryFragment extends Fragment {

    public static final int ADD_WEIGHT_REQUEST = 1;
    private WeightViewModel weightViewModel;





    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        weightViewModel = new ViewModelProvider(requireActivity()).get(WeightViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_weight_history, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        requireActivity().setTitle("Your Weight History");



        // FB
        FloatingActionButton buttonAddWeight = view.findViewById(R.id.button_add_weight);
        buttonAddWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment addWeightFragment = new AddWeightFragment();
                addWeightFragment.setTargetFragment(getParentFragment(), ADD_WEIGHT_REQUEST );
                // consider using Java coding conventions (upper first char class names!!!)
                requireActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, addWeightFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });

        // recycle View
        RecyclerView recyclerView = view.findViewById(R.id.weights_history_list);
        recyclerView.setLayoutManager((new LinearLayoutManager(getActivity())));
        recyclerView.setHasFixedSize(true);
        UserWeightsHistoryAdapter adapter = new UserWeightsHistoryAdapter();
        recyclerView.setAdapter(adapter);

        // vm
        try {
            weightViewModel.getAllWeights().observe(getViewLifecycleOwner(), new Observer<List<WeightEntity>>() {
                @Override
                public void onChanged(@Nullable List<WeightEntity> weightEntities) {
                    adapter.setWeights(weightEntities);
                }
            });
        } catch (Exception e) {
            Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }



    public void updateResult(@Nullable Intent data) {


        assert data != null;
        String weight = data.getStringExtra(AddWeightFragment.EXTRA_WEIGHT);
        String date = data.getStringExtra(AddWeightFragment.EXTRA_DATE);

        assert weight != null;
        WeightEntity newWeight = new WeightEntity(Double.parseDouble(weight), date);
        weightViewModel.insert(newWeight);
        Toast.makeText(getActivity(), "Weight Saved!", Toast.LENGTH_SHORT).show();


    }
}

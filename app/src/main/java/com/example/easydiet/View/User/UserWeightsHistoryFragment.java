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

package com.example.easydiet.View.User;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_weight_history, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        requireActivity().setTitle("Weight History");

        // add weight floating button
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

        // recycle View of weight cards history
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

        // touch swipe and delete
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                  weightViewModel.delete(adapter.getWeightAt(viewHolder.getAdapterPosition()));
                Toast.makeText(getActivity(), "Weight Deleted!", Toast.LENGTH_SHORT).show();
            }
        }).attachToRecyclerView(recyclerView);
    }

    public void updateResult(@Nullable Intent data) {

        assert data != null;
        String weight = data.getStringExtra(AddWeightFragment.EXTRA_WEIGHT);
        String date = data.getStringExtra(AddWeightFragment.EXTRA_DATE);
        String day = data.getStringExtra(AddWeightFragment.EXTRA_DAY);
        assert weight != null;
        WeightEntity newWeight = new WeightEntity(Double.parseDouble(weight), date, day);
        weightViewModel.insert(newWeight);
        Toast.makeText(getActivity(), "Weight Saved!", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.weight_history_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.delete_all_weights:
                weightViewModel.deleteAllWeights();
                Toast.makeText(getActivity(), "All Notes Deleted!", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

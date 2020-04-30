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

package com.example.easydiet.View.User;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easydiet.Model.WeightEntity;
import com.example.easydiet.R;

import java.util.ArrayList;
import java.util.List;

public class UserWeightsHistoryAdapter extends RecyclerView.Adapter<UserWeightsHistoryAdapter.WeightsViewHolder> {

    private List<WeightEntity> weights = new ArrayList<>();


    @NonNull
    @Override
    public WeightsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView  = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.weight_card, parent, false);
        return new WeightsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull WeightsViewHolder holder, int position) {
        WeightEntity currentWeight = weights.get(position);
        holder.weightValue.setText(String.valueOf(currentWeight.getWeight()));
        holder.dateValue.setText(currentWeight.getDate());
        holder.dayValue.setText(currentWeight.getDay());
    }


    @Override
    public int getItemCount() {
        return weights.size();
    }


    public void setWeights(List<WeightEntity> weights) {
        this.weights = weights;
        notifyDataSetChanged();
    }

    public WeightEntity getWeightAt(int position) {
        return weights.get(position);
    }


    class WeightsViewHolder extends RecyclerView.ViewHolder{
        private TextView dateValue;
        private TextView weightValue;
        private TextView dayValue;
        public WeightsViewHolder(@NonNull View itemView) {
            super(itemView);
            dateValue = (TextView) itemView.findViewById(R.id.date_value);
            weightValue = (TextView) itemView.findViewById(R.id.weight_value);
            dayValue = (TextView) itemView.findViewById(R.id.day);
        }
    }
}

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

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
        public WeightsViewHolder(@NonNull View itemView) {
            super(itemView);
            dateValue = (TextView) itemView.findViewById(R.id.date_value);
            weightValue = (TextView) itemView.findViewById(R.id.weight_value);
        }
    }
}

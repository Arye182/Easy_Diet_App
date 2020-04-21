package com.example.easydiet.View.User;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easydiet.R;

import java.util.ArrayList;

class UserWeightsHistoryAdapter extends RecyclerView.Adapter {


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    private class WeightsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView dateValue;
        private TextView weightValue;


        public WeightsViewHolder(@NonNull View itemView) {
            super(itemView);
            this.dateValue = (TextView) itemView.findViewById(R.id.date_value);
            this.weightValue = (TextView) itemView.findViewById(R.id.weight_value);
            itemView.setOnClickListener(this);
        }

        public void bindView (int position){

        }

        @Override
        public void onClick(View v) {

        }
    }
}

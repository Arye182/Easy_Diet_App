package com.example.easydiet.View.User;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easydiet.R;

import java.util.ArrayList;

class UserHomeScreenAdapter extends RecyclerView.Adapter<UserHomeScreenAdapter.ViewHolder>  {


    ArrayList<String> users;
    public UserHomeScreenAdapter(ArrayList<String> users) {
        this.users = users;
    }

    @NonNull
    @Override
    public UserHomeScreenAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_weight_row, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserHomeScreenAdapter.ViewHolder holder, int position) {
        holder.first_name.setText(users.get(position));
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView first_name;
        public ViewHolder(View itemView){
            super(itemView);
            first_name = itemView.findViewById(R.id.first_name);
        }
    }
}

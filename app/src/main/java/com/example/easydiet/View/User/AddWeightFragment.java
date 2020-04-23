package com.example.easydiet.View.User;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.easydiet.R;

import java.util.Objects;

public class AddWeightFragment extends Fragment {

    public static final String EXTRA_WEIGHT =
            "com.example.easydiet.View.User.EXTRA_WEIGHT";
    public static final String EXTRA_DATE =
            "com.example.easydiet.View.User.EXTRA_DATE";


    private static final int RESULT_OK = -1 ;


    private EditText date;
    private EditText weight;

    private AddWeightFragmentListener listener;

    public interface AddWeightFragmentListener {
        void onInputWeightSent (Intent data);
    }



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.date = view.findViewById(R.id.edit_text_new_date);
        this.weight = view.findViewById(R.id.edit_text_new_weight);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);
        requireActivity().setTitle("Add Weight");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_weight, container, false);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.add_weight_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_weight:
                saveWeight();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void saveWeight() {
        String weight = this.weight.getText().toString();
        String date = this.date.getText().toString();
        if(weight.trim().isEmpty() || date.trim().isEmpty()) {
            Toast.makeText(getActivity(), "Please insert a weight and date", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent data = new Intent();
        data.putExtra(EXTRA_WEIGHT, weight);
        data.putExtra(EXTRA_DATE, date);
        listener.onInputWeightSent(data);
        requireActivity().onBackPressed();

    }



    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof AddWeightFragmentListener) {
            listener = (AddWeightFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement listener weight");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}

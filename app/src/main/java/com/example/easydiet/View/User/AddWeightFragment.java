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
import androidx.appcompat.widget.Toolbar;
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

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Objects;

public class AddWeightFragment extends Fragment {

    public static final String EXTRA_WEIGHT =
            "com.example.easydiet.View.User.EXTRA_WEIGHT";
    public static final String EXTRA_DATE =
            "com.example.easydiet.View.User.EXTRA_DATE";
    public static final String EXTRA_DATE_TIME =
            "com.example.easydiet.View.User.EXTRA_DATE_TIME";
    public static final String EXTRA_DAY =
            "com.example.easydiet.View.User.EXTRA_DAY";
    public static final String EXTRA_TIME =
            "com.example.easydiet.View.User.EXTRA_TIME";
    private static final int RESULT_OK = -1 ;


    private EditText date;
    private EditText weight;
    private String day;
    private EditText time;

    Calendar calendar = Calendar.getInstance();



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
        //this.day = view.findViewById(R.id.day);

        // DATE
        // 00/00/0000
        String CurrentTime = DateFormat.getDateInstance(DateFormat.DATE_FIELD).format(calendar.getTime());
        // yyyy-MM-dd'T'HH:mm:ss.SSSXXX
        String CurrentDate = new SimpleDateFormat( "yyyy-MM-dd'T'HH:mm:ss.SSSXXX" ).format(Calendar.getInstance().getTime());
        this.date.setText(CurrentTime);


        // DAY
        DateFormatSymbols dfs = new DateFormatSymbols(Locale.ENGLISH);
        String weekdays[] = dfs.getWeekdays();
        Calendar cal = Calendar.getInstance();
        int day = cal.get(Calendar.DAY_OF_WEEK);
        this.day = weekdays[day];









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
            case R.id.close_save_weight:
                Toast.makeText(getActivity(), "Item Was Not Saved!", Toast.LENGTH_SHORT).show();

                requireActivity().onBackPressed();

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void saveWeight() {
        String weight = this.weight.getText().toString();
        String date = this.date.getText().toString();
        String day = this.day;
        if(weight.trim().isEmpty() || date.trim().isEmpty()) {
            Toast.makeText(getActivity(), "Please insert a weight and date", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent data = new Intent();
        data.putExtra(EXTRA_WEIGHT, weight);
        data.putExtra(EXTRA_DATE, date);
        data.putExtra(EXTRA_DAY, day);
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

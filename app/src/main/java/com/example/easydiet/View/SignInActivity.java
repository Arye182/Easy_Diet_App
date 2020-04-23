package com.example.easydiet.View;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.easydiet.Model.WeightEntity;
import com.example.easydiet.R;
import com.example.easydiet.View.User.AddWeightFragment;
import com.example.easydiet.View.User.UserHomeActivity;
import com.example.easydiet.View.User.UserHomeFragment;
import com.example.easydiet.ViewModel.WeightViewModel;


public class SignInActivity extends AppCompatActivity {
    public static final int ADD_WEIGHT_REQUEST = 1;
    private WeightViewModel weightViewModel;
    private static final String TAG = "MyMessage";
    EditText firstName;
    EditText lastName;
    EditText email;
    EditText age;
    EditText gender;
    EditText weight;
    EditText height;
    Button saveContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        weightViewModel = new ViewModelProvider(this).get(WeightViewModel.class);

        // initialize
        firstName = findViewById(R.id.first_name);
        lastName = findViewById(R.id.last_name);
        email = findViewById(R.id.email);
        age = findViewById(R.id.age);
        gender = findViewById(R.id.gender);
        weight = findViewById(R.id.weight);
        height = findViewById(R.id.heigth);
        saveContinue = findViewById(R.id.button_saveContinue);

        saveContinue.setOnClickListener(new View.OnClickListener(){
          @Override
          public void onClick(View view){
              // TODO Save to database
              openUserHome();
              Log.i(TAG, "Saving New User: firstName: " + firstName.getText().toString());
          }
        });

    }

    public void openUserHome(){
        Intent intent = new Intent(this, UserHomeActivity.class);
        startActivity(intent);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ADD_WEIGHT_REQUEST && resultCode == RESULT_OK) {
            String weight = data.getStringExtra(AddWeightFragment.EXTRA_WEIGHT);
            String date = data.getStringExtra(AddWeightFragment.EXTRA_DATE);

            assert weight != null;
            WeightEntity newWeight = new WeightEntity(Double.parseDouble(weight), date);
            weightViewModel.insert(newWeight);
            Toast.makeText(this, "Weight Saved!", Toast.LENGTH_SHORT).show();


        }

    }
}

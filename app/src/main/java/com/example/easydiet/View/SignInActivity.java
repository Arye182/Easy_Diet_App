package com.example.easydiet.View;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.example.easydiet.R;
import com.example.easydiet.View.User.UserHomeActivity;


public class SignInActivity extends AppCompatActivity {

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
}

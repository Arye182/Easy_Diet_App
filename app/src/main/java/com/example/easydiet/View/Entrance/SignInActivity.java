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

package com.example.easydiet.View.Entrance;
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
import com.example.easydiet.View.User.UserActivity;
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
        Intent intent = new Intent(this, UserActivity.class);
        startActivity(intent);
    }

}

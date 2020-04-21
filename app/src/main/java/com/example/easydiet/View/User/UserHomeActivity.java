package com.example.easydiet.View.User;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.easydiet.R;
import com.example.easydiet.View.SignInActivity;
import com.example.easydiet.View.User.UserHomeScreenAdapter;

import java.util.ArrayList;

public class UserHomeActivity extends AppCompatActivity implements View.OnClickListener{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home);




    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_history_weights:
                openHistoryWindow();
                break;
        }
    }

    private void openHistoryWindow() {
        Intent intent = new Intent(this, UserWeightsHistoryActivity.class);
        startActivity(intent);
    }
}

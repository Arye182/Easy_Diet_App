package com.example.easydiet.View.User;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.easydiet.R;

import com.google.android.material.bottomnavigation.BottomNavigationView;



public class UserActivity extends AppCompatActivity implements AddWeightFragment.AddWeightFragmentListener {
    public static final int ADD_WEIGHT_REQUEST = 1;
    UserWeightsHistoryFragment uwhf;
    UserHomeFragment uhf;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home);

        // bottom navigation initialization
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        // fragments
        uwhf = new UserWeightsHistoryFragment();
        uhf = new UserHomeFragment();

        // start home user fragment as default
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, new UserHomeFragment())
                .commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.nav_home:
                    selectedFragment = uhf;
                    break;
                case R.id.nav_weight:
                    selectedFragment = uwhf;
                    break;
            }
            assert selectedFragment != null;

            // start fragment which was selected
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, selectedFragment)
                    .commit();
            return true;
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onInputWeightSent(Intent data) {
        uwhf.updateResult(data);
    }
}

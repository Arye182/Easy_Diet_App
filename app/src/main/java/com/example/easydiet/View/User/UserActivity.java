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

package com.example.easydiet.View.User;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.example.easydiet.R;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class UserActivity extends AppCompatActivity implements AddWeightFragment.AddWeightFragmentListener {
    public static final int ADD_WEIGHT_REQUEST = 1;
    UserWeightsHistoryFragment uwhf;
    UserHomeFragment uhf;
    SettingsFragment sf;
    ProfileFragment pf;



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
        sf = new SettingsFragment();
        pf = new ProfileFragment();


        // toolbar
        Toolbar toolbar = findViewById(R.id.home_toolbar_in_fragment);
        setSupportActionBar(toolbar);

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
                case R.id.nav_settings:
                    selectedFragment = sf;
                    break;
                case R.id.nav_profile:
                    selectedFragment = pf;
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

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.user_menu, menu);
//        return true;
//    }
}

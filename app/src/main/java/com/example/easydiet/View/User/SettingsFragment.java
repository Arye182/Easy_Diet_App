package com.example.easydiet.View.User;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.preference.PreferenceFragmentCompat;

import com.example.easydiet.R;


public class SettingsFragment extends PreferenceFragmentCompat {


    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        requireActivity().setTitle("Settings");
        setPreferencesFromResource(R.xml.root_preferences, rootKey);
    }
}

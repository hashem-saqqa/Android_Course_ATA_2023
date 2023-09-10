package com.example.android_course_ata_2023.Section101.Firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.android_course_ata_2023.R;
import com.example.android_course_ata_2023.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {
    ActivityHomeBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


    }
}
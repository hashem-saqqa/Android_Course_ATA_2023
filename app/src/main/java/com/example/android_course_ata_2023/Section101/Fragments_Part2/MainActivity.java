package com.example.android_course_ata_2023.Section101.Fragments_Part2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.android_course_ata_2023.R;
import com.example.android_course_ata_2023.databinding.ActivityMain2Binding;

public class MainActivity extends AppCompatActivity implements OnFragmentActionListener{
    ActivityMain2Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragmentsContainer1, new InsertNameFragment()).commit();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragmentsContainer2, new ViewNameFragment()).commit();

    }

    @Override
    public void onNameInserted(String name) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentsContainer2,ViewNameFragment.newInstance(name)).commit();

    }
}
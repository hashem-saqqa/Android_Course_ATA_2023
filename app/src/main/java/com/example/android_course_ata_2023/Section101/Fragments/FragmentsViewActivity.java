package com.example.android_course_ata_2023.Section101.Fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.android_course_ata_2023.R;
import com.example.android_course_ata_2023.databinding.ActivityFragmentsViewBinding;

public class FragmentsViewActivity extends AppCompatActivity {
    ActivityFragmentsViewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFragmentsViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragmentsContainer,
                        StudentNameViewFragment.newInstance(null)).commit();


        binding.fragment1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                FirstFragment firstFragment = new FirstFragment();

                transaction.replace(R.id.fragmentsContainer, firstFragment);
                transaction.addToBackStack("F1");
                transaction.commit();

            }
        });
        binding.fragment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                SecondFragment secondFragment = new SecondFragment();

                transaction.replace(R.id.fragmentsContainer, secondFragment);
                transaction.addToBackStack("F2");
                transaction.commit();

            }
        });

        binding.addBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = binding.nameET.getText().toString();

                StudentNameViewFragment fragment = StudentNameViewFragment
                        .newInstance(name);

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentsContainer, fragment).commit();
            }
        });


    }
}
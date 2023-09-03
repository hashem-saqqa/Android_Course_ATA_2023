package com.example.android_course_ata_2023.Section101.Threads;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;

import com.example.android_course_ata_2023.R;
import com.example.android_course_ata_2023.databinding.ActivityCounterBinding;

import java.util.concurrent.Executors;

public class CounterActivity extends AppCompatActivity {
    ActivityCounterBinding binding;
    boolean isRed = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCounterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.startCounterBt.setOnClickListener(view -> {

            Handler handler = new Handler();

            Executors.newSingleThreadExecutor().execute(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 1000000000; i++) {
                        int f = i ;
                        if (f % 80000 == 0){
                            handler.postDelayed(() -> {
                                binding.counterTv.setText(String.valueOf(f));
                            },5000);
//                            runOnUiThread(new Runnable() {
//                                @Override
//                                public void run() {
//                                    binding.counterTv.setText(String.valueOf(f));
//                                }
//                            });
                        }
                    }
                }
            });


//            Thread thread = new Thread(new Runnable() {
//                @Override
//                public void run() {
//
//                }
//            });
//            thread.start();
        });

        binding.changeBackgroundBt.setOnClickListener(view -> {
            if (!isRed){
                binding.getRoot().setBackgroundColor(Color.RED);
                isRed = true;
            }else {
                binding.getRoot().setBackgroundColor(Color.WHITE);
                isRed = false;
            }

        });




    }
}
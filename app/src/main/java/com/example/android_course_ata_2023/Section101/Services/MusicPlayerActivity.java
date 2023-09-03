package com.example.android_course_ata_2023.Section101.Services;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import com.example.android_course_ata_2023.R;
import com.example.android_course_ata_2023.databinding.ActivityMusicPlayerBinding;

public class MusicPlayerActivity extends AppCompatActivity {
    ActivityMusicPlayerBinding binding;
    boolean isPlaying = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMusicPlayerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.playBt.setOnClickListener(view -> {
            Intent intent = new Intent(this,MyService.class);
            if (!isPlaying){
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    startForegroundService(intent);
                }else {
                    ContextCompat.startForegroundService(this,intent);
                }
                binding.playBt.setText("Stop");
                isPlaying = true;
            }else {
                stopService(intent);
                binding.playBt.setText("Play");
                isPlaying = false;
            }


        });


    }
}
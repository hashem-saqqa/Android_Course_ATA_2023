package com.example.android_course_ata_2023.Section101.RoomDatabasePart2;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;

import com.example.android_course_ata_2023.R;
import com.example.android_course_ata_2023.databinding.ActivityPlayersViewBinding;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class PlayersViewActivity extends AppCompatActivity {
    ActivityPlayersViewBinding binding;
    Bitmap bitmap;
    ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == RESULT_OK && result.getData() != null ){
                         bitmap = (Bitmap) result.getData().getExtras().get("data");
                    }
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPlayersViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        MyViewModel viewModel = new ViewModelProvider(this).get(MyViewModel.class);

        binding.addBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                launcher.launch(intent);

            }
        });

        binding.insertBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                viewModel.insertTeam(new Team("Brazil",5));
//                viewModel.insertTeam(new Team("Morocco",4));

                viewModel.insertPlayer(new Player("Neymar",10,
                        new Date(System.currentTimeMillis()),1, bitmap));
                viewModel.insertPlayer(new Player("Hakimi",2,
                        Calendar.getInstance().getTime(),2,bitmap));
                viewModel.insertPlayer(new Player("Silva",4,
                        Calendar.getInstance().getTime(),1,bitmap));
                viewModel.insertPlayer(new Player("Bounou",1,
                        new Date(System.currentTimeMillis()),2,bitmap));

//                viewModel.getAllPlayersByTeamId(1).observe(PlayersViewActivity.this,
//                        players -> {
//                            for (Player p : players) {
//                                Log.d("TeamsTesting", "onClick: "+p.toString());
//                            }
//                        });
            }
        });
    }
}
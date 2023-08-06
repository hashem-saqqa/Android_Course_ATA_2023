package com.example.android_course_ata_2023.Section101.RoomDatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.android_course_ata_2023.R;
import com.example.android_course_ata_2023.databinding.ActivityViewStudentsRoomBinding;

import java.util.List;

public class ViewStudentsRoomActivity extends AppCompatActivity {
    ActivityViewStudentsRoomBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityViewStudentsRoomBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        StudentViewModel viewModel = new ViewModelProvider(this)
                .get(StudentViewModel.class);

        binding.addStudentBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Student student = new Student(2,"Soha",50);
                 viewModel.getAllStudents().observe(ViewStudentsRoomActivity.this, students -> {
                     for (Student s: students) {
                         Log.d("ViewStudentTest", "onClick: Name "+s.getName());
                         Log.d("ViewStudentTest", "onClick: GPA "+s.getGpa());
                         Log.d("ViewStudentTest", "onClick: Id "+s.getId());
                         Log.d("ViewStudentTest", "onClick: *****************************");
                     }
                 });

            }
        });
    }
}
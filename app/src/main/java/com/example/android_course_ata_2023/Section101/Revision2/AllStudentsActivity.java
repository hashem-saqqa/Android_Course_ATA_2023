package com.example.android_course_ata_2023.Section101.Revision2;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;

import com.example.android_course_ata_2023.R;
import com.example.android_course_ata_2023.Section101.Revision1.OnItemClickListener;
import com.example.android_course_ata_2023.databinding.ActivityAllStudentsBinding;

import java.util.ArrayList;

public class AllStudentsActivity extends AppCompatActivity implements OnItemClickListener {
    ActivityAllStudentsBinding binding;
    ArrayList<Student> students;
    Bitmap bitmap;
    ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == RESULT_OK && result.getData() != null){
                        bitmap = (Bitmap) result.getData().getExtras().get("data");
                        binding.studentImageIv.setImageBitmap(bitmap);
                    }
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAllStudentsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        StudentsDB db = new StudentsDB(this);

        binding.addStudentBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Student student = new Student(binding.studentNameEt.getText().toString(),
                        Double.parseDouble(binding.studentGpaEt.getText().toString()),
                        bitmap);
                db.insertStudent(student);
                students =  db.getAllStudents();
                StudentsAdapter adapter = new StudentsAdapter(students, AllStudentsActivity.this);
                binding.studentsRv.setAdapter(adapter);
                binding.studentsRv.setLayoutManager(new LinearLayoutManager(AllStudentsActivity.this));
            }
        });
        binding.studentImageIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                launcher.launch(intent);
            }
        });

         students = db.getAllStudents();
        StudentsAdapter adapter = new StudentsAdapter(students, this);
        binding.studentsRv.setAdapter(adapter);
        binding.studentsRv.setLayoutManager(new LinearLayoutManager(this));


    }

    @Override
    public void onDelete(int pos) {

    }
}
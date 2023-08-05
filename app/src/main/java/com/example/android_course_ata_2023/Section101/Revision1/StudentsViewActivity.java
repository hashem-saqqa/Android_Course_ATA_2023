package com.example.android_course_ata_2023.Section101.Revision1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.android_course_ata_2023.R;
import com.example.android_course_ata_2023.databinding.ActivityStudentsViewBinding;

import java.util.ArrayList;

public class StudentsViewActivity extends AppCompatActivity  implements  OnItemClickListener{
    ActivityStudentsViewBinding binding;
    ArrayList<Student> students;
    StudentsAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding  = ActivityStudentsViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


         students = new ArrayList<>();
        students.add(new Student("Ahmed",1,90.5));
        students.add(new Student("Mohammed",2,80.6));
        students.add(new Student("Ali",3,97));

         adapter = new StudentsAdapter(students, this);

        binding.StudentsRv.setAdapter(adapter);
        binding.StudentsRv.setLayoutManager(
                new LinearLayoutManager(this, RecyclerView.VERTICAL,false));



    }

    @Override
    public void onDelete(int pos) {
        students.remove(pos);
        adapter.notifyItemRemoved(pos);
        adapter.notifyItemRangeChanged(pos,1);
    }
}
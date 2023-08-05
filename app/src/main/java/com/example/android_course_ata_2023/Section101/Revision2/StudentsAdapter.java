package com.example.android_course_ata_2023.Section101.Revision2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_course_ata_2023.Section101.Revision1.OnItemClickListener;
import com.example.android_course_ata_2023.databinding.ItemStudentBinding;

import java.util.ArrayList;

public class StudentsAdapter extends RecyclerView.Adapter<StudentsAdapter.StudentViewHolder> {
    ArrayList<com.example.android_course_ata_2023.Section101.Revision2.Student> students ;
    OnItemClickListener listener;

    public StudentsAdapter(ArrayList<com.example.android_course_ata_2023.Section101.Revision2.Student> students, OnItemClickListener listener) {
        this.students = students;
        this.listener = listener;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemStudentBinding binding = ItemStudentBinding.inflate(
                LayoutInflater.from(parent.getContext()),parent,false);
        return new StudentViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        int poss = position;
        Student s = students.get(poss);
        holder.studentId.setText(String.valueOf(s.getId()));
        holder.studentName.setText(s.getName());
        holder.studentGPA.setText(String.valueOf(s.getGPA()));
        holder.deleteIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onDelete(poss);
            }
        });

    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    class StudentViewHolder extends RecyclerView.ViewHolder {
        TextView studentId,studentName,studentGPA;
        ImageView deleteIv;

        public StudentViewHolder(ItemStudentBinding binding) {
            super(binding.getRoot());
            studentId = binding.studentId;
            studentName = binding.studentName;
            studentGPA = binding.studentGPA;
            deleteIv = binding.deleteIcon;

        }
    }

}

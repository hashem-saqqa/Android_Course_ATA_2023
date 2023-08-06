package com.example.android_course_ata_2023.Section101.RoomDatabase;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class StudentViewModel extends AndroidViewModel {
    private StudentRepository repository;
    public StudentViewModel(@NonNull Application application) {
        super(application);
        repository = new StudentRepository(application);
    }
    void insertStudent(Student student){
        repository.insertStudent(student);
    }


    void updateStudent(Student student){
       repository.updateStudent(student);
    }


    void deleteStudent(Student student){
        repository.deleteStudent(student);

    }

    LiveData<List<Student>> getAllStudents(){
        return repository.getAllStudents();
    }
}

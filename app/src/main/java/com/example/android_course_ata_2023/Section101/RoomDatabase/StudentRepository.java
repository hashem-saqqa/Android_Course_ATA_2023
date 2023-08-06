package com.example.android_course_ata_2023.Section101.RoomDatabase;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

public class StudentRepository {

    private StudentDao studentDao;

    public StudentRepository(Application application) {
       StudentsDatabase db = StudentsDatabase.getDatabase(application);
       studentDao = db.studentDao();
    }

    void insertStudent(Student student){
        StudentsDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                studentDao.insertStudent(student);
            }
        });
    }


    void updateStudent(Student student){
        StudentsDatabase.databaseWriteExecutor.execute(() -> {
            studentDao.updateStudent(student);
        });

    }


    void deleteStudent(Student student){
        StudentsDatabase.databaseWriteExecutor.execute(() -> {
            studentDao.deleteStudent(student);
        });

    }

    LiveData<List<Student>> getAllStudents(){
        return studentDao.getAllStudents();
    }

}

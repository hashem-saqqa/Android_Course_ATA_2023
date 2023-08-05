package com.example.android_course_ata_2023.Section101.Revision2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import androidx.annotation.Nullable;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class StudentsDB extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "studentsDb";
    public static final String STUDENTS_TABLE = "students";
    public static final String STUDENTS_ID_COLUMN = "id";
    public static final String STUDENTS_NAME_COLUMN = "name";
    public static final String STUDENTS_GPA_COLUMN = "GPA";
    public static final String STUDENTS_IMAGE_COLUMN = "image";

    public StudentsDB(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE " + STUDENTS_TABLE + " (" +
                STUDENTS_ID_COLUMN + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                STUDENTS_NAME_COLUMN + " TEXT, " + STUDENTS_GPA_COLUMN + " REAL, " + STUDENTS_IMAGE_COLUMN + " BLOB)";
        sqLiteDatabase.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + STUDENTS_TABLE);
        onCreate(sqLiteDatabase);
    }

    public boolean insertStudent(Student student) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(STUDENTS_NAME_COLUMN, student.getName());
        cv.put(STUDENTS_GPA_COLUMN, student.getGPA());
        if (student.getImage() != null)
            cv.put(STUDENTS_IMAGE_COLUMN, getBitmapAsByteArray(student.getImage()));
        long result = db.insert(STUDENTS_TABLE, null, cv);
        return result > 0;
    }

    public boolean updateStudent(Student student) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(STUDENTS_NAME_COLUMN, student.getName());
        cv.put(STUDENTS_GPA_COLUMN, student.getGPA());

        if (student.getImage() != null)
            cv.put(STUDENTS_IMAGE_COLUMN, getBitmapAsByteArray(student.getImage()));

        int result = db.update(STUDENTS_TABLE, cv , STUDENTS_ID_COLUMN+" = ?"
                ,new String[]{String.valueOf(student.getId())});
        return result != 0 ;
    }

    public int deleteStudent(int id){
        SQLiteDatabase db = getWritableDatabase();
       return db.delete(STUDENTS_TABLE, STUDENTS_ID_COLUMN+ "= ?",
                new String[]{String.valueOf(id)});
    }

    public ArrayList<Student> getAllStudents(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+STUDENTS_TABLE,null);
        ArrayList<Student> students = new ArrayList<>();

        while (cursor.moveToNext()){
          int id = cursor.getInt(cursor.getColumnIndexOrThrow(STUDENTS_ID_COLUMN));
          String name = cursor.getString(cursor.getColumnIndexOrThrow(STUDENTS_NAME_COLUMN));
          double GPA = cursor.getDouble(cursor.getColumnIndexOrThrow(STUDENTS_GPA_COLUMN));

          if (cursor.getBlob(cursor.getColumnIndexOrThrow(STUDENTS_IMAGE_COLUMN)) != null){
              Bitmap image =  getByteArrayAsBitmap(cursor.getBlob(cursor.getColumnIndexOrThrow(STUDENTS_IMAGE_COLUMN)));
              students.add(new Student(id,name,GPA,image));
          }else {
              students.add(new Student(id,name,GPA));
          }
        }
        return students;
    }


    public static byte[] getBitmapAsByteArray(Bitmap bitmap) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, outputStream);
        return outputStream.toByteArray();
    }

    public static Bitmap getByteArrayAsBitmap(byte[] bytes) {
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
    }

}

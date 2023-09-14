package com.example.android_course_ata_2023.Section101.Firebase;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import com.example.android_course_ata_2023.R;
import com.example.android_course_ata_2023.databinding.ActivityMain3Binding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.SetOptions;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.UploadTask;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    FirebaseFirestore fireStore;
    FirebaseStorage storage;



    ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == RESULT_OK && result.getData() != null){

                        Uri uri = result.getData().getData();

                        storage.getReference().child("images")
                                .child("profileImages")
                                .child("Ahmed profile Image").putFile(uri).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                                    @Override
                                    public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                                        if (task.isSuccessful()){
                                            Toast.makeText(MainActivity.this, "Image Uploaded", Toast.LENGTH_SHORT).show();
                                        }else {
                                            Toast.makeText(MainActivity.this, "Image Uploading failed", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                    }
                }
            }
    );


    ActivityMain3Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain3Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        fireStore = FirebaseFirestore.getInstance();
        storage = FirebaseStorage.getInstance();

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        launcher.launch(intent);


        //        Post p = new Post(1,"First Post",
//                "this is my first Post");
//
//        Map<String,Object> map = new HashMap<>();
//        map.put("id",2);
//        map.put("postTitle","Second Post");
//        map.put("postContent","this is my second post");

//        fireStore.collection("posts").add(map).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
//            @Override
//            public void onComplete(@NonNull Task<DocumentReference> task) {
//                if (task.isSuccessful()){
//                    Toast.makeText(MainActivity.this, "post added successfully", Toast.LENGTH_SHORT).show();
//                }else {
//                    Toast.makeText(MainActivity.this, String.valueOf(task.getException()), Toast.LENGTH_SHORT).show();
//
//                }
//            }
//        });

//        Map<String,Object> map2 = new HashMap<>();
//        map2.put("postLikes",1500);
//        map2.put("postComments",500);
//
//       fireStore.collection("posts").document("3").update("PostLikes", FieldValue.delete());
//

//      fireStore.collection("posts").document("3")
//              .get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
//                  @Override
//                  public void onComplete(@NonNull Task<DocumentSnapshot> task) {
//                      Post post = task.getResult().toObject(Post.class);
//                      task.getResult().getString("postLikes");
//                      post.getPostContent();
//                      binding.viewDataTv.setText( task.getResult().getId() +" ==> "+ post.toString());
//
//                  }
//              });

//        fireStore.collection("posts")
//                .orderBy("id")
//                .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<QuerySnapshot> task) {
////                task.getResult().getDocuments().get(0);
//                binding.viewDataTv.setText("");
//                for ( QueryDocumentSnapshot doc :task.getResult()){
//                    Post post =  doc.toObject(Post.class);
//                    binding.viewDataTv.append("\n\n"+post);
//                }
//            }
//        });



    }
}
package com.example.android_course_ata_2023.Section101.Firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.android_course_ata_2023.R;
import com.example.android_course_ata_2023.databinding.ActivityHomeBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.squareup.picasso.Picasso;

public class HomeActivity extends AppCompatActivity {
    ActivityHomeBinding binding;

    FirebaseFirestore fireStore;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        fireStore = FirebaseFirestore.getInstance();
        auth = FirebaseAuth.getInstance();


        fireStore.collection("users").document(auth.getCurrentUser().getUid())
                .get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        String imageUrl = task.getResult().getString("imageUrl");
                        binding.welcomeTv.append(" "+task.getResult().getString("name"));

                        Picasso.get().load(imageUrl).into(binding.profileImage);

                    }
                });






    }
}
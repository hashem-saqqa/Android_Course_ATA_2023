package com.example.android_course_ata_2023.Section101.Notifications;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.RemoteViews;

import com.example.android_course_ata_2023.R;
import com.example.android_course_ata_2023.databinding.ActivityShowNotificationBinding;

public class ShowNotificationActivity extends AppCompatActivity {
    ActivityShowNotificationBinding binding;
    public static final String CHANNEL_ID = "Channel1";
    NotificationManagerCompat managerCompat;
    NotificationCompat.Builder builder;
    Bitmap bitmap;

    ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == RESULT_OK && result.getData() != null){
                        bitmap = (Bitmap) result.getData().getExtras().get("data");
                    }
                }
            }

    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityShowNotificationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.showNotificationBt.setOnClickListener(view -> {

            Intent intent= new Intent(this,
                    ShowNotificationActivity.class);

            PendingIntent pendingIntent = PendingIntent.
                    getActivity(this,102,intent,
                            PendingIntent.FLAG_IMMUTABLE);

            RemoteViews remoteView1 = new RemoteViews(getPackageName(),R.layout.small_notification_layout);
            RemoteViews remoteView2 = new RemoteViews(getPackageName(),R.layout.big_notification_layout);

            builder = new NotificationCompat
                    .Builder(this, CHANNEL_ID);
            builder.setSmallIcon(R.drawable.icon_person);
            builder.setContentTitle("New Message");
            builder.setContentText("bring bread with u");
            builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);
            builder.setContentIntent(pendingIntent);

            builder.setStyle(new NotificationCompat.DecoratedCustomViewStyle());
            builder.setCustomContentView(remoteView1);
            builder.setCustomBigContentView(remoteView2);


//            builder.setStyle(new NotificationCompat.BigTextStyle().bigText("or u gonna be kicked out of the home"));

//            builder.setLargeIcon(bitmap);
//            builder.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bitmap)
//                    .bigLargeIcon(null));

//            builder.setStyle(new NotificationCompat.InboxStyle()
//                    .addLine("Hello")
//                    .addLine("how r u")
//            );

            builder.addAction(R.drawable.cancel_icon,"View",pendingIntent);
            builder.addAction(R.drawable.cancel_icon,"Archive",pendingIntent);
            builder.setAutoCancel(true);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                NotificationChannel channel = new NotificationChannel(CHANNEL_ID,
                        "System Channel", NotificationManager.IMPORTANCE_DEFAULT);

                NotificationManager notificationManager = getSystemService(NotificationManager.class);
                notificationManager.createNotificationChannel(channel);
            }
            managerCompat = NotificationManagerCompat.from(this);

            if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.POST_NOTIFICATIONS)
                    != PackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.POST_NOTIFICATIONS}, 101);
            } else {

                managerCompat.notify(1, builder.build());
            }
        });

        binding.addPictureBt.setOnClickListener(view -> {
            Intent intent = new Intent();
            intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
            launcher.launch(intent);
        });


    }

    @SuppressLint("MissingPermission")
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 101 && grantResults.length > 0 &&
                grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            managerCompat.notify(1, builder.build());
        }

    }
}
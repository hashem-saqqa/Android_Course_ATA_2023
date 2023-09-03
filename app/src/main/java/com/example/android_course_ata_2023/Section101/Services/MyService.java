package com.example.android_course_ata_2023.Section101.Services;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.IBinder;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.android_course_ata_2023.R;

public class MyService extends Service {
    MediaPlayer player;
    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        player = MediaPlayer.create(this, R.raw.ringtone);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        player.start();

        Intent intent1 = new Intent(this,MyService.class);
        intent1.setAction("stopMusic");

        PendingIntent pendingIntent = PendingIntent.getService(this,
                102,intent1,PendingIntent.FLAG_MUTABLE);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel(
                    "ServiceChannel","Music Channel", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);

        }
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,"ServiceChannel")
                .setSmallIcon(R.drawable.icon_person)
                .setContentTitle("Music Notification")
                .setContentText("Billie Aillesh")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .addAction(R.drawable.cancel_icon, "Stop",pendingIntent)
                ;
       startForeground(11,builder.build());

       if (intent.getAction()!=null){
           if (intent.getAction().equals("stopMusic")){
               stopSelf();
           }
       }



        return START_NOT_STICKY;

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        player.stop();
        player.release();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
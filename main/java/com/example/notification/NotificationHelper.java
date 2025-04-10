package com.example.notification;
import android.Manifest;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

public class NotificationHelper {
    private static final String channelId = "jakiś domyślny kanał";
    private static final String channelName = "jakaś domyślna nazwa";
    private static final int notificationIt = 9972;

    public static void Notification(AppCompatActivity activity, Context context, String title, String message,
                                    int styleType, int largeIconResId){

        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.TIRAMISU){
            if(activity.checkSelfPermission(Manifest.permission.POST_NOTIFICATIONS)
            != PackageManager.PERMISSION_GRANTED){
                activity.requestPermissions(new String[]{Manifest.permission.POST_NOTIFICATIONS},100);
                return;
            }
        }
        NotificationManager notificationManager =(NotificationManager) activity.getSystemService(Context.NOTIFICATION_SERVICE);
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(channel);
        }

    }

    private void createNotificationChannel(){
//        if(Build.VERSION.SDK_INT)
    }

    public static void sendNotification(AppCompatActivity activity, Context context, String title){

        NotificationCompat.Builder builder = new NotificationCompat.Builder(activity, channelId)
                .setSmallIcon(R.drawable.ok)
                .setContentText(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
    }

    private static final String channelIdLow = "niski nakał";

    public static void createNotificationChannels(Context context){
        NotificationManager notificationManager = (NotificationManager)context.getSystemService(context.NOTIFICATION_SERVICE);
        NotificationChannel channelLow = new NotificationChannel(channelIdLow, channelName,
                NotificationManager.IMPORTANCE_LOW);
    }
}

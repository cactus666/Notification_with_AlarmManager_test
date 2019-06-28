package com.forasoft.notification_with_alarmmanager;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    private Button btn;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                count++;
//                Log.i("info", count+"");
//                long time = System.currentTimeMillis();
//                MyService.setServiceAlarm(MainActivity.this, true, "lol"+count, time);


//                Notification notification = new NotificationCompat.Builder(MainActivity.this)
//                        .setTicker("hello")
//                        .setSmallIcon(R.drawable.ic_qwerty)
//                        .setContentTitle("hi")
//                        .setContentText("qws")
////                .setContentIntent(pi)
//                        .setAutoCancel(true)
//                        .build();
//                NotificationManagerCompat notificationManager =
//                        NotificationManagerCompat.from(MainActivity.this);
//                notificationManager.notify(0, notification);



                NotificationCompat.Builder builder =
                        new NotificationCompat.Builder(MainActivity.this,
                                "56t")
                                .setSmallIcon(R.drawable.ic_notification)
                                .setContentTitle("Title 2")
                                .setContentText("Notification text 2");

                Notification notification = builder.build();

                NotificationManager notificationManager =
                        (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(2, notification);


//                NotificationCompat.Builder builder =
//                        new NotificationCompat.Builder(MainActivity.this)
//                                .setSmallIcon(R.drawable.ic_notification)
//                                .setContentTitle("Notifications Example")
//                                .setContentText("This is a test notification");
//                Intent notificationIntent = new Intent(MainActivity.this, MainActivity.class);
//                PendingIntent contentIntent = PendingIntent.getActivity(MainActivity.this, 0, notificationIntent,
//                        PendingIntent.FLAG_UPDATE_CURRENT);
//                builder.setContentIntent(contentIntent);
                // Add as notification
//                NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//                manager.notify(0, builder.build());
            }
        });
    }
}

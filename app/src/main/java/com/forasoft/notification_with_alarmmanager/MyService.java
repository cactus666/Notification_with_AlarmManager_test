package com.forasoft.notification_with_alarmmanager;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;

import java.util.concurrent.TimeUnit;

public class MyService extends IntentService {
    private static final String TAG = "PollService";
    // 60 секунд
    private static final long POLL_INTERVAL_MS = TimeUnit.MINUTES.toMillis(4);

    public MyService() {
        super("test");
        Log.i("info", "constr");
    }

    public static Intent newIntent(Context context) {
        return new Intent(context, MyService.class);
    }

    public static void setServiceAlarm(Context context, boolean isOn, String arg, long time) {
        Log.i("info", "start_ssa");
        Intent i = MyService.newIntent(context);
        i.putExtra("val", arg);
        i.setAction(arg);
        PendingIntent pi = PendingIntent.getService(context, 0, i, 0);
        AlarmManager alarmManager = (AlarmManager)
                context.getSystemService(Context.ALARM_SERVICE);
        if (isOn) {
            Log.i("info", "start_now");
//            Log.i("info", (SystemClock.elapsedRealtime())+"");
//            Log.i("info", time+"");
            alarmManager.set(AlarmManager.ELAPSED_REALTIME, SystemClock.elapsedRealtime() + 4*60000, pi);
//            alarmManager.setRepeating(AlarmManager.ELAPSED_REALTIME,
//                    SystemClock.elapsedRealtime(), POLL_INTERVAL_MS, pi);
        } else {
            alarmManager.cancel(pi);
            pi.cancel();
        }
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.i("info", "start_hi = "+intent.getStringExtra("val"));

        Resources resources = getResources();
//        Intent i = MainActivity.newIntent(this);
//        PendingIntent pi = PendingIntent.getActivity(this, 0, i, 0);
        Notification notification = new NotificationCompat.Builder(this)
                .setTicker("hello")
                .setSmallIcon(android.R.drawable.ic_menu_report_image)
                .setContentTitle("hi")
                .setContentText("qws")
//                .setContentIntent(pi)
                .setAutoCancel(true)
                .build();
        NotificationManagerCompat notificationManager =
                NotificationManagerCompat.from(this);
        notificationManager.notify(0, notification);

    }

}
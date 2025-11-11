package com.informatika.mobilecomponentrofa.alarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.informatika.mobilecomponentrofa.R;

public class AlarmActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        Button btnSet = findViewById(R.id.btnSetAlarm);
        btnSet.setOnClickListener(v -> {
            Intent intent = new Intent(this, AlarmReceiver.class);
            PendingIntent pi = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_IMMUTABLE);
            AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
            am.setExact(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + 5000, pi);
        });
    }
}

package com.example.benja.moodtracker;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;


public class Notification_receiver extends BroadcastReceiver {

    public static final String CUSTOM_INTENT = "com.example.benja.moodtracker.CUSTOM_INTENT";

    @Override
    public void onReceive(Context context, Intent intent) {
        SharedPreferences mPreferences = context.getSharedPreferences("PREFERENCE_KEY_NAME", MODE_PRIVATE);

        if (CUSTOM_INTENT.equals(intent.getAction())) {
            Log.d("asdf", "I've began");

            mPreferences.edit().putInt("counter", 0).apply();

        } else {
            Log.d("tagtag", "received unsupported Intent " + intent);
        }

    }
}


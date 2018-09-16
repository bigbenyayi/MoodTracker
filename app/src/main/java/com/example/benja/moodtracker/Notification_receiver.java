package com.example.benja.moodtracker;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;
import static com.example.benja.moodtracker.MainActivity.PREF_KEY_MOOD0;

public class Notification_receiver extends BroadcastReceiver {
    public static final String PREF_KEY_COMMENT = "PREFERENCE_KEY_COMMENT";
    private Context mContext;


    @Override
    public void onReceive(Context context, Intent intent) {
        this.mContext = context;
        //  ArrayList listMood = new ArrayList();

        SharedPreferences mPreferences = context.getSharedPreferences("PREFERENCE_KEY_NAME", MODE_PRIVATE);
        int mood = (mPreferences.getInt(PREF_KEY_MOOD0, 2));
        String moodString = Integer.toString(mood);
        // listMood.add(moodString);
        mood = 2;

        Log.d("emma", moodString);


    }
}


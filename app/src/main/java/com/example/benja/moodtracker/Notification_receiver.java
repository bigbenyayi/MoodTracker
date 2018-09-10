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

import static android.content.Context.MODE_PRIVATE;
import static com.example.benja.moodtracker.MainActivity.PREF_KEY_MOOD;

public class Notification_receiver extends BroadcastReceiver {
    public static final String PREF_KEY_COMMENT = "PREFERENCE_KEY_COMMENT";
    private Context mContext;



    @Override
    public void onReceive(Context context, Intent intent) {
        this.mContext = context;

        SharedPreferences mPreferences = context.getSharedPreferences("PREFERENCE_KEY_NAME", MODE_PRIVATE);
        final int mood = (mPreferences.getInt(PREF_KEY_MOOD, 0));
        String moodString = Integer.toString(mood);

        Log.d("emma", moodString);






       //Log.d("asdf","It worked my time machine worked");
      /*  TextView linearLayout =  (TextView) (Activity)context.find(R.id.moodView4);
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams)linearLayout.getLayoutParams();
        params.setMargins(0, 0, 0, 10);
        linearLayout.setLayoutParams(params);

        linearLayout.requestLayout(); */


    }
}

package com.example.benja.moodtracker;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
    public static final String PREF_KEY_COMMENT = "PREFERENCE_KEY_COMMENT";
    private Context mContext;
    public static final String PREF_KEY_MOOD = "PREFERENCE_KEY_MOOD";
    public List<Integer> listOfMoods = new ArrayList<>();
    final ArrayList<String> listOfComments = new ArrayList<>();

    @Override
    public void onReceive(Context context, Intent intent) {
        this.mContext = context;

        SharedPreferences mPreferences = context.getSharedPreferences("PREFERENCE_KEY_NAME", MODE_PRIVATE);

        int mood = (mPreferences.getInt(PREF_KEY_MOOD, 2));
        String comment = (mPreferences.getString(PREF_KEY_COMMENT, "Not found!"));

        switch (mood) {

            case 0:

                if (listOfMoods.size() == 7) {
                    listOfMoods.set(0, listOfMoods.get(1));
                    listOfMoods.set(1, listOfMoods.get(2));
                    listOfMoods.set(2, listOfMoods.get(3));
                    listOfMoods.set(3, listOfMoods.get(4));
                    listOfMoods.set(4, listOfMoods.get(5));
                    listOfMoods.set(5, listOfMoods.get(6));
                    listOfMoods.set(6, R.color.banana_yellow);
                } else {
                    listOfMoods.add(R.color.banana_yellow);
                }
                break;

            case 1:

                if (listOfMoods.size() == 7) {
                    listOfMoods.set(0, listOfMoods.get(1));
                    listOfMoods.set(1, listOfMoods.get(2));
                    listOfMoods.set(2, listOfMoods.get(3));
                    listOfMoods.set(3, listOfMoods.get(4));
                    listOfMoods.set(4, listOfMoods.get(5));
                    listOfMoods.set(5, listOfMoods.get(6));
                    listOfMoods.set(6, R.color.light_sage);
                } else {
                    listOfMoods.add(R.color.light_sage);
                }

                break;

            case 2:

                if (listOfMoods.size() == 7) {
                    listOfMoods.set(0, listOfMoods.get(1));
                    listOfMoods.set(1, listOfMoods.get(2));
                    listOfMoods.set(2, listOfMoods.get(3));
                    listOfMoods.set(3, listOfMoods.get(4));
                    listOfMoods.set(4, listOfMoods.get(5));
                    listOfMoods.set(5, listOfMoods.get(6));
                    listOfMoods.set(6, R.color.cornflower_blue_65);
                } else {
                    listOfMoods.add(R.color.cornflower_blue_65);
                }

                break;

            case 3:

                if (listOfMoods.size() == 7) {
                    listOfMoods.set(0, listOfMoods.get(1));
                    listOfMoods.set(1, listOfMoods.get(2));
                    listOfMoods.set(2, listOfMoods.get(3));
                    listOfMoods.set(3, listOfMoods.get(4));
                    listOfMoods.set(4, listOfMoods.get(5));
                    listOfMoods.set(5, listOfMoods.get(6));
                    listOfMoods.set(6, R.color.warm_grey);
                } else {
                    listOfMoods.add(R.color.warm_grey);
                }

                break;

            case 4:

                if (listOfMoods.size() == 7) {
                    listOfMoods.set(0, listOfMoods.get(1));
                    listOfMoods.set(1, listOfMoods.get(2));
                    listOfMoods.set(2, listOfMoods.get(3));
                    listOfMoods.set(3, listOfMoods.get(4));
                    listOfMoods.set(4, listOfMoods.get(5));
                    listOfMoods.set(5, listOfMoods.get(6));
                    listOfMoods.set(6, R.color.faded_red);
                } else {
                    listOfMoods.add(R.color.faded_red);
                }

                break;
        }

        for (int i = 0; i < listOfMoods.size(); i++) {
            mPreferences.edit().putInt("PREFERENCE_KEY_COLOR" + i, listOfMoods.get(i)).apply();
        }

        if (listOfComments.size() == 7) {
            listOfComments.set(0, listOfComments.get(1));
            listOfComments.set(1, listOfComments.get(2));
            listOfComments.set(2, listOfComments.get(3));
            listOfComments.set(3, listOfComments.get(4));
            listOfComments.set(4, listOfComments.get(5));
            listOfComments.set(5, listOfComments.get(6));
            listOfComments.set(6, comment);
        } else {
            listOfComments.add(comment);
        }

        for (int j = 0; j < listOfComments.size(); j++) {
            mPreferences.edit().putString("PREFERENCE_KEY_COMMENT" + j, listOfComments.get(j)).apply();
        }

    }

}


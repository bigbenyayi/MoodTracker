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
    //Extracting all values in SP
    public static final String PREF_KEY_COMMENT = "PREFERENCE_KEY_COMMENT";
    public static final String PREF_KEY_COLOR1 = "PREFERENCE_KEY_COLOR1";
    public static final String PREF_KEY_COLOR2 = "PREFERENCE_KEY_COLOR2";
    public static final String PREF_KEY_COLOR3 = "PREFERENCE_KEY_COLOR3";
    public static final String PREF_KEY_COLOR4 = "PREFERENCE_KEY_COLOR4";
    public static final String PREF_KEY_COLOR5 = "PREFERENCE_KEY_COLOR5";
    public static final String PREF_KEY_COLOR6 = "PREFERENCE_KEY_COLOR6";
    public static final String PREF_KEY_COMMENT1 = "PREFERENCE_KEY_COMMENT1";
    public static final String PREF_KEY_COMMENT2 = "PREFERENCE_KEY_COMMENT2";
    public static final String PREF_KEY_COMMENT3 = "PREFERENCE_KEY_COMMENT3";
    public static final String PREF_KEY_COMMENT4 = "PREFERENCE_KEY_COMMENT4";
    public static final String PREF_KEY_COMMENT5 = "PREFERENCE_KEY_COMMENT5";
    public static final String PREF_KEY_COMMENT6 = "PREFERENCE_KEY_COMMENT6";
    public static final String PREF_KEY_MOOD = "PREFERENCE_KEY_MOOD";
    //Defining the Arraylists that will hold the colors and the comments
    public List<Integer> listOfMoods = new ArrayList<>();
    final ArrayList<String> listOfComments = new ArrayList<>();

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("asdf", "I've began");

        //Extracting colors from SP
        SharedPreferences mPreferences = context.getSharedPreferences("PREFERENCE_KEY_NAME", MODE_PRIVATE);
        int mood = (mPreferences.getInt(PREF_KEY_MOOD, 2)); //If no mood selected --> normal emoji chosen
        String comment = (mPreferences.getString(PREF_KEY_COMMENT, ""));
        int checking0;
        int checking1 = (mPreferences.getInt(PREF_KEY_COLOR1, 5)); //default value of 5 gets treated in History activity
        int checking2 = (mPreferences.getInt(PREF_KEY_COLOR2, 5));
        int checking3 = (mPreferences.getInt(PREF_KEY_COLOR3, 5));
        int checking4 = (mPreferences.getInt(PREF_KEY_COLOR4, 5));
        int checking5 = (mPreferences.getInt(PREF_KEY_COLOR5, 5));
        int checking6 = (mPreferences.getInt(PREF_KEY_COLOR6, 5));

        //extracting comments from SP
        String checkingComments0;
        String checkingComments1 = (mPreferences.getString(PREF_KEY_COMMENT1, "")); //default value "" to not display empty strings (gets treated in History activity)
        String checkingComments2 = (mPreferences.getString(PREF_KEY_COMMENT2, ""));
        String checkingComments3 = (mPreferences.getString(PREF_KEY_COMMENT3, ""));
        String checkingComments4 = (mPreferences.getString(PREF_KEY_COMMENT4, ""));
        String checkingComments5 = (mPreferences.getString(PREF_KEY_COMMENT5, ""));
        String checkingComments6 = (mPreferences.getString(PREF_KEY_COMMENT6, ""));

        //Setting comments in correct order with new comment
        checkingComments0 = checkingComments1;
        checkingComments1 = checkingComments2;
        checkingComments2 = checkingComments3;
        checkingComments3 = checkingComments4;
        checkingComments4 = checkingComments5;
        checkingComments5 = checkingComments6;
        checkingComments6 = comment;

        //Adding new order containing new comment into empty Arraylist
        listOfComments.add(checkingComments0);
        listOfComments.add(checkingComments1);
        listOfComments.add(checkingComments2);
        listOfComments.add(checkingComments3);
        listOfComments.add(checkingComments4);
        listOfComments.add(checkingComments5);
        listOfComments.add(checkingComments6);

        //Saving this list to SP
        for (int j = 0; j < listOfComments.size(); j++) {
            mPreferences.edit().putString("PREFERENCE_KEY_COMMENT" + j, listOfComments.get(j)).apply();
        }

        //Setting colors in correct order with new color
        checking0 = checking1;
        checking1 = checking2;
        checking2 = checking3;
        checking3 = checking4;
        checking4 = checking5;
        checking5 = checking6;
        checking6 = mood;

        //Adding new order containing new color into empty Arraylist
        listOfMoods.add(checking0);
        listOfMoods.add(checking1);
        listOfMoods.add(checking2);
        listOfMoods.add(checking3);
        listOfMoods.add(checking4);
        listOfMoods.add(checking5);
        listOfMoods.add(checking6);

        //Saving this list to SP
        for (int j = 0; j < listOfMoods.size(); j++) {
            mPreferences.edit().putInt("PREFERENCE_KEY_COLOR" + j, listOfMoods.get(j)).apply();
        }

        mPreferences.edit().putInt("PREFERENCE_KEY_MOOD", 2).apply(); //Reseting mood to normal emoji if no mood is selected on days after
        mPreferences.edit().putString("PREFERENCE_KEY_COMMENT", "").apply(); //Reseting comment to not duplicate comment for next days
    }
}


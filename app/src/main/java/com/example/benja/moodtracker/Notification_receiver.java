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
    public static final String PREF_KEY_COLOR0 = "PREFERENCE_KEY_COLOR0";
    public static final String PREF_KEY_COLOR1 = "PREFERENCE_KEY_COLOR1";
    public static final String PREF_KEY_COLOR2 = "PREFERENCE_KEY_COLOR2";
    public static final String PREF_KEY_COLOR3 = "PREFERENCE_KEY_COLOR3";
    public static final String PREF_KEY_COLOR4 = "PREFERENCE_KEY_COLOR4";
    public static final String PREF_KEY_COLOR5 = "PREFERENCE_KEY_COLOR5";
    public static final String PREF_KEY_COMMENT0 = "PREFERENCE_KEY_COMMENT0";
    public static final String PREF_KEY_COMMENT1 = "PREFERENCE_KEY_COMMENT1";
    public static final String PREF_KEY_COMMENT2 = "PREFERENCE_KEY_COMMENT2";
    public static final String PREF_KEY_COMMENT3 = "PREFERENCE_KEY_COMMENT3";
    public static final String PREF_KEY_COMMENT4 = "PREFERENCE_KEY_COMMENT4";
    public static final String PREF_KEY_COMMENT5 = "PREFERENCE_KEY_COMMENT4";
    private Context mContext;
    public static final String PREF_KEY_MOOD = "PREFERENCE_KEY_MOOD";
    public List<Integer> listOfMoods = new ArrayList<>();
    final ArrayList<String> listOfComments = new ArrayList<>();

    @Override
    public void onReceive(Context context, Intent intent) {
        this.mContext = context;
        Log.d("mhsc","I've began");

        SharedPreferences mPreferences = context.getSharedPreferences("PREFERENCE_KEY_NAME", MODE_PRIVATE);
        int mood = (mPreferences.getInt(PREF_KEY_MOOD, 2));
        String comment = (mPreferences.getString(PREF_KEY_COMMENT, ""));
        int checking0 = (mPreferences.getInt(PREF_KEY_COLOR0, 15));
        int checking1 = (mPreferences.getInt(PREF_KEY_COLOR1, 15));
        int checking2 = (mPreferences.getInt(PREF_KEY_COLOR2, 15));
        int checking3 = (mPreferences.getInt(PREF_KEY_COLOR3, 15));
        int checking4 = (mPreferences.getInt(PREF_KEY_COLOR4, 15));
        int checking5 = (mPreferences.getInt(PREF_KEY_COLOR5, 15));
        String checkingComments0 = (mPreferences.getString(PREF_KEY_COMMENT0, "NoThInG"));
        String checkingComments1 = (mPreferences.getString(PREF_KEY_COMMENT1, "NoThInG"));
        String checkingComments2 = (mPreferences.getString(PREF_KEY_COMMENT2, "NoThInG"));
        String checkingComments3 = (mPreferences.getString(PREF_KEY_COMMENT3, "NoThInG"));
        String checkingComments4 = (mPreferences.getString(PREF_KEY_COMMENT4, "NoThInG"));
        String checkingComments5 = (mPreferences.getString(PREF_KEY_COMMENT5, "NoThInG"));

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



                    if (checking0 == 15) {
                        listOfMoods.add(R.color.banana_yellow);
                    } else if (checking1 == 15) {
                        listOfMoods.add(checking0);
                        listOfMoods.add(1, R.color.banana_yellow);
                    } else if (checking2 == 15) {
                        listOfMoods.add(checking0);
                        listOfMoods.add(checking1);
                        listOfMoods.add(2, R.color.banana_yellow);
                    } else if (checking3 == 15) {
                        listOfMoods.add(checking0);
                        listOfMoods.add(checking1);
                        listOfMoods.add(checking2);
                        listOfMoods.add(3, R.color.banana_yellow);
                    } else if (checking4 == 15) {
                        listOfMoods.add(checking0);
                        listOfMoods.add(checking1);
                        listOfMoods.add(checking2);
                        listOfMoods.add(checking3);
                        listOfMoods.add(4, R.color.banana_yellow);
                    } else if (checking5 == 15) {
                        listOfMoods.add(checking0);
                        listOfMoods.add(checking1);
                        listOfMoods.add(checking2);
                        listOfMoods.add(checking3);
                        listOfMoods.add(checking4);
                        listOfMoods.add(5, R.color.banana_yellow);
                    }
                }
                break;

            case 1:

                if (listOfMoods.size() >= 7) {
                    listOfMoods.set(0, listOfMoods.get(1));
                    listOfMoods.set(1, listOfMoods.get(2));
                    listOfMoods.set(2, listOfMoods.get(3));
                    listOfMoods.set(3, listOfMoods.get(4));
                    listOfMoods.set(4, listOfMoods.get(5));
                    listOfMoods.set(5, listOfMoods.get(6));
                    listOfMoods.set(6, R.color.light_sage);
                } else {
                    if (checking0 == 15) {
                        listOfMoods.add(R.color.light_sage);
                    } else if (checking1 == 15) {
                        listOfMoods.add(checking0);
                        listOfMoods.add(R.color.light_sage);
                    } else if (checking2 == 15) {
                        listOfMoods.add(checking0);
                        listOfMoods.add(checking1);
                        listOfMoods.add(R.color.light_sage);
                    } else if (checking3 == 15) {
                        listOfMoods.add(checking0);
                        listOfMoods.add(checking1);
                        listOfMoods.add(checking2);
                        listOfMoods.add( R.color.light_sage);
                    } else if (checking4 == 15) {
                        listOfMoods.add(checking0);
                        listOfMoods.add(checking1);
                        listOfMoods.add(checking2);
                        listOfMoods.add(checking3);
                        listOfMoods.add( R.color.light_sage);
                    } else if (checking5 == 15) {
                        listOfMoods.add(checking0);
                        listOfMoods.add(checking1);
                        listOfMoods.add(checking2);
                        listOfMoods.add(checking3);
                        listOfMoods.add(checking4);
                        listOfMoods.add(R.color.light_sage);
                    }
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
                    if (checking0 == 15) {
                        listOfMoods.add(R.color.cornflower_blue_65);
                    } else if (checking1 == 15) {
                        listOfMoods.add(checking0);
                        listOfMoods.add(1, R.color.cornflower_blue_65);
                    } else if (checking2 == 15) {
                        listOfMoods.add(checking0);
                        listOfMoods.add(checking1);
                        listOfMoods.add(2, R.color.cornflower_blue_65);
                    } else if (checking3 == 15) {
                        listOfMoods.add(checking0);
                        listOfMoods.add(checking1);
                        listOfMoods.add(checking2);
                        listOfMoods.add(3, R.color.cornflower_blue_65);
                    } else if (checking4 == 15) {
                        listOfMoods.add(checking0);
                        listOfMoods.add(checking1);
                        listOfMoods.add(checking2);
                        listOfMoods.add(checking3);
                        listOfMoods.add(4, R.color.cornflower_blue_65);
                    } else if (checking5 == 15) {
                        listOfMoods.add(checking0);
                        listOfMoods.add(checking1);
                        listOfMoods.add(checking2);
                        listOfMoods.add(checking3);
                        listOfMoods.add(checking4);
                        listOfMoods.add(5, R.color.cornflower_blue_65);
                    }
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
                    if (checking0 == 15) {
                        listOfMoods.add(R.color.warm_grey);
                    } else if (checking1 == 15) {
                        listOfMoods.add(checking0);
                        listOfMoods.add(1, R.color.warm_grey);
                    } else if (checking2 == 15) {
                        listOfMoods.add(checking0);
                        listOfMoods.add(checking1);
                        listOfMoods.add(2, R.color.warm_grey);
                    } else if (checking3 == 15) {
                        listOfMoods.add(checking0);
                        listOfMoods.add(checking1);
                        listOfMoods.add(checking2);
                        listOfMoods.add(3, R.color.warm_grey);
                    } else if (checking4 == 15) {
                        listOfMoods.add(checking0);
                        listOfMoods.add(checking1);
                        listOfMoods.add(checking2);
                        listOfMoods.add(checking3);
                        listOfMoods.add(4, R.color.warm_grey);
                    } else if (checking5 == 15) {
                        listOfMoods.add(checking0);
                        listOfMoods.add(checking1);
                        listOfMoods.add(checking2);
                        listOfMoods.add(checking3);
                        listOfMoods.add(checking4);
                        listOfMoods.add(5, R.color.warm_grey);
                    }
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
                    if (checking0 == 15) {
                        listOfMoods.add(R.color.faded_red);
                    } else if (checking1 == 15) {
                        listOfMoods.add(checking0);
                        listOfMoods.add(1, R.color.faded_red);
                    } else if (checking2 == 15) {
                        listOfMoods.add(checking0);
                        listOfMoods.add(checking1);
                        listOfMoods.add(2, R.color.faded_red);
                    } else if (checking3 == 15) {
                        listOfMoods.add(checking0);
                        listOfMoods.add(checking1);
                        listOfMoods.add(checking2);
                        listOfMoods.add(3, R.color.faded_red);
                    } else if (checking4 == 15) {
                        listOfMoods.add(checking0);
                        listOfMoods.add(checking1);
                        listOfMoods.add(checking2);
                        listOfMoods.add(checking3);
                        listOfMoods.add(4, R.color.faded_red);
                    } else if (checking5 == 15) {
                        listOfMoods.add(checking0);
                        listOfMoods.add(checking1);
                        listOfMoods.add(checking2);
                        listOfMoods.add(checking3);
                        listOfMoods.add(checking4);
                        listOfMoods.add(5, R.color.faded_red);
                    }                }

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
            if (checkingComments0.equals("NoThInG")) {
                listOfComments.add(comment);
            } else if (checkingComments1.equals("NoThInG")) {
                listOfComments.add(checkingComments0);
                listOfComments.add(comment);
            } else if (checkingComments2.equals("NoThInG")) {
                listOfComments.add(checkingComments0);
                listOfComments.add(checkingComments1);
                listOfComments.add(comment);
            } else if (checkingComments3.equals("NoThInG")) {
                listOfComments.add(checkingComments0);
                listOfComments.add(checkingComments1);
                listOfComments.add(checkingComments2);
                listOfComments.add(comment);
            } else if (checkingComments4.equals("NoThInG")) {
                listOfComments.add(checkingComments0);
                listOfComments.add(checkingComments1);
                listOfComments.add(checkingComments2);
                listOfComments.add(checkingComments3);
                listOfComments.add(comment);
            } else if (checkingComments5.equals("NoThInG")) {
                listOfComments.add(checkingComments0);
                listOfComments.add(checkingComments1);
                listOfComments.add(checkingComments2);
                listOfComments.add(checkingComments3);
                listOfComments.add(checkingComments4);
                listOfComments.add(comment);
            }
        }

        for (int j = 0; j < listOfComments.size(); j++) {
            mPreferences.edit().putString("PREFERENCE_KEY_COMMENT" + j, listOfComments.get(j)).apply();
        }

    }

}


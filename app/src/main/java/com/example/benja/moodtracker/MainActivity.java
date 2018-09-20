package com.example.benja.moodtracker;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String PREF_KEY_COMMENT = "PREFERENCE_KEY_COMMENT";
    public static final String PREF_KEY_COLOR = "PREFERENCE_KEY_COLOR";
    public static final String EXTRA_NUMBER = "com.example.application.EXTRA_NUMBER";
    public static final String EXTRA_MOOD = "com.example.application.EXTRA_MOOD";
    public static final String PREF_KEY_COLOR0 = "PREFERENCE_KEY_COLOR0";
    public static final String PREF_KEY_COLOR1 = "PREFERENCE_KEY_COLOR1";
    public static final String PREF_KEY_COLOR2 = "PREFERENCE_KEY_COLOR2";
    public static final String PREF_KEY_COLOR3 = "PREFERENCE_KEY_COLOR3";
    public static final String PREF_KEY_COLOR4 = "PREFERENCE_KEY_COLOR4";
    public static final String PREF_KEY_COLOR5 = "PREFERENCE_KEY_COLOR5";
    public static final String PREF_KEY_COLOR6 = "PREFERENCE_KEY_COLOR6";
    public static final String PREF_KEY_MOOD0 = "PREFERENCE_KEY_MOOD0";
    public static final String PREF_KEY_COMMENT0 = "PREFERENCE_KEY_COMMENT0";
    public static final String PREF_KEY_COMMENT1 = "PREFERENCE_KEY_COMMENT1";
    public static final String PREF_KEY_COMMENT2 = "PREFERENCE_KEY_COMMENT2";
    public static final String PREF_KEY_COMMENT3 = "PREFERENCE_KEY_COMMENT3";
    public static final String PREF_KEY_COMMENT4 = "PREFERENCE_KEY_COMMENT4";
    public static final String PREF_KEY_COMMENT5 = "PREFERENCE_KEY_COMMENT5";
    public static final String PREF_KEY_COMMENT6 = "PREFERENCE_KEY_COMMENT6";
    public static final String BUNDLE_EXTRA_COMMENT = History.class.getCanonicalName().concat("BUNDLE_EXTRA_COMMENT");
    public static final String BUNDLE_EXTRA_MOOD = Notification_receiver.class.getCanonicalName().concat("BUNDLE_EXTRA_COMMENT");
    private SharedPreferences mPreferences;


    private GestureDetector mDetector;


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Retrieving every button needed from the layout
        mDetector = new GestureDetector(this, new GestureListener());
        ImageButton imageView = findViewById(R.id.imageHowToUse);
        imageView.setOnTouchListener(touchListener);
        ImageButton historyButton = findViewById(R.id.historyButton);
        final EditText edittext = new EditText(MainActivity.this);
        ImageButton commentButton = findViewById(R.id.superHappyComment);


        //When one clicks on the history button
        historyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent historyActivityIntent = new Intent(MainActivity.this, History.class);
                //Sending the mood a.k.a the emoji selected
                historyActivityIntent.putExtra(EXTRA_MOOD, mood);
                MainActivity.this.startActivity(historyActivityIntent);

            }
        });

        //When one clicks on the comment button
        commentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Write your feelings")
                        .setView(edittext)
                        .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                String comment = edittext.getText().toString();
                                Intent data = new Intent();
                                data.putExtra(BUNDLE_EXTRA_COMMENT, comment);
                                setResult(RESULT_OK, data);
                                SharedPreferences mPreferences = getSharedPreferences("PREFERENCE_KEY_NAME", MODE_PRIVATE);
                                mPreferences.edit().putString("PREFERENCE_KEY_COMMENT", comment).apply();

                            }
                        })
                        .setNegativeButton("Cancel", null).setCancelable(false);
                if (edittext.getParent() != null)
                    ((ViewGroup) edittext.getParent()).removeView(edittext);
                builder.setView(edittext);
                AlertDialog alert5 = builder.create();
                alert5.show();


            }
        });


        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.HOUR_OF_DAY, 22);
        calendar.set(Calendar.MINUTE, 23);
        calendar.set(Calendar.SECOND, 0);

        Intent intent = new Intent(getApplicationContext(), Notification_receiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 100, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        assert alarmManager != null;
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);


    }

    View.OnTouchListener touchListener = new View.OnTouchListener() {
        @SuppressLint("ClickableViewAccessibility")
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return mDetector.onTouchEvent(motionEvent);
        }
    };


    private static final int SWIPE_MIN_DISTANCE = 120;
    private static final int SWIPE_THRESHOLD_VELOCITY = 200;
    int mood = 0;

    private class GestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

            if (e1.getY() - e2.getY() > SWIPE_MIN_DISTANCE && Math.abs(velocityY) > SWIPE_THRESHOLD_VELOCITY) {

                mood++;

                if (mood == 5) //5th is to many, we only have 5 pictures
                {
                    mood = 4; //Stops when last ImageButtons on view
                }

                changeImage();


                return false; // Bottom to top
            } else if (e2.getY() - e1.getY() > SWIPE_MIN_DISTANCE && Math.abs(velocityY) > SWIPE_THRESHOLD_VELOCITY) {
                mood--;

                if (mood == -1)//too far
                {
                    mood = 0; //stops when first image on view
                }

                changeImage();


                return false; // Top to bottom

            }
            return false;

        }

        void changeImage() {
            ImageButton imageButton = findViewById(R.id.imageHowToUse);
            SharedPreferences mPreferences = getSharedPreferences("PREFERENCE_KEY_NAME", MODE_PRIVATE);

            switch (mood) {

                case 0:
                    imageButton.setImageResource(R.drawable.smiley_super_happy);
                    imageButton.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.banana_yellow));

                    break;

                case 1:
                    imageButton.setImageResource(R.drawable.smiley_happy);
                    imageButton.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.light_sage));

                    break;

                case 2:
                    imageButton.setImageResource(R.drawable.smiley_normal);
                    imageButton.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.cornflower_blue_65));

                    break;

                case 3:
                    imageButton.setImageResource(R.drawable.smiley_disappointed);
                    imageButton.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.warm_grey));


                    break;

                case 4:
                    imageButton.setImageResource(R.drawable.smiley_sad);
                    imageButton.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.faded_red));
                    break;
            }
            mPreferences.edit().putInt("PREFERENCE_KEY_MOOD", mood).apply();

        }

    }
}





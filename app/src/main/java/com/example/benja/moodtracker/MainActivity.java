package com.example.benja.moodtracker;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.Uri;
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

import static android.content.Intent.EXTRA_TEXT;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MOOD = "com.example.application.EXTRA_MOOD";
    public static final String BUNDLE_EXTRA_COMMENT = History.class.getCanonicalName().concat("BUNDLE_EXTRA_COMMENT");



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
        //Setting a time for app to update every day at midnight
        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
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

    //Defining a distance and speed minimum for better usability
    private static final int SWIPE_MIN_DISTANCE = 120;
    private static final int SWIPE_THRESHOLD_VELOCITY = 200;
    int mood = 0;

    //onFling detects the gestures performed by the user
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
        //changeImage() changes the background color and as the emoji displayed as well as updating the value of mood
        void changeImage() {
            ImageButton imageButton = findViewById(R.id.imageHowToUse);
            SharedPreferences mPreferences = getSharedPreferences("PREFERENCE_KEY_NAME", MODE_PRIVATE);
            MediaPlayer mediaPlayer;

            switch (mood) {

                case 0:
                    imageButton.setImageResource(R.drawable.smiley_super_happy);
                    imageButton.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.banana_yellow));
                    mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.super_happy_sound);
                    mediaPlayer.start();
                    break;

                case 1:
                    imageButton.setImageResource(R.drawable.smiley_happy);
                    imageButton.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.light_sage));
                    mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.happy_sound);
                    mediaPlayer.start();
                    break;

                case 2:
                    imageButton.setImageResource(R.drawable.smiley_normal);
                    imageButton.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.cornflower_blue_65));
                    mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.medium_sound);
                    mediaPlayer.start();

                    break;

                case 3:
                    imageButton.setImageResource(R.drawable.smiley_disappointed);
                    imageButton.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.warm_grey));
                    mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.disappointed_sound);
                    mediaPlayer.start();

                    break;

                case 4:
                    imageButton.setImageResource(R.drawable.smiley_sad);
                    imageButton.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.faded_red));
                    mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.sad_sound);
                    mediaPlayer.start();

                    break;
            }
            //Storing the mood in SharedPreferences
            mPreferences.edit().putInt("PREFERENCE_KEY_MOOD", mood).apply();
        }
    }
}





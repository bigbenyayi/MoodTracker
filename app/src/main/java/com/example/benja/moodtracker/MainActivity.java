package com.example.benja.moodtracker;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences mPreferences;
    public static final String PREF_KEY_COMMENT = "PREFERENCE_KEY_COMMENT";
    public static final String EXTRA_NUMBER = "com.example.application.EXTRA_NUMBER";
    public static final String EXTRA_MOOD = "com.example.application.EXTRA_MOOD";
    public static final String PREF_KEY_MOOD = "PREFERENCE_KEY_MOOD";
    int mood;
    public static final String BUNDLE_EXTRA_COMMENT = History.class.getCanonicalName().concat("BUNDLE_EXTRA_COMMENT");
    public static final String BUNDLE_EXTRA_MOOD = Notification_receiver.class.getCanonicalName().concat("BUNDLE_EXTRA_COMMENT");
    private int number = 0;
    private float initialX;
    private ImageButton imageView;


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageButton imageView = findViewById(R.id.imageHowToUse);

        final GestureDetector gdt = new GestureDetector(new GestureListener());

        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return false;
            }
        });
    }

    private static final int SWIPE_MIN_DISTANCE = 120;
    private static final int SWIPE_THRESHOLD_VELOCITY = 200;

    private class GestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

            if (e1.getY() - e2.getY() > SWIPE_MIN_DISTANCE && Math.abs(velocityY) > SWIPE_THRESHOLD_VELOCITY) {
                next();
                return false; // Bottom to top
            } else if (e2.getY() - e1.getY() > SWIPE_MIN_DISTANCE && Math.abs(velocityY) > SWIPE_THRESHOLD_VELOCITY) {
                previous();
                return false; // Top to bottom
            }
            return false;
        }

        private void next() {
            number++;
            imageView.setImageResource(getImage());
        }

        private void previous() {
            number--;
            imageView.setImageResource(getImage());
        }

        private int getImage() {
            int resource = R.drawable.smiley_super_happy;
            switch (number) {
                case 0:
                    resource = R.drawable.smiley_super_happy;
                    break;
                case 1:
                    resource = R.drawable.smiley_happy;
                    break;
                case 2:
                    resource = R.drawable.smiley_normal;
                    break;
                case 3:
                    resource = R.drawable.smiley_disappointed;
                    break;
                case 4:
                    resource = R.drawable.smiley_sad;
                    break;

            }
            return resource;
        }
    }
        /*
        //Retrieving all the different moods or buttons that could be selected
        final ImageButton superHappyTextButton = findViewById(R.id.superHappyTextButton);
        final ImageButton happyTextButton = findViewById(R.id.happyTextButton);
        final ImageButton normalTextButton = findViewById(R.id.normalTextButton);
        final ImageButton disappointedTextButton = findViewById(R.id.disappointedTextButton);
        final ImageButton sadTextButton = findViewById(R.id.sadTextButton);
        ImageButton superHappyButton = findViewById(R.id.superHappyButton);
        ImageButton happyButton = findViewById(R.id.happyButton);
        ImageButton normalButton = findViewById(R.id.normalButton);
        ImageButton disappointedButton = findViewById(R.id.disappointedButton);
        ImageButton sadButton = findViewById(R.id.sadButton);
        ImageButton historyButton = findViewById(R.id.historyButton);
        final TextView superHappyBorder = findViewById(R.id.superHappyBorder);
        final TextView happyBorder = findViewById(R.id.happyBorder);
        final TextView normalBorder = findViewById(R.id.normalBorder);
        final TextView disappointedBorder = findViewById(R.id.disappointedBorder);
        final TextView sadBorder = findViewById(R.id.sadBorder);
        final EditText edittext = new EditText(MainActivity.this);
        mPreferences = getSharedPreferences("PREFERENCE_KEY_NAME", MODE_PRIVATE);


        //Setting the borders invisible (as long as no mood has been selected)
        superHappyBorder.setVisibility(View.INVISIBLE);
        happyBorder.setVisibility(View.INVISIBLE);
        normalBorder.setVisibility(View.INVISIBLE);
        disappointedBorder.setVisibility(View.INVISIBLE);
        sadBorder.setVisibility(View.INVISIBLE);

        //Setting the edit buttons invisible (till one of the mood is selected)
        superHappyTextButton.setVisibility(View.INVISIBLE);
        happyTextButton.setVisibility(View.INVISIBLE);
        normalTextButton.setVisibility(View.INVISIBLE);
        disappointedTextButton.setVisibility(View.INVISIBLE);
        sadTextButton.setVisibility(View.INVISIBLE);


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

        //When one clicks on the superHappy emoji
        superHappyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mood = 4;
                //Making the border appear and the others disappear
                superHappyBorder.setVisibility(View.VISIBLE);
                happyBorder.setVisibility(View.INVISIBLE);
                normalBorder.setVisibility(View.INVISIBLE);
                disappointedBorder.setVisibility(View.INVISIBLE);
                sadBorder.setVisibility(View.INVISIBLE);

                //Making the add note button appear and the others disappear
                superHappyTextButton.setVisibility(View.VISIBLE);
                happyTextButton.setVisibility(View.INVISIBLE);
                normalTextButton.setVisibility(View.INVISIBLE);
                disappointedTextButton.setVisibility(View.INVISIBLE);
                sadTextButton.setVisibility(View.INVISIBLE);

                Intent data = new Intent();
                data.putExtra(BUNDLE_EXTRA_MOOD, mood);
                setResult(RESULT_OK, data);
                mPreferences.edit().putInt(PREF_KEY_MOOD, mood).apply();
            }
        });

        //When one clicks on the happy emoji
        happyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mood = 3;
                //Making the border appear and the others disappear
                happyBorder.setVisibility(View.VISIBLE);
                superHappyBorder.setVisibility(View.INVISIBLE);
                normalBorder.setVisibility(View.INVISIBLE);
                disappointedBorder.setVisibility(View.INVISIBLE);
                sadBorder.setVisibility(View.INVISIBLE);

                //Making the add note button appear and the others disappear
                superHappyTextButton.setVisibility(View.INVISIBLE);
                happyTextButton.setVisibility(View.VISIBLE);
                normalTextButton.setVisibility(View.INVISIBLE);
                disappointedTextButton.setVisibility(View.INVISIBLE);
                sadTextButton.setVisibility(View.INVISIBLE);

            }
        });
        //When one clicks on the normal emoji
        normalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mood = 2;
                //Making the border appear and the others disappear
                normalBorder.setVisibility(View.VISIBLE);
                superHappyBorder.setVisibility(View.INVISIBLE);
                happyBorder.setVisibility(View.INVISIBLE);
                disappointedBorder.setVisibility(View.INVISIBLE);
                sadBorder.setVisibility(View.INVISIBLE);

                //Making the add note button appear and the others disappear
                superHappyTextButton.setVisibility(View.INVISIBLE);
                happyTextButton.setVisibility(View.INVISIBLE);
                normalTextButton.setVisibility(View.VISIBLE);
                disappointedTextButton.setVisibility(View.INVISIBLE);
                sadTextButton.setVisibility(View.INVISIBLE);
            }
        });
        //When one clicks on the disappointed emoji
        disappointedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mood = 1;
                //Making the border appear and the others disappear
                disappointedBorder.setVisibility(View.VISIBLE);
                superHappyBorder.setVisibility(View.INVISIBLE);
                happyBorder.setVisibility(View.INVISIBLE);
                normalBorder.setVisibility(View.INVISIBLE);
                sadBorder.setVisibility(View.INVISIBLE);

                //Making the add note button appear and the others disappear
                superHappyTextButton.setVisibility(View.INVISIBLE);
                happyTextButton.setVisibility(View.INVISIBLE);
                normalTextButton.setVisibility(View.INVISIBLE);
                disappointedTextButton.setVisibility(View.VISIBLE);
                sadTextButton.setVisibility(View.INVISIBLE);
            }
        });
        //When one clicks on the sad emoji
        sadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mood = 0;
                //Making the border appear and the others disappear
                sadBorder.setVisibility(View.VISIBLE);
                superHappyBorder.setVisibility(View.INVISIBLE);
                happyBorder.setVisibility(View.INVISIBLE);
                normalBorder.setVisibility(View.INVISIBLE);
                disappointedBorder.setVisibility(View.INVISIBLE);

                //Making the add note button appear and the others disappear
                superHappyTextButton.setVisibility(View.INVISIBLE);
                happyTextButton.setVisibility(View.INVISIBLE);
                normalTextButton.setVisibility(View.INVISIBLE);
                disappointedTextButton.setVisibility(View.INVISIBLE);
                sadTextButton.setVisibility(View.VISIBLE);
            }
        });
        //When one clicks on the super happy Add a note button
        superHappyTextButton.setOnClickListener(new View.OnClickListener() {
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

                                mPreferences.edit().putString(PREF_KEY_COMMENT, comment).apply();
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

        //When one clicks on the happy Add a note button
        happyTextButton.setOnClickListener(new View.OnClickListener() {
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

                                mPreferences.edit().putString(PREF_KEY_COMMENT, comment).apply();
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
        //When one clicks on the normal Add a note button
        normalTextButton.setOnClickListener(new View.OnClickListener() {
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

                                mPreferences.edit().putString(PREF_KEY_COMMENT, comment).apply();

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
        //When one clicks on the disappointed Add a note button
        disappointedTextButton.setOnClickListener(new View.OnClickListener() {
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

                                mPreferences.edit().putString(PREF_KEY_COMMENT, comment).apply();
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
        //When one clicks on the sad Add a note button
        sadTextButton.setOnClickListener(new View.OnClickListener() {
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
                                mPreferences.edit().putString(PREF_KEY_COMMENT, comment).apply();

                            }
                        })
                        .setNegativeButton("Cancel", null).setCancelable(false);
                if (edittext.getParent() != null) {
                    ((ViewGroup) edittext.getParent()).removeView(edittext);
                }
                builder.setView(edittext);
                AlertDialog alert5 = builder.create();
                alert5.show();

            }
        });

        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.HOUR_OF_DAY, 9);
        calendar.set(Calendar.MINUTE, 45);
        calendar.set(Calendar.SECOND, 10);

        Intent intent = new Intent(getApplicationContext(), Notification_receiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 100, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        assert alarmManager != null;
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
*/


}

/*
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                initialX = event.getX();
                break;
            case MotionEvent.ACTION_UP:
                float finalX = event.getX();

                if (initialX > finalX) {
                    if (number >= 4) {
                        break;
                    }
                    next();
                } else {
                    if (number <= 0) {
                        break;
                    }
                    previous();
                }
                break;
        }
        return false;
    }


    private void next() {
        number++;
        imageView.setImageResource(getImage());
    }

    private void previous() {
        number--;
        imageView.setImageResource(getImage());
    }

    private int getImage() {
        int resource = R.drawable.smiley_super_happy;
        switch(number) {
            case 0:
                resource = R.drawable.smiley_super_happy;
                break;
            case 1:
                resource = R.drawable.smiley_happy;
                break;
            case 2:
                resource = R.drawable.smiley_normal;
                break;
            case 3:
                resource = R.drawable.smiley_disappointed;
                break;
            case 4:
                resource = R.drawable.smiley_sad;
                break;

        }
        return resource;
    }
*/


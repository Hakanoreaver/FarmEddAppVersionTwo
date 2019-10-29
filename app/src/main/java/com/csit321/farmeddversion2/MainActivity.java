package com.csit321.farmeddversion2;

import android.app.Activity;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;


import com.csit321.farmeddversion2.Bugs.BugsActivity;
import com.csit321.farmeddversion2.Database.FarmEdDatabase;
import com.csit321.farmeddversion2.Database.Objects.PlantTypes;
import com.csit321.farmeddversion2.Farm.MyFarm;
import com.csit321.farmeddversion2.Messaging.MessagingActivity;
import com.csit321.farmeddversion2.Messaging.RepliesActivity;
import com.csit321.farmeddversion2.Objects.PlantType;
import com.csit321.farmeddversion2.Objects.PlantVarieties;
import com.csit321.farmeddversion2.Objects.User;
import com.csit321.farmeddversion2.Plants.PlantsActivity;
import com.csit321.farmeddversion2.Utilities.SettingsActivity;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private static Context mContext;
    static User user;
    static ArrayList<PlantVarieties> plantVarietiesArrayList = new ArrayList<>();
    static ArrayList<PlantType> plantTypeArrayList = new ArrayList<>();
    TextView userTextView;

    Button myFarm;
    Button messaging;
    Button plants;
    Button pests;
    Button settings;
    Button replies;

    public static FarmEdDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this.getApplicationContext();
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);


        createRoomDatabase();

        userTextView = findViewById(R.id.userTextView);
        userTextView.setText("Welcome, " + user.getUserName());


        myFarm = findViewById(R.id.myFarmButton);
        messaging = findViewById(R.id.messagingButton);
        plants = findViewById(R.id.plantsButton);
        pests = findViewById(R.id.pestsAndDiseasesButton);
        settings = findViewById(R.id.settingsButton);
        replies = findViewById(R.id.repliesButton);

        Intent intent = getIntent();
        if(intent.getBooleanExtra("offline", false)) {
            userTextView.setText("Offline Mode");
            myFarm.setEnabled(false);
            messaging.setEnabled(false);
            replies.setEnabled(false);
            findViewById(R.id.myFarmFrame).setBackground(getResources().getDrawable(R.drawable.round_disabled));
            findViewById(R.id.MessagingFrame).setBackground(getResources().getDrawable(R.drawable.round_disabled));
            findViewById(R.id.RepliesFrame).setBackground(getResources().getDrawable(R.drawable.round_disabled));
        }

        myFarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPage(1);
            }
        });
        messaging.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPage(2);
            }
        });
        plants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPage(3);
            }
        });
        pests.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPage(4);
            }
        });
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPage(5);
            }
        });
        replies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPage(6);
            }
        });
    }

    //Gets the context of the app
    public static Context getAppContext(){
        return mContext;
    }

    public static User getUser() {
        return user;
    }

    public static void setUser(User u) {
        user = u;
    }

    //Function to open a page depending on what button was clicked
    void openPage(int page) {
        switch(page) {
            case 1 : Intent intent1 = new Intent(this, MyFarm.class);
                startActivity(intent1);
                break;
            case 2 : Intent intent2 = new Intent(this, MessagingActivity.class);
                startActivity(intent2);
                break;
            case 3 : Intent intent3 = new Intent(this, PlantsActivity.class);
                startActivity(intent3);
                break;
            case 4 :Intent intent4 = new Intent(this, BugsActivity.class);
                startActivity(intent4);
                break;
            case 5 :Intent intent5 = new Intent(this, SettingsActivity.class);
                startActivity(intent5);
                break;
            case 6 : Intent intent6 = new Intent(this, RepliesActivity.class);
                startActivity(intent6);
        }
    }

    //Creates the room database
    void createRoomDatabase() {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                database = FarmEdDatabase.getInstance(getAppContext());
            }
        };
        Thread t = new Thread(r);
        t.start();

    }

    //Returns the database
    public static FarmEdDatabase getDatabase() {
        return database;
    }

}

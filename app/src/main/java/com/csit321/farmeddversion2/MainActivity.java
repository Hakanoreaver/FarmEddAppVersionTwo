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
        userTextView.setText(user.getUserName());

        makePlantVarieties();
        makePlantTypes();

        myFarm = findViewById(R.id.myFarmButton);
        messaging = findViewById(R.id.messagingButton);
        plants = findViewById(R.id.plantsButton);
        pests = findViewById(R.id.pestsAndDiseasesButton);
        settings = findViewById(R.id.settingsButton);
        replies = findViewById(R.id.repliesButton);

        Intent intent = getIntent();
        if(intent.getBooleanExtra("offline", false)) {
            myFarm.setEnabled(false);
            messaging.setEnabled(false);
            replies.setEnabled(false);
            findViewById(R.id.myFarmFrame).setBackgroundColor(getResources().getColor(R.color.disabled));
            findViewById(R.id.MessagingFrame).setBackgroundColor(getResources().getColor(R.color.disabled));
            findViewById(R.id.RepliesFrame).setBackgroundColor(getResources().getColor(R.color.disabled));
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
  
    public static Context getAppContext(){
        return mContext;
    }

    public static User getUser() {
        return user;
    }

    public static void setUser(User u) {
        user = u;
    }

    private void makePlantVarieties() {
        PlantVarieties p = new PlantVarieties();
        p.setId(1);
        p.setPlantTypeID(1);
        p.setVarietyName("Veimama");
        p.setSuitableSoils("Rich Dark, Fertile Soils");
        p.setpHMin(4.5);
        p.setpHMax(6);
        p.setGrowingTempMin(26);
        p.setGrowingTempMax(30);
        p.setDroughtTolerance("Unknown");
        p.setPests("Prone to: Weeds, Fungal and Viral Disease, Black Sigatoka Disease, Banana Aphid, Banana Weevil, Banana Root Nematodes");
        p.setDiseases("Prone to: Weeds, Fungal and Viral Disease, Black Sigatoka Disease, Banana Aphid, Banana Weevil, Banana Root Nematodes");
        p.setDurationOfCrop(270);
        p.setLocation("All");
        p.setSeason("Year Round");
        p.setBestGrowTime("Year Round");
        p.setAverageYield(4950);
        p.setSeedRate(1668);

        PlantVarieties p2 = new PlantVarieties();
        p2.setId(2);
        p2.setPlantTypeID(1);
        p2.setVarietyName("Jaina Balavu");
        p2.setSuitableSoils("Rich Dark, Fertile Soils");
        p2.setpHMin(1);
        p2.setpHMax(1);
        p2.setGrowingTempMin(26);
        p2.setGrowingTempMax(30);
        p2.setDroughtTolerance("Unknown");
        p2.setPests("Prone to: Weeds, Fungal and Viral Disease, Black Sigatoka Disease, Banana Aphid, Banana Weevil, Banana Root Nematodes");
        p2.setDiseases("Prone to: Weeds, Fungal and Viral Disease, Black Sigatoka Disease, Banana Aphid, Banana Weevil, Banana Root Nematodes");
        p2.setDurationOfCrop(270);
        p2.setLocation("All");
        p2.setSeason("Year Round");
        p2.setBestGrowTime("Year Round");
        p2.setAverageYield(4950);
        p2.setSeedRate(1668);

        PlantVarieties p3 = new PlantVarieties();
        p3.setId(3);
        p3.setPlantTypeID(1);
        p3.setVarietyName("Lady Finger");
        p3.setSuitableSoils("Rich Dark, Fertile Soils");
        p3.setpHMin(6);
        p3.setpHMax(7);
        p3.setGrowingTempMin(26);
        p3.setGrowingTempMax(30);
        p3.setDroughtTolerance("Unknown");
        p3.setPests("Prone to: Weeds, Fungal and Viral Disease, Black Sigatoka Disease, Banana Aphid, Banana Weevil, Banana Root Nematodes");
        p3.setDiseases("Prone to: Weeds, Fungal and Viral Disease, Black Sigatoka Disease, Banana Aphid, Banana Weevil, Banana Root Nematodes");
        p3.setDurationOfCrop(270);
        p3.setLocation("All");
        p3.setSeason("Year Round");
        p3.setBestGrowTime("Year Round");
        p3.setAverageYield(4950);
        p3.setSeedRate(1668);

        plantVarietiesArrayList.add(p);
        plantVarietiesArrayList.add(p2);
        plantVarietiesArrayList.add(p3);



    }

    private void makePlantTypes() {
        PlantType pt = new PlantType();
        pt.setId(1);
        pt.setPlantTypeName("Banana");
        plantTypeArrayList.add(pt);
    }

    public static ArrayList<PlantType> getPlantTypeArrayList() {
        return plantTypeArrayList;
    }

    public static ArrayList<PlantVarieties> getPlantVarietiesArrayList() {
        return plantVarietiesArrayList;
    }

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

    public static FarmEdDatabase getDatabase() {
        return database;
    }

}

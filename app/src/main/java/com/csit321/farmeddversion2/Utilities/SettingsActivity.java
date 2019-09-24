package com.csit321.farmeddversion2.Utilities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.csit321.farmeddversion2.LogInActivity;
import com.csit321.farmeddversion2.MainActivity;
import com.csit321.farmeddversion2.Utils.utils;
import com.csit321.farmeddversion2.R;
import android.widget.Switch;
import com.nightonke.boommenu.BoomMenuButton;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SettingsActivity extends Activity {

    BoomMenuButton bmb;
    Button backButton;
    Button signOut;
    Switch animationSwitch;
    Switch plantSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_settings);

        bmb = findViewById(R.id.bmb);
        bmb = utils.createBMBMenu(bmb);

        backButton = findViewById(R.id.settingBackButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        animationSwitch = findViewById(R.id.animationSwitch);
        plantSwitch = findViewById(R.id.plantSwitch);

        animationSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchAnimations();
            }
        });

        plantSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchPlants();
            }
        });

        SharedPreferences sharedPref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        if(sharedPref.getBoolean("plantsOn", true)) {
            plantSwitch.setChecked(true);
        }
        else {
            System.out.println("Here");
            plantSwitch.setChecked(false);
        }
        if(sharedPref.getBoolean("animationsOn", true)) {
            animationSwitch.setChecked(true);
        }
        else {
            System.out.println("Here");
            animationSwitch.setChecked(false);
        }

        signOut = findViewById(R.id.logOutButton);
        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logOut();
            }
        });
    }

    private void switchAnimations() {
        SharedPreferences sharedPref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean("animationsOn", !sharedPref.getBoolean("animationsOn", true));
        editor.commit();
    }

    private void switchPlants() {
        SharedPreferences sharedPref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean("plantsOn", !sharedPref.getBoolean("plantsOn", true));
        editor.commit();
    }

    private void logOut() {
        SharedPreferences sharedPref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("userNum", -1);
        editor.putString("date", "null");
        editor.commit();
        Intent intent = new Intent(this, LogInActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }

}

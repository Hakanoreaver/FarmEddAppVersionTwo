package com.csit321.farmeddversion2.Utils;

import android.content.Intent;
import android.os.StrictMode;

import com.csit321.farmeddversion2.Bugs.BugsActivity;
import com.csit321.farmeddversion2.Farm.MyFarm;
import com.csit321.farmeddversion2.MainActivity;
import com.csit321.farmeddversion2.Messaging.MessagingActivity;
import com.csit321.farmeddversion2.Messaging.RepliesActivity;
import com.csit321.farmeddversion2.Plants.PlantsActivity;
import com.csit321.farmeddversion2.R;
import com.csit321.farmeddversion2.Utilities.SettingsActivity;
import com.nightonke.boommenu.BoomButtons.ButtonPlaceEnum;
import com.nightonke.boommenu.BoomButtons.OnBMClickListener;
import com.nightonke.boommenu.BoomButtons.SimpleCircleButton;
import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.ButtonEnum;
import com.nightonke.boommenu.Piece.PiecePlaceEnum;
import android.os.Vibrator;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class util  {

    public static BoomMenuButton createBMBMenu(BoomMenuButton bmb) {
        bmb.setButtonEnum(ButtonEnum.SimpleCircle);
        bmb.setPiecePlaceEnum(PiecePlaceEnum.DOT_6_1);
        bmb.setButtonPlaceEnum(ButtonPlaceEnum.SC_6_3);
        bmb.addBuilder(new SimpleCircleButton.Builder().normalImageRes(R.drawable.wheat_icon).normalColorRes(R.color.treeGreen).listener(new OnBMClickListener() {
            @Override
            public void onBoomButtonClick(int index) {
                Intent menuIntent = new Intent(MainActivity.getAppContext().getApplicationContext(), PlantsActivity.class);
                menuIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                MainActivity.getAppContext().getApplicationContext().startActivity(menuIntent);

            }
        }));
        bmb.addBuilder(new SimpleCircleButton.Builder().normalImageRes(R.drawable.farm_icon).normalColorRes(R.color.farmYellow).listener(new OnBMClickListener() {
            @Override
            public void onBoomButtonClick(int index) {
                Intent menuIntent = new Intent(MainActivity.getAppContext().getApplicationContext(), MyFarm.class);
                menuIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                MainActivity.getAppContext().getApplicationContext().startActivity(menuIntent);
            }
        }));
        bmb.addBuilder(new SimpleCircleButton.Builder().normalImageRes(R.drawable.chat_icon).normalColorRes(R.color.chatPurple).listener(new OnBMClickListener() {
            @Override
            public void onBoomButtonClick(int index) {
                Intent menuIntent = new Intent(MainActivity.getAppContext().getApplicationContext(), MessagingActivity.class);
                menuIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                MainActivity.getAppContext().getApplicationContext().startActivity(menuIntent);
            }
        }));
        bmb.addBuilder(new SimpleCircleButton.Builder().normalImageRes(R.drawable.stats_icon).normalColorRes(R.color.statsRed).listener(new OnBMClickListener() {
            @Override
            public void onBoomButtonClick(int index) {
                Intent menuIntent = new Intent(MainActivity.getAppContext().getApplicationContext(), BugsActivity.class);
                menuIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                MainActivity.getAppContext().getApplicationContext().startActivity(menuIntent);
            }
        }));
        bmb.addBuilder(new SimpleCircleButton.Builder().normalImageRes(R.drawable.help_icon).normalColorRes(R.color.questionBlue).listener(new OnBMClickListener() {
            @Override
            public void onBoomButtonClick(int index) {
                Intent menuIntent = new Intent(MainActivity.getAppContext().getApplicationContext(), RepliesActivity.class);
                menuIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                MainActivity.getAppContext().getApplicationContext().startActivity(menuIntent);
            }
        }));
        bmb.addBuilder(new SimpleCircleButton.Builder().normalImageRes(R.drawable.cog_icon).normalColorRes(R.color.settingsGrey).listener(new OnBMClickListener() {
            @Override
            public void onBoomButtonClick(int index) {
                Intent menuIntent = new Intent(MainActivity.getAppContext().getApplicationContext(), SettingsActivity.class);
                menuIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                MainActivity.getAppContext().getApplicationContext().startActivity(menuIntent);

            }
        }));
        return bmb;
    }

    public static HttpURLConnection httpFactory(String urlString, String requestType) throws IOException {
        //Set up the connection
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        URL url = new URL(urlString);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setDoOutput (true);
        urlConnection.setUseCaches (false);
        urlConnection.setRequestMethod(requestType);
        if(requestType.equals("POST")) {
            urlConnection.setDoInput (true);
        }
        urlConnection.setRequestProperty("Content-Type", "application/json");
        return urlConnection;
    }
}

package com.csit321.farmeddversion2.Farm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.csit321.farmeddversion2.MainActivity;
import com.csit321.farmeddversion2.Objects.User;
import com.csit321.farmeddversion2.R;
import com.csit321.farmeddversion2.Utils.utils;
import com.diegodobelo.expandingview.ExpandingList;
import com.nightonke.boommenu.BoomMenuButton;

public class MyFarm extends Activity {

    BoomMenuButton bmb;
    ExpandingList expandingList;
    Button myInformationButton;
    TextView farmNameView;
    TextView provincesView;
    TextView divisionsView;
    TextView extentView;
    TextView carbonView;
    TextView nView;
    TextView pView;
    TextView kView;
    TextView phView;
    TextView micronutrientsView;
    TextView soilTestView;
    TextView waterSourceView;
    TextView aggrozoneView;
    Button backButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_my_farm);
        setVars();
        backButton = findViewById(R.id.myFarmBackButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        test();
    }

    //This function takes the active users information and puts it in the activities text fields.
    private void test() {
        User u = MainActivity.getUser();
        farmNameView.setText(u.getFarmName());
        provincesView.setText("Provinces : " + u.getProvince());
        divisionsView.setText("Divisions : " + u.getDivision());
        extentView.setText( u.getExtent() + " km squared");
        carbonView.setText("Carbon - " + u.getC());
        nView.setText("Nitrogen - " + u.getN());
        pView.setText("Phsophorous - " + u.getP());
        kView.setText("Potassium - " + u.getK());
        phView.setText("pH - " + u.getpH());
        micronutrientsView.setText(u.getMicronutrients());
        soilTestView.setText("Soil Test - " + u.isSoilTest());
        waterSourceView.setText("Water Source - " + u.getWaterSource());
        aggrozoneView.setText("Aggrozone Score - " + u.getAggrozone());
    }

    //Initialises our text views
    private void setVars() {
        farmNameView = findViewById(R.id.farm_name_view);
        provincesView = findViewById(R.id.provinces_view);
        divisionsView = findViewById(R.id.divisions_view);
        extentView = findViewById(R.id.extent_view);
        carbonView = findViewById(R.id.carbon_view);
        nView = findViewById(R.id.nitrogen_view);
        pView = findViewById(R.id.phosphorous_view);
        kView = findViewById(R.id.potassium_view);
        phView = findViewById(R.id.ph_view);
        micronutrientsView = findViewById(R.id.micronutrients_view);
        soilTestView = findViewById(R.id.soiltest_view);
        waterSourceView = findViewById(R.id.watersource_view);
        aggrozoneView = findViewById(R.id.agrozone_view);

        bmb = findViewById(R.id.bmb);
        bmb = utils.createBMBMenu(bmb);

        myInformationButton = findViewById(R.id.myInformationButton);
        myInformationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeViewEditInformation();
            }
        });
    }


    //This changes the activity to the edit information activity
    private void changeViewEditInformation() {
        Intent menuIntent = new Intent(this, ChangeInformationActivity.class);
        menuIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        this.startActivity(menuIntent);
        overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
        finish();
    }

}
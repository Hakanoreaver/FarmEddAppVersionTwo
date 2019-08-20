package com.csit321.farmeddversion2.Farm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.csit321.farmeddversion2.R;
import com.csit321.farmeddversion2.Utils.util;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_my_farm);
        setVars();
        test();
    }

    private void test() {
        farmNameView.setText("James' Ranch");
        provincesView.setText("Provinces : Sydney");
        divisionsView.setText("Divisions : Wollongong");
        extentView.setText("10 km squared");
        carbonView.setText("Carbon - 10");
        nView.setText("Nitrogen - 10");
        pView.setText("Phsophorous - 10");
        kView.setText("Potassium - 10");
        phView.setText("pH - 7");
        micronutrientsView.setText("Micronutrient Rich");
        soilTestView.setText("Soil Test - Yes");
        waterSourceView.setText("Water Source - Rain, Canal, Irrigation");
        aggrozoneView.setText("Aggrozone Score - 20");
    }

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
        bmb = util.createBMBMenu(bmb);

        myInformationButton = findViewById(R.id.myInformationButton);
        myInformationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeViewEditInformation();
            }
        });
    }

    private void changeViewEditInformation() {
        Intent menuIntent = new Intent(this, ChangeInformationActivity.class);
        menuIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        this.startActivity(menuIntent);
        overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
    }

}
package com.csit321.farmeddversion2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.diegodobelo.expandingview.ExpandingItem;
import com.diegodobelo.expandingview.ExpandingList;
import com.nightonke.boommenu.BoomMenuButton;

public class MyFarm extends AppCompatActivity {

    BoomMenuButton bmb;
    ExpandingList expandingList;
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
    }

}
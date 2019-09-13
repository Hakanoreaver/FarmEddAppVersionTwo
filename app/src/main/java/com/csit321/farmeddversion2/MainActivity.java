package com.csit321.farmeddversion2;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;

import com.csit321.farmeddversion2.Objects.PlantType;
import com.csit321.farmeddversion2.Objects.PlantVarieties;
import com.csit321.farmeddversion2.Objects.User;
import com.csit321.farmeddversion2.Utils.util;
import com.nightonke.boommenu.BoomMenuButton;

import java.util.ArrayList;

public class MainActivity extends Activity {

    BoomMenuButton bmb;
    private static Context mContext;
    static User user;
    static ArrayList<PlantVarieties> plantVarietiesArrayList = new ArrayList<>();
    static ArrayList<PlantType> plantTypeArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this.getApplicationContext();
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        bmb = findViewById(R.id.bmb);
        bmb = util.createBMBMenu(bmb);

        makePlantVarieties();
        makePlantTypes();
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

}

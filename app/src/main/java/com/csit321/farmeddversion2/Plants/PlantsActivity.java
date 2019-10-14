package com.csit321.farmeddversion2.Plants;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.csit321.farmeddversion2.Database.FarmEdDatabase;
import com.csit321.farmeddversion2.Database.Objects.PlantTypes;
import com.csit321.farmeddversion2.Database.Objects.PlantVarieties;
import com.csit321.farmeddversion2.MainActivity;
import com.csit321.farmeddversion2.Objects.PlantType;
import com.csit321.farmeddversion2.Objects.User;
import com.csit321.farmeddversion2.R;
import com.csit321.farmeddversion2.Utils.utils;
import com.diegodobelo.expandingview.ExpandingItem;
import com.diegodobelo.expandingview.ExpandingList;
import com.nightonke.boommenu.BoomMenuButton;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

import static com.csit321.farmeddversion2.MainActivity.getAppContext;

public class PlantsActivity extends Activity {

    BoomMenuButton bmb;
    List<View> views = new ArrayList<>();
    ExpandingList expandingList;
    Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_plants);

        bmb = findViewById(R.id.bmb);
        bmb = utils.createBMBMenu(bmb);

        System.out.println("Plant Types");
        System.out.println(MainActivity.database.plantTypesDAO().getAll());

        expandingList = (ExpandingList) findViewById(R.id.plants_expanding_list);

        backButton = findViewById(R.id.plantsBackButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        setUpItems();




    }



    private void setUpItems() {
        User u = MainActivity.getUser();
        List<PlantTypes> plants = MainActivity.getDatabase().plantTypesDAO().getAll();

        for(PlantTypes pt : plants) {
            ExpandingItem item = expandingList.createNewItem(R.layout.expanding_layout);
            item.setIndicatorColorRes(R.color.expandingListIcon);
            ((TextView) item.findViewById(R.id.title)).setText(pt.getPlantTypeName());
            List<PlantVarieties> pvs = MainActivity.getDatabase().plantVarietiesDAO().findByType(pt.getPlantTypeName());
            item.createSubItems(pvs.size());
            for(int i = 0; i < pvs.size(); i++) {
                final View subItemZero = item.getSubItemView(i);
                ((TextView) subItemZero.findViewById(R.id.sub_title)).setText(pvs.get(i).getVarietyName());
                subItemZero.setId(pvs.get(i).getId());
                SharedPreferences sharedPref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                if(sharedPref.getBoolean("plantsOn", true)) {
                    if (pvs.get(i).getPhMin() < u.getpH() && pvs.get(i).getPhMax() > u.getpH()) {
                        subItemZero.setBackgroundColor(getResources().getColor(R.color.good));
                    } else if ((pvs.get(i).getPhMin() - 1) < u.getpH() && (pvs.get(i).getPhMax() + 1) > u.getpH()) {
                        subItemZero.setBackgroundColor(getResources().getColor(R.color.medium));
                    } else {
                        subItemZero.setBackgroundColor(getResources().getColor(R.color.bad));
                    }
                }
                else {
                    ((TextView) subItemZero.findViewById(R.id.sub_title)).setTextColor(getResources().getColor(R.color.white));
                }
            }

            for(int i = 0; i < item.getSubItemsCount(); i++) {
                final View view = item.getSubItemView(i);
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        IndividualPlantActivity.setPlantId(v.getId());
                        Intent menuIntent = new Intent(getAppContext().getApplicationContext(), IndividualPlantActivity.class);
                        menuIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        getAppContext().getApplicationContext().startActivity(menuIntent);
                    }
                });
            }
        }


    }




}

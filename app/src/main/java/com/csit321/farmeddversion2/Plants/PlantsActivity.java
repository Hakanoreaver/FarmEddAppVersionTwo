package com.csit321.farmeddversion2.Plants;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.csit321.farmeddversion2.MainActivity;
import com.csit321.farmeddversion2.Objects.PlantType;
import com.csit321.farmeddversion2.Objects.PlantVarieties;
import com.csit321.farmeddversion2.Objects.User;
import com.csit321.farmeddversion2.R;
import com.csit321.farmeddversion2.Utils.utils;
import com.diegodobelo.expandingview.ExpandingItem;
import com.diegodobelo.expandingview.ExpandingList;
import com.nightonke.boommenu.BoomMenuButton;

import java.util.ArrayList;
import java.util.List;

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

        for(PlantType pt : MainActivity.getPlantTypeArrayList()) {
            ExpandingItem item = expandingList.createNewItem(R.layout.expanding_layout);
            item.setIndicatorColorRes(R.color.treeGreen);
            ((TextView) item.findViewById(R.id.title)).setText(pt.getPlantTypeName());
            ArrayList<PlantVarieties> pvs = new ArrayList<>();
            for(PlantVarieties pv : MainActivity.getPlantVarietiesArrayList()) {
                if(pv.getPlantTypeID() == pt.getId()) {
                    pvs.add(pv);
                }
            }
            item.createSubItems(pvs.size());
            for(int i = 0; i < pvs.size(); i++) {
                final View subItemZero = item.getSubItemView(i);
                ((TextView) subItemZero.findViewById(R.id.sub_title)).setText(pvs.get(i).getVarietyName());
                subItemZero.setId(pvs.get(i).getId());
                if(pvs.get(i).getpHMin() < u.getpH() && pvs.get(i).getpHMax() > u.getpH()) {
                    subItemZero.setBackgroundColor(getResources().getColor(R.color.good));
                }
                else if((pvs.get(i).getpHMin() - 1) < u.getpH() && (pvs.get(i).getpHMax() + 1) > u.getpH()) {
                    subItemZero.setBackgroundColor(getResources().getColor(R.color.medium));
                }
                else {
                    subItemZero.setBackgroundColor(getResources().getColor(R.color.bad));
                }
            }

            for(int i = 0; i < item.getSubItemsCount(); i++) {
                final View view = item.getSubItemView(i);
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        IndividualPlantActivity.setPlantId(v.getId());
                        Intent menuIntent = new Intent(MainActivity.getAppContext().getApplicationContext(), IndividualPlantActivity.class);
                        menuIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        MainActivity.getAppContext().getApplicationContext().startActivity(menuIntent);
                    }
                });
            }
        }


    }
}

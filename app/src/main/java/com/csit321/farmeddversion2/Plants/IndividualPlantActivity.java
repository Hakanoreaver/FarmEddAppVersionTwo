package com.csit321.farmeddversion2.Plants;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.csit321.farmeddversion2.MainActivity;
import com.csit321.farmeddversion2.Objects.PlantType;
import com.csit321.farmeddversion2.Objects.PlantVarieties;
import com.csit321.farmeddversion2.R;
import com.csit321.farmeddversion2.Utils.utils;
import com.diegodobelo.expandingview.ExpandingItem;
import com.diegodobelo.expandingview.ExpandingList;
import com.nightonke.boommenu.BoomMenuButton;

public class IndividualPlantActivity extends Activity {

    static int plantId;
    TextView plantNameView;
    TextView pHView;
    TextView temperatureView;
    BoomMenuButton bmb;
    ExpandingList pestsAndDiseaseList;
    Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_individual_plant);


        backButton = findViewById(R.id.plantBackButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        plantNameView = findViewById(R.id.plantNameView);
        pHView = findViewById(R.id.pHViewPlant);
        temperatureView = findViewById(R.id.temperatureViewPlant);
        pestsAndDiseaseList = findViewById(R.id.pestsAndDiseasesList);

        bmb = findViewById(R.id.bmb);
        bmb = utils.createBMBMenu(bmb);

        PlantVarieties p = null;
        for(PlantVarieties pv : MainActivity.getPlantVarietiesArrayList()) {
            if(pv.getId() == plantId) p = pv;
        }

        PlantType pt = MainActivity.getPlantTypeArrayList().get(p.getPlantTypeID()-1);

        plantNameView.setText(pt.getPlantTypeName() + " : " + p.getVarietyName());
        pHView.setText("pH " + p.getpHMin() + " - " + p.getpHMax());
        temperatureView.setText("Temp" + p.getGrowingTempMin() + " - " + p.getGrowingTempMax());

        ExpandingItem pests = pestsAndDiseaseList.createNewItem(R.layout.expanding_layout);
        pests.setIndicatorColorRes(R.color.treeGreen);
        ((TextView) pests.findViewById(R.id.title)).setText("Pests");
        String[] pestList = p.getPests().split(",");
        pests.createSubItems(pestList.length);
        for(int i = 0; i < pestList.length; i++) {
            final View subItem = pests.getSubItemView(i);
            ((TextView) subItem.findViewById(R.id.sub_title)).setText(pestList[i]);
        }

        ExpandingItem diseases = pestsAndDiseaseList.createNewItem(R.layout.expanding_layout);
        diseases.setIndicatorColorRes(R.color.treeGreen);
        ((TextView) diseases.findViewById(R.id.title)).setText("Diseases");
        String[] diseaseList = p.getDiseases().split(",");
        diseases.createSubItems(diseaseList.length);
        for(int i = 0; i < diseaseList.length; i++) {
            final View subItem = diseases.getSubItemView(i);
            ((TextView) subItem.findViewById(R.id.sub_title)).setText(diseaseList[i]);
        }
    }

    static void setPlantId(int id) {
        plantId = id;
    }
}

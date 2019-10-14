package com.csit321.farmeddversion2.Plants;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.csit321.farmeddversion2.Database.Objects.PlantTypes;
import com.csit321.farmeddversion2.Database.Objects.PlantVarieties;
import com.csit321.farmeddversion2.MainActivity;
import com.csit321.farmeddversion2.Objects.PlantType;
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



        PlantVarieties pv = MainActivity.getDatabase().plantVarietiesDAO().findById(plantId);

        plantNameView.setText(pv.getCropName() + " : " + pv.getVarietyName());
        pHView.setText("pH " + pv.getPhMin() + " - " + pv.getPhMax());
        temperatureView.setText("Temp" + pv.getTemperatureMin() + " - " + pv.getGetTemperatureMax());

        ExpandingItem pests = pestsAndDiseaseList.createNewItem(R.layout.expanding_layout);
        pests.setIndicatorColorRes(R.color.treeGreen);
        ((TextView) pests.findViewById(R.id.title)).setText("Pests and Diseases");
        String[] pestList = pv.getPestAndDiseases().split(",");
        pests.createSubItems(pestList.length);
        for(int i = 0; i < pestList.length; i++) {
            final View subItem = pests.getSubItemView(i);
            ((TextView) subItem.findViewById(R.id.sub_title)).setText(pestList[i]);
        }
    }

    static void setPlantId(int id) {
        plantId = id;
    }
}

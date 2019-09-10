package com.csit321.farmeddversion2.Plants;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

import com.csit321.farmeddversion2.MainActivity;
import com.csit321.farmeddversion2.Objects.PlantVarieties;
import com.csit321.farmeddversion2.R;
import com.csit321.farmeddversion2.Utils.util;
import com.nightonke.boommenu.BoomMenuButton;

import org.w3c.dom.Text;

public class IndividualPlantActivity extends Activity {

    static int plantId;
    TextView plantNameView;
    BoomMenuButton bmb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_individual_plant);

        plantNameView = findViewById(R.id.plantNameView);

        bmb = findViewById(R.id.bmb);
        bmb = util.createBMBMenu(bmb);

        PlantVarieties p = null;
        for(PlantVarieties pv : MainActivity.getPlantVarietiesArrayList()) {
            if(pv.getId() == plantId) p = pv;
        }

        plantNameView.setText(p.getVarietyName());
    }

    static void setPlantId(int id) {
        plantId = id;
    }
}

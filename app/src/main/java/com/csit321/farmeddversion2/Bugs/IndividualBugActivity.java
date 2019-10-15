package com.csit321.farmeddversion2.Bugs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.csit321.farmeddversion2.Database.Objects.Diseases;
import com.csit321.farmeddversion2.Database.Objects.Pests;
import com.csit321.farmeddversion2.MainActivity;
import com.csit321.farmeddversion2.R;
import com.csit321.farmeddversion2.Utils.utils;
import com.nightonke.boommenu.BoomMenuButton;

import org.w3c.dom.Text;

public class IndividualBugActivity extends Activity {

    BoomMenuButton bmb;
    TextView name;
    TextView description;
    TextView nonChemical;
    TextView chemical;
    TextView prevention;
    TextView link;
    TextView plantsAffected;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_individual_bug);

        bmb = findViewById(R.id.bmb);
        bmb = utils.createBMBMenu(bmb);

        name = findViewById(R.id.bugDiseaseName);
        description = findViewById(R.id.descriptionView);
        nonChemical = findViewById(R.id.nonChemicalView);
        chemical = findViewById(R.id.chemicalView);
        prevention = findViewById(R.id.protectiveView);
        link = findViewById(R.id.linkView);
        plantsAffected = findViewById(R.id.plantsAffectedView);

        Intent intent = getIntent();

        if(intent.getBooleanExtra("bug", true)) {
            Pests p = MainActivity.getDatabase().pestsDAO().findById(intent.getIntExtra("id", 0));
            name.setText(p.getPestName());
            description.setText(p.getDescription());
            nonChemical.setText(p.getMitigationsNon());
            chemical.setText(p.getMitigationsChemical());
            prevention.setText(p.getProtectiveMeasures());
            if(p.getProtectiveMeasures() == null) {
                prevention.setVisibility(View.GONE);
                findViewById(R.id.protectiveView2).setVisibility(View.GONE);
            }
            link.setText(p.getLink());
            plantsAffected.setText(p.getPlantsAffected());
        }
        else {
            Diseases d = MainActivity.getDatabase().diseasesDAO().findById(intent.getIntExtra("id", 0));
            name.setText(d.getDiseaseName());
            description.setText(d.getDescription());
            nonChemical.setText(d.getMitigationsNon());
            chemical.setText(d.getMitigationsChemical());
            prevention.setText(d.getProtectiveMeasures());
            if(d.getProtectiveMeasures() == null) {
                prevention.setVisibility(View.GONE);
                findViewById(R.id.protectiveView2).setVisibility(View.GONE);
            }
            link.setText(d.getLink());
            plantsAffected.setText(d.getPlantsAffected());
        }


    }

}

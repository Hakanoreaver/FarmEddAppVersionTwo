package com.csit321.farmeddversion2.Bugs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.csit321.farmeddversion2.Database.Objects.Diseases;
import com.csit321.farmeddversion2.Database.Objects.Pests;
import com.csit321.farmeddversion2.Database.Objects.PlantTypes;
import com.csit321.farmeddversion2.MainActivity;
import com.csit321.farmeddversion2.Plants.IndividualPlantActivity;
import com.csit321.farmeddversion2.R;
import com.csit321.farmeddversion2.Utils.utils;
import com.diegodobelo.expandingview.ExpandingItem;
import com.diegodobelo.expandingview.ExpandingList;
import com.nightonke.boommenu.BoomMenuButton;

import java.util.List;

import static com.csit321.farmeddversion2.MainActivity.getAppContext;

public class BugsActivity extends Activity {

    BoomMenuButton bmb;
    Button backButton;
    ExpandingList expandingList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_bugs);

        bmb = findViewById(R.id.bmb);
        bmb = utils.createBMBMenu(bmb);

        expandingList = (ExpandingList) findViewById(R.id.bugs_expanding_list);
        setUpItems();

        backButton = findViewById(R.id.bugsBackButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    //Sets up the diseases and bugs from the database
    private void setUpItems() {
       List<Diseases> diseases = MainActivity.getDatabase().diseasesDAO().getAll();
       List<Pests> pests = MainActivity.getDatabase().pestsDAO().getAll();

        ExpandingItem diseasesItem = expandingList.createNewItem(R.layout.expanding_layout);
        diseasesItem.setIndicatorColorRes(R.color.expandingListIcon);
        ((TextView) diseasesItem.findViewById(R.id.title)).setText("Diseases");

        diseasesItem.createSubItems(diseases.size());

        for(int i = 0; i < diseases.size(); i++) {
            final View subItemZero = diseasesItem.getSubItemView(i);
            ((TextView) subItemZero.findViewById(R.id.sub_title)).setText(diseases.get(i).getDiseaseName());
            subItemZero.setId(diseases.get(i).getId());
            ((TextView) subItemZero.findViewById(R.id.sub_title)).setTextColor(getResources().getColor(R.color.white));
            subItemZero.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getAppContext().getApplicationContext(), IndividualBugActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("id", v.getId());
                    intent.putExtra("bug", false);
                    getAppContext().getApplicationContext().startActivity(intent);
                }
            });
        }

        ExpandingItem pestsItem = expandingList.createNewItem(R.layout.expanding_layout);
        pestsItem.setIndicatorColorRes(R.color.expandingListIcon);
        ((TextView) pestsItem.findViewById(R.id.title)).setText("Pests");

        pestsItem.createSubItems(pests.size());

        for(int i = 0; i < pests.size(); i++) {
            final View subItemZero = pestsItem.getSubItemView(i);
            ((TextView) subItemZero.findViewById(R.id.sub_title)).setText(pests.get(i).getPestName());
            subItemZero.setId(pests.get(i).getId());
            ((TextView) subItemZero.findViewById(R.id.sub_title)).setTextColor(getResources().getColor(R.color.white));
            subItemZero.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getAppContext().getApplicationContext(), IndividualBugActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("id", v.getId());
                    intent.putExtra("bug", true);
                    getAppContext().getApplicationContext().startActivity(intent);
                }
            });
        }
    }
}

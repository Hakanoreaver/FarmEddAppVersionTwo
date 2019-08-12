package com.csit321.farmeddversion2.Plants;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.csit321.farmeddversion2.R;
import com.csit321.farmeddversion2.Functions.util;
import com.diegodobelo.expandingview.ExpandingItem;
import com.diegodobelo.expandingview.ExpandingList;
import com.nightonke.boommenu.BoomMenuButton;

public class PlantsActivity extends Activity {

    BoomMenuButton bmb;

    ExpandingList expandingList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_plants);

        bmb = findViewById(R.id.bmb);
        bmb = util.createBMBMenu(bmb);

        expandingList = (ExpandingList) findViewById(R.id.plants_expanding_list);
        setUpItems();
    }

    private void setUpItems() {
        for(int i = 0; i < 4; i++) {
            ExpandingItem item = expandingList.createNewItem(R.layout.expanding_layout);
            item.setIndicatorColorRes(R.color.treeGreen);
            ((TextView) item.findViewById(R.id.title)).setText("Tomatoes");
            //This will create 5 items
            item.createSubItems(5);

            //get a sub item View
            View subItemZero = item.getSubItemView(0);
            ((TextView) subItemZero.findViewById(R.id.sub_title)).setText("Grosse Lisse");

            View subItemOne = item.getSubItemView(1);
            ((TextView) subItemOne.findViewById(R.id.sub_title)).setText("Beefsteak");

            View subItemTwo = item.getSubItemView(2);
            ((TextView) subItemTwo.findViewById(R.id.sub_title)).setText("Tommy Toe");

            View subItemThree = item.getSubItemView(3);
            ((TextView) subItemThree.findViewById(R.id.sub_title)).setText("Truss Plum");

            View subItemFour = item.getSubItemView(4);
            ((TextView) subItemFour.findViewById(R.id.sub_title)).setText("Truss");
        }
    }
}

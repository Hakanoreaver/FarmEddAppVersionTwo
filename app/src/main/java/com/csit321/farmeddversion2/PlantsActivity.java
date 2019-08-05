package com.csit321.farmeddversion2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.diegodobelo.expandingview.ExpandingItem;
import com.diegodobelo.expandingview.ExpandingList;

public class PlantsActivity extends AppCompatActivity {

    ExpandingList expandingList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plants);

        expandingList = (ExpandingList) findViewById(R.id.expanding_list_main);
        setUpItems();
    }

    private void setUpItems() {
        for(int i = 0; i < 4; i++) {
            ExpandingItem item = expandingList.createNewItem(R.layout.expanding_layout);
            item.setIndicatorColorRes(R.color.treeGreen);
            ((TextView) item.findViewById(R.id.title)).setText("Plant Name");
            //This will create 5 items
            item.createSubItems(5);

            //get a sub item View
            View subItemZero = item.getSubItemView(0);
            ((TextView) subItemZero.findViewById(R.id.sub_title)).setText("pH - 7");

            View subItemOne = item.getSubItemView(1);
            ((TextView) subItemOne.findViewById(R.id.sub_title)).setText("Temperatures - 15º-30º");

            View subItemTwo = item.getSubItemView(2);
            ((TextView) subItemTwo.findViewById(R.id.sub_title)).setText("Nitrogen - 5");

            View subItemThree = item.getSubItemView(3);
            ((TextView) subItemThree.findViewById(R.id.sub_title)).setText("Phosphorus - 5");

            View subItemFour = item.getSubItemView(4);
            ((TextView) subItemFour.findViewById(R.id.sub_title)).setText("Potassium - 5");
        }
    }
}

package com.csit321.farmeddversion2;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.diegodobelo.expandingview.ExpandingItem;
import com.diegodobelo.expandingview.ExpandingList;

import org.w3c.dom.Text;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        ExpandingList expandingList = (ExpandingList) findViewById(R.id.expanding_list_main);

        ExpandingItem item = expandingList.createNewItem(R.layout.expanding_layout);
        item.setIndicatorColorRes(R.color.treeGreen);
        ((TextView) item.findViewById(R.id.title)).setText("HelloWorld");
        //This will create 5 items
        item.createSubItems(5);

//get a sub item View
        View subItemZero = item.getSubItemView(0);
        ((TextView) subItemZero.findViewById(R.id.sub_title)).setText("Cool");

        View subItemOne = item.getSubItemView(1);
        ((TextView) subItemOne.findViewById(R.id.sub_title)).setText("Awesome");

        View subItemTwo = item.getSubItemView(2);
        ((TextView) subItemTwo.findViewById(R.id.sub_title)).setText("Wow");

        View subItemThree = item.getSubItemView(3);
        ((TextView) subItemThree.findViewById(R.id.sub_title)).setText("Amazing");

        View subItemFour = item.getSubItemView(4);
        ((TextView) subItemFour.findViewById(R.id.sub_title)).setText("Nice!");

    }

}

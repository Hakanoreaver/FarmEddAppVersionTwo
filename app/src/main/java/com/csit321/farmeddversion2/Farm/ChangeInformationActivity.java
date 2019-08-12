package com.csit321.farmeddversion2.Farm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.csit321.farmeddversion2.R;
import com.csit321.farmeddversion2.Functions.util;
import com.nightonke.boommenu.BoomMenuButton;

public class ChangeInformationActivity extends Activity {

    BoomMenuButton bmb;
    Button saveButton;
    Button cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_change_information);

        setVars();
    }

    private void setVars() {
        bmb = findViewById(R.id.bmb);
        bmb = util.createBMBMenu(bmb);

        saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save();

            }
        });

        cancelButton = findViewById(R.id.cancelButton);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancel();
            }
        });
    }

    private void save() {
        //TODO Implement Save Code

        Intent menuIntent = new Intent(this, ChangeInformationActivity.class);
        menuIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        this.startActivity(menuIntent);
        overridePendingTransition(R.anim.push_right_out, R.anim.push_right_in);
    }

    private void cancel() {
        Intent menuIntent = new Intent(this, MyFarm.class);
        menuIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        this.startActivity(menuIntent);
        overridePendingTransition(R.anim.push_right_out, R.anim.push_right_in);
    }
}

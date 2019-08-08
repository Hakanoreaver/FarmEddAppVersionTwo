package com.csit321.farmeddversion2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.nightonke.boommenu.BoomMenuButton;

public class ChangeInformationActivity extends AppCompatActivity {

    BoomMenuButton bmb;
    Button saveButton;
    Button cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
    }

    private void cancel() {
        Intent menuIntent = new Intent(this, MyFarm.class);
        menuIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        this.startActivity(menuIntent);
        overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
    }
}

package com.csit321.farmeddversion2.Utilities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.csit321.farmeddversion2.Utils.utils;
import com.csit321.farmeddversion2.R;
import com.gc.materialdesign.views.Switch;
import com.nightonke.boommenu.BoomMenuButton;

public class SettingsActivity extends Activity {

    BoomMenuButton bmb;
    Button backButton;
    Button signOut;
    Switch animationSwitch;
    Switch plantSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_settings);

        bmb = findViewById(R.id.bmb);
        bmb = utils.createBMBMenu(bmb);

        backButton = findViewById(R.id.settingBackButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        animationSwitch = findViewById(R.id.animationSwitch);
        plantSwitch = findViewById(R.id.plantSwitch);

    }

}

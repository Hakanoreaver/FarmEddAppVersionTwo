package com.csit321.farmeddversion2.Utilities;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

import com.csit321.farmeddversion2.Functions.util;
import com.csit321.farmeddversion2.R;
import com.nightonke.boommenu.BoomMenuButton;

public class SettingsActivity extends Activity {

    BoomMenuButton bmb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_settings);

        bmb = findViewById(R.id.bmb);
        bmb = util.createBMBMenu(bmb);

    }

}

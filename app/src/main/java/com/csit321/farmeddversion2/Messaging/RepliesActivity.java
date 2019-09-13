package com.csit321.farmeddversion2.Messaging;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.csit321.farmeddversion2.R;
import com.csit321.farmeddversion2.Utils.util;
import com.nightonke.boommenu.BoomMenuButton;

public class RepliesActivity extends AppCompatActivity {

    BoomMenuButton bmb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_replies);

        bmb = findViewById(R.id.bmb);
        bmb = util.createBMBMenu(bmb);
    }
}

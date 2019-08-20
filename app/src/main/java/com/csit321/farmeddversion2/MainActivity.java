package com.csit321.farmeddversion2;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;

import com.csit321.farmeddversion2.Utils.util;
import com.nightonke.boommenu.BoomMenuButton;

public class MainActivity extends Activity {

    BoomMenuButton bmb;
    private static Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this.getApplicationContext();
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        bmb = findViewById(R.id.bmb);
        bmb = util.createBMBMenu(bmb);
    }

    public static Context getAppContext(){
        return mContext;
    }

}

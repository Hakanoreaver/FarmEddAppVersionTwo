package com.csit321.farmeddversion2.Farm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.csit321.farmeddversion2.MainActivity;
import com.csit321.farmeddversion2.Objects.User;
import com.csit321.farmeddversion2.R;
import com.csit321.farmeddversion2.Utils.utils;
import com.nightonke.boommenu.BoomMenuButton;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class ChangeInformationActivity extends Activity {

    BoomMenuButton bmb;
    Button saveButton;
    Button cancelButton;
    TextView farmNameView;
    TextView provincesView;
    TextView divisionsView;
    TextView extentView;
    TextView carbonView;
    TextView nView;
    TextView pView;
    TextView kView;
    TextView phView;
    TextView micronutrientsView;
    TextView soilTestView;
    TextView waterSourceView;
    TextView aggrozoneView;
    Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_change_information);

        setVars();

        backButton = findViewById(R.id.changeInformationBackButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                back();
            }
        });
    }

    private void setVars() {
        bmb = findViewById(R.id.bmb);
        bmb = utils.createBMBMenu(bmb);

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

        farmNameView = findViewById(R.id.farmNameEdit);
        provincesView = findViewById(R.id.provincesEdit);
        divisionsView = findViewById(R.id.divisionEdit);
        extentView = findViewById(R.id.extentEdit);
        carbonView = findViewById(R.id.carbonEdit);
        nView = findViewById(R.id.nitrogenEdit);
        pView = findViewById(R.id.phosphorousEdit);
        kView = findViewById(R.id.potassiumEdit);
        phView = findViewById(R.id.pHEdit);
        micronutrientsView = findViewById(R.id.micronutrientsEdit);
        soilTestView = findViewById(R.id.soilTestEdit);
        waterSourceView = findViewById(R.id.waterSourceEdit);
        aggrozoneView = findViewById(R.id.aggrozoneEdit);

        User u = MainActivity.getUser();
        farmNameView.setText(u.getFarmName());
        provincesView.setText(u.getProvince());
        divisionsView.setText(u.getDivision());
        extentView.setText(Double.toString(u.getExtent()));
        carbonView.setText(Double.toString(u.getC()));
        nView.setText(Double.toString(u.getN()));
        pView.setText(Double.toString(u.getP()));
        kView.setText(Double.toString(u.getK()));
        phView.setText(Double.toString(u.getpH()));
        micronutrientsView.setText(u.getMicronutrients());
        soilTestView.setText(Boolean.toString(u.isSoilTest()));
        waterSourceView.setText(u.getWaterSource());
        aggrozoneView.setText(Integer.toString(u.getAggrozone()));
    }

    private void save() {
        //Save Code
        User u = MainActivity.getUser();
        u.setFarmName(farmNameView.getText().toString());
        u.setProvince(provincesView.getText().toString());
        u.setDivision(divisionsView.getText().toString());
        u.setExtent(Double.parseDouble(extentView.getText().toString()));
        u.setC(Double.parseDouble(carbonView.getText().toString()));
        u.setN(Double.parseDouble(nView.getText().toString()));
        u.setP(Double.parseDouble(pView.getText().toString()));
        u.setK(Double.parseDouble(kView.getText().toString()));
        u.setpH(Double.parseDouble(phView.getText().toString()));
        u.setMicronutrients(micronutrientsView.getText().toString());
        u.setSoilTest(Boolean.parseBoolean(soilTestView.getText().toString()));
        u.setWaterSource(waterSourceView.getText().toString());
        u.setAggrozone(Integer.parseInt(aggrozoneView.getText().toString()));
        try {
            System.out.println("Here1");
            System.out.println("Here1");
            System.out.println("Here1");
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            URL url = new URL("https://agriculturepipeline.herokuapp.com/main/user/update");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setDoInput(true);
            urlConnection.setDoOutput(true);
            urlConnection.setUseCaches(false);
            urlConnection.setRequestMethod("POST");
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.connect();
            //Create JSON object
            JSONObject jsonParam = new JSONObject();
            jsonParam.put("id", u.getId());
            jsonParam.put("farmName", u.getFarmName());
            jsonParam.put("province", u.getProvince());
            jsonParam.put("division", u.getDivision());
            jsonParam.put("extent", u.getExtent());
            jsonParam.put("c", u.getC());
            jsonParam.put("n", u.getN());
            jsonParam.put("p", u.getP());
            jsonParam.put("k", u.getK());
            jsonParam.put("pH", u.getpH());
            jsonParam.put("soilTest", u.isSoilTest());
            jsonParam.put("micronutrients", u.getMicronutrients());
            jsonParam.put("waterSource", u.getWaterSource());
            jsonParam.put("aggrozone", u.getAggrozone());
            //Send Body as JSON Object
            OutputStream os = urlConnection.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
            System.out.println(jsonParam.toString());
            writer.write(jsonParam.toString());
            writer.flush();
            writer.close();
            os.close();

            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            BufferedReader r = new BufferedReader(new InputStreamReader(in));
            StringBuilder total = new StringBuilder();
            for (String line; (line = r.readLine()) != null; ) {
                total.append(line);
            }
            urlConnection.disconnect();

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            System.out.println(e);
        } catch (ProtocolException e) {
            e.printStackTrace();
            System.out.println(e);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.out.println(e);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e);
        } catch (JSONException e) {
            e.printStackTrace();
            System.out.println(e);
        }

        Intent intent = new Intent(this, MyFarm.class);
        startActivity(intent);

        overridePendingTransition(R.anim.push_right_out, R.anim.push_right_in);
        finish();
    }

    private void cancel() {
        Intent intent = new Intent(this, MyFarm.class);
        startActivity(intent);
        overridePendingTransition(R.anim.push_right_out, R.anim.push_right_in);
        finish();
    }

    private void back() {
        Intent menuIntent = new Intent(this, MyFarm.class);
        this.startActivity(menuIntent);
        finish();
    }
}

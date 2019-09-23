package com.csit321.farmeddversion2.Messaging;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.csit321.farmeddversion2.MainActivity;
import com.csit321.farmeddversion2.Objects.ResponseResponse;
import com.csit321.farmeddversion2.Objects.User;
import com.csit321.farmeddversion2.R;
import com.csit321.farmeddversion2.Utils.utils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nightonke.boommenu.BoomMenuButton;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

public class RepliesActivity extends Activity {

    BoomMenuButton bmb;
    ResponseResponse[] responseList;
    ArrayAdapter adapter;
    Spinner spinner;
    TextView questionView;
    TextView replyView;
    Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_replies);

        bmb = findViewById(R.id.bmb);
        bmb = utils.createBMBMenu(bmb);

        questionView = findViewById(R.id.questionTextView);
        replyView = findViewById(R.id.responseTextView);
        spinner = findViewById(R.id.spinner);

        backButton = findViewById(R.id.repliesBackButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }



    @Override
    protected  void onResume() {
        super.onResume();
        loadReplies();
    }


    private void loadReplies() {
        User u = MainActivity.getUser();
        try {
            HttpURLConnection urlConnection = utils.httpFactory("https://agriculturepipeline.herokuapp.com/main/getResponses/" + u.getId(), "GET");
            urlConnection.connect();

            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            BufferedReader r = new BufferedReader(new InputStreamReader(in));
            StringBuilder total = new StringBuilder();
            for (String line; (line = r.readLine()) != null; ) {
                total.append(line);
            }
            urlConnection.disconnect();

            ObjectMapper mapper = new ObjectMapper();
            responseList = mapper.readValue(total.toString(), ResponseResponse[].class);

            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, responseList);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            spinner.setAdapter(adapter);
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                    ResponseResponse response = (ResponseResponse) adapterView.getSelectedItem();
                    questionView.setText(response.getQuestion());
                    replyView.setText(response.getReply());
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

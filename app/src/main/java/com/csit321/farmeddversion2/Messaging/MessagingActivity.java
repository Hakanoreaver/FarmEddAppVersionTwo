package com.csit321.farmeddversion2.Messaging;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.csit321.farmeddversion2.R;
import com.csit321.farmeddversion2.Utils.util;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.util.Locale;

public class MessagingActivity extends AppCompatActivity {

    private TextView mTextMessage;
    static int userID = 1;
    ImageView imageView;
    EditText pTxt;
    EditText kTxt;
    EditText nTxt;
    EditText phTxt;
    EditText cropTxt;
    EditText locTxt;
    EditText questionTxt;
    EditText fertiliserTxt;
    EditText pesticideTxt;
    EditText lengthTxt;
    EditText frequencyTxt;
    TextView errorView;
    String currentPhotoPath;
    MessagingActivity context = this;

    static final int REQUEST_IMAGE_CAPTURE = 1;
    static final int REQUEST_TAKE_PHOTO = 1;
    private int PICK_IMAGE_REQUEST = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messaging);

        //Bind Variables
        final Button submitButton = (Button)findViewById(R.id.submitBtn);
        Button selectButton = (Button)findViewById(R.id.selectBtn);
        imageView = (ImageView)findViewById(R.id.imageView);
        pTxt = (EditText) findViewById(R.id.pTxt);
        kTxt = (EditText) findViewById(R.id.kTxt);
        nTxt = (EditText) findViewById(R.id.nTxt);
        phTxt = (EditText) findViewById(R.id.phTxt);
        cropTxt = (EditText) findViewById(R.id.cropTxt);
        locTxt = (EditText) findViewById(R.id.locTxt);
        questionTxt = (EditText) findViewById(R.id.questionTxt);
        fertiliserTxt = findViewById(R.id.fertTxt);
        pesticideTxt = findViewById(R.id.pestTxt);
        lengthTxt = findViewById(R.id.lengthTxt);
        frequencyTxt = findViewById(R.id.frequencyTxt);
        errorView = findViewById(R.id.errorView);

        //Set Button on Click Listeners
        selectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                // Show only images, no videos or anything else
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                // Always show the chooser (if there are multiple options available)
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitQuestion();
            }
        });
    }

    public void submitQuestion() {
        String n = nTxt.getText().toString();
        if (n.equals("") || n == null) {
            errorView.setText(R.string.nError);
            errorView.setTextColor(getResources().getColor(R.color.errorText));
            return;
        }

        String p = pTxt.getText().toString();
        if (p.equals("") || p == null) {
            errorView.setText(R.string.pError);
            errorView.setTextColor(getResources().getColor(R.color.errorText));
            return;
        }

        String k = kTxt.getText().toString();
        if (k.equals("") || k == null) {
            errorView.setText(R.string.kError);
            errorView.setTextColor(getResources().getColor(R.color.errorText));
            return;
        }

        String pH = phTxt.getText().toString();
        if (pH.equals("") || pH == null) {
            errorView.setText(R.string.pHError);
            errorView.setTextColor(getResources().getColor(R.color.errorText));
            return;
        }

        String time = cropTxt.getText().toString();
        if (time.equals("") || time == null) {
            errorView.setText(R.string.timeError);
            errorView.setTextColor(getResources().getColor(R.color.errorText));
            return;
        }

        String location = locTxt.getText().toString();
        if (location.equals("") || location == null) {
            errorView.setText(R.string.locationError);
            errorView.setTextColor(getResources().getColor(R.color.errorText));
            return;
        }

        String question = questionTxt.getText().toString();
        if (question.equals("") || question == null) {
            errorView.setText(R.string.questionError);
            errorView.setTextColor(getResources().getColor(R.color.errorText));
            return;
        }

        String fertiliser = fertiliserTxt.getText().toString();
        if (question.equals("") || question == null) {
            errorView.setText(R.string.fertError);
            errorView.setTextColor(getResources().getColor(R.color.errorText));
            return;
        }

        String pesticide = pesticideTxt.getText().toString();
        if (question.equals("") || question == null) {
            errorView.setText(R.string.pestError);
            errorView.setTextColor(getResources().getColor(R.color.errorText));
            return;
        }

        String length = lengthTxt.getText().toString();
        if (question.equals("") || question == null) {
            errorView.setText(R.string.lengthError);
            errorView.setTextColor(getResources().getColor(R.color.errorText));
            return;
        }

        String frequency = frequencyTxt.getText().toString();
        if (question.equals("") || question == null) {
            errorView.setText(R.string.freqError);
            errorView.setTextColor(getResources().getColor(R.color.errorText));
            return;
        }

        String image;
        try {
            Bitmap bm = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bm.compress(Bitmap.CompressFormat.JPEG, 30, baos);
            byte[] b = baos.toByteArray();
            image = Base64.encodeToString(b, Base64.DEFAULT);
        } catch (Exception e) {
            System.out.println(e);
            errorView.setText(R.string.imageError);
            errorView.setTextColor(getResources().getColor(R.color.errorText));
            return;
        }


        try {
            try {
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
                HttpURLConnection urlConnection = util.httpFactory("https://agriculturepipeline.herokuapp.com/main/query/add", "POST");

                //Create JSON object
                JSONObject jsonParam = new JSONObject();
                jsonParam.put("userNum", userID);
                jsonParam.put("n", n);
                jsonParam.put("p", p);
                jsonParam.put("k", k);
                jsonParam.put("pH", pH);
                jsonParam.put("date", time);
                jsonParam.put("location", location);
                jsonParam.put("question", question);
                jsonParam.put("image", image);
                jsonParam.put("pesticides", pesticide);
                jsonParam.put("fertilisers", fertiliser);
                jsonParam.put("length", length);
                jsonParam.put("frequency", frequency);

                //Send Body as JSON Object
                OutputStream os = urlConnection.getOutputStream();
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
                writer.write(jsonParam.toString());
                writer.flush();
                writer.close();
                os.close();

                urlConnection.connect();

                int HttpResult = urlConnection.getResponseCode();
                System.out.println(HttpResult);
                System.out.println(urlConnection.getErrorStream());

                errorView.setText(R.string.requestSuccess);
                errorView.setTextColor(getResources().getColor(R.color.successText));
                pTxt.setText("");
                kTxt.setText("");
                nTxt.setText("");
                phTxt.setText("");
                cropTxt.setText("");
                locTxt.setText("");
                questionTxt.setText("");
                fertiliserTxt.setText("");
                pesticideTxt.setText("");
                lengthTxt.setText("");
                frequencyTxt.setText("");

                imageView.setImageBitmap(null);


            }
            catch (Exception e) {
                System.out.println(e.toString());
            }

/**
 String userpass = "username:password";
 String basicAuth = "Basic " + android.util.Base64.decode(userpass.getBytes("UTF-8"), android.util.Base64.DEFAULT );
 conn.setRequestProperty ("Authorizaton", userpass);
 **/


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {

            Uri uri = data.getData();

            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                // Log.d(TAG, String.valueOf(bitmap));

                ImageView imageView = (ImageView) findViewById(R.id.imageView);
                imageView.setImageBitmap(bitmap);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    public static void setUserID(int id) {
        userID = id;
    }

    public static int getUserID() {
        return userID;
    }

    public void setLanguage() {
        String text = "";

        try {
            File file = getFileStreamPath("language.txt");
            if (!file.exists()) {
                file.createNewFile();
                FileOutputStream writer = openFileOutput(file.getName(), Context.MODE_PRIVATE);

                String string = "en";
                writer.write(string.getBytes());
                writer.flush();


                writer.close();
            }
            else {
                try {
                    BufferedReader br = new BufferedReader(new FileReader(file));
                    String line;
                    while ((line = br.readLine()) != null) {
                        text += line;
                    }
                    br.close();
                }
                catch (IOException e) {

                }
            }


        }

        catch (Exception e) {

        }
        String lang = text;
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config,
                getBaseContext().getResources().getDisplayMetrics());
    }


}
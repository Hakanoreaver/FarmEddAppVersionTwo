package com.csit321.farmeddversion2.Messaging;

import android.app.Activity;
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
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.csit321.farmeddversion2.R;
import com.csit321.farmeddversion2.Utils.utils;
import com.nightonke.boommenu.BoomMenuButton;

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

public class MessagingActivity extends Activity {

    BoomMenuButton bmb;
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
    ProgressBar progressBar;
    Button backButton;


    static final int REQUEST_IMAGE_CAPTURE = 1;
    static final int REQUEST_TAKE_PHOTO = 1;
    private int PICK_IMAGE_REQUEST = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_messaging);


        bmb = findViewById(R.id.bmb);
        bmb = utils.createBMBMenu(bmb);

        backButton = findViewById(R.id.messagingBackButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        //Bind Variables
        final Button submitButton = (Button)findViewById(R.id.submitBtn);
        Button selectButton = (Button)findViewById(R.id.selectBtn);
        imageView = (ImageView)findViewById(R.id.imageView);
        pTxt = (EditText) findViewById(R.id.nTxt);
        kTxt = (EditText) findViewById(R.id.kTxt);
        nTxt = (EditText) findViewById(R.id.nTxt);
        phTxt = (EditText) findViewById(R.id.pHTxt);
        cropTxt = (EditText) findViewById(R.id.cropTxt);
        locTxt = (EditText) findViewById(R.id.locTxt);
        questionTxt = (EditText) findViewById(R.id.questionTxt);
        fertiliserTxt = findViewById(R.id.fertTxt);
        pesticideTxt = findViewById(R.id.pestTxt);
        lengthTxt = findViewById(R.id.lengthTxt);
        frequencyTxt = findViewById(R.id.frequencyTxt);
        errorView = findViewById(R.id.errorView);
        progressBar = findViewById(R.id.progressBar2);

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
                progressBar.setVisibility(View.VISIBLE);
                Runnable r = new Runnable() {
                    @Override
                    public void run() {
                        submitQuestion();
                    }
                };
                Thread thread = new Thread(r);
                thread.start();
            }
        });
    }

    public void submitQuestion() {
        String n = nTxt.getText().toString();
        if (n.equals("") || n == null) {
            n = "-1";
        }

        String p = pTxt.getText().toString();
        if (p.equals("") || p == null) {
            p = "-1";
        }

        String k = kTxt.getText().toString();
        if (k.equals("") || k == null) {
            k = "-1";
        }

        String pH = phTxt.getText().toString();
        if (pH.equals("") || pH == null) {
            p = "-1";
        }

        String time = cropTxt.getText().toString();
        if (time.equals("") || time == null) {
            errorView.setText(R.string.cropError);
            errorView.setTextColor(getResources().getColor(R.color.errorText));
            progressBar.setVisibility(View.GONE);
            return;
        }

        String location = locTxt.getText().toString();
        if (location.equals("") || location == null) {
            errorView.setText(R.string.locationError);
            errorView.setTextColor(getResources().getColor(R.color.errorText));
            progressBar.setVisibility(View.GONE);
            return;
        }

        String question = questionTxt.getText().toString();
        if (question.equals("") || question == null) {
            errorView.setText(R.string.questionError);
            errorView.setTextColor(getResources().getColor(R.color.errorText));
            progressBar.setVisibility(View.GONE);
            return;
        }

        String fertiliser = fertiliserTxt.getText().toString();
        if (fertiliser.equals("") || question == null) {
            errorView.setText(R.string.fertError);
            errorView.setTextColor(getResources().getColor(R.color.errorText));
            progressBar.setVisibility(View.GONE);
            return;
        }

        String pesticide = pesticideTxt.getText().toString();
        if (pesticide.equals("") || question == null) {
            errorView.setText(R.string.pestError);
            errorView.setTextColor(getResources().getColor(R.color.errorText));
            progressBar.setVisibility(View.GONE);
            return;
        }

        String length = lengthTxt.getText().toString();
        if (length.equals("") || question == null) {
            errorView.setText(R.string.lengthError);
            errorView.setTextColor(getResources().getColor(R.color.errorText));
            progressBar.setVisibility(View.GONE);
            return;
        }

        String frequency = frequencyTxt.getText().toString();
        if (frequency.equals("") || question == null) {
            errorView.setText(R.string.freqError);
            errorView.setTextColor(getResources().getColor(R.color.errorText));
            progressBar.setVisibility(View.GONE);
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
            progressBar.setVisibility(View.GONE);
            return;
        }


        try {
            try {
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
                HttpURLConnection urlConnection = utils.httpFactory("https://agriculturepipeline.herokuapp.com/main/query/add", "POST");

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
 String basicAuth = "Basic " + android.utils.Base64.decode(userpass.getBytes("UTF-8"), android.utils.Base64.DEFAULT );
 conn.setRequestProperty ("Authorizaton", userpass);
 **/


        } catch (Exception e) {
            e.printStackTrace();
        }
        progressBar.setVisibility(View.GONE);
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

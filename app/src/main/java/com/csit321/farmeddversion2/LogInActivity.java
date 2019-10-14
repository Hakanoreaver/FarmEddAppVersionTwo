package com.csit321.farmeddversion2;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;

import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.csit321.farmeddversion2.Objects.User;
import com.csit321.farmeddversion2.Utilities.SignUpActivity;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LogInActivity extends Activity {
    private static final String TAG = "LoginActivity";
    private static final int REQUEST_SIGNUP = 0;
    ProgressBar progressBar;
    TextView errorView;
    @BindView(R.id.input_email) EditText _emailText;
    @BindView(R.id.input_password) EditText _passwordText;
    @BindView(R.id.btn_login) Button _loginButton;
    @BindView(R.id.link_signup) TextView _signupLink;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_log_in);
        ButterKnife.bind(this);

        progressBar = findViewById(R.id.progressBar);

        errorView = findViewById(R.id.loginErrorView);

        _loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                login();
            }
        });

        _signupLink.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Start the Signup activity
                Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
                startActivityForResult(intent, REQUEST_SIGNUP);
                finish();
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            }
        });

        try {
            System.out.println("Here");
            checkLogIn();
        } catch (Exception e) {
            e.printStackTrace();
        }

        SharedPreferences sharedPref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        if(!sharedPref.contains("plantsOn")) {
            sharedPref.edit().putBoolean("plantsOn", true);
            sharedPref.edit().commit();
        }
        if(!sharedPref.contains("animationsOn")) {
            sharedPref.edit().putBoolean("animationsOn", true);
            sharedPref.edit().commit();
        }
    }

    public void checkLogIn() throws ParseException {
        SharedPreferences sharedPref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        String dateString = sharedPref.getString("date", "01/01/0001");
        Date date1 = new Date(dateString);
        Calendar c = Calendar.getInstance();
        c.setTime(date1);
        c.add(Calendar.DATE,14);
        date1 = c.getTime();
        Calendar cal2  = Calendar.getInstance();
        Date date2 = cal2.getInstance().getTime();
        System.out.println(date1);
        System.out.println(date2);
        final int userNum = sharedPref.getInt("userNum", -1);
        System.out.println(userNum);
        System.out.println(date2.compareTo(date1));
        if(date2.compareTo(date1) < 0) {
            //int userNum = sharedPref.getInt("userNum", -1);
            if(userNum == -1) return;
            Runnable r = new Runnable() {
                @Override
                public void run() {
                    getUser(userNum);
                }
            };
            Thread t = new Thread(r);
            t.start();


        }

    }
    public void login() {
        Log.d(TAG, "Login");

        _loginButton.setEnabled(false);

        progressBar.setVisibility(View.VISIBLE);

        final String email = _emailText.getText().toString();
        final String password = _passwordText.getText().toString();

        Runnable r = new Runnable() {
            @Override
            public void run() {
                logIn(email, password);
            }
        };
        Thread thread = new Thread(r);
        thread.start();



    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_SIGNUP) {
            if (resultCode == RESULT_OK) {

                // TODO: Implement successful signup logic here
                // By default we just finish the Activity and log them in automatically
                this.finish();
            }
        }
    }

    @Override
    public void onBackPressed() {
        // Disable going back to the MainActivity
        moveTaskToBack(true);
    }

    public void logIn(String username, String password) {


        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            URL url = new URL("https://agriculturepipeline.herokuapp.com/main/user/login");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setDoInput (true);
            urlConnection.setDoOutput (true);
            urlConnection.setUseCaches (false);
            urlConnection.setRequestMethod("POST");
            urlConnection.setRequestProperty("Content-Type","application/json");
            urlConnection.connect();
            //Create JSON object
            JSONObject jsonParam = new JSONObject();
            jsonParam.put("username", username);
            jsonParam.put("password", password);
            //Send Body as JSON Object
            OutputStream os = urlConnection.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
            writer.write(jsonParam.toString());
            writer.flush();
            writer.close();
            os.close();



            try {
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                BufferedReader r = new BufferedReader(new InputStreamReader(in));
                StringBuilder total = new StringBuilder();
                for (String line; (line = r.readLine()) != null; ) {
                    total.append(line);
                }
                if(Integer.parseInt(total.toString()) > 0) {
                    SharedPreferences sharedPref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putInt("userNum", Integer.parseInt(total.toString()));
                    DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    Calendar cal = Calendar.getInstance();
                    editor.putString("date", cal.getTime().toString());
                    editor.commit();

                    System.out.println("User Number - " + sharedPref.getInt("userNum", 79));
                    getUser(Integer.parseInt(total.toString()));
                }
                else {
                    if(Integer.parseInt(total.toString()) == -1) {
                        errorView.setText(R.string.usernameError);
                        errorView.setTextColor(getResources().getColor(R.color.errorText));
                    }
                    else {
                        errorView.setText(R.string.passwordError);
                        errorView.setTextColor(getResources().getColor(R.color.errorText));
                    }
                }
            } finally {
                urlConnection.disconnect();
                progressBar.setVisibility(View.GONE);
                _loginButton.setEnabled(true);
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    private void getUser(int userId) {
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            URL url = new URL("https://agriculturepipeline.herokuapp.com/main/user/find/" + userId);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setDoInput(true);
            urlConnection.setDoOutput(true);
            urlConnection.setUseCaches(false);
            urlConnection.setRequestMethod("POST");
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.connect();


            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            BufferedReader r = new BufferedReader(new InputStreamReader(in));
            StringBuilder total = new StringBuilder();
            for (String line; (line = r.readLine()) != null; ) {
                total.append(line);
            }
            ObjectMapper mapper = new ObjectMapper();
            User user = mapper.readValue(total.toString(), User.class);
            System.out.println(user.getAggrozone());
            MainActivity.setUser(user);
            System.out.println(MainActivity.getUser().toString());
            openMainPage();


        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void openMainPage(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }


}

package com.csit321.farmeddversion2.Utilities;

import android.app.Activity;
import android.content.Intent;
import android.os.StrictMode;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.csit321.farmeddversion2.MainActivity;
import com.csit321.farmeddversion2.Objects.User;
import com.csit321.farmeddversion2.R;
import com.csit321.farmeddversion2.Utils.utils;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

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

import javax.net.ssl.HttpsURLConnection;

public class SignUpActivity extends Activity {

    Button backButton;
    Button signUpButton;
    TextInputEditText usernameField;
    TextInputEditText password1Field;
    TextInputEditText password2Field;
    TextInputEditText codeField;
    TextView errorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_sign_up);

        backButton = findViewById(R.id.signUpBackButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        usernameField = findViewById(R.id.usernameSignUpField);
        password1Field = findViewById(R.id.passwordInputOne);
        password2Field = findViewById(R.id.passwordInputTwo);
        codeField = findViewById(R.id.securityPinEdit);

        errorView = findViewById(R.id.createErrorView);

        signUpButton = findViewById(R.id.createAccountButton);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createAccount();
            }
        });
    }

    private void createAccount() {
        errorView.setVisibility(View.GONE);

        String username = usernameField.getText().toString();
        String password1 = password1Field.getText().toString();
        String password2 = password2Field.getText().toString();
        String code = codeField.getText().toString();

        System.out.println(code + " CODE");

        //Passwords do not match
        if(!password1.equals(password2)) {
            errorView.setVisibility(View.VISIBLE);
            errorView.setTextColor(getResources().getColor(R.color.errorText));
            errorView.setText(R.string.passwordCreateError);
            return;
        }

        //Send Request
        try {
            //Create request object
            HttpsURLConnection urlConnection = utils.httpFactory("https://agriculturepipeline.herokuapp.com/main/user/create", "POST");
            //Create JSON object
            JSONObject jsonParam = new JSONObject();
            jsonParam.put("username", username);
            jsonParam.put("password", password1);
            jsonParam.put("pin", code);
            //Send JSON object
            OutputStream os = urlConnection.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
            writer.write(jsonParam.toString());
            writer.flush();
            writer.close();
            os.close();
            //Receive Response
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            BufferedReader r = new BufferedReader(new InputStreamReader(in));
            StringBuilder total = new StringBuilder();
            for (String line; (line = r.readLine()) != null; ) {
                total.append(line);
            }
            int response = Integer.parseInt(total.toString());
            if(response < 0) {
                if(response == -2) {
                    errorView.setVisibility(View.VISIBLE);
                    errorView.setTextColor(getResources().getColor(R.color.errorText));
                    errorView.setText(R.string.wrongPin);
                    return;
                }
                if(response == -1) {
                    errorView.setVisibility(View.VISIBLE);
                    errorView.setTextColor(getResources().getColor(R.color.errorText));
                    errorView.setText(R.string.usernameCreateError);
                    return;
                }
            }
            else {
                getUser(response);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (JSONException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
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

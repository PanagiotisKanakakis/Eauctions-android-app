package com.eauctions.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.eauctions.Utils.Util;
import com.eauctions.entity.User;
import com.eauctions.rest.RestApi;
import com.subasta.activity.dashbord.Dashboard;
import com.sourcey.activities.R;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URI;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    private static final int REQUEST_SIGNUP = 0;

    private ProgressDialog progressDialog ;

    @Bind(R.id.username)
    EditText _username;
    @Bind(R.id.input_password)
    EditText _passwordText;
    @Bind(R.id.btn_login)
    Button _loginButton;
    @Bind(R.id.link_signup)
    TextView _signupLink;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        progressDialog =  new ProgressDialog(LoginActivity.this,
                R.style.ThemeOverlay_AppCompat_Dark);
        _loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                login();
            }
        });

        _signupLink.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
                startActivityForResult(intent, REQUEST_SIGNUP);
                finish();
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            }
        });


    }

    @Override
    public void onPause(){
        super.onPause();
        progressDialog.dismiss();
    }

    public void login() {
        Log.d(TAG, "Login");

        if (!validate()) {
            onLoginFailed();
            return;
        }

        _loginButton.setEnabled(false);


        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");
        progressDialog.show();


        //TODO  cases for admin and guest


        String username = _username.getText().toString();
        String password = _passwordText.getText().toString();

       // onLoginSuccess();
        new Login().execute(username,password);
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
        //moveTaskToBack(true);
    }

    public void onLoginSuccess(User user) {
        _loginButton.setEnabled(true);
        Intent intent = new Intent(getApplicationContext(), Dashboard.class);
        Bundle bundle = new Bundle();
//
//        String user_json = new Gson().toJson(user);
//        bundle.putString("user", user_json);
//        intent.putExtras(bundle);
        startActivity(intent);
        finish();
    }

    public void onLoginFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();

        _loginButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String username = _username.getText().toString();
        String password = _passwordText.getText().toString();

        if (username.isEmpty() ) {
            _username.setError("enter a valid username");
            valid = false;
        } else {
            _username.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            _passwordText.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            _passwordText.setError(null);
        }

        return valid;
    }

    private class Login extends AsyncTask<String, Void,User> {

        private RestTemplate restTemplate =  new RestApi().getRestTemplate();

        @Override
        protected User doInBackground(String... params) {
            String uri = "";
            try {
                uri = Util.getProperty("baseAddress",getApplicationContext()) +  "/login";
            } catch (IOException e) {
                e.printStackTrace();
            }
            URI targetUrl= UriComponentsBuilder.fromUriString(uri)
                    .queryParam("username", params[0])
                    .queryParam("password", params[1])
                    .build()
                    .encode()
                    .toUri();

            User result = null;
            try {
                result = restTemplate.getForObject(targetUrl,User.class);
                return result;
            } catch (Exception e) {
                Log.e(TAG, e.getMessage());
            }
            return null;
        }

        @Override
        protected void onPostExecute(final User user) {
            if(user != null) {
                new android.os.Handler().postDelayed(
                        new Runnable() {
                            public void run() {
                                onLoginSuccess(user);
                                progressDialog.dismiss();
                            }
                        }, 1000);
            }else{
                new android.os.Handler().postDelayed(
                        new Runnable() {
                            public void run() {
                                onLoginFailed();
                                progressDialog.dismiss();
                            }
                        }, 1000);
            }

        }

    }
}

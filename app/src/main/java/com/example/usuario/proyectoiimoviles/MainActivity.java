package com.example.usuario.proyectoiimoviles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.analytics.HitBuilders;

public class MainActivity extends AppCompatActivity {

    AnalyticsTracker analyticsTracker;
    private static final String TAG = MainActivity.class.getSimpleName();
    private EditText usernameField, passwordField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Google Analytics
        analyticsTracker = AnalyticsTracker.getAnalyticsTracker(this.getApplicationContext());

        usernameField = (EditText)findViewById(R.id.usernameText);
        passwordField = (EditText)findViewById(R.id.passText);

    }

    public void login(View view){
        String username = usernameField.getText().toString();
        String password = passwordField.getText().toString();
        new SignInActivity(this).execute(username,password);
    }

    public void register(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "Setting screen name: " + "Main screen");
        //using tracker variable to set Screen Name
        //sending the screen to analytics using ScreenViewBuilder() method
        analyticsTracker.trackScreen("Main screen");
    }
}

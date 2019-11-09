package com.example.emotionmusicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{

    Button b1;
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    public static final String loginStatus = "loginStatus";
    static final String loggedIn = "loggedIn";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pref = getApplicationContext().getSharedPreferences("MyPref", 0);
        editor = pref.edit();

        /*
        * If the user is not logged in, the login activity will be executed.
        *  */
        if(!pref.contains(loginStatus))
        {
            editor.putString(loginStatus, loggedIn);
            editor.commit();
            Intent intent = new Intent(this, Login.class);
            startActivity(intent);
        }

        b1 = (Button) findViewById(R.id.button1);
        b1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}
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
            /*editor.putString(loginStatus, loggedIn);
            editor.commit();*/
            Intent intent = new Intent(this, Signup.class);
            startActivityForResult(intent, 2);
        }

        b1 = (Button) findViewById(R.id.button1);
        b1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        // check if the request code is same as what is passed  here it is 2
        if(requestCode == 2) {

            if(data != null){
                String message = data.getStringExtra("MESSAGE");

                if (message.equals("successful")) {
                    editor.putString(loginStatus, loggedIn);
                    editor.commit();
                } else if (message.equals("unsuccessful")) {
                    Intent intent = new Intent(this, Signup.class);
                    startActivityForResult(intent, 2);
                }
            }
            else
            {
                finish();
            }

            //String message=data.getStringExtra("MESSAGE");
            //textView1.setText(message);
        }

        /*if(requestCode == 0)
        {
            Intent intent = new Intent(this, Signup.class);
            startActivityForResult(intent, 2);
        }*/
    }
}
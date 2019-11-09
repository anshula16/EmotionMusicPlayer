package com.example.emotionmusicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Login extends AppCompatActivity implements View.OnClickListener{

    Button btn_login;
    EditText input_email;
    EditText input_password;
    TextView link_signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_login = (Button)findViewById(R.id.btn_login);
        btn_login.setOnClickListener(this);

        input_email = (EditText)findViewById(R.id.input_email);
        input_password = (EditText)findViewById(R.id.input_password);

        link_signup = (TextView)findViewById(R.id.link_signup);
        link_signup.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        String email, password;
        if(v == btn_login) {
            email = input_email.getText().toString();
            password = input_password.getText().toString();

            if (!email.equals("") && !password.equals("")) {
                Intent intent = new Intent(this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        }
        if(v == link_signup)
        {
            System.out.println("SIGNUP");
            Intent intent = new Intent(this, Signup.class);
            startActivity(intent);
        }
    }
    /*@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_SIGNUP) {
            if (resultCode == RESULT_OK) {

                // TODO: Implement successful signup logic here
                // By default we just finish the Activity and log them in automatically
                this.finish();
            }
        }

    }*/

    /*@Override
    public void onBackPressed() {
        // disable going back to the MainActivity
        moveTaskToBack(true);
    }*/
}

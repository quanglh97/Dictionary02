package com.example.khaik;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.khaik.hihi21042018.R;

/*
    KhaiTB - 25/04/2018
 */
public class LoginActivity extends AppCompatActivity {

    private Button btnLoginSign;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLoginSign = (Button) findViewById(R.id.login_button_signin);
        btnLoginSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}

package com.example.khaik;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

import com.example.khaik.hihi21042018.R;

/*
    KhaiTB - 25/04/2018
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView crv_main_search, crv_main_history, crv_main_addword, crv_main_transale, crv_main_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IniIDView();
    }

    public void IniIDView(){
        crv_main_search = (CardView) findViewById(R.id.crv_main_search);
        crv_main_history = (CardView) findViewById(R.id.crv_main_history);
        crv_main_addword = (CardView) findViewById(R.id.crv_main_addword);
        crv_main_transale = (CardView) findViewById(R.id.crv_main_transale);
        crv_main_login = (CardView) findViewById(R.id.crv_main_login);

        crv_main_search.setOnClickListener(this);
        crv_main_history.setOnClickListener(this);
        crv_main_addword.setOnClickListener(this);
        crv_main_transale.setOnClickListener(this);
        crv_main_login.setOnClickListener(this);

    }

    /*
         KhaiTB - 25/04/2018
   */
    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId())
        {
            case R.id.crv_main_search:
                intent = new Intent(this, MainSearchActivity.class);
                startActivity(intent);
                break;
            case R.id.crv_main_history:
                break;
            case R.id.crv_main_addword:
                break;
            case R.id.crv_main_transale:
                break;
            case R.id.crv_main_login:
                break;
        }

    }
}

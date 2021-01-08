package com.example.farmzone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class home extends AppCompatActivity {


    TextView usernameDisplay;
    ImageView farms,report,helpPage,contactUs, logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        logout = findViewById(R.id.logOut);

        usernameDisplay = findViewById(R.id.txtdashboard);
        farms = findViewById(R.id.manage);
        report = findViewById(R.id.reports);
        helpPage = findViewById(R.id.help);
        contactUs = findViewById(R.id.contact);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("login", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove("login");
                editor.commit();

                finish();

                Intent intent = new Intent(home.this, Login.class);
                startActivity(intent);
            }
        });


        farms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(home.this,AddFarm.class);
                startActivity(i);
            }
        });

        helpPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(home.this,appHelp.class);
                startActivity(i);
            }
        });

        report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(home.this,Report.class);
                startActivity(i);
            }
        });

        String username = getIntent().getStringExtra("username");
        usernameDisplay.setText(username);
        }

    }

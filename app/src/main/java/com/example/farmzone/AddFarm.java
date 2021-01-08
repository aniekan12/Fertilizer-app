package com.example.farmzone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class AddFarm extends AppCompatActivity {

    EditText name;
    Button farmAdd;
    Spinner loc;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_farm);



        name = findViewById(R.id.farmName);

        farmAdd = findViewById(R.id.addfarm);

        preferences = getSharedPreferences("AddFarm",0);

        farmAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String farmnamevalue = name.getText().toString();



                if (farmnamevalue.length()>1) {
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("name",farmnamevalue);

                    editor.apply();
                    Intent intent = new Intent(getApplicationContext(), Farm.class);
                    intent.putExtra("name",farmnamevalue);
                    startActivity(intent);

                }
            }
        });

    }
}

package com.example.farmzone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONException;
import org.json.JSONObject;

public class Farm extends AppCompatActivity {

    SharedPreferences preferences;
    TextView nameFarm, dose, Pvalue, Kvalue, fertTitle, DoseTItle;

    EditText PName, landsize;

    TextView N_Value, methodApply;

    Button btnCal;

    int a, b , c, d, res1, res2, res3;


    SharedPreferences.Editor editor;
    JSONObject saved = new JSONObject();
    Spinner crop, stage, location;
    TextView cropnamers, stagenamers;
    Button save;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farm);

        save = findViewById(R.id.savebutton);
        save.setVisibility(View.GONE);

        methodApply = findViewById(R.id.methodOFapply);
        methodApply.setVisibility(View.GONE);


        DoseTItle = findViewById(R.id.DoseTitle);
        DoseTItle.setVisibility(View.GONE);

        fertTitle = findViewById(R.id.fertTitle);
        fertTitle.setVisibility(View.GONE);

        PName = findViewById(R.id.programName);
        N_Value = findViewById(R.id.N);
        N_Value.setVisibility(View.GONE);

        Kvalue = findViewById(R.id.valueofK);
        Kvalue.setVisibility(View.GONE);

        btnCal= findViewById(R.id.generateButton);

        Pvalue = findViewById(R.id.valueofP);
        Pvalue.setVisibility(View.GONE);

        dose = findViewById(R.id.dose);
        dose.setVisibility(View.GONE);

        location = findViewById(R.id.farmLocations);
        crop = findViewById(R.id.cropSpinner);
        landsize = findViewById(R.id.landSize);
        //

        nameFarm = findViewById(R.id.farmNames);

        preferences = getSharedPreferences("AddFarm", 0);

        String farmname = getIntent().getStringExtra("name");

        nameFarm.setText(farmname);

        btnCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                a = Integer.parseInt(N_Value.getText().toString());
                b = Integer.parseInt(Pvalue.getText().toString());
                c = Integer.parseInt(Kvalue.getText().toString());
                d = Integer.parseInt(landsize.getText().toString());

                res1 = a * d;
                res2 = b * d;
                res3 = c * d;

                N_Value.setText(String.valueOf(res1));
                N_Value.setVisibility(View.VISIBLE);
                Pvalue.setText(String.valueOf(res2));
                Pvalue.setVisibility(View.VISIBLE);
                Kvalue.setText(String.valueOf(res3));
                Kvalue.setVisibility(View.VISIBLE);

                methodApply.setVisibility(View.VISIBLE);

                fertTitle.setVisibility(View.VISIBLE);
                DoseTItle.setVisibility(View.VISIBLE);

                dose.setVisibility(View.VISIBLE);

                save.setVisibility(View.VISIBLE);
            }
        });


        ArrayAdapter adapter=ArrayAdapter.createFromResource(this, R.array.cropType,android.R.layout.simple_spinner_dropdown_item);
        crop.setAdapter(adapter);

       crop.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               switch (position)
               {
                   case 0:
                       N_Value.setText("20");
                       dose.setText("8");
                       Pvalue.setText("10");
                       Kvalue.setText("10");
                       methodApply.setText("Broadcasting");
                       break;

                   case 1:
                       N_Value.setText("15");
                       dose.setText("4");
                       Pvalue.setText("15");
                       Kvalue.setText("15");
                       methodApply.setText("Banding");
                       break;

                   case 2:
                       N_Value.setText("20");
                       dose.setText("4");
                       Pvalue.setText("10");
                       Kvalue.setText("10");
                       methodApply.setText("Half Circle Method");
                       break;

                   case 3:
                       N_Value.setText("25");
                       dose.setText("4");
                       Pvalue.setText("15");
                       Kvalue.setText("15");
                       methodApply.setText("Localized Placement");
                       break;

                   case 4:
                       N_Value.setText("15");
                       dose.setText("2");
                       Pvalue.setText("15");
                       Kvalue.setText("15");
                       methodApply.setText("Broadcasting");
                       break;

                   case 5:
                       N_Value.setText("15");
                       dose.setText("4");
                       Pvalue.setText("15");
                       Kvalue.setText("15");
                       break;

                   case 6:
                       N_Value.setText("15");
                       dose.setText("0.25g");
                       Pvalue.setText("15");
                       Kvalue.setText("15");
                       break;

                   case 7:
                       N_Value.setText("20");
                       dose.setText("4");
                       Pvalue.setText("10");
                       Kvalue.setText("10");
                       break;

                   case 8:
                       N_Value.setText("0");
                       dose.setText("2");
                       Pvalue.setText("25");
                       Kvalue.setText("0");
                       break;

                   case 9:
                       N_Value.setText("8");
                       Pvalue.setText("32");
                       Kvalue.setText("16");
                       dose.setText("3.5g");
                       methodApply.setText("Localized Placement");
                       break;

                   case 10:
                       N_Value.setText("12");
                       Pvalue.setText("0");
                       Kvalue.setText("0");
                       dose.setText("4");
                       methodApply.setText("Localized Placement");
                       break;

                   case 11:
                       N_Value.setText("15");
                       Pvalue.setText("15");
                       Kvalue.setText("15");
                       dose.setText("8");
                       methodApply.setText("Localized Placement");
                       break;

                   case 12:
                       N_Value.setText("20");
                       Pvalue.setText("20");
                       Kvalue.setText("20");
                       dose.setText("8");
                       methodApply.setText("Banding");
                       break;

                   case 13:
                       N_Value.setText("8");
                       Pvalue.setText("6");
                       Kvalue.setText("30");
                       dose.setText("4");
                       methodApply.setText("Banding");
                       break;

                   case 14:
                       N_Value.setText("12");
                       Pvalue.setText("12");
                       Kvalue.setText("12");
                       dose.setText("6");
                       methodApply.setText("Localized Placement");
                       break;

                   case 15:
                       N_Value.setText("12");
                       Pvalue.setText("12");
                       Kvalue.setText("12");
                       dose.setText("6");
                       methodApply.setText("Localized Placement");
                       break;

                   case 16:
                       N_Value.setText("0");
                       Pvalue.setText("10");
                       Kvalue.setText("10");
                       dose.setText("2");
                       methodApply.setText("Localized Placement");
                       break;

                   case 17:
                       N_Value.setText("15");
                       Pvalue.setText("15");
                       Kvalue.setText("15");
                       dose.setText("4");
                       methodApply.setText("Localized Placement");
                       break;

                   case 18:
                       N_Value.setText("21");
                       Pvalue.setText("0");
                       Kvalue.setText("0");
                       dose.setText("6");
                       methodApply.setText("Localized Placement");
                       break;

                   case 19:
                       N_Value.setText("5");
                       Pvalue.setText("10");
                       Kvalue.setText("10");
                       dose.setText("6");
                       methodApply.setText("Localized Placement");
                       break;

               }
           }

           @Override
           public void onNothingSelected(AdapterView<?> parent) {

           }
       });

        init();
        Intent intent = getIntent();
        if(intent.getIntExtra("position",-1) != -1){
            try {
                String a = nameFarm.getText().toString();

                String c = PName.getText().toString();
                String d = N_Value.getText().toString();
                String e = Pvalue.getText().toString();
                String f = Kvalue.getText().toString();
                String g = cropnamers.getText().toString();
                String h = stagenamers.getText().toString();


                if (!preferences.getString("saved","").equals(""))
                    saved = new JSONObject(preferences.getString("saved",""));
                nameFarm.setText(saved.getString("saved"+intent.getIntExtra("position",0)));
                a = saved.getString("saved"+intent.getIntExtra("position",0));
                // g = saved.getString("saved"+intent.getIntExtra("position",0));
                //  b = saved.getString("saved"+intent.getIntExtra("position",2));
//                PName.setText(saved.getString("saved"+intent.getIntExtra("position",2)));
//                cropnamers.setText(saved.getString("saved"+intent.getIntExtra("position",3)));
                // d = saved.getString("saved"+intent.getIntExtra("position",0));
//                stagenamers.setText(saved.getString("saved"+intent.getIntExtra("position",4)));
                //e = saved.getString("saved"+intent.getIntExtra("position",0));
//                condition.setText(saved.getString("saved"+intent.getIntExtra("position",5)));
                //f = saved.getString("saved"+intent.getIntExtra("position",0));
//                NPK.setText(saved.getString("saved"+intent.getIntExtra("position",6)));
                //g = saved.getString("saved"+intent.getIntExtra("position",0));
//                location.setText(saved.getString("saved"+intent.getIntExtra("position",7)));
                //h = saved.getString("saved"+intent.getIntExtra("position",0));
            } catch (JSONException e) {
                e.printStackTrace();
            }


        }

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = nameFarm.getText().toString();
                String b = N_Value.getText().toString();
                String c = Pvalue.getText().toString();
                String d = Kvalue.getText().toString();
                String e = crop.getSelectedItem().toString();
                String f = dose.getText().toString();
                String g = PName.getText().toString();
                String h = methodApply.getText().toString();

                if (!a.equals("")){
                    try {
                        if (!preferences.getString("saved","").equals(""))
                            saved = new JSONObject(preferences.getString("saved",""));
                        saved.put("saved"+saved.length(),"Program name\t\t - "+ g + "\n\nMethod of Application - " + h +  "\n\nCrop name - " + e +
                        "\n\nNitrogen Value - " + b + "\n\nPhosphorus value - "+ c + "\n\nPotassium value - "+ d + "\n\nDose - "+ f);


                        //saved.put("saved"+saved.length(),b);
                        // saved.put("saved"+saved.length(),c);
                        //saved.put("saved"+saved.length(),d);
                        //saved.put("saved"+saved.length(),e);
                        //saved.put("saved"+saved.length(),f);
                        //saved.put("saved"+saved.length(),g);

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    Log.d("testing",saved+"");
                    editor.putString("saved",saved.toString());
                    editor.apply();

                    PName.setText("");
                    N_Value.setText("");
                    Pvalue.setText("");
                    Kvalue.setText("");

                    methodApply.setText("");
                    dose.setText("");
//                    cropnamers.setText("");
                  //  stagenamers.setText("");

                    nameFarm.setText("");

                    Intent intent1 = new Intent(Farm.this,Report.class);
                    startActivity(intent1);
                }
            }
        });

    }



    private void init() {
        preferences = getSharedPreferences("farmer", Context.MODE_PRIVATE);
        editor = preferences.edit();

        nameFarm = findViewById(R.id.farmNames);

        PName = findViewById(R.id.programName);
        N_Value = findViewById(R.id.N);
        Kvalue = findViewById(R.id.valueofK);

        Pvalue = findViewById(R.id.valueofP);

        methodApply = findViewById(R.id.methodOFapply);

        dose = findViewById(R.id.dose);


        save = findViewById(R.id.savebutton);



    }




}

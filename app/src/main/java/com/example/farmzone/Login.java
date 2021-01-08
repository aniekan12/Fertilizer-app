package com.example.farmzone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Properties;

public class Login extends AppCompatActivity {

    TextView register;

    EditText editTextusername, editTextpassword;
    Button login;

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        preferences = getSharedPreferences("Userinfo",0);

        register = findViewById(R.id.registertext);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),Register.class);
                startActivity(intent);
            }
        });



        editTextpassword = findViewById(R.id.pass);
        editTextusername = findViewById(R.id.user);
        login = findViewById(R.id.buttonLogin);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernamevalue = editTextusername.getText().toString();
                String passwordvalue = editTextpassword.getText().toString();

                String registeredUsername = preferences.getString("username","");
                String registeredPassword = preferences.getString("password","");

                if(usernamevalue.equals(registeredUsername) && passwordvalue.equals(registeredPassword))
                {
                    Toast toast = Toast.makeText(getApplicationContext(),"Welcome to FarmZone",Toast.LENGTH_LONG);
                    toast.show();


                    Intent i = new Intent(Login.this, home.class);
                    i.putExtra("username", usernamevalue);
                    startActivity(i);
                }
            }
        });
    }


   /* public String validate(String userName, String password)
    {
        if(userName.equals("user") && password.equals("user"))
            return "Login was successful";
        else
            return "Invalid login!";
    }

    public void butn(View View)
    {
        Send objSend = new Send();
        objSend.execute("");

    }

    private class Send extends AsyncTask<String, String, String>
    {
        String msg = "";
        String text1 = editTextusername.getText().toString();
        String text2 = editTextpassword.getText().toString();

        @Override
        protected void onPreExecute()
        {
            Toast toast = Toast.makeText(getApplicationContext(),"We're working on your request",Toast.LENGTH_LONG);
            toast.show();

        }

        @Override
        protected String doInBackground(String... strings)
        {

            // Initialize connection variables.
            String host = "farmzones.mysql.database.azure.com";
            String database = "farmzone";
            String user = "donjur@farmzones";
            String password = "Hoomsuk1995";




            try
            {
                String url = String.format("jdbc:mysql://%s/%s", host, database);

                // Set connection properties.
                Properties properties = new Properties();
                properties.setProperty("user", user);
                properties.setProperty("password", password);
                properties.setProperty("useSSL", "true");
                properties.setProperty("verifyServerCertificate", "true");
                properties.setProperty("requireSSL", "false");

                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection(url, properties);
                if(conn == null)
                {
                    Toast toast = Toast.makeText(getApplicationContext(),"Oops!, something went wrong",Toast.LENGTH_LONG);
                    toast.show();
                }
                else
                {
                    String query2 = "select * from user where username='" + text1 + "' and Password='" + text2 + "'";
                    PreparedStatement stmt = conn.prepareStatement(query2);
                    stmt.executeQuery();
                    //msg = "Registered succesfull";
                }
                conn.close();
            }
            catch (Exception e)
            {
                msg = "Connection goes wrong";
                e.printStackTrace();
            }
            return msg;

        }


        @Override
        protected void onPostExecute(String msg)
        {
            Toast toast = Toast.makeText(getApplicationContext(),"Welcome to FarmZone",Toast.LENGTH_LONG);
            toast.show();

            startActivity(new Intent(Login.this,home.class));
        }
*/
    }


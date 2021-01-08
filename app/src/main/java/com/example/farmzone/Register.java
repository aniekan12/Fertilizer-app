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
import java.sql.Statement;
import java.util.Properties;
import java.util.regex.Pattern;

public class Register extends AppCompatActivity {

    EditText username, password, cpassword, locationn;
    Button signUp;
    TextView login;
    SharedPreferences preferences;

    private static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";

   /* public final Pattern EMAIL_ADDRESS_PATTERN = Pattern.compile(
            "[a-zA-Z0-9+._%-+]{1,256}" +
                    "@" +
                    "[a-zA-Z0-9][a-zA-Z0-9-]{0,64}" +
                    "(" +
                    "." +
                    "[a-zA-Z0-9][a-zA-Z0-9-]{0,25}" +
                    ")+"
    );

*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = findViewById(R.id.Username);
        password = findViewById(R.id.Userpassword);
        cpassword = findViewById(R.id.editText23);
        locationn = findViewById(R.id.locations);
        signUp = findViewById(R.id.registerbutton);
        login = findViewById(R.id.logbtn);


        preferences = getSharedPreferences("Userinfo",0);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernamevalue = username.getText().toString();
                String passwordvalue = password.getText().toString();
                String locationvalue = locationn.getText().toString();
                String cpasswordvalue = cpassword.getText().toString();


                if(usernamevalue.length()>1 && passwordvalue.equals(cpasswordvalue) && locationvalue.equals("Jos")) {
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("username",usernamevalue);
                    editor.putString("password",passwordvalue);
                    editor.putString("location",locationvalue);
                    editor.apply();
                    Toast.makeText(Register.this,"You have been registered",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),Login.class);
                    startActivity(intent);
                }

                else {
                    Toast.makeText(Register.this,"Your passwords do not match or you are not in the right location to register for this app",Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    public void emptyField(){
        username.setText("");
        password.setText("");
        locationn.setText("");
    }





   /* private boolean validate() {
        boolean temp=true;
        String loc = "Jos";
        String pass=password.getText().toString();
        String cpass=cpassword.getText().toString();
        String location = locationn.getText().toString();

         if (!location.equals(loc)) {
            Toast.makeText(Register.this,"Sorry, you can't be registered on this application",Toast.LENGTH_SHORT).show();
            temp=false;
            }
         else if(!pass.equals(cpass)){
            Toast.makeText(Register.this,"Password doesn't match",Toast.LENGTH_SHORT).show();
            temp=false;
        }
        return temp;

    }

    public void btnConn(View View)
    {
        if (validate()) {
            Send objSend = new Send();
            objSend.execute("");
        }

    }

    private class Send extends AsyncTask<String, String, String>
    {
        String msg = "";
        String text1 = username.getText().toString();
        String text2 = password.getText().toString();
        String text3 = cpassword.getText().toString();
        String text4 = locationn.getText().toString();


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
                    String query = "INSERT INTO user (username, Password, Location) VALUES('"+text1+"','"+text2+"','"+text4+"')";
                    Statement stmt = conn.createStatement();
                    stmt.executeUpdate(query);
                    msg = "Registered succesfull";
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
            Toast toast = Toast.makeText(getApplicationContext(),"Registration is Successful",Toast.LENGTH_LONG);
            toast.show();

            startActivity(new Intent(Register.this,Login.class));
        }

    }
*/


}



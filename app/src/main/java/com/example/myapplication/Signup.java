package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Signup extends AppCompatActivity {
    EditText firstname;
    EditText lastname;
    EditText phonenumber;
    EditText email;
    EditText password;
    Button singup;
    Button facebook;
    Button google;
    private static final String URL="jdbc:mysql://localhost:3306/FoodCafe";
    private static final String USER="root";
    private static final String PASS="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.homy) {
                    Intent intent = new Intent(Signup.this,MainActivity.class);

                    startActivity(intent);

                    return true;
                }

                else if (id == R.id.dashboard) {
                    Toast toast=Toast.makeText(getApplicationContext(),"Firstly..,You have to Signup!",Toast.LENGTH_SHORT);
                    toast.show();

                    return true;
                }

                else if (id == R.id.setting) {
                    Intent intent = new Intent(Signup.this,preference.class);

                    startActivity(intent);

                    return true;
                }
                return true;
            }
        });
        firstname=(EditText)findViewById(R.id.firstname);
        lastname=(EditText)findViewById(R.id.lastname);
        phonenumber=(EditText)findViewById(R.id.phonenumber);
        email=(EditText)findViewById(R.id.email);
        password=(EditText) findViewById(R.id.password);
        singup=(Button) findViewById(R.id.signup);
        facebook=(Button)findViewById(R.id.facebook);
        google=(Button)findViewById(R.id.google);
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/"));

                startActivity(intent);
            }
        });
        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://accounts.google.com/ServiceLogin?sacu=1"));

                startActivity(intent);
            }
        });
        singup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email=email.getText().toString();
                String pass=password.getText().toString();
                if (firstname.getText().toString().trim().length()==0)
                {
                    firstname.setError("Please Enter your First Name");
                }
                if (lastname.getText().toString().trim().length()==0)
                {
                    lastname.setError("Please Enter your Last Name");
                }
                if (phonenumber.getText().toString().trim().length()==0)
                {
                    phonenumber.setError("Please Enter your Phone Number");
                }
                if (Email.length()==0)
                {
                    email.setError("FIELD CANNOT BE EMPTY..!");
                    email.requestFocus();
                }
                else if (!Email.matches("[a-zA-Z0-9_\\.\\+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-\\.]+"))
                {
                    Toast.makeText(getApplicationContext(),"Invalid Email Address",Toast.LENGTH_SHORT).show();
                }
                else if (pass.length()==0)
                {
                    password.setError("FIELD CANNOT BE EMPTY..!");
                    Toast.makeText(getApplicationContext(),"Password must be a least six digit",Toast.LENGTH_SHORT).show();
                    password.requestFocus();
                }
                else if(pass.length()<=6)
                {
                    password.setError(" Password is too short");
                    Toast.makeText(getApplicationContext(),"Password must be a least six digit",Toast.LENGTH_SHORT).show();
                    password.requestFocus();
                }
                else {
                    Intent intent = new Intent(getApplicationContext(), welcome.class);
                    startActivity(intent);
                }
            }
        });
        password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email=email.getText().toString();
                if (Email.matches("[a-zA-Z0-9_\\.\\+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-\\.]+"))
                {
                    Toast.makeText(getApplicationContext(),"valid Email Address",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.set1) {
            Intent intent = new Intent(Signup.this,preference.class);

            startActivity(intent);

            return true;
        }
        if (id == R.id.privacy1) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.food-cafe.com/privacy-policy/"));

            startActivity(intent);

            return true;
        }
        if (id == R.id.location) {
            Intent intent = new Intent(Signup.this,map.class);

            startActivity(intent);

            return true;
        }

        if (id == R.id.b1) {
            Toast toast=Toast.makeText(getApplicationContext(),"Firstly..,You have to Signup!",Toast.LENGTH_SHORT);
            toast.show();

            return true;
        }
        if (id == R.id.j1) {
            Toast toast=Toast.makeText(getApplicationContext(),"Firstly..,You have to Signup!",Toast.LENGTH_SHORT);
            toast.show();

            return true;
        }
        if (id == R.id.hot1) {
            Toast toast=Toast.makeText(getApplicationContext(),"Firstly..,You have to Signup!",Toast.LENGTH_SHORT);
            toast.show();

            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void buttonbn(View view) {
      Send obj=new Send();
      obj.execute();
    }
    private class Send extends AsyncTask<String,String,String> {
        String msg = "";
        String Firstname=firstname.getText().toString();
        String Lastname=lastname.getText().toString();
        String Phone=phonenumber.getText().toString();
        String Email = email.getText().toString();
        String Password = password.getText().toString();

        @Override
        protected void onPreExecute() {
            firstname.setText("please wait to insert First name");
            lastname.setText("please wait to insert last name");
            phonenumber.setText("please wait to insert phone number");
            email.setText("please wait to insert Email data");
            password.setText("please wait to insert data");


        }


        @Override
        protected String doInBackground(String... strings) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection(URL, USER, PASS);
                if (conn == null) {
                    msg = "insert not success";
                } else {
                    String query = "INSERT INTO Food signup VALUES('"+Firstname+"','"+Lastname+"','"+Phone+"','"+Email+"','" + Password + "')";
                    Statement st = conn.createStatement();
                    st.executeUpdate(query);
                    msg = "success";
                }
                conn.close();
            } catch (Exception e) {
                msg = "wrong";
                e.printStackTrace();
            }
            return msg;
        }

        @Override
        protected void onPostExecute(String msg) {
            firstname.setText(msg);
            lastname.setText(msg);
            phonenumber.setText(msg);
            email.setText(msg);
            password.setText(msg);
        }

    }
}
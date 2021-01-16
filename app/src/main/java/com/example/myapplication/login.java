package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class login extends AppCompatActivity {
    EditText email;
    EditText pass;
    String emailpattern="[a-zA-Z0-9._-]+@[a-z+]\\.+[a-z]+";
    Button button;
    TextView signup;
    private static final String URL="jdbc:mysql://localhost:3306/FoodCafe";
    private static final String USER="root";
    private static final String PASS="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.homy) {
                    Intent intent = new Intent(login.this,MainActivity.class);

                    startActivity(intent);

                    return true;
                }

                else if (id == R.id.dashboard) {
                    Toast toast=Toast.makeText(getApplicationContext(),"Firstly..,You have to Login!",Toast.LENGTH_SHORT);
                    toast.show();

                    return true;
                }

                else if (id == R.id.setting) {
                    Intent intent = new Intent(login.this,preference.class);

                    startActivity(intent);

                    return true;
                }
                return true;
            }
        });
        email=(EditText) findViewById(R.id.email);
        pass=(EditText)findViewById(R.id.pass);
        button=(Button)findViewById(R.id.login);
        signup=(TextView)findViewById(R.id.signup);
        final Loadingdialog loadingdialog=new Loadingdialog(login.this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Email=email.getText().toString();
                String password=pass.getText().toString();
                if (Email.length()==0)
                {
                    email.setError("FIELD CANNOT BE EMPTY..!");
                    email.requestFocus();
                }
                else if (!Email.matches("[a-zA-Z0-9_\\.\\+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-\\.]+"))
                {
                    Toast.makeText(getApplicationContext(),"Invalid Email Address",Toast.LENGTH_SHORT).show();
                }
                else if (password.length()==0)
                {
                    pass.setError("FIELD CANNOT BE EMPTY..!");
                    Toast.makeText(getApplicationContext(),"Please Enter your Password",Toast.LENGTH_SHORT).show();
                    pass.requestFocus();
                }
                else if(password.length()<=6)
                {
                    pass.setError(" Incorrect Password");
                    Toast.makeText(getApplicationContext(),"Password must be a least six digit",Toast.LENGTH_SHORT).show();
                    pass.requestFocus();
                }

                else {
                    loadingdialog.startloadingdialog();
                    Handler handler= new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent=new Intent(login.this,welcome.class);
                            startActivity(intent);
                        }
                    },5000);

                }
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opensignup();
            }
        });
        pass.setOnClickListener(new View.OnClickListener() {
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

    public void opensignup() {
        Intent intent = new Intent(this,Signup.class);
        startActivity(intent);
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
            Intent intent = new Intent(login.this,preference.class);

            startActivity(intent);

            return true;
        }
        if (id == R.id.privacy1) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.food-cafe.com/privacy-policy/"));

            startActivity(intent);

            return true;
        }
        if (id == R.id.location) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://maps.app.goo.gl/QgfkFkSaarg1jbts8"));
            startActivity(intent);

            return true;
        }
        if (id == R.id.search) {
            Intent intent = new Intent(login.this,search.class);
            startActivity(intent);

            return true;
        }

        if (id == R.id.b1) {
            Toast toast=Toast.makeText(getApplicationContext(),"Firstly..,You have to Login!",Toast.LENGTH_SHORT);
            toast.show();

            return true;
        }
        if (id == R.id.j1) {
            Toast toast=Toast.makeText(getApplicationContext(),"Firstly..,You have to Login!",Toast.LENGTH_SHORT);
            toast.show();

            return true;
        }
        if (id == R.id.hot1) {
            Toast toast=Toast.makeText(getApplicationContext(),"Firstly..,You have to Login!",Toast.LENGTH_SHORT);
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
        String Email = email.getText().toString();
        String password = pass.getText().toString();

        @Override
        protected void onPreExecute() {
            email.setText("please wait to insert data");
            pass.setText("please wait to insert data");

        }


        @Override
        protected String doInBackground(String... strings) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection(URL, USER, PASS);
                if (conn == null) {
                    msg = "insert not success";
                } else {
                    String query = "INSERT INTO Food Login VALUES('" + Email + "','" + password + "')";
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
            email.setText(msg);
            pass.setText(msg);
        }

    }

}

package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;fhfhf
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.homy) {
                    Toast toast=Toast.makeText(getApplicationContext(),"Already you are on the Home page",Toast.LENGTH_SHORT);
                    toast.show();

                    return true;


                }

                else if (id == R.id.dashboard) {
                    Toast toast=Toast.makeText(getApplicationContext(),"Please..!if you don't have Signup..! please signup fisrt go to the Dashbord",Toast.LENGTH_SHORT);
                    toast.show();

                    return true;
                }

                else if (id == R.id.setting) {
                    Intent intent = new Intent(MainActivity.this,preference.class);

                    startActivity(intent);

                    return true;
                }
                return true;
            }
        });
        Button btn1 = (Button) findViewById(R.id.login);
        Button btn2 = (Button) findViewById(R.id.register);
        TextView skip = (TextView) findViewById(R.id.skip);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openlogin();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openlogin2();
            }
        });
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opensignup1();
            }
        });

    }
        public void opensignup1(){
            Intent intent3 = new Intent(this,Signup.class);
            startActivity(intent3);

        }

    public void openlogin(){
        Intent intent = new Intent(this,login.class);
        startActivity(intent);

    }
    public void openlogin2(){
        Intent intent1=new Intent(this,Signup.class);
        startActivity(intent1);
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
            Intent intent = new Intent(MainActivity.this,preference.class);

            startActivity(intent);

            return true;
        }
        if (id == R.id.privacy1) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.food-cafe.com/privacy-policy/"));

            startActivity(intent);

            return true;
        }
        if (id == R.id.location) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/place/Sydney+NSW,+Australia/@-33.8469759,150.3715249,9z/data=!3m1!4b1!4m5!3m4!1s0x6b129838f39a743f:0x3017d681632a850!8m2!3d-33.8688197!4d151.2092955"));

            startActivity(intent);

            return true;
        }

        if (id == R.id.b1) {
            Toast toast=Toast.makeText(getApplicationContext(),"Firstly...,You have to Signup!",Toast.LENGTH_SHORT);
            toast.show();

            return true;
        }
        if (id == R.id.j1) {
            Toast toast=Toast.makeText(getApplicationContext(),"Firstly...,You have to Signup!",Toast.LENGTH_SHORT);
            toast.show();

            return true;
        }
        if (id == R.id.hot1) {
            Toast toast=Toast.makeText(getApplicationContext(),"Firstly...,You have to Signup!",Toast.LENGTH_SHORT);
            toast.show();

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}

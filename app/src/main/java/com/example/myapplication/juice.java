package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class juice extends AppCompatActivity {
    TextView view1;
    TextView view2;
    ConstraintLayout view3;
    TextView view4;
    TextView view5;
    ConstraintLayout view6;
    TextView view7;
    TextView view8;
    ConstraintLayout view9;
    TextView view10;
    TextView view11;
    ConstraintLayout view12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juice);
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.homy) {
                    Intent intent = new Intent(juice.this,MainActivity.class);

                    startActivity(intent);

                    return true;
                }

                else if (id == R.id.dashboard) {
                    Intent intent = new Intent(juice.this,menubar.class);

                    startActivity(intent);

                    return true;
                }

                else if (id == R.id.setting) {
                    Intent intent = new Intent(juice.this,preference.class);

                    startActivity(intent);

                    return true;
                }
                return true;
            }
        });
        view1=(TextView)findViewById(R.id.view1);
        view2=(TextView)findViewById(R.id.view2);
        view3=(ConstraintLayout)findViewById(R.id.view3);
        view4=(TextView)findViewById(R.id.view4);
        view5=(TextView)findViewById(R.id.view5);
        view6=(ConstraintLayout)findViewById(R.id.view6);
        view7=(TextView)findViewById(R.id.view7);
        view8=(TextView)findViewById(R.id.view8);
        view9=(ConstraintLayout)findViewById(R.id.view9);
        view10=(TextView)findViewById(R.id.view10);
        view11=(TextView)findViewById(R.id.view11);
        view12=(ConstraintLayout)findViewById(R.id.view12);
        view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(juice.this,scroll2.class);
                startActivity(intent);
            }
        });
        view2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(juice.this,scroll2.class);
                startActivity(intent);
            }
        });
        view3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(juice.this,scroll2.class);
                startActivity(intent);
            }
        });
        view4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(juice.this,scroll2.class);
                startActivity(intent);
            }
        });
        view5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(juice.this,scroll2.class);
                startActivity(intent);
            }
        });
        view6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(juice.this,scroll2.class);
                startActivity(intent);
            }
        });
        view7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(juice.this,scroll2.class);
                startActivity(intent);
            }
        });
        view8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(juice.this,scroll2.class);
                startActivity(intent);
            }
        });
        view9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(juice.this,scroll2.class);
                startActivity(intent);
            }
        });
        view10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(juice.this,scroll2.class);
                startActivity(intent);
            }
        });
        view11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(juice.this,scroll2.class);
                startActivity(intent);
            }
        });
        view12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(juice.this,scroll2.class);
                startActivity(intent);
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
            Intent intent = new Intent(juice.this,preference.class);

            startActivity(intent);

            return true;
        }
        if (id == R.id.privacy1) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.food-cafe.com/privacy-policy/"));

            startActivity(intent);

            return true;
        }
        if (id == R.id.location) {
            Intent intent = new Intent(juice.this,map.class);

            startActivity(intent);

            return true;
        }

        if (id == R.id.b1) {
            Intent intent = new Intent(juice.this, burger.class);
            startActivity(intent);

            return true;
        }
        if (id == R.id.j1) {
            Intent intent = new Intent(juice.this, juice.class);
            startActivity(intent);

            return true;
        }
        if (id == R.id.hot1) {
            Intent intent = new Intent(juice.this, hotdrinks.class);

            startActivity(intent);

            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

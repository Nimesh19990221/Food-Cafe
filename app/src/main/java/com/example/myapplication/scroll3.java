package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class scroll3 extends AppCompatActivity {
    Button bur1;
    Button bur2;
    Button bur3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll3);
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.homy) {
                    Intent intent = new Intent(scroll3.this,MainActivity.class);

                    startActivity(intent);

                    return true;
                }

                else if (id == R.id.dashboard) {
                    Intent intent = new Intent(scroll3.this,menubar.class);

                    startActivity(intent);

                    return true;
                }

                else if (id == R.id.setting) {
                    Intent intent = new Intent(scroll3.this,preference.class);

                    startActivity(intent);

                    return true;
                }
                return true;
            }
        });
        bur1=(Button)findViewById(R.id.bur1);
        bur2=(Button)findViewById(R.id.bur2);
        bur3=(Button)findViewById(R.id.bur3);
        bur1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=IYaCZHoBTjw"));
                startActivity(intent);
            }
        });
        bur2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=SM_dqUSJvgk"));
                startActivity(intent);
            }
        });
        bur3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=xxhVZ28aCrw"));
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
            Intent intent = new Intent(scroll3.this,preference.class);

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

        if (id == R.id.b1) {
            Intent intent = new Intent(scroll3.this, burger.class);
            startActivity(intent);

            return true;
        }
        if (id == R.id.j1) {
            Intent intent = new Intent(scroll3.this, juice.class);
            startActivity(intent);

            return true;
        }
        if (id == R.id.hot1) {
            Intent intent = new Intent(scroll3.this, hotdrinks.class);

            startActivity(intent);

            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

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

public class welcome extends AppCompatActivity {
    Button getstart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.homy) {
                    Intent intent = new Intent(welcome.this,MainActivity.class);

                    startActivity(intent);

                    return true;
                }

                else if (id == R.id.dashboard) {
                    Intent intent = new Intent(welcome.this,menubar.class);

                    startActivity(intent);

                    return true;
                }

                else if (id == R.id.setting) {
                    Intent intent = new Intent(welcome.this,preference.class);

                    startActivity(intent);

                    return true;
                }
                return true;
            }
        });

        getstart=(Button)findViewById(R.id.getstart);
        getstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getstart();
            }
        });

    }
    public void getstart(){
        Intent intent=new Intent(this,menubar.class);
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
            Intent intent = new Intent(welcome.this,preference.class);

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
            Intent intent = new Intent(welcome.this,search.class);
            startActivity(intent);

            return true;
        }

        if (id == R.id.b1) {
            Intent intent = new Intent(welcome.this, burger.class);
            startActivity(intent);

            return true;
        }
        if (id == R.id.j1) {
            Intent intent = new Intent(welcome.this, juice.class);
            startActivity(intent);

            return true;
        }
        if (id == R.id.hot1) {
            Intent intent = new Intent(welcome.this, hotdrinks.class);

            startActivity(intent);

            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

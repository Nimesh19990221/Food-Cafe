package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class search extends AppCompatActivity {
    SearchView mySearchView;
    ListView mylist;

    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();
        String []listviewitems=new String[]{
               "Menu","Burger","Hot Drinks","Juice", " Larger burger", "Double Burger", "Original Burger", "The Wiskey king", "Black Tea","Coffee"," Tea", "Milk Shake","Strawberry","Fruit Juice","Cocktail"
        };
        mySearchView=(SearchView)findViewById(R.id.searchview);
        mylist=(ListView)findViewById(R.id.mylist);



        adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listviewitems);
        mylist.setAdapter(adapter);
        mylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    Intent intent=new Intent(search.this,menubar.class);
                    startActivity(intent);
                }
                if (position==1){
                    Intent intent=new Intent(search.this,burger.class);
                    startActivity(intent);
                }
                if (position==2){
                    Intent intent=new Intent(search.this,hotdrinks.class);
                    startActivity(intent);
                }
                if (position==3){
                    Intent intent=new Intent(search.this,juice.class);
                    startActivity(intent);
                }
                if (position==4){
                    Intent intent=new Intent(search.this,burger.class);
                    startActivity(intent);
                }
                if (position==5){
                    Intent intent=new Intent(search.this,burger.class);
                    startActivity(intent);
                }
                if (position==6){
                    Intent intent=new Intent(search.this,burger.class);
                    startActivity(intent);
                }
                if (position==7){
                    Intent intent=new Intent(search.this,burger.class);
                    startActivity(intent);
                }
                if (position==8){
                    Intent intent=new Intent(search.this,hotdrinks.class);
                    startActivity(intent);
                }
                if (position==9){
                    Intent intent=new Intent(search.this,hotdrinks.class);
                    startActivity(intent);
                }
                if (position==10){
                    Intent intent=new Intent(search.this,hotdrinks.class);
                    startActivity(intent);
                }
                if (position==11){
                    Intent intent=new Intent(search.this,hotdrinks.class);
                    startActivity(intent);
                }
                if (position==12){
                    Intent intent=new Intent(search.this,juice.class);
                    startActivity(intent);
                }
                if (position==13){
                    Intent intent=new Intent(search.this,juice.class);
                    startActivity(intent);
                }
                if (position==14){
                    Intent intent=new Intent(search.this,juice.class);
                    startActivity(intent);
                }
                if (position==15){
                    Intent intent=new Intent(search.this,juice.class);
                    startActivity(intent);
                }

            }
        });
        mySearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });
    }
}
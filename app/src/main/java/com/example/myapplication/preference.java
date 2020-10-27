package com.example.myapplication;



import android.preference.PreferenceActivity;
import android.os.Bundle;



public class preference extends PreferenceActivity{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.prefs);
    }
}
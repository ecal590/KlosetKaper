package com.example.ebonycalloway.klosetkaper;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.ebonycalloway.klosetkaper.View.MainActivity;

public class OutfitSearch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outfit_search);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }
    public void selectOutfit(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

}

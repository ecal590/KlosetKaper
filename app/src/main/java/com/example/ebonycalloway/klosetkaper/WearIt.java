package com.example.ebonycalloway.klosetkaper;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.ebonycalloway.klosetkaper.View.AddItem;
import com.example.ebonycalloway.klosetkaper.View.BuildOutfit;
import com.example.ebonycalloway.klosetkaper.View.Hamper;
import com.example.ebonycalloway.klosetkaper.View.ViewCloset;

public class WearIt extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wear_it);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //TODO: Set wears and washes when wearing clothing
    }

    public void addItem(View view) {
        Intent intent = new Intent(this, AddItem.class);
        startActivity(intent);
    }

    public void hamper(View view) {
        Intent intent = new Intent(this, Hamper.class);
        startActivity(intent);
    }

    public void viewCloset(View view) {
        Intent intent = new Intent(this, ViewCloset.class);
        startActivity(intent);
    }

    public void buildOutfit(View view) {
        Intent intent = new Intent(this, BuildOutfit.class);
        startActivity(intent);
    }
}

package com.example.ebonycalloway.klosetkaper.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.ebonycalloway.klosetkaper.MoreInfo;
import com.example.ebonycalloway.klosetkaper.R;
import com.example.ebonycalloway.klosetkaper.WearIt;

public class BuildOutfit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_build_outfit);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    //TODO: Connect to database/folder on phone* to get data
    }

    public void randomOutfit(View view) {
        Intent intent = new Intent(this, MoreInfo.class);
        startActivity(intent);
    }

    public void wearIt(View view) {
        Intent intent = new Intent(this, WearIt.class);
        startActivity(intent);
    }

    public void moreInfo(View view) {
        Intent intent = new Intent(this, MoreInfo.class);
        startActivity(intent);
    }
}

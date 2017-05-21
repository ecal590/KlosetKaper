package com.example.ebonycalloway.klosetkaper.View;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.ebonycalloway.klosetkaper.R;

public class ViewItem extends AppCompatActivity {
    //TODO: Same layout as add item with save button for changes
    //TODO: Open the database and get items
    //TODO: DELETE CLOTHING?????
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_item);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

}

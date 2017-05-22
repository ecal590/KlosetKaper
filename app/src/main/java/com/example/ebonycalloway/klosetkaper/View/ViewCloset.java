package com.example.ebonycalloway.klosetkaper.View;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.ebonycalloway.klosetkaper.Controller.MyDBHandler;
import com.example.ebonycalloway.klosetkaper.R;

import java.util.ArrayList;

public class ViewCloset extends AppCompatActivity {
    MyDBHandler dbHandler;
    ListView clothesListView;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_closet);
        clothesListView = (ListView) findViewById(R.id.clothesListView);
        dbHandler = new MyDBHandler(this,null,null,1);
        printDatabase();
    }
    public void printDatabase(){
        String dbString = dbHandler.databaseToString();
        String[] clothingList = dbString.split(",");
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,clothingList);
        clothesListView.setAdapter(adapter);//TODO:Set on click for each item

    }
}

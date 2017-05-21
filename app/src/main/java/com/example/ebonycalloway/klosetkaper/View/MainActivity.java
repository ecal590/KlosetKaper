package com.example.ebonycalloway.klosetkaper.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.ebonycalloway.klosetkaper.FindOutfit;
import com.example.ebonycalloway.klosetkaper.POJO.Clothing;
import com.example.ebonycalloway.klosetkaper.R;
import com.example.ebonycalloway.klosetkaper.Settings;

//TODO: Landscape and portrait view
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //TODO: Get put extras from Other pages
        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        if (b != null) {
            String clothingName = b.get("outfitName").toString();
            String category = b.get("category").toString();
            String firstColor = b.get("mainColor").toString();
            String secondColor = b.get("secondaryColor").toString();
            long date = Long.parseLong(b.get("purchaseDate").toString());
            String description = b.get("description").toString();
            String occasion = b.get("occassion").toString();
            double cost = Double.parseDouble(b.get("cost").toString());
            int rating = Integer.parseInt(b.get("rating").toString());
            int wash = Integer.parseInt(b.get("washes").toString());
            int wears = Integer.parseInt(b.get("wears").toString());

            Clothing newClothing = new Clothing(clothingName, firstColor, secondColor, category, description, occasion, date, cost,rating);
            //TODO:Add a Toast to check information
            Toast toast = Toast.makeText(getApplicationContext(),newClothing.getName(),Toast.LENGTH_LONG);
            toast.show();
        }
    }

    public void findOutfit(View view) {
        Intent intent = new Intent(this, FindOutfit.class);
        startActivity(intent);
    }

    public void addItem(View view) {
        Intent intent = new Intent(this, AddItem.class);
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

    public void hamper(View view) {
        Intent intent = new Intent(this, Hamper.class);
        startActivity(intent);
    }

    public void settings(View view) {
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }
}

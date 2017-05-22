package com.example.ebonycalloway.klosetkaper.View;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.ebonycalloway.klosetkaper.Controller.MyDBHandler;
import com.example.ebonycalloway.klosetkaper.POJO.Clothing;
import com.example.ebonycalloway.klosetkaper.POJO.ClothingManager;
import com.example.ebonycalloway.klosetkaper.POJO.LibraryActions;
import com.example.ebonycalloway.klosetkaper.R;

import static com.example.ebonycalloway.klosetkaper.POJO.ClothingManager.clothingLibrary;

public class AddItem extends AppCompatActivity {
    static final int REQUEST_IMAGE_CAPTURE = 1;

    ImageView outfitImageView;
    EditText nameText;
    Spinner categorySpinner;
    Spinner color1Spinner;
    Spinner color2Spinner;
    CalendarView calendarView;
    RadioButton storeButton;
    RadioButton onlineButton;
    EditText descriptionEditText;
    EditText costEditText;
    RatingBar ratingBar;
    Spinner occasionSpinner;
    RadioGroup locationGroup;
    MyDBHandler dbHandler;
    Button pictureTake,addItem;
    byte[] photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        nameText = (EditText) findViewById(R.id.nameEditText);
        categorySpinner = (Spinner) findViewById(R.id.categorySpinner);
        color1Spinner = (Spinner) findViewById(R.id.color1Spinner);
        color2Spinner = (Spinner) findViewById(R.id.color2Spinner);
        calendarView = (CalendarView)  findViewById(R.id.calendarView);
        storeButton = (RadioButton) findViewById(R.id.storeRadioButton);
        onlineButton = (RadioButton) findViewById(R.id.onlineRadioButton);
        descriptionEditText = (EditText) findViewById(R.id.descriptionEditText);
        costEditText = (EditText) findViewById(R.id.costEditText);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        occasionSpinner = (Spinner) findViewById(R.id.occasionSpinner);
        locationGroup = (RadioGroup) findViewById(R.id.locationGroup);

        dbHandler = new MyDBHandler(this,null,null,1);

        outfitImageView = (ImageView) findViewById(R.id.outfitImageView);
        pictureTake = (Button) findViewById(R.id.outfitPictureButton);
        addItem = (Button) findViewById(R.id.addItemButton);

        pictureTake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                takePicture(view);//TODO: Camera fails
            }
        });

        addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addItemAndGoHome(view);
            }
        });
    }

    public void addItemAndGoHome(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        //TODO: Make sure everything is filled in

        /*intent.putExtra("outfitName","Dog Shirt");//title,value new activity getExtra("yellow")
        intent.putExtra("category","Shirt");
        intent.putExtra("occasion","casual");
        intent.putExtra("mainColor","Orange");
        intent.putExtra("secondaryColor","Highlighter Yellow");
        intent.putExtra("purchaseDate","January 2005");
        intent.putExtra("description","Cool t-shirt with a big dog that makes everyone happy");
        intent.putExtra("cost",12.50);
        intent.putExtra("rating",3);
        intent.putExtra("washes",3);
        intent.putExtra("wears",0);*/
        if(nameText.getText().toString() != null && color1Spinner.getSelectedItem().toString() != null && color2Spinner.getSelectedItem().toString() != null && categorySpinner.getSelectedItem().toString() != null && descriptionEditText.getText().toString() != null && occasionSpinner.getSelectedItem().toString() != null && Double.parseDouble(costEditText.getText().toString()) >=0.00) {
            int id = locationGroup.getCheckedRadioButtonId();
            View radioButton = locationGroup.findViewById(id);
            int index = locationGroup.indexOfChild(radioButton);

            RadioButton r = (RadioButton) locationGroup.getChildAt(index);
            Clothing clothing = new Clothing(nameText.getText().toString(), color1Spinner.getSelectedItem().toString(), color2Spinner.getSelectedItem().toString(), categorySpinner.getSelectedItem().toString(), descriptionEditText.getText().toString(), occasionSpinner.getSelectedItem().toString(), r.getText().toString(),calendarView.getDate(), Double.parseDouble(costEditText.getText().toString()), ratingBar.getNumStars());
            clothing.setWash(0);
            clothing.setWears(0);//TODO:Washes and wears initialized to something other than 0
            clothing.setPicture(photo);
            dbHandler.addClothing(clothing);
        }
        //TODO: PASS clothing to Clothing Manager CLASS
        //TODO: If rating is 3 or lower after 3 months ask if they want to donate
            //TODO: Keep clothing to a minimum
        //TODO: Algorithm to make sure not too many duplicates of clothing
        //TODO: Setting to help person minimize or not

        startActivity(intent);
    }
    public void takePicture(View view){
        Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(camera_intent, REQUEST_IMAGE_CAPTURE);

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap picture = (Bitmap) extras.get("data");
            photo = picture.getBytes();
            //TODO: Rotate picture 90 degrees right
            outfitImageView.setImageBitmap(picture);

        }
    }
}

package com.example.ebonycalloway.klosetkaper;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.ebonycalloway.klosetkaper.View.MainActivity;

public class Settings extends AppCompatActivity {
    EditText nameText, weekFreq,wearFreq;
    Button saveButton;
    ToggleButton reminders;
    RadioGroup radioGroup;
    static final int firstRadio = 2131558579;
    static final int secondRadio = 2131558580;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        nameText = (EditText) findViewById(R.id.nameText);
        weekFreq = (EditText) findViewById(R.id.weeksCleanNumber);
        wearFreq = (EditText) findViewById(R.id.wearsCleanNumber);
        saveButton = (Button) findViewById(R.id.saveSettingsButton);
        reminders = (ToggleButton) findViewById(R.id.toggleButton);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        saveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                saveSettings(view);
            }
        });

        SharedPreferences shared = this.getSharedPreferences("Settings", MODE_PRIVATE);
        if (shared.contains("name")){
            //set preferences
            nameText.setText(shared.getString("name", null).toString());
            int tempwear = shared.getInt("wears", 0);
            int tempweek = shared.getInt("weeks",0);
            if(tempweek > 0) {
                weekFreq.setText(String.valueOf(tempweek));
            }
            if (tempwear > 0) {
                wearFreq.setText(String.valueOf(tempwear));
            }
            if(shared.getString("remind", null).equals("ON")) {
                reminders.setChecked(true);
            }else if(shared.getString("remind", null).equals("OFF")){
                reminders.setChecked(false);
            }//TODO: Generalize for more than 2 buttons
            String thing = shared.getString("saveImage", null).toString();
            if(shared.getString("saveImage", null).toString().equals("separate")) {
                RadioButton temp2 = (RadioButton) findViewById(R.id.separateSaveButton);
                temp2.setChecked(true);
            }else if(shared.getString("saveImage", null).toString().equals("link")){
                RadioButton temp2 = (RadioButton) findViewById(R.id.linkSaveButton);
                temp2.setChecked(true);
            }
        }else{

    }
    }

    public void saveSettings(View view) {
        Intent intent = new Intent(this, MainActivity.class);

        int wearNum = -1, weekNum = -1, radioSelected = 0;
        String remind = "OFF";
        String nameString = "";

        if(nameText.getText().length() > 0) {
            nameString = nameText.getText().toString();
            if(Integer.parseInt(wearFreq.getText().toString()) > 0 && wearFreq.getText().length() > 0) {
                wearNum = Integer.parseInt(wearFreq.getText().toString());
            }else{
                wearNum = -1;
            }
            if(Integer.parseInt(weekFreq.getText().toString()) > 0 && weekFreq.getText().length() > 0) {
                weekNum = Integer.parseInt(weekFreq.getText().toString());
            }else{
                weekNum = -1;
            }
            remind = reminders.getText().toString();//check this?
            radioSelected = radioGroup.getCheckedRadioButtonId();
        }else{
            Context context = getApplicationContext();
            CharSequence text = "You must enter at least your name";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
        /*intent.putExtra("name",nameString);//title,value new activity getExtra("yellow")
        intent.putExtra("wears",wearNum);
        intent.putExtra("weeks",weekNum);*/

        SharedPreferences shared = this.getSharedPreferences("Settings",MODE_PRIVATE);
        SharedPreferences.Editor editor = shared.edit();
        editor.putString("name",nameString);
        editor.putInt("wears",wearNum);
        editor.putInt("weeks",weekNum);
        //TODO: Generalize for more than 2 buttons
        if (radioSelected == firstRadio) {
            editor.putString("saveImage","separate");
        }else if(radioSelected == secondRadio){
            editor.putString("saveImage","link");
        }

        if (remind.equals("ON")) {
            editor.putString("remind", remind.toString());
        }else{
            editor.putString("remind", remind.toString());
        }
        editor.apply();//TODO: commit() will return true or false. Do I need to check if it was a success or not?
        Context context = getApplicationContext();
        CharSequence text = "Saved";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();


        startActivity(intent);
    }
}

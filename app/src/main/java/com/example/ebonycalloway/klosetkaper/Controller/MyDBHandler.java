package com.example.ebonycalloway.klosetkaper.Controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.ebonycalloway.klosetkaper.POJO.Clothing;

/**
 * Created by ebonycalloway on 4/19/17.
 */

public class MyDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "closetDB.db";
    public static final String TABLE_CLOTHING = "clothing";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_CLOTHINGNAME = "clothingname";
    public static final String COLUMN_CLOTHINGDESCRIPTION = "clothingdescription";
    public static final String COLUMN_CLOTHINGOCCASION = "clothingoccasion";
    public static final String COLUMN_CLOTHINGCOLOR = "clothingdcolor";
    public static final String COLUMN_CLOTHINGCOLOR2 = "clothingcolor2";
    public static final String COLUMN_CLOTHINGDATE = "clothingdate";
    public static final String COLUMN_CLOTHINGLOCATION = "clothinglocation";
    public static final String COLUMN_CLOTHINGCATEGORY = "clothingcategory";
    public static final String COLUMN_CLOTHINGPIC = "clothingpic";
    public static final String COLUMN_CLOTHINGCOST = "clothingdcost";
    public static final String COLUMN_CLOTHINGRATING = "clothingrating";

    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + TABLE_CLOTHING + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_CLOTHINGNAME + " TEXT " +
                COLUMN_CLOTHINGDESCRIPTION + " TEXT " +
                COLUMN_CLOTHINGOCCASION + "TEXT" +
                COLUMN_CLOTHINGCOLOR + "TEXT" +
                COLUMN_CLOTHINGCOLOR2 + "TEXT" +
                COLUMN_CLOTHINGDATE + "TEXT" +
                COLUMN_CLOTHINGLOCATION + "TEXT" +
                COLUMN_CLOTHINGCATEGORY + "TEXT" +
                COLUMN_CLOTHINGPIC + "TEXT" +//"BLOB"
                COLUMN_CLOTHINGCOST + "TEXT" +
                COLUMN_CLOTHINGRATING + "TEXT" +
                ");";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_CLOTHING);
        onCreate(sqLiteDatabase);
    }

    //Add a new row to the database
    public void addClothing(Clothing clothing){
        ContentValues values = new ContentValues();
        values.put(COLUMN_CLOTHINGNAME, clothing.getName());
        values.put(COLUMN_CLOTHINGDESCRIPTION,clothing.getDescription());
        values.put(COLUMN_CLOTHINGOCCASION, clothing.getOccassion());
        values.put(COLUMN_CLOTHINGCOLOR, clothing.getPrimaryColor());
        values.put(COLUMN_CLOTHINGCOLOR2,clothing.getSecondaryColor());
        values.put(COLUMN_CLOTHINGDATE, clothing.getDate());
        values.put(COLUMN_CLOTHINGLOCATION,clothing.getLocation());
        values.put(COLUMN_CLOTHINGCATEGORY, clothing.getCategory());
        values.put(COLUMN_CLOTHINGPIC,"he");//byte, drawable, blob//TODO: picture conversion
        values.put(COLUMN_CLOTHINGCOST, clothing.getCost());
        values.put(COLUMN_CLOTHINGRATING,clothing.getRating());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_CLOTHING, null, values);
        db.close();
    }

    //Delete a piece of clothing from the database
    public void deleteClothing(String clothingName){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_CLOTHING + " WHERE " + COLUMN_CLOTHINGNAME + "=\"" + clothingName + "\";");
    }

    public String databaseToString(){
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_CLOTHING + " WHERE 1";

        //Cursor points to a location in your results
        Cursor c = db.rawQuery(query, null);
        //Move to the first row in your results
        c.moveToFirst();

        //Position after the last row means the end of the results
        while (!c.isAfterLast()) {
            if (c.getString(c.getColumnIndex("clothingname")) != null) {
                dbString += c.getString(c.getColumnIndex("clothingname"));
                dbString += "\n";
                dbString += c.getString(c.getColumnIndex("clothingdescription"));
                dbString += ",";
            }
            c.moveToNext();
        }
        db.close();
        return dbString;
    }
}

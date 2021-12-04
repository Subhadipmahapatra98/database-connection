package com.example.databaseconnection;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class call extends SQLiteOpenHelper {
    public static final String dbname="DataBase.db";
    public static final String tbname="Table1";
    public static final String f1="name";
    public static final String f2="pwd";
    public call( Context context) {
        super(context, dbname, null, 11);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String q1="CREATE TABLE " + tbname +" ( " + f1 +"TEXT" + f2 + "TEXT)";
        db.execSQL(q1);
    }

    public void addNewUser(String Uname, String Pwd) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(f1, Uname);
        values.put(f2, Pwd);
        db.insert(tbname, null, values);
        db.close();
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS "+ tbname);
        onCreate(db);
    }
}

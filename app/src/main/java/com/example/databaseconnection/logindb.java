package com.example.databaseconnection;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
public class logindb extends SQLiteOpenHelper {
    public static final String dbname="ldb.db";
    public static final String tbname="ltb";
    public static final String F1="name";
    public static final String F2="pwd";
    public logindb(Context context) {
        super(context, dbname, null,1);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String Q1 = "CREATE TABLE " + tbname + " ("+ F1 + " TEXT, " + F2 + " TEXT)";
        db.execSQL(Q1);
    }
    public void addNewUser(String Uname, String Pwd) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(F1, Uname);
        values.put(F2, Pwd);
        db.insert(tbname, null, values);
        db.close();
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS "+ tbname);
        onCreate(db);
    }
}